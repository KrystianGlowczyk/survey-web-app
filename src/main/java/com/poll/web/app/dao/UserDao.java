package com.poll.web.app.dao;

import com.poll.web.app.entity.User;

public interface UserDao {

    User findByUserName(String userName);
    
    void save(User user);
    
}
