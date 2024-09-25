package com.example.its.domain.repository;

import com.example.its.domain.model.Users;
import org.apache.ibatis.annotations.Param;
import org.seasar.doma.*;
import org.seasar.doma.jdbc.Result;
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
    Result<Users> updateDeleteFlag(Users users);

    @Select
    List<Users> user_search(@Param("username") String username, @Param("authority") String authority);

}