package com.coc.cocserver.service;

import com.coc.cocserver.model.User;

public interface PlayerService {

    String getByTag(String tag);

    String verifyToken(String tag, String token);

}
