package br.com.cuidapet.cuidapet.models;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import java.time.Instant;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class BaseModelClass {

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant Created_at;

    @LastModifiedBy
    @Column(nullable = false)
    private Instant Updated_at;

}
