package com.platform.auctionplatform.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/bids")
@RestController
public class BidController {


    @RequestMapping(method = RequestMethod.POST)
    public void insertAuctionItems() {
//    return new Item("green", 10, 7);
//    return null;
    }

    @RequestMapping(value = "/ping",method = RequestMethod.GET)
    public String Ping() {
        return "Pong";
    }
}