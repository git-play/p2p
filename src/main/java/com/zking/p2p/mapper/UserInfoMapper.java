package com.zking.p2p.mapper;

import com.zking.p2p.model.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoMapper {
  /*  int deleteByPrimaryKey(Integer uid);*/

    int insert(UserInfo record);

    int insert2(UserInfo record);

    int update(UserInfo record);

    UserInfo login(UserInfo record);

   List<UserInfo> selectByPrimaryKey(UserInfo record);

    UserInfo byName(UserInfo record);

  /*  int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer uid);*/

   /* int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);*/
}