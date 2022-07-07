package com.controllerpackage;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.dao.UserDao;
import com.entities.Allotment;
import com.entities.Contact;
import com.entities.Department;
import com.entities.Doctor;
import com.entities.LabReports;
import com.entities.Patient;
import com.entities.PatientDetails;
import com.entities.Treatment;
import com.entities.Users;
import com.entities.Ward;
import com.services.*;

@Controller
public class ProfileController extends MainControl{


	// ----------------------------Admin Profile---------------------------
	@RequestMapping(value = "/adminprofile", method = RequestMethod.GET)
	public String adminprofile(Model m, HttpSession session, HttpServletRequest req) {
		Map<String, ?> flashmsg = RequestContextUtils.getInputFlashMap(req);
		Users u = (Users) session.getAttribute("users");
		if (u == null) {
			m.addAttribute("msg", "You must be logged in first!");
			return "adminlogin";
		}

		String r = u.getRole();
		if (r.equals("Admin")) {
			String name = u.getFname() + " " + u.getLname();
			m.addAttribute("user", u);
			m.addAttribute("name", name);

			if (flashmsg != null) {
				String msg = (String) flashmsg.get("key");
				return "adminprofile";
			}
			m.addAttribute("msg", "");
			return "adminprofile";
		}

		return "restricted";

	}

	// -----------------------------------Doctor Profile----------------------------

	@RequestMapping(value = "/docprofile", method = RequestMethod.GET)
	public String doctorprofile(Model m, HttpSession session, HttpServletRequest req) {
		Users u = (Users) session.getAttribute("users");
		Map<String, ?> flashmsg = RequestContextUtils.getInputFlashMap(req);

		if (u == null) {
			m.addAttribute("msg", "You must be logged in first!");
			return "doclogin";
		}
		String r = u.getRole();
		if (r.equals("Doctor")) {
			int uid= u.getId();
			String em = u.getEmail();
			Doctor d = doctorService.getdoctor(em);
			int docid = d.getId();
			Contact c = contactService.getcontact(d.getContact());
			Department dept = departmentService.getdepartmentid(d.getDepartment());
			m.addAttribute("dept", dept);
			m.addAttribute("c", c);
			m.addAttribute("user", d);
			List<Patient> p = patientService.docpat(docid);
			List<PatientDetails> pd = patient_detailsService.getall();
			m.addAttribute("pd", pd);
			m.addAttribute("p", p);
			m.addAttribute("uid", uid);
			List<Contact> cl= contactService.getall();
			m.addAttribute("cl", cl);
			if (flashmsg != null) {
				String msg = (String) flashmsg.get("msg");
				m.addAttribute("msg", msg);
				return "docprofile";
			}
			m.addAttribute("msg", "");

			return "docprofile";

		}

		return "restricted";

	}

	// ---------------------------------Patient Profile----------------------------

	@SuppressWarnings("unused")
	@RequestMapping(value = "/patientprofile", method = RequestMethod.GET)
	public String patientprofile(Model m, HttpSession session, HttpServletRequest req) {
		Users u = (Users) session.getAttribute("users");
		Map<String, ?> flashmsg = RequestContextUtils.getInputFlashMap(req);

		if (u == null) {
			m.addAttribute("msg", "You must be logged in first!");
			return "patientlogin";
		}

		String r = u.getRole();
		if (r.equals("Patient")) {
			Patient p = patientService.getpatient(u.getEmail());
			Integer docid = p.getDoctor();
			List<LabReports> report = lab_reportsService.getallreportbypat(p.getPid());
			PatientDetails pd = patient_detailsService.get_patient_details(p.getPid());
			Contact c = contactService.getcontact(p.getContact());
			String docname = doctorService.doctorname(docid);
		//	String bi = pd.getBloodgroup();
			Allotment a = allotmentService.getlatest(p.getPid());
//			if(a!=null) {
//				Integer w1= a.getWard();
//			}
			if (a != null) {
				Integer wi = a.getWard();
				Integer bed = a.getBed();
				if (wi != null) {
					Ward w = wardService.get(wi);
					m.addAttribute("w", w);
				}

				m.addAttribute("bed", bed);
			}
			
			// m.addAttribute("bed", bed);
			Treatment t= treatmentService.latest(p.getPid());
			m.addAttribute("t", t);
			m.addAttribute("p", p);
			m.addAttribute("d", docname);
			m.addAttribute("r", report);
			m.addAttribute("pd", pd);
			m.addAttribute("c", c);
			if (flashmsg != null) {
				String msg = (String) flashmsg.get("msg");
				m.addAttribute("msg", msg);
				return "patientprofile";
			}
			m.addAttribute("msg", "");
			return "patientprofile";
		}

		m.addAttribute("msg", "Page restricted");
		return "restricted";

	}

