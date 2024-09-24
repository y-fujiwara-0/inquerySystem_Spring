package com.example.its.infrastructure.entity;

import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * Inquerys Entity
 */
@Entity
@Table(name = "INQUERYS")
public class Inquerys {

    /** inqueryId */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INQUERY_ID")
    Long inqueryId;

    /** mailAddress */
    @Column(name = "MAIL_ADDRESS")
    String mailAddress;

    /** name */
    @Column(name = "NAME")
    String name;

    /** age */
    @Column(name = "AGE")
    Integer age;

    /** address */
    @Column(name = "ADDRESS")
    String address;

    /** classification */
    @Column(name = "CLASSIFICATION")
    Short classification;

    /** registrationAt */
    @Column(name = "REGISTRATION_AT")
    LocalDateTime registrationAt;

    /** replyAt */
    @Column(name = "REPLY_AT")
    LocalDateTime replyAt;

    /** isReaded */
    @Column(name = "IS_READED")
    Short isReaded;

    /** content */
    @Column(name = "CONTENT")
    String content;

    /** createdAt */
    @Column(name = "CREATED_AT")
    LocalDateTime createdAt;

    /** updatedAt */
    @Column(name = "UPDATED_AT")
    LocalDateTime updatedAt;

    /**
     * Returns the inqueryId.
     * @return the inqueryId
     */
    public Long getInqueryId() {
        return inqueryId;
    }

    /**
     * Sets the inqueryId.
     * @param inqueryId the inqueryId
     */
    public void setInqueryId(Long inqueryId) {
        this.inqueryId = inqueryId;
    }

    /**
     * Returns the mailAddress.
     * @return the mailAddress
     */
    public String getMailAddress() {
        return mailAddress;
    }

    /**
     * Sets the mailAddress.
     * @param mailAddress the mailAddress
     */
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    /**
     * Returns the name.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the age.
     * @return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Sets the age.
     * @param age the age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * Returns the address.
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address.
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns the classification.
     * @return the classification
     */
    public Short getClassification() {
        return classification;
    }

    /**
     * Sets the classification.
     * @param classification the classification
     */
    public void setClassification(Short classification) {
        this.classification = classification;
    }

    /**
     * Returns the registrationAt.
     * @return the registrationAt
     */
    public LocalDateTime getRegistrationAt() {
        return registrationAt;
    }

    /**
     * Sets the registrationAt.
     * @param registrationAt the registrationAt
     */
    public void setRegistrationAt(LocalDateTime registrationAt) {
        this.registrationAt = registrationAt;
    }

    /**
     * Returns the replyAt.
     * @return the replyAt
     */
    public LocalDateTime getReplyAt() {
        return replyAt;
    }

    /**
     * Sets the replyAt.
     * @param replyAt the replyAt
     */
    public void setReplyAt(LocalDateTime replyAt) {
        this.replyAt = replyAt;
    }

    /**
     * Returns the isReaded.
     * @return the isReaded
     */
    public Short getIsReaded() {
        return isReaded;
    }

    /**
     * Sets the isReaded.
     * @param isReaded the isReaded
     */
    public void setIsReaded(Short isReaded) {
        this.isReaded = isReaded;
    }

    /**
     * Returns the content.
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content.
     * @param content the content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Returns the createdAt.
     * @return the createdAt
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the createdAt.
     * @param createdAt the createdAt
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Returns the updatedAt.
     * @return the updatedAt
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets the updatedAt.
     * @param updatedAt the updatedAt
     */
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}