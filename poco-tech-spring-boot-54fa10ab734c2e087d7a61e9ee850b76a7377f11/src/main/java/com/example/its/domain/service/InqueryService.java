package com.example.its.domain.service;

import com.example.its.domain.model.Inquery;
import com.example.its.domain.repository.InqueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InqueryService {

    private final InqueryRepository inqueryRepository;


    public List<Inquery> findAll() {
        return inqueryRepository.findAll();
    }

    public List<Inquery> inquerySearch(String keyword, LocalDate dateFrom, LocalDate dateTo) {
        return inqueryRepository.inquerySearch(keyword, dateFrom, dateTo);
    }


    @Transactional
    public int save(Inquery inquery) {
        return inqueryRepository.save(inquery);
    }

    public Inquery findById(Long id) {
        return inqueryRepository.findById(id);
    }
    @Transactional
    public void create(String mailAddress, String name, String old, String address, String classification, String day, String unread, String body) {
    }

    // 既読処理
    public void markAsRead(Long inqueryId) {
        updateUnreadStatus(inqueryId, "0");
    }

    // 未読処理
    public void markAsUnread(Long inqueryId) {
        updateUnreadStatus(inqueryId, "1");
    }

    // 共通処理
    private void updateUnreadStatus(Long id, String status) {
        inqueryRepository.save(Optional.ofNullable(findById(id))
                .map(inquery -> {
                    inquery.setIs_readed(status);
                    return inquery;
                })
                .orElseThrow(() -> new IllegalArgumentException("Inquiry not found with inqueryId: " + id)));
    }
}
