package com.example.its.domain.repository;

import com.example.its.domain.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Dao
@ConfigAutowireable
public interface UserRepository {

    @Select
    Optional<User> findByUsernameAndDeleteflagFalse(String username);

    @Select
   List<User> findAll();

    @Insert
    @Transactional
    Result<User> insert(User user);

    @Update
    @Transactional
    Result<User> updatePassword(User user);

    @Update
    @Transactional
    Result<User> updateDeleteFlag(User user);
}