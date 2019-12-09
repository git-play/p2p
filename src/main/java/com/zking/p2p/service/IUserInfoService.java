package com.zking.p2p.service;

import com.zking.p2p.model.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IUserInfoService {

    int insert(UserInfo record);

    int insert2(UserInfo record);

    int update(UserInfo record);


    List<UserInfo> selectByPrimaryKey(UserInfo record);


}