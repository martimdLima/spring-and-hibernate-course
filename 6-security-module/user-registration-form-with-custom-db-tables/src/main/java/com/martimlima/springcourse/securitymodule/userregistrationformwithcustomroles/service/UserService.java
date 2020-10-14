package com.martimlima.springcourse.securitymodule.userregistrationformwithcustomroles.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.martimlima.springcourse.securitymodule.userregistrationformwithcustomroles.entity.User;
import com.martimlima.springcourse.securitymodule.userregistrationformwithcustomroles.user.CrmUser;

public interface UserService extends UserDetailsService {
	
    User findByUserName(String userName);

    void save(CrmUser crmUser);

}
