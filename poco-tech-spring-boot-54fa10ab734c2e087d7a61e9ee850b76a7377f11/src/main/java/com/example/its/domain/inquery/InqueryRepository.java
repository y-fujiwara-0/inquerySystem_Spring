package com.example.its.domain.inquery;

import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface InqueryRepository{

    @Select("select * from inquerys")
    List<Inquery> findAll();

    //TODO inquerysにあったものにあとで変更する
    @Insert("insert into inquerys (summary, description) values (#{summary}, #{description})")
    void insert(String summary, String description);

    @Select("select * from inquerys where id = #{inqueryid}")
    Inquery findById(long inqueryId);

    @Insert("insert into inquerys (mailAddress, name, old, address, classification, day, unread, body) values(#{mailAddress}, #{name}, #{old}, #{address}, #{classification}, #{day}, #{unread}, #{body})")
    int save(Inquery inquery);

    @Transactional
    @Update("UPDATE inquerys  SET unread = '0' WHERE id = #{id}")
    void markAsRead(@Param("id") String id);
}
