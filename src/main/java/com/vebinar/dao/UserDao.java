package com.vebinar.dao;

import com.vebinar.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

}
