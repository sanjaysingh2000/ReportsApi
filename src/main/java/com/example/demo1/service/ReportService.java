package com.example.demo1.service;

import java.util.List;

import com.example.demo1.request.SearchRequest;

import com.example.demo1.response.SearchResponse;

import jakarta.servlet.http.HttpServletResponse;
public interface ReportService {
	
	public List<String> getUniqueNames();
	
	public List<String> getUniquePlanStatuses();
	
	public List<SearchResponse> search(SearchRequest request);
	
	public void generateExcel(HttpServletResponse response) throws Exception;
	
	public void generatePdf(HttpServletResponse response) throws Exception;

}
