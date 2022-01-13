package com.coc.cocserver.service;

import feign.Body;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface CocApi {

    /**
     * 黄金令牌
     */
    @GetMapping(value = "goldpass/seasons/current")
    @RequestLine("GET goldpass/seasons/current")
    String goldPass();

    /**
     * 玩家信息
     */
    @GetMapping(value = "players/{playerTag}")
    @RequestLine("GET players/{playerTag}")
    String player(@PathVariable @Param("playerTag") String playerTag);

    /**
     * 玩家信息
     */
    @PostMapping(value = "players/{playerTag}/verifytoken")
    @RequestLine("POST players/{playerTag}/verifytoken")
    @Body("{body}")
    String playerVerify(@PathVariable @Param("playerTag") String playerTag, @RequestBody @Param("body") String body);


}
