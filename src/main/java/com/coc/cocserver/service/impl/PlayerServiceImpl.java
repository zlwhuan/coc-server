package com.coc.cocserver.service.impl;

import com.coc.cocserver.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public String getByTag(String tag) {
        if (!StringUtils.hasLength(tag)) {
            return null;
        }
        Map<String, String> params = new HashMap<>();
        params.put("tag", tag);
        return restTemplate.getForObject("https://api.clashofclans.com/v1/players/{tag}", String.class, params);
    }

    @Override
    public String verifyToken(String tag, String token) {
        return null;
    }
}
