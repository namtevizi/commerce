package com.evizi.commerce.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseModel implements Serializable {

    @CreatedDate
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    @JsonIgnore
    LocalDateTime createdTime;

    @LastModifiedDate
    @Column(nullable = false)
    @UpdateTimestamp
    @JsonIgnore
    LocalDateTime modifiedTime;

    @CreatedBy
    @Column(nullable = false, updatable = false)
    @JsonIgnore
    private String createdBy;

    @LastModifiedBy
    @Column(nullable = false)
    @JsonIgnore
    private String modifiedBy;

}