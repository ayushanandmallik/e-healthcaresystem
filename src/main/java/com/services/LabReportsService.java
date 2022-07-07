package com.services;

import java.util.List;

import com.entities.LabReports;

public interface LabReportsService {

	
	public void uploadreport(LabReports lab_report);
	public LabReports getreport(int id);
	public List<LabReports> allreports();
	public LabReports getreportbypat(int id);
	public List<LabReports> getallreportbypat(int id);
	
	
}
