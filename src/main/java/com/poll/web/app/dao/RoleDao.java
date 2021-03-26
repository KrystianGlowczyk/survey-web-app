package com.poll.web.app.dao;

import com.poll.web.app.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
