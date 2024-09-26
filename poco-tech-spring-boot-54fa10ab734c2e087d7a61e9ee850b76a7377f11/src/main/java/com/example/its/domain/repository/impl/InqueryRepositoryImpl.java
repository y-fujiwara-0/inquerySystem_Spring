package com.example.its.domain.repository.impl;

import com.example.its.domain.model.Inquery;
import com.example.its.domain.repository.InqueryRepository;
import com.example.its.infrastructure.dao.InquerysDao;
import com.example.its.infrastructure.entity.Inquerys;
import com.example.its.infrastructure.mapper.InquerysMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.seasar.doma.jdbc.Result;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class InqueryRepositoryImpl implements InqueryRepository {
    private final InquerysDao inquerysDao;
    private final InquerysMapper inqueryMapper;

    @Override
    public List<Inquery> findAll(){
        List<Inquerys> entities = inquerysDao.findAll();
        return entities.stream()
                .map(inqueryMapper::mapToDomain) // エンティティをドメインモデルにマッピング
                .collect(Collectors.toList());
    }
    @Override
    public void insert(String summary, String description) {
        try {
            // 新規のinqueryを挿入する処理
            Inquerys entity = Inquerys.builder()
                    .mailAddress(summary) // 適切なプロパティに設定
                    .content(description) // 適切なプロパティに設定
                    .build();
            inquerysDao.insert(entity);
        } catch (Exception e) {
            throw new RuntimeException("Insert failed: " + e.getMessage(), e);
        }
    }
    @Override
    public Inquery findById(long inqueryId){
        Optional<com.example.its.infrastructure.entity.Inquerys> entity = inquerysDao.findById(inqueryId);
        return entity.map(inqueryMapper::mapToDomain).orElse(null);
    }
    @Override
    public Result<Inquerys> save(Inquery inquery){
        try {
            com.example.its.infrastructure.entity.Inquerys entity = inqueryMapper.mapToEntity(inquery);
            return inquerysDao.insert(entity); // 挿入メソッドを呼び出して行数を返す
        } catch (Exception e) {
            throw new RuntimeException("Save failed: " + e.getMessage());
        }
    }
//    @Override
//    public void markAsRead(long inqueryId) {
//        try {
//            inquerysDao.updateReadStatus(inqueryId, "1");
//        } catch (Exception e) {
//            throw new RuntimeException("Mark as read failed: " + e.getMessage());
//        }
//    }
//    @Override
//    public void markAsUnread(long inqueryId) {
//        try {
//            inquerysDao.updateReadStatus(inqueryId, "0");
//        } catch (Exception e) {
//            throw new RuntimeException("Mark as unread failed: " + e.getMessage());
//        }
//    }

    @Override
    public List<Inquery> inquerySearch(@Param("keyword") String keyword,
                                       @Param("dateFrom") LocalDate dateFrom,
                                       @Param("dateTo") LocalDate dateTo) {
        try {
            List<com.example.its.infrastructure.entity.Inquerys> entities = inquerysDao.inquerySearch(keyword, dateFrom, dateTo);
            return entities.stream()
                    .map(inqueryMapper::mapToDomain)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Search failed: " + e.getMessage());
        }
    }
}