package com.platform.auctionplatform.Controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.platform.auctionplatform.Database.DbContext;
import com.platform.auctionplatform.Models.AuctionItem;
import com.platform.auctionplatform.Models.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/bids")
@CrossOrigin(maxAge = 3600)
@RestController
public class BidController {

    @Autowired
    DbContext db;

    @RequestMapping(method = RequestMethod.POST)
    public void Bid(@RequestBody String str) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(str);

        Bid bid = new Bid();

        int itemId = mapper.convertValue(node.get("auctionItemId"), int.class);
        String bidderName = mapper.convertValue(node.get("bidderName"), String.class);
        double maxAutoBidAmount = mapper.convertValue(node.get("maxAutoBidAmount"), double.class);

        AuctionItem au = db.auctionItems().findOne(itemId);

        //we are the first bidder
        if(au.getCurrentBid() == 0) {
            //set current bid to either reserve or maxauto, whichever is lower
            if(au.getReservePrice() > maxAutoBidAmount) {
                au.setCurrentBid(maxAutoBidAmount);
            }
            else {
                au.setCurrentBid(au.getReservePrice());
            }

            bid.setMaxAutoBidAmount(maxAutoBidAmount);
            bid.setBidderName(bidderName);
            bid.setBidAmount(au.getCurrentBid());
            bid.setAuctionItemId(au.getAuctionItemId());
        }
        else {
            if(au.getReservePrice() > au.getCurrentBid()) { //reserve not met
                if(au.getReservePrice() > maxAutoBidAmount) {
                    if(au.getCurrentBid() < maxAutoBidAmount) { //
                        au.setCurrentBid(maxAutoBidAmount);
                        bid.setBidAmount(au.getCurrentBid());
                    }
                    else { //max auto is less then the current bid so the buyer cant win, set the bid to max or 0
                        bid.setBidAmount(maxAutoBidAmount);
                        //max auto less than current and reserve so do nothing
                    }
                }
                else { //max auto greater than reserve
                    if(au.getCurrentBid() < maxAutoBidAmount) {
                        au.setCurrentBid(au.getReservePrice());
                        bid.setBidAmount(au.getCurrentBid());
                    }
                }

                //make the assumption that a bidder will only bid when they have a higher max auto
                bid.setMaxAutoBidAmount(maxAutoBidAmount);
                bid.setBidderName(bidderName);
                bid.setAuctionItemId(au.getAuctionItemId());

            }
            else {
                List<Bid> bids = db.toList(db.bids().findAll()).stream()
                        .filter(x -> (x.getAuctionItemId() == au.getAuctionItemId() &&
                                au.getCurrentBid() == x.getBidAmount())).collect(Collectors.toList());

                String secondaryBidder = bids.get(0).getBidderName();
                double secondaryBidderAuto = bids.get(0).getMaxAutoBidAmount();

                boolean flag = true;
                while(flag) {

                    if(maxAutoBidAmount > au.getCurrentBid()) {
                        Bid bidLog = new Bid();

                        bidLog.setMaxAutoBidAmount(maxAutoBidAmount);
                        bidLog.setBidderName(bidderName);
                        bidLog.setBidAmount(au.getCurrentBid() + 1.00);
                        bidLog.setAuctionItemId(au.getAuctionItemId());
                        au.setCurrentBid(au.getCurrentBid() + 1.00);

                        if(bidLog.getBidAmount() > secondaryBidderAuto) { //bidder one wins
                            flag = false;
                        }
                        db.bids().save(bidLog);
                    }
                    if(secondaryBidderAuto > au.getCurrentBid()) { //its the other bidders turn
                        Bid bidLog = new Bid();

                        bidLog.setMaxAutoBidAmount(secondaryBidderAuto);
                        bidLog.setBidderName(secondaryBidder);
                        bidLog.setAuctionItemId(au.getAuctionItemId());
                        bidLog.setBidAmount(au.getCurrentBid() + 1.00);
                        au.setCurrentBid(au.getCurrentBid() + 1.00);

                        if(bidLog.getBidAmount() > maxAutoBidAmount) { //bidder number two wins
                            flag = false;
                        }

                        db.bids().save(bidLog);
                    }

                }

            }
        }

        db.auctionItems().save(au);
        db.bids().save(bid);
    }
}