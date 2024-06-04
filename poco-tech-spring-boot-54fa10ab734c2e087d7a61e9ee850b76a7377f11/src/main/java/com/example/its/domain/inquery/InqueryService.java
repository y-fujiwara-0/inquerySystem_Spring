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

    //既読処理
    public void markAsRead(Long id) {
        Inquery inquery = findById(id);
        inquery.setUnread("0");
        inqueryRepository.save(inquery);
    }
    //未読処理
    public void markAsUnread(Long id){
        Inquery inquery = findById(id);
        inquery.setUnread("1");
        inqueryRepository.save(inquery);
    }
}
