package com.example.demo1.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import com.example.demo1.entity.EligibilityDetails;
import com.example.demo1.repository.EligibilityDetailsRepo;                                                                                           
import com.example.demo1.request.SearchRequest;
import com.example.demo1.response.SearchResponse;

import jakarta.servlet.http.HttpServletResponse;

public class ReportServiceImpl implements ReportService {

	@Autowired
	private EligibilityDetailsRepo eligRepo;

	@Override
	public List<String> getUniqueNames() {

		return eligRepo.findPlanNames();
	}

	@Override
	public List<String> getUniquePlanStatuses() {

		return eligRepo.findPlanStatus();
	}

	@Override
	public void generateExcel(HttpServletResponse response) {
		
		List<EligibilityDetails> entities = eligRepo.findAll();
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		HSSFRow headerRow = sheet.createRow(0);
		
		headerRow.createCell(0).setCellValue("S.No");
		headerRow.createCell(1).setCellValue("Name");
		headerRow.createCell(2).setCellValue("Mobile");
		headerRow.createCell(3).setCellValue("Gender");                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
		headerRow.createCell(4).setCellValue("SSN");		
		
		
		int i=1;
		entities.forEach(entity -> {
			
			HSSFRow datarow = sheet.createRow(i);
			datarow.createCell(0).setCellValue(entity.getName());
			datarow.createCell(1).setCellValue(entity.getMobile());
			datarow.createCell(2).setCellValue(entity.getGender());
			datarow.createCell(3).setCellValue(entity.getSsn());
			
		});
		
	}

	@Override
	public void generatePdf(HttpServletResponse response) {

	}

	@Override
	public List<SearchResponse> search(SearchRequest request) {

		List<SearchResponse> response = new ArrayList<>();

		EligibilityDetails queryBuilder = new EligibilityDetails();

		String planName = request.getPlanName();

		if (planName != null && planName.equals("")) {
			queryBuilder.setPlanName(planName);
		}

		String planStatus = request.getPlanStatus();
		if (planName != null && planName.equals("")) {
			queryBuilder.setPlanStatus(planStatus);
		}

		LocalDate planStartDate = request.getPlanStartDate();
		if(planStartDate!=null) {
			request.setPlanStartDate(planStartDate);
		}
		
		LocalDate planEndDate = request.getPlanEndDate();
		if(planEndDate!=null) {
			request.setPlanEndDate(planEndDate);
		}
		
		Example<EligibilityDetails> example = Example.of(queryBuilder);

		List<EligibilityDetails> entities = eligRepo.findAll();

		for (EligibilityDetails entity : entities) {

			SearchResponse sr = new SearchResponse();

			BeanUtils.copyProperties(entity, sr);
		}
		return response;
	}
}
