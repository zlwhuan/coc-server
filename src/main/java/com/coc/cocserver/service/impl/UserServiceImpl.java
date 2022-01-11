package com.coc.cocserver.service.impl;

import com.coc.cocserver.model.User;
import com.coc.cocserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public User getByTag(String tag) {
        User user = new User();
        user.setTag("#QLCR9URR");
        user.setUsername("测试名称");
        Map<String, String> params = new HashMap<String, String>();
        params.put("tag", "#QLCR9URR");
        String detail = restTemplate.getForObject("https://api.clashofclans.com/v1/players/{tag}", String.class, params);
        user.setDetail(detail);
        return user;
    }
}
