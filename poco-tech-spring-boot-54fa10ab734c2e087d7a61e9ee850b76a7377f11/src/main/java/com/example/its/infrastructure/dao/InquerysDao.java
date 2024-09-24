//package com.example.its.infrastructure.dao;
//
//import com.example.its.infrastructure.entity.Inquerys;
//import org.seasar.doma.Dao;
//import org.seasar.doma.Delete;
//import org.seasar.doma.Insert;
//import org.seasar.doma.Select;
//import org.seasar.doma.Update;
//import org.seasar.doma.boot.ConfigAutowireable;
//
//import java.util.Optional;
//
///**
// * InquerysDao
// */
//@Dao
//@ConfigAutowireable
//public interface InquerysDao {
//
//    /**
//     * 主キーを指定してInquerysを検索します。
//     * @param id Inquerysエンティティのid
//     * @return the Inquerys entity
//     */
//    @Select
//    Optional<Inquerys> selectById(Long id);
//
//    /**
//     * Inquerysを登録します。
//     * @param entity Inquerysエンティティ
//     * @return 登録された行数
//     */
//    @Insert
//    int insert(Inquerys entity);
//
//    /**
//     * Inquerysを更新します。
//     * @param entity Inquerysエンティティ
//     * @return 更新された行数
//     */
//    @Update
//    int update(Inquerys entity);
//
//    /**
//     * Inquerysを削除します。
//     * @param entity Inquerysエンティティ
//     * @return 削除された行数
//     */
//    @Delete
//    int delete(Inquerys entity);
//
//}