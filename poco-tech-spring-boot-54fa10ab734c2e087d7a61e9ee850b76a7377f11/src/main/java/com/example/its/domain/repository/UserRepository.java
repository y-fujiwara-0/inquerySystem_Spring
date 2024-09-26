package com.example.its.domain.repository;

import com.example.its.domain.model.Users;
import org.apache.ibatis.annotations.Param;
import org.seasar.doma.*;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

public interface UserRepository {

    /**
     * 内容
     * @param username
     * @return　返す内容
     */
    Optional<Users> findByUsernameAndDeleteflagFalse(String username);

    @Select
   List<Users> findAll();

    @Insert
    @Transactional
    Users insert(Users users);

    @Update
    @Transactional
    Users updatePassword(Users users);

    @Update
    @Transactional
    Users updateDeleteFlag(@Param("username") String username);

    @Select
    List<Users> userSearch(@Param("username") String username, @Param("authority") String authority);

    @Select
    com.example.its.infrastructure.entity.Users deleteUserSearch(String username);

}