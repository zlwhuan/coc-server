package com.coc.controller;

import com.coc.service.CocApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CocController implements CocApi {

    @Autowired
    CocApi api;
//
//    @GetMapping(value = "goldpass/seasons/current")
//    String getGoldPass() {
//        return api.goldPass();
//    }

    @Override
    public String goldPass() {
        return api.goldPass();
    }

    @Override
    public String player(String playerTag) {
        return api.player(playerTag);
    }

    @Override
    public String playerVerify(String playerTag, String body) {
        return api.playerVerify(playerTag, body);
    }
}
