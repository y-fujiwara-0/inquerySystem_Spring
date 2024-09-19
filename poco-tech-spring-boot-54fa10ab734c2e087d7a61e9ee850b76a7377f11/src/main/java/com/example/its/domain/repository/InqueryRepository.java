package com.example.its.domain.repository;

import com.example.its.domain.model.Inquery;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface InqueryRepository{

    @Select("select * from inquerys ORDER BY inquery_id DESC")
    List<Inquery> findAll();

    @Insert("insert into inquerys (summary, description) values (#{summary}, #{description})")
    void insert(String summary, String description);

    @Select("select * from inquerys where inquery_id = #{inquery_id}")
    Inquery findById(long inqueryId);

    @Insert("insert into inquerys (mail_Address, name, age, address, classification, registration_At, is_readed, text) values(#{mailAddress}, #{name}, #{age}, #{address}, #{classification}, #{registration_at}, #{isReaded}, #{text})")
    int save(Inquery inquery);

    @Transactional
    @Update("UPDATE inquerys  SET unread = '0' WHERE inquery_id = #{inquery_id}")
    void markAsRead(@Param("inquery_id") String inquery_id);

    @Transactional
    @Update("UPDATE inquerys  SET is_readed = '1' WHERE inquery_id = #{inquery_id}")
    void markAsUnread(@Param("inquery_id") Long inquery_id);
}

