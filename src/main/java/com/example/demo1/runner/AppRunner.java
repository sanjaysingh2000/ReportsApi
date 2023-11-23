package com.example.demo1.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.example.demo1.entity.EligibilityDetails;
import com.example.demo1.repository.EligibilityDetailsRepo;

@Component
public class AppRunner implements ApplicationRunner{
	
	@Autowired
	private EligibilityDetailsRepo repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		EligibilityDetails entity1 = new EligibilityDetails();
		entity1.setEligId(1);
		entity1.setName("Sanjay");
		entity1.setMobile(798696);
		entity1.setEmail("ram123@gmail.com");
		entity1.setGender('M');
		entity1.setSsn(86786);
		entity1.setPlanName("Java");
		entity1.setPlanStatus("Approved");
		repo.save(entity1);
		
		EligibilityDetails entity2 = new EligibilityDetails();
		entity2.setEligId(2);
		entity2.setName("Sanju");
		entity2.setMobile(7986496);
		entity2.setEmail("ram1234@gmail.com");
		entity2.setGender('M');
		entity2.setSsn(867867);
		entity2.setPlanName("Advance Java");
		entity2.setPlanStatus("Denied");
		repo.save(entity2);
		
		
		EligibilityDetails entity3 = new EligibilityDetails();
		entity3.setEligId(3);
		entity3.setName("Ram");
		entity3.setMobile(7986968);
		entity3.setEmail("ram12345@gmail.com");
		entity3.setGender('M');
		entity3.setSsn(867866);
		entity3.setPlanName("SQL");
		entity3.setPlanStatus("Approved");
		repo.save(entity3);
		
	}

	
	
}
