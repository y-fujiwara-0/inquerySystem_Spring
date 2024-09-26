package com.example.its.domain.repository;

import com.example.its.domain.model.Inquery;
import com.example.its.infrastructure.entity.Inquerys;
import org.mapstruct.Mapper;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.jdbc.Result;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface InqueryRepository{

    @Select
    List<Inquery> findAll();

    @Insert
    void insert(String summary, String description);

    @Select
    Inquery findById(long inqueryId);

    @Insert
    Result<Inquerys> save(Inquery inquery);

    @Transactional
    @Update
    void markAsRead(@Param("inqueryId") String inqueryId);

    @Transactional
    @Update
    void markAsUnread(@Param("inqueryId") Long inqueryId);


    @Select
    List<Inquery> inquerySearch(@Param("keyword") String keyword,
                                 @Param("dateFrom") LocalDate dateFrom,
                                 @Param("dateTo") LocalDate dateTo);

}

