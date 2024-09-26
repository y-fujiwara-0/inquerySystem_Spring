package com.example.its.infrastructure.entity;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.jdbc.criteria.context.Criterion;

/**
 * Inquerys Entity
 */
@Entity(immutable = true)
@Table(name = "inquerys")
@Getter
@Builder
public class Inquerys {

    /**
     * inqueryId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inquery_id") // ここを小文字に変更
    private final Long inqueryId;

    /**
     * mailAddress
     */
    @Column(name = "mail_address")
    private final String mailAddress;

    /**
     * name
     */
    @Column(name = "name")
    private final String name;

    /**
     * age
     */
    @Column(name = "age")
    private final Integer age;

    /**
     * address
     */
    @Column(name = "address")
    private final String address;

    /**
     * classification
     */
    @Column(name = "classification")
    private final String classification;

    /**
     * registrationAt
     */
    @Column(name = "registration_at") // スネークケースに変更
    private final LocalDateTime registrationAt;

    /**
     * replyAt
     */
    @Column(name = "reply_at") // スネークケースに変更
    private final LocalDateTime replyAt;

    /**
     * isReaded
     */
    @Column(name = "is_readed") // スネークケースに変更
    private final String isReaded;

    /**
     * content
     */
    @Column(name = "content")
    private final String content;

    /**
     * createdAt
     */
    @Column(name = "created_at") // スネークケースに変更
    private final LocalDateTime createdAt;

    /**
     * updatedAt
     */
    @Column(name = "updated_at") // スネークケースに変更
    private final LocalDateTime updatedAt;

    public Inquerys(Long inqueryId, String mailAddress, String name, Integer age, String address,
                    String classification, LocalDateTime registrationAt, LocalDateTime replyAt, String isReaded,
                    String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.inqueryId = inqueryId; // こちらはオートインクリメントのためnullではなく、引数をそのまま使用
        this.mailAddress = mailAddress;
        this.name = name;
        this.age = age;
        this.address = address;
        this.classification = classification;
        this.registrationAt = registrationAt;
        this.replyAt = replyAt;
        this.isReaded = isReaded;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}

//    /**
//     * Returns the inqueryId.
//     * @return the inqueryId
//     */
//    public Long getInqueryId() {
//        return inqueryId;
//    }
//
//    /**
//     * Sets the inqueryId.
//     * @param inqueryId the inqueryId
//     */
//    public void setInqueryId(Long inqueryId) {
//        this.inqueryId = inqueryId;
//    }
//
//    /**
//     * Returns the mailAddress.
//     * @return the mailAddress
//     */
//    public String getMailAddress() {
//        return mailAddress;
//    }
//
//    /**
//     * Sets the mailAddress.
//     * @param mailAddress the mailAddress
//     */
//    public void setMailAddress(String mailAddress) {
//        this.mailAddress = mailAddress;
//    }
//
//    /**
//     * Returns the name.
//     * @return the name
//     */
//    public String getName() {
//        return name;
//    }
//
//    /**
//     * Sets the name.
//     * @param name the name
//     */
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    /**
//     * Returns the age.
//     * @return the age
//     */
//    public Integer getAge() {
//        return age;
//    }
//
//    /**
//     * Sets the age.
//     * @param age the age
//     */
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    /**
//     * Returns the address.
//     * @return the address
//     */
//    public String getAddress() {
//        return address;
//    }
//
//    /**
//     * Sets the address.
//     * @param address the address
//     */
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    /**
//     * Returns the classification.
//     * @return the classification
//     */
//    public Short getClassification() {
//        return classification;
//    }
//
//    /**
//     * Sets the classification.
//     * @param classification the classification
//     */
//    public void setClassification(Short classification) {
//        this.classification = classification;
//    }
//
//    /**
//     * Returns the registrationAt.
//     * @return the registrationAt
//     */
//    public LocalDateTime getRegistrationAt() {
//        return registrationAt;
//    }
//
//    /**
//     * Sets the registrationAt.
//     * @param registrationAt the registrationAt
//     */
//    public void setRegistrationAt(LocalDateTime registrationAt) {
//        this.registrationAt = registrationAt;
//    }
//
//    /**
//     * Returns the replyAt.
//     * @return the replyAt
//     */
//    public LocalDateTime getReplyAt() {
//        return replyAt;
//    }
//
//    /**
//     * Sets the replyAt.
//     * @param replyAt the replyAt
//     */
//    public void setReplyAt(LocalDateTime replyAt) {
//        this.replyAt = replyAt;
//    }
//
//    /**
//     * Returns the isReaded.
//     * @return the isReaded
//     */
//    public Short getIsReaded() {
//        return isReaded;
//    }
//
//    /**
//     * Sets the isReaded.
//     * @param isReaded the isReaded
//     */
//    public void setIsReaded(Short isReaded) {
//        this.isReaded = isReaded;
//    }
//
//    /**
//     * Returns the content.
//     * @return the content
//     */
//    public String getContent() {
//        return content;
//    }
//
//    /**
//     * Sets the content.
//     * @param content the content
//     */
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    /**
//     * Returns the createdAt.
//     * @return the createdAt
//     */
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    /**
//     * Sets the createdAt.
//     * @param createdAt the createdAt
//     */
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    /**
//     * Returns the updatedAt.
//     * @return the updatedAt
//     */
//    public LocalDateTime getUpdatedAt() {
//        return updatedAt;
//    }
//
//    /**
//     * Sets the updatedAt.
//     * @param updatedAt the updatedAt
//     */
//    public void setUpdatedAt(LocalDateTime updatedAt) {
//        this.updatedAt = updatedAt;
//    }
//
//}