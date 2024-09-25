package com.example.its.infrastructure.dao;


import com.example.its.infrastructure.entity.Users;
import org.apache.ibatis.annotations.Param;
import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * UsersDao
 */
@Dao
@ConfigAutowireable
public interface UsersDao {
    @Select
    Optional<Users> findByUsernameAndDeleteflagFalse(String username);

    @Select
    List<Users> findAll();

    @Select
    List<Users> user_search(@Param("username") String username, @Param("authority") String authority);

    @Insert(sqlFile = true)
    Result<Users> insert(Users users);

    @Update(sqlFile = true)
    @Transactional
    Result<Users> updatePassword(Users users);

    @Update
    @Transactional
    Result<Users> updateDeleteFlag(Users users);
}
