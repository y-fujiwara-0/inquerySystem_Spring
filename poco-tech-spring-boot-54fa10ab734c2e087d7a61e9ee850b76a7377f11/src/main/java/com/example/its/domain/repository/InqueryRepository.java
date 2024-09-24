package com.example.its.domain.repository;

import com.example.its.domain.model.Inquery;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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


    @Select("<script>"
            + "SELECT * FROM inquerys"
            + " WHERE 1=1"
            + "<if test='keyword != null and !keyword.isEmpty()'>"
            + " AND (mail_Address LIKE CONCAT('%', #{keyword}, '%')"
            + " OR name LIKE CONCAT('%', #{keyword}, '%')"
            + " OR content LIKE CONCAT('%', #{keyword}, '%'))"
            + "</if>"
            + "<if test='dateFrom != null'>"
            + " AND registration_At &gt;= #{dateFrom}"
            + "</if>"
            + "<if test='dateTo != null'>"
            + " AND registration_At &lt;= #{dateTo}"
            + "</if>"
            + " ORDER BY inquery_id DESC"
            + "</script>")
    List<Inquery> inquery_search(@Param("keyword") String keyword,
                                 @Param("dateFrom") LocalDate dateFrom,
                                 @Param("dateTo") LocalDate dateTo);

}

