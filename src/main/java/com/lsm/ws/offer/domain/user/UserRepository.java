package com.lsm.ws.offer.domain.user;

public interface UserRepository {

    void verifyToken(String token);
}
