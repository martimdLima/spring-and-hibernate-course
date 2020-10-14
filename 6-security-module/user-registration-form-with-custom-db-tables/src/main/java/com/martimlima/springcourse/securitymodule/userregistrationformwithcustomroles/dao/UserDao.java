package com.martimlima.springcourse.securitymodule.userregistrationformwithcustomroles.dao;

import com.martimlima.springcourse.securitymodule.userregistrationformwithcustomroles.entity.User;

public interface UserDao {

    User findByUserName(String userName);
    
    void save(User user);
    
}