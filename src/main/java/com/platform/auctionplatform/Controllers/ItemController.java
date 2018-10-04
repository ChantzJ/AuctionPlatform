package com.platform.auctionplatform.Controllers;

import com.platform.auctionplatform.Database.DbContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/auctionItems")
@RestController
public class ItemController {
    public static final String SUBMISSION_ERRORS = "Submission errors";

    @Autowired
    DbContext db;

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public void insertAuctionItems() {

    }


    @RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public void getAuctionItems() {

    }

    @RequestMapping(value = "/{auctionItemId}",method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public void getAuctionItemByID(@PathVariable("auctionItemId") int itemID) {

    }



}