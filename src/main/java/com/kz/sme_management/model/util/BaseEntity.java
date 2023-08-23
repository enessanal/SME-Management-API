package com.kz.sme_management.model.util;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@MappedSuperclass
@ToString
public abstract class BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id", updatable = false, nullable = false)
    @Getter
    private String id;

    @Getter
    @Column(name="created_time", updatable = false)
    @CreationTimestamp
    private Date createdTime;

    @Getter
    @UpdateTimestamp
    @Column(name="updated_time")
    private Date updatedTime;
}
