package com.platform.auctionplatform.Controllers;

import com.google.gson.Gson;
import com.platform.auctionplatform.Database.DbContext;
import com.platform.auctionplatform.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    DbContext db;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String login(@PathVariable("userId") int userId) throws IOException {

        try {
            User user  = db.users().findOne(userId);
            return new Gson().toJson(user);
        }
        catch(Exception e) {
            return new Gson().toJson(e);
        }

    }



}