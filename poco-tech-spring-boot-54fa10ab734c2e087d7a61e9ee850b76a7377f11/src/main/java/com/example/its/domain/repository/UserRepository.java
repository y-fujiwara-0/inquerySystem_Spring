package com.example.its.domain.repository;

import com.example.its.domain.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserRepository {

    @Select("select * from users where username = #{username}")
    Optional<User> findByUsername(String username);

    @Select("select * from users")
    List<User>findAll();

    @Insert("insert into users (username, password, authority) values (#{username}, #{password}, #{authority})")
    void insert(String username, String password, String authority);

    @Update("UPDATE users  SET password = #{password} WHERE username = #{username}")
    void updatePassword(@Param("username") String username, @Param("password") String password);
}
