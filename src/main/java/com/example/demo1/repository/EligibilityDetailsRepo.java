package com.example.demo1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo1.entity.EligibilityDetails;

public interface EligibilityDetailsRepo extends JpaRepository<EligibilityDetails, Integer>{

	@Query("select distinctt(planName from EligibilityDetails")
	public List<String> findPlanNames();
	
	
	@Query("select distinct(planStatus from EligibilityDetails")
	public List<String> findPlanStatus();
	
	
}
