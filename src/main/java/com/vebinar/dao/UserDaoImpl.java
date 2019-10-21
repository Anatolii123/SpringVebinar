package com.vebinar.dao;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.vebinar.entity.User;
import com.vebinar.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO SPRING_PRACTICE_USER (NAME, EMAIL, AGE) VALUES (?,?,?)";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getAge());
    }

    @Override
    public User getById(int id) {
        String sql = "SELECT * FROM SPRING_PRACTICE_USER WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM SPRING_PRACTICE_USER";
        return jdbcTemplate.query(sql, new UserMapper());
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE SPRING_PRACTICE_USER SET NAME=?, EMAIL=?,AGE=? WHERE ID=?";
        jdbcTemplate.update(sql,user.getName(), user.getEmail(), user.getAge(), user.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM SPRING_PRACTICE_USER WHERE ID=?";
        jdbcTemplate.update(sql, id);
    }
}
