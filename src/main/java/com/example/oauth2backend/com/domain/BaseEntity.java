package com.example.oauth2backend.com.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseEntity implements Serializable {

	@CreatedDate
	@Column(name = "CREATED_AT", updatable = false)
	private LocalDateTime createAt;

	@LastModifiedDate
	@Column(name = "LAST_MODIFIED_AT")
	private LocalDateTime updateAt;

	@Column(name = "IS_VALID")
	@Builder.Default()
	private String isValid = "Y";

}
