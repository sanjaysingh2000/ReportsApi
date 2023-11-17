package com.example.demo1.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ELIGIBILITY_DETAILS")
@Data
public class EligibilityDetails {
	
	@Id
	private Integer eligId;
	
	private String name;
	
	private long mobile;
	
	private String email;
	
	private Character gender;
	
	private long ssn;
	
	private String planName;
	
	private String planStatus;
	
	private LocalDateTime planStartDate;
	
	private LocalDateTime planEndDate;
	
	private LocalDateTime createDate;
	
	private LocalDateTime updateDate;
	
	private String createdBy;
	
	private String updatedBy;

}

