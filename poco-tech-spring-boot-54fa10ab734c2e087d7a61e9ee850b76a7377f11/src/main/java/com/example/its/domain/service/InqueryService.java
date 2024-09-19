package com.example.its.domain.service;

import com.example.its.domain.model.Inquery;
import com.example.its.domain.repository.InqueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InqueryService {

    private final InqueryRepository inqueryRepository;


    public List<Inquery> findAll() {
        return inqueryRepository.findAll();
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
    public void markAsRead(Long inquery_id) {
        updateUnreadStatus(inquery_id, "0");
    }

    // 未読処理
    public void markAsUnread(Long inquery_id) {
        updateUnreadStatus(inquery_id, "1");
    }

    // 共通処理
    private void updateUnreadStatus(Long id, String status) {
        inqueryRepository.save(Optional.ofNullable(findById(id))
                .map(inquery -> {
                    inquery.setIs_readed(status);
                    return inquery;
                })
                .orElseThrow(() -> new IllegalArgumentException("Inquiry not found with inquery_id: " + id)));
    }
}
