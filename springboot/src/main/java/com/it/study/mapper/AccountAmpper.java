package com.it.study.mapper;

import com.it.study.demain.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
@Mapper
public interface AccountAmpper {

    // 一对一的关系查询时候 采用立即加载方式
    @Select("select * from account")
    @Results(id="accountMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),
            @Result(property = "student",column = "uid",one = @One(select = "com.it.study.mapper.UserMapper.finalStudentById",fetchType = FetchType.EAGER))
    })
    public List<Account> finalAll();


    /**
     * 根据用户信息查询账户信息
     */
    @Select("select * from account where uid = #{userId}")
    public List<Account> finalAccountByUid();
}
