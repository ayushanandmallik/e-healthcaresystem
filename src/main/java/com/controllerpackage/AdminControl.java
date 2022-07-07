package com.controllerpackage;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

//import com.dao.UserDao;
import com.entities.Patient;
import com.entities.PatientDetails;
import com.entities.Users;
import com.entities.Ward;
import com.entities.Contact;
import com.entities.Department;
import com.entities.Doctor;
//import com.entities.hospital_res;
import com.entities.LabReports;

@Controller
public class AdminControl extends MainControl{

	@Autowired
	private SessionFactory sessionFactory;

	public void setsessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// --------------------Add Patient----------------------------------------

	@RequestMapping(value = "/addpatient", method = RequestMethod.GET)
	public String addpatient(Model m, HttpSession session, HttpServletRequest req) {
		Users u = (Users) session.getAttribute("users");
		Map<String, ?> flashmsg = RequestContextUtils.getInputFlashMap(req);
		if (u != null) {
			String r = u.getRole();
			if (r.equalsIgnoreCase("Admin")) {
				if (flashmsg != null) {
					String msg = (String) flashmsg.get("msg");
					List<Doctor> d = doctorService.getall();
					m.addAttribute("doctors", d);
					m.addAttribute("msg", msg);
					return "addpatient";
				}

				List<Doctor> d = doctorService.getall();
				m.addAttribute("doctors", d);
				return "addpatient";
			}
		}

		return "redirect:/adminlogin";

	}

	@RequestMapping(value = "/addpatient", method = RequestMethod.POST)
	public String addpatient(@ModelAttribute("patient") Patient p, Model m, RedirectAttributes attr, @RequestParam("phone") String ph, @RequestParam("email") String email) {
		Contact c= new Contact();
		c.setPhone_no(ph);
		c.setEmail(email);
		int j= contactService.savecontact(c);
		if(j==0) {
			Patient pat= patientService.getpatient(email);
			if(pat!=null) {
				int patid= pat.getPid();
				PatientDetails pat_det= patient_detailsService.get_patient_details(patid);
				Integer st= pat_det.getStatus();
				if(st==1) {
					String msg = "This patient is an active patient...try another one!";
					attr.addFlashAttribute("msg", msg);
					return "redirect:/addpatient";
				}
				Integer pat_det_id= pat_det.getId();
				patient_detailsService.updatestatus(pat_det_id);
				patientService.updatepatientdoctor(patid, p.getDoctor());
				String msg = "This patient has visited before and has been treated in the past. His current status has been changed to Active.";
				attr.addFlashAttribute("msg", msg);
				return "redirect:/addpatient";
			}
		}
		Contact cp= contactService.getcontactem(ph);
		p.setContact(cp.getId());
		int i = patientService.addpatient(p);
		Patient p1= patientService.getpatient(email);
		PatientDetails pd= new PatientDetails();
		pd.setPid(p1.getPid());
		pd.setStatus(1);
		patient_detailsService.add_patient_details(pd);
		Users u= new Users();
		String pwd= p.getFirst_name()+"@"+p.getLast_name();
		u.setEmail(email);
		u.setFname(p.getFirst_name());
		u.setLname(p.getLast_name());
		u.setPassword(pwd);
		u.setRole("Patient");
		userService.registerUser(u);
		String msg = "Patient added. Password for user is FirstName@LastName";
		attr.addFlashAttribute("msg", msg);
		return "redirect:/addpatient";
	}

	// ---------------------------Add Doctor----------------------------------------

	@RequestMapping(value = "/adddoctor", method = RequestMethod.GET)
	public String adddoctor(Model m, HttpSession session, HttpServletRequest req) {
		Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(req);
		Users u = (Users) session.getAttribute("users");
		if (u != null) {
			String r = u.getRole();
			if (r.equalsIgnoreCase("Admin")) {
				if (inputFlashMap != null) {
					String msg = (String) inputFlashMap.get("msg");
					m.addAttribute("msg", msg);
					List<Department> d= departmentService.getalldepartment();
					m.addAttribute("department", d);
					return "adddoctor";
				}
				String msg = "";
				m.addAttribute("msg", msg);
				List<Department> d= departmentService.getalldepartment();
				m.addAttribute("department", d);
				return "adddoctor";
			}
		}
		return "redirect:/adminlogin";

	}

	@RequestMapping(value = "/adddoctor", method = RequestMethod.POST)
	public String adddoctor(@RequestParam("email") String email,@RequestParam("phone") String phone,@ModelAttribute("doctor") Doctor d, Model m, RedirectAttributes attr) {
		
		Contact c= new Contact();
		c.setPhone_no(phone);
		c.setEmail(email);
		int j= contactService.savecontact(c);
		if(j==0) {
			String msg = "This doctor already exists...try another one!";
			attr.addFlashAttribute("msg", msg);
			return "redirect:/adddoctor";
		}
		Contact cd= contactService.getcontactem(phone);
		d.setContact(cd.getId());
		doctorService.adddoctor(d);
		Users u= new Users();
		u.setEmail(email);
		String pwd= d.getFirst_name()+"@"+d.getLast_name();
		u.setFname(d.getFirst_name());
		u.setLname(d.getLast_name());
		u.setPassword(pwd);
		u.setRole("Doctor");
		userService.registerUser(u);
		String msg = "Doctor added! Passoword for doctor is FirstName@LastName";
		attr.addFlashAttribute("msg", msg);
		return "redirect:/adddoctor";
	}



	// -----------------------------------Add Report-----------------------------------

	@RequestMapping(value = "/addreport", method = RequestMethod.GET)
	public String addreport(Model m, HttpSession session, RedirectAttributes attr, HttpServletRequest req) {
		Users u = (Users) session.getAttribute("users");
		if (u != null) {
			String r = u.getRole();
			if (r.equalsIgnoreCase("Admin")) {
				List<Patient> patients = patientService.getall();
				m.addAttribute("patients", patients);
				Map<String, ?> f = RequestContextUtils.getInputFlashMap(req);
				if (f != null) {
					String msg = (String) f.get("msg");
					m.addAttribute("msg", msg);
				}
				return "addreport";
			}
		}
		attr.addFlashAttribute("msg", "You need to be logged in as admin");
		return "redirect:/adminlogin";

	}

	@RequestMapping(value = "/addreport", method = RequestMethod.POST)
	public String addreport(@RequestParam("patient_id") int pid, @RequestParam("report") MultipartFile report,
			RedirectAttributes attr, HttpSession session) throws HibernateException, IOException {

		if (report != null) {

			LabReports l1 = new LabReports();
			Blob blob = Hibernate.getLobCreator(sessionFactory.openSession()).createBlob(report.getInputStream(),
					report.getSize());
			l1.setFilename(report.getOriginalFilename());
			l1.setPatient_id(pid);
			l1.setData(blob);
			lab_reportsService.uploadreport(l1);
			attr.addFlashAttribute("msg", "Report added successfully");
			return "redirect:/addreport";
		}
		attr.addFlashAttribute("msg", "Something wrong with file");
		return "redirect:/addreport";
	}
	
	//------------------Add Department-------------------------------
	
	@RequestMapping(value="/adddepartment", method=RequestMethod.GET)
	public String adddepartment(Model m, HttpServletRequest req) {
		Map<String,?> flashmsg= RequestContextUtils.getInputFlashMap(req);
		if(flashmsg!=null) {
			String msg= (String) flashmsg.get("msg");
			m.addAttribute("msg", msg);
			return "adddepartment";
		}
		m.addAttribute("msg", "");
		return "adddepartment";
	}
	
	@RequestMapping(value="/adddepartment", method=RequestMethod.POST)
	public String adddepartment(Model m, @ModelAttribute("department") Department d, RedirectAttributes attr) {
		Department d1= departmentService.getdepartment(d.getDept());
		if(d1!=null) {
			attr.addFlashAttribute("msg", "Already exist");
			return "redirect:/adddepartment";
		}
		departmentService.adddepartment(d);
		attr.addFlashAttribute("msg", "Added");
		return "redirect:/adddepartment";
	}
	
	//------------------Add Ward-------------------------------
	
		@RequestMapping(value="/addward", method=RequestMethod.GET)
		public String addward(Model m, HttpServletRequest req) {
			Map<String,?> flashmsg= RequestContextUtils.getInputFlashMap(req);
			if(flashmsg!=null) {
				String msg= (String) flashmsg.get("msg");
				m.addAttribute("msg", msg);
				return "addward";
			}
			m.addAttribute("msg", "");
			return "addward";
		}
		
		@RequestMapping(value="/addward", method=RequestMethod.POST)
		public String addward(Model m, @ModelAttribute("ward") Ward w, RedirectAttributes attr) {
//			department d1= departmentService.getdepartment(d.getDept());
			Ward w1= wardService.getward(w.getWard());
			if(w1!=null) {
				attr.addFlashAttribute("msg", "Already exist");
				return "redirect:/addward";
			}
//			departmentService.adddepartment(d);
			wardService.addward(w);
			attr.addFlashAttribute("msg", "Added");
			return "redirect:/addward";
		}
	

}
