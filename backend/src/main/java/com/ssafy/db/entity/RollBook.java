package com.ssafy.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 방 모델 정의.
 */
@Entity
@Getter
@Setter
//Entity 영속성 및 업데이트에 대한 Auditing 정보를 캡처하는 JPA Entity Listener
@EntityListeners(AuditingEntityListener.class)
@Table(
		uniqueConstraints={
				@UniqueConstraint(
					columnNames={"rmid","date"}
				)
			})
public class RollBook extends BaseEntity{    
	
	@ManyToOne
    @JoinColumn(name="rmid", nullable=false)
	@OnDelete(action=OnDeleteAction.CASCADE)
    RoomMember roomMember;
	
	LocalDate date;
	
	String state;

	@Override
	public String toString() {
		return "RollBook [roomMember=" + roomMember + ", date=" + date + ", state=" + state + "]";
	}

}
