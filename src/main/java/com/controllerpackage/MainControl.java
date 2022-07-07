package com.controllerpackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.services.AllotmentService;
import com.services.ContactService;
import com.services.DepartmentService;
import com.services.DoctorService;
import com.services.LabReportsService;
import com.services.PatientDetailsService;
import com.services.PatientService;
import com.services.TreatmentService;
import com.services.UserService;
import com.services.WardService;

@Controller
public class MainControl {
	@Autowired
	protected UserService userService;

	@Autowired
	protected DoctorService doctorService;

	@Autowired
	protected PatientService patientService;

	@Autowired
	protected ContactService contactService;
	
	@Autowired
	protected PatientDetailsService patient_detailsService;
	
	@Autowired
	protected DepartmentService departmentService;
	
	@Autowired
	protected AllotmentService allotmentService;
	
//	@Autowired
//	protected BloodgroupService bloodgroupService;
//	
	@Autowired
	protected LabReportsService lab_reportsService;
	
	@Autowired
	protected TreatmentService treatmentService;
	
	@Autowired
	protected WardService wardService;
	
}