	// ----------------------------------All Doctors
	// list------------------------------

	@RequestMapping(value = "/doctorslist")
	public String doctor(Model m) {

		List<Doctor> l = doctorService.getall();
		List<Contact> c = contactService.getall();
		List<Department> dept = departmentService.getalldepartment();
		m.addAttribute("dept", dept);
		m.addAttribute("d", l);
		m.addAttribute("c", c);
		return "doctor";
	}

	// ----------------------------------All Patients
	// list------------------------------
	@RequestMapping(value = "/patientlist", method = RequestMethod.GET)
	public String loadpatient(Model m, HttpSession session, HttpServletRequest req, RedirectAttributes attr) {
		Users u = (Users) session.getAttribute("users");
		if (u == null) {
			String msg = "You must be admin to view patient list";
			attr.addFlashAttribute("msg", msg);
			return "redirect:/adminlogin";
		}
		String r = u.getRole();
		if (r.equals("Admin")) {
			List<Patient> l = patientService.getall();
			List<PatientDetails> pl = patient_detailsService.getall();
			List<Contact> c = contactService.getall();
			m.addAttribute("p", l);
			m.addAttribute("pl", pl);
			m.addAttribute("c", c);
			return "allpatient";
		}
		String msg = "You must be admin to view patient list";
		attr.addFlashAttribute("msg", msg);
		return "redirect:/adminlogin";

	}

	// --------------------------Change password--------------------

	@RequestMapping(value = "/changepwd", method = RequestMethod.GET)
	public String changepwd(Model m, HttpServletRequest req, HttpSession session, RedirectAttributes attr) {
		Users u= (Users) session.getAttribute("users");
		if(u!=null) {
			attr.addFlashAttribute("msg", "Page restricted");
			String r= u.getRole();
			if(r.equalsIgnoreCase("Admin")) {
				return "redirect:/adminprofile";
			}
			else if(r.equalsIgnoreCase("Doctor")) {
				return "redirect:/docprofile";
			}
			return "redirect:/patientprofile";
		}
		Map<String, ?> flsh = RequestContextUtils.getInputFlashMap(req);
		if (flsh == null) {
			m.addAttribute("msg", "");
			return "changepwd";
		}
		String msg = (String) flsh.get("msg");
		m.addAttribute("msg", msg);
		return "changepwd";
	}

	@RequestMapping(value = "/changepwd", method = RequestMethod.POST)
	public String changepwd(Model m, @RequestParam("email") String em, @RequestParam("opwd") String opwd,
			@RequestParam("npwd") String npwd, RedirectAttributes attr) {
		int i = userService.changepwd(em, opwd, npwd);
		if (i == 0) {
			attr.addFlashAttribute("msg", "You entered wrong email/password");
			return "redirect:/changepwd";
		}
		attr.addFlashAttribute("msg", "Your password have been changed successfully");
		return "redirect:/changepwd";
	}

	// ----------------------------Forgot Password--------------------

	@RequestMapping(value = "/forgotpwd", method = RequestMethod.GET)
	public String forgotpwd(Model m, HttpServletRequest req, HttpSession session, RedirectAttributes attr) {
		Users u= (Users) session.getAttribute("users");
		if(u!=null) {
			attr.addFlashAttribute("msg", "Page restricted");
			String r= u.getRole();
			if(r.equalsIgnoreCase("Admin")) {
				return "redirect:/adminprofile";
			}
			else if(r.equalsIgnoreCase("Doctor")) {
				return "redirect:/docprofile";
			}
			return "redirect:/patientprofile";
		}
		Map<String,?> flsh= RequestContextUtils.getInputFlashMap(req);
		if(flsh!=null) {
			String msg= (String) flsh.get("msg");
			m.addAttribute("msg", msg);
			return "forgotpwd";
		}
		m.addAttribute("msg", "");
		return "forgotpwd";
	}

	@RequestMapping(value = "/forgotpwd", method = RequestMethod.POST)
	public String forgotpwd(Model m, @RequestParam("email") String em, @RequestParam("npwd") String npwd,
			RedirectAttributes attr) {
		int i = userService.forgotpwd(em, npwd);
		if (i == 0) {
				attr.addFlashAttribute("msg", "You entered wrong email/password");
				return "redirect:/forgotpwd";
		}
		attr.addFlashAttribute("msg", "Your password has been successfully reset");
		return "redirect:/forgotpwd";
	}

}
