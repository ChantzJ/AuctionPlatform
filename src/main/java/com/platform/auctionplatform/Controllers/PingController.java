package com.platform.auctionplatform.Controllers;

import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class PingController {

    @RequestMapping(value = "/ping", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    String ping() {
        String pong = "PONG";



        return new Gson().toJson("PONG");
    }

}
