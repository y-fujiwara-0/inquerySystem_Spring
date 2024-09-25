package com.example.its.infrastructure.dao;


import com.example.its.infrastructure.entity.Users;
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

    @Insert(sqlFile = true)
    Result<Users> insert(Users users);

    @Update(sqlFile = true)
    @Transactional
    Result<Users> updatePassword(Users users);

    @Update
    @Transactional
    Result<Users> updateDeleteFlag(Users users);
}
