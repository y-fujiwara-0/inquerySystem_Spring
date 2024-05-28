package com.example.its.domain.inquery;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InqueryService {

    private final InqueryRepository inqueryRepository;


    public List<Inquery> findAll() {
        return inqueryRepository.findAll();
    }

    //TODO inqueryにあったものに変更する
    @Transactional
    public Inquery save(Inquery inquery) {
        return inqueryRepository.save(inquery);
    }

    public Inquery findById(Long id) {
        return inqueryRepository.findById(id);
    }
    @Transactional
    public void create(String mailAddress, String name, String old, String address, String classification, String day, String unread, String body) {
    }
    public void markAsRead(Long id) {
        Inquery inquery = findById(id);
        inquery.setUnread("0");
        inqueryRepository.save(inquery);
    }
}
