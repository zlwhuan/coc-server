package com.coc.cocserver.controller;

import com.coc.cocserver.model.User;
import com.coc.cocserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    @Autowired
    UserService service;

    @GetMapping(value = "player/{tag}")
    User getByTag(@PathVariable("tag") String tag) {
        return service.getByTag(tag);
    }

}
