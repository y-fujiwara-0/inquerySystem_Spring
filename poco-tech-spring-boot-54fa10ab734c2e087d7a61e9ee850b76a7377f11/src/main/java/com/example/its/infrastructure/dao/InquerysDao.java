package com.example.its.infrastructure.dao;

import com.example.its.infrastructure.entity.Inquerys;
import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * InquerysDao
 */
@Dao
@ConfigAutowireable
public interface InquerysDao {

    /**
     * 主キーを指定してInquerysを検索します。
     * @param id Inquerysエンティティのid
     * @return the Inquerys entity
     */
    @Select
    Optional<Inquerys> findById(Long id);

    /**
     * 全てのInquerysを検索します。
     *
     * @return 全てのInquerysエンティティのリスト
     */
    @Select
    List<Inquerys> findAll();

    /**
     * Inquerysを登録します。
     *
     * @param entity Inquerysエンティティ
     * @return 登録された行数
     */
    @Insert
    Result<Inquerys> insert(Inquerys entity);

    /**
     * Inquerysを更新します。
     *
     * @param entity Inquerysエンティティ
     * @return 更新された行数
     */
    @Update
    Result<Inquerys> update(Inquerys entity);

    /**
     * Inquerysを削除します。
     *
     * @param entity Inquerysエンティティ
     * @return 削除された行数
     */
    @Delete
    Result<Inquerys> delete(Inquerys entity);

    /**
     * 指定されたキーワードと日付範囲でInquerysを検索します。
     * @param keyword 検索キーワード
     * @param dateFrom 検索開始日
     * @param dateTo 検索終了日
     * @return 検索結果のInquerysエンティティのリスト
     */
    @Select
    List<Inquerys> inquerySearch(@Param("keyword") String keyword,
                                 @Param("dateFrom") LocalDate dateFrom,
                                 @Param("dateTo") LocalDate dateTo);

    /**
     * Inquerysの既読ステータスを更新します。
     * @param inqueryId 更新するInquerysのID
     * @param isReaded 既読か未読か
     * @return 更新された行数
     */
//    @Update
//    int updateReadStatus(Long inqueryId, String isReaded);


}