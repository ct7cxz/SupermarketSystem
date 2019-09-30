package org.dfzr.service;

import org.dfzr.pojo.UserInfo;

import java.io.IOException;

public interface IUserService {
    boolean login(UserInfo user);

    UserInfo registerCheck(UserInfo user) throws IOException;

    void register(UserInfo userInfo);
}
