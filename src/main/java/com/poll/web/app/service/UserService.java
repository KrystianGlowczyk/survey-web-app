package com.poll.web.app.service;

import com.poll.web.app.entity.User;
import com.poll.web.app.user.CrmUser;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

    void save(CrmUser crmUser);
}
