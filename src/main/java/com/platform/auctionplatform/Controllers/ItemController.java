package com.platform.auctionplatform.Controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.platform.auctionplatform.Database.DbContext;
import com.platform.auctionplatform.Models.AuctionItem;
import com.platform.auctionplatform.Models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/auctionItems")
@RestController
public class ItemController {

    @Autowired
    DbContext db;

    @RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public int insertAuctionItems(@RequestBody String str) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(str);

        AuctionItem auItem = new AuctionItem();

        auItem.setAuctionItem(mapper.convertValue(node.get("item"), Item.class));
        auItem.setReservePrice(mapper.convertValue(node.get("reserve"), double.class));

        db.auctionItems().save(auItem);

        //return auto generated auctionKeyID
        return auItem.getAuctionItemId();
    }


    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String getAuctionItems() {

        //TODO
        //Wrap in try catch to catch DBFetchErrors

        List<AuctionItem> au = db.toList(db.auctionItems().findAll());

        return new Gson().toJson(au);
    }

    @RequestMapping(value = "/{auctionItemId}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String getAuctionItemByID(@PathVariable("auctionItemId") int itemID) {

        AuctionItem au = db.auctionItems().findOne(itemID);

        return new Gson().toJson(au);
    }

}