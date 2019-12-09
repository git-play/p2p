package com.zking.p2p.service.impl;

import com.zking.p2p.mapper.UserInfoMapper;
import com.zking.p2p.model.UserInfo;
import com.zking.p2p.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements IUserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public int insert(UserInfo record) {
        return userInfoMapper.insert(record);
    }

    @Override
    public int insert2(UserInfo record) {
        return userInfoMapper.insert2(record);
    }

    @Override
    public int update(UserInfo record) {
        return userInfoMapper.update(record);
    }

    @Override
    public UserInfo login(UserInfo record) {
        return userInfoMapper.login(record);
    }

    @Override
    public List<UserInfo> selectByPrimaryKey(UserInfo record) {
        return userInfoMapper.selectByPrimaryKey(record);
    }

}
