package org.dfzr.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.dfzr.dao.IProductDao;
import org.dfzr.dao.IUserDao;
import org.dfzr.pojo.UserInfo;
import org.dfzr.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service("userService")
public class UserService implements IUserService {

    @Autowired
    IUserDao userDao;


    /*
     * 用户登录校验
     * */
    @Override
    public boolean login(UserInfo user) {
        Long sum = userDao.login(user);
        if (sum == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 用户名是否重复校验
     *
     * @param user
     * @return
     * @throws IOException
     */
    @Override
    public UserInfo registerCheck(UserInfo user) throws IOException {
        List<UserInfo> userInfoList = null;
        if ("".equals(user.getUsername())) {
            return null;
        }
        userInfoList = userDao.registerCheck(user);
        if (userInfoList.size() == 1) {
            return userInfoList.get(0);
        }
        return new UserInfo();
    }

    /**
     * 用户注册
     *
     * @param userInfo
     */
    @Override
    public void register(UserInfo userInfo) {
        userDao.register(userInfo);
    }
}
