package com.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.dao.*;
import com.entities.LabReports;

@Service
@Primary
public class LabReportsServiceImpl implements LabReportsService {

	@Autowired
	private LabReportsDao lab_reportsDao;
	
	public void setLabReportsDao(LabReportsDao lab_reportsDao) {
		this.lab_reportsDao= lab_reportsDao;
	}

	public void uploadreport(LabReports lab_report) {
		// TODO Auto-generated method stub
		lab_reportsDao.uploadreport(lab_report);
		
	}

	public LabReports getreport(int id) {
		// TODO Auto-generated method stub
		LabReports l= lab_reportsDao.getreport(id);
		return l;
	}

	public List<LabReports> allreports() {
		List<LabReports> r= lab_reportsDao.allreports();
		// TODO Auto-generated method stub
		return r;
	}

	public LabReports getreportbypat(int id) {
		// TODO Auto-generated method stub
		LabReports l= lab_reportsDao.getreportbypat(id);
		return l;
	}

	public List<LabReports> getallreportbypat(int id) {
		// TODO Auto-generated method stub
		List<LabReports> l= lab_reportsDao.getallreportbypat(id);
		return l;
	}
	
	
	
}
