package com.martimlima.springcourse.securitymodule.userregistrationformwithcustomroles.dao;

import com.martimlima.springcourse.securitymodule.userregistrationformwithcustomroles.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
