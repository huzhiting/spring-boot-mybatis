package com.uqiauto.user.service;

import com.uqiauto.user.model.User;

import java.util.List;

public interface IUserService {
    int addUser(User user);

    List<User> findAllUser(int pageNum, int pageSize);
}
