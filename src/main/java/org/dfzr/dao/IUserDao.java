package org.dfzr.dao;

import org.dfzr.pojo.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {

    Long login(UserInfo user);

    List<UserInfo> registerCheck(UserInfo userInfo);

    void register(UserInfo userInfo);
}
