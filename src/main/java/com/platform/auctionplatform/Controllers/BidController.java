package com.platform.auctionplatform.Controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.platform.auctionplatform.Database.DbContext;
import com.platform.auctionplatform.Models.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequestMapping("/bids")
@CrossOrigin(maxAge = 3600)
@RestController
public class BidController {

    @Autowired
    DbContext db;

    @RequestMapping(method = RequestMethod.POST)
    public void Bid(@RequestBody String str) throws IOException {

        //int auctionItemId, double maxAutoBidAmount, String bidderName
        //take in a username, itemID, and bidderName

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(str);

        Bid bid = new Bid();

        int itemId = mapper.convertValue(node.get("item"), int.class);
        String bidderName = mapper.convertValue(node.get("bidderName"), String.class);
        double maxAutoBidAmount = mapper.convertValue(node.get("maxAutoBidAmount"), double.class);

        //before setting final values
        //RUN BIDDING ALGORITHM

//        bid.setAuctionItemId();
//        bid.setBidderName();
//        bid.setMaxAutoBidAmount();

        db.bids().save(bid);

        //no return
    }

}