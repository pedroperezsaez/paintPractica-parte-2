package com.paint.paintPrimeraPractica.Respository;


import com.paint.paintPrimeraPractica.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepoImpl implements UserRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;
    private final List<User> users = new ArrayList<>();


    UserRepoImpl() {


    }


    @Override
    public User buscarUser(String username) {
        String sql = "SELECT * FROM user WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, (rs,rn) ->
                        new User(
                                rs.getString("username"),
                                rs.getString("password"),
                                rs.getInt("id")
                        ),
                username
        );
    }




    @Override
    public User addUser(String username, String password, int id) {

        String sql = "INSERT INTO user (username, password, id) VALUES (?, ?, ?)";

        jdbcTemplate.update(sql, username, password, id);

        return new User(username,password,id);

    }
}
