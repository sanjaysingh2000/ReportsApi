package com.example.demo1.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.request.SearchRequest;
import com.example.demo1.response.SearchResponse;
import com.example.demo1.service.ReportService;
import com.example.demo1.service.ReportServiceImpl;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class ReportRestController {
	
	@Autowired
	private ReportService service;
	
	@GetMapping("/plans")
	public ResponseEntity<List<String>> getPlanNames(){
		
		List<String> planNames = service.getUniqueNames();
		return new ResponseEntity<>(planNames, HttpStatus.OK);
	}
	
	@GetMapping("/statuses")
	public ResponseEntity<List<String>> getPlanStatus(){
		
		List<String> planStatuses = service.getUniquePlanStatuses();
		return new ResponseEntity<>(planStatuses, HttpStatus.OK);
	
	}
	
	
	@PostMapping("/search")
	public ResponseEntity<List<SearchResponse>> search(@RequestBody SearchRequest request){
	
		List<SearchResponse> response = service.search(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/excel")
	public void excelReport(HttpServletResponse response) throws Exception {
		
		response.setContentType("appication/octet-stream");
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=data.xls";
		
		response.setHeader(headerKey, headerValue);
		service.generateExcel(response);
		
	}
	
	@GetMapping("/pdf")
	public void pdfReport(HttpServletResponse response) throws Exception {
		
		response.setContentType("application/pdf");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=data.pdf";
		response.setHeader(headerKey, headerValue);
		service.generatePdf(response);
		
		
		
		
		
	}
	
	
	
	
	
	
}
