package com.example.its.infrastructure.entity;

import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * Sample Entity
 */
@Entity
@Table(name = "SAMPLE")
public class Sample {

    /** sampleId */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SAMPLE_ID")
    Long sampleId;

    /** name */
    @Column(name = "NAME")
    String name;

    /** createdAt */
    @Column(name = "createdAt")
    LocalDateTime createdAt;

    /**
     * Returns the sampleId.
     * @return the sampleId
     */
    public Long getSampleId() {
        return sampleId;
    }

    /**
     * Sets the sampleId.
     * @param sampleId the sampleId
     */
    public void setSampleId(Long sampleId) {
        this.sampleId = sampleId;
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

}