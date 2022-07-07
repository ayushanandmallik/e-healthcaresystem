package com.controllerpackage;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dao.PatientDao;
import com.dao.UserDao;
import com.entities.Doctor;
import com.entities.LabReports;
import com.entities.Patient;
import com.entities.Users;
import com.services.DoctorService;
//import com.services.hospital_resService;
import com.services.LabReportsService;
import com.services.PatientService;
import com.services.UserService;

@Controller
public class ReportController extends MainControl{

	@Autowired
	private SessionFactory sessionFactory;

	public void setsessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// --------------------------Download Report------------------------------------
	@RequestMapping(value = "downloadreport/{id}/{rid}")
	public String downloadreport(@PathVariable Integer id, @PathVariable Integer rid, HttpServletResponse res,
			HttpSession session, RedirectAttributes attr) throws IOException, SQLException {

		Users u = (Users) session.getAttribute("users");
		if (u != null) {
			String r = u.getRole();
			if (r.equalsIgnoreCase("Patient")) {
				String em = u.getEmail();
				Patient p = patientService.getpatient(em);
				int pid = p.getPid();
				if (pid == id) {
					LabReports l = lab_reportsService.getreport(rid);

					OutputStream out = res.getOutputStream();
					IOUtils.copy(l.getData().getBinaryStream(), out);
					out.flush();
					out.close();
					return null;
				}
				return "restricted";
			} else if (r.equalsIgnoreCase("Doctor")) {
				String em = u.getEmail();
				Doctor d = doctorService.getdoctor(em);
				int did = d.getId();
				Patient p = patientService.getpatientid(id);
				int pdid = p.getDoctor();
				if (did == pdid) {
					LabReports l = lab_reportsService.getreport(rid);

					OutputStream out = res.getOutputStream();
					IOUtils.copy(l.getData().getBinaryStream(), out);
					out.flush();
					out.close();
					return null;
				}
				return "restricted";

			}
			LabReports l = lab_reportsService.getreport(rid);

			OutputStream out = res.getOutputStream();
			IOUtils.copy(l.getData().getBinaryStream(), out);
			out.flush();
			out.close();
			return null;

		}
		return "restricted";
	}

	// ----------------------------------All
	// Reports-----------------------------------

	@RequestMapping(value = "allreports")
	public String allreports(Model m, HttpSession session) {
		Users u = (Users) session.getAttribute("users");
		if (u != null) {
			String role = u.getRole();
			if (role.equalsIgnoreCase("Admin")) {
				List<LabReports> r = lab_reportsService.allreports();
				List<Patient> p = new ArrayList<Patient>();
				for (LabReports report : r) {
					int pid = report.getPatient_id();
					Patient p1 = patientService.getpatientid(pid);
					p.add(p1);
				}
				m.addAttribute("reports", r);
				m.addAttribute("patient", p);
				return "allreports";
			}
			return "restricted";
		}
		return "restricted";

	}

}
