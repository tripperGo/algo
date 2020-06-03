package com.mright.server1.service.impl;

import com.mright.server1.dao.IUserDao;
import com.mright.server1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/6/3 16:54
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao iUserDao;

    @Override
    @Transactional
    public String insert() {
        iUserDao.insert();
        return "SUCCESS";
    }
}
