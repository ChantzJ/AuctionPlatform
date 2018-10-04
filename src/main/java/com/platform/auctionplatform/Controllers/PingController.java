package com.platform.auctionplatform.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@CrossOrigin
public class PingController {

    @RequestMapping(value = "/ping", method = POST)
    public @ResponseBody
    String ping() {
        return ("PONG");
    }

}
