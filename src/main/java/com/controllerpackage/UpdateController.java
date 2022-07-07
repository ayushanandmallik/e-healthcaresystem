package com.controllerpackage;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.time.LocalDateTime;

@Controller
public class UpdateController extends MainControl{


	// --------------------------------Patient profile by id------------------------

	@RequestMapping(value = "/patprofile/{id}", method = RequestMethod.GET)
	public String patprofile(@PathVariable int id, Model m, HttpSession session, RedirectAttributes attr) {

		Users u = (Users) session.getAttribute("users");
		if (u == null) {
			attr.addFlashAttribute("msg", "You must be logged in as doctor");
			return "redirect:/doctorlogin";
		}
		String r = u.getRole();
		if (r.equalsIgnoreCase("Patient")) {
			attr.addFlashAttribute("msg", "Access restricted");
			return "redirect:/patientprofile";
		}

		else if (r.equalsIgnoreCase("Doctor")) {
			Patient p = patientService.getpatientid(id);
			int pdid = p.getDoctor();
			String em = u.getEmail();
			Doctor d = doctorService.getdoctor(em);
			int did = d.getId();
			if (pdid == did) {
				List<LabReports> l = lab_reportsService.getallreportbypat(id);
				Contact c = contactService.getcontact(p.getContact());
				PatientDetails pd = patient_detailsService.get_patient_details(p.getPid());
		//		Integer bi = pd.getBloodgroup();
				//List<Allotment> a= allotmentService.getbypat(p.getPid());
				Allotment a= allotmentService.getlatest(p.getPid());
				if(a!=null) {
//					LocalDateTime t1= LocalDateTime.now();
//					Duration duration;
//					
					Integer wi = a.getWard();
					Integer bed= a.getBed();
					if (wi != null) {
						Ward w = wardService.get(wi);
						m.addAttribute("w", w);
					}
					
					m.addAttribute("bed", bed);
				}
				Treatment t= treatmentService.latest(p.getPid());
				m.addAttribute("t", t);
				m.addAttribute("c", c);
				m.addAttribute("pd", pd);
				m.addAttribute("reports", l);
				m.addAttribute("p", p);
				m.addAttribute("doc", d);
				m.addAttribute("role", "doctor");
				return "patprofile";
			}
			String msg = "Access Restricted";
			attr.addFlashAttribute("msg", msg);
			return "redirect:/docprofile";
		}
		Patient p = patientService.getpatientid(id);
		Doctor d = doctorService.getdoctorid(p.getDoctor());
		List<LabReports> l = lab_reportsService.getallreportbypat(id);
		Contact c = contactService.getcontact(p.getContact());
		PatientDetails pd = patient_detailsService.get_patient_details(p.getPid());
		//Integer bi = pd.getBloodgroup();
		Allotment a= allotmentService.getlatest(p.getPid());
		if(a!=null) {
			Integer wi = a.getWard();
			Integer bed= a.getBed();
			if (wi != null) {
				Ward w = wardService.get(wi);
				m.addAttribute("w", w);
			}
			
			m.addAttribute("bed", bed);
		}
		
//		if(bi!=null) {
//			Bloodgroup b = bloodgroupService.get(pd.getBloodgroup());
//			m.addAttribute("b", b);
//			
//		}
		
		Treatment t= treatmentService.latest(p.getPid());
		m.addAttribute("t", t);
		m.addAttribute("c", c);
		m.addAttribute("pd", pd);
		m.addAttribute("reports", l);
		m.addAttribute("p", p);
		m.addAttribute("doc", d);
		m.addAttribute("p", p);
		m.addAttribute("role", "admin");
		return "adminpatprofile";

	}

	// ------------------------Edit patient profile page-----------------------------

	@RequestMapping(value = "patprofile/editpatient/{id}", method = RequestMethod.GET)
	public String editpatient(@PathVariable() int id, Model m, HttpSession session, RedirectAttributes attr) {

		Users u = (Users) session.getAttribute("users");
		if (u != null) {
			if (u.getRole().equalsIgnoreCase("Patient")) {
				attr.addFlashAttribute("msg", "Page restricted");
				return "redirect:/patientprofile";
			}
			if (u.getRole().equalsIgnoreCase("Admin")) {
				m.addAttribute("id", id);
				
				List<Ward> w = wardService.getall();
				m.addAttribute("w", w);
				return "admineditpatient";
			}
			m.addAttribute("id", id);

			return "editpatient";
		}
		attr.addFlashAttribute("msg", "You must be logged in as doctor/admin");
		return "redirect:/home";
	}

	@RequestMapping(value = "patprofile/editpatient/{id}", method = RequestMethod.POST)
	public String editpatient(@PathVariable() int id, Model m, Patient p, HttpSession session, RedirectAttributes attr,
			Treatment tr1, Allotment a) {
		PatientDetails pat1 = patient_detailsService.get_patient_details(id);
		Users u = (Users) session.getAttribute("users");
		String r = u.getRole();

		Patient p1 = patientService.getpatientid(id);
		int p1id = p1.getPid();

		if (p1id == id) {
			if (r.equalsIgnoreCase("Doctor")) {
				int pd = p1.getDoctor();
				Doctor d = doctorService.getdoctor(u.getEmail());
				int did = d.getId();
				if (pd == did) {
					Treatment treatment= treatmentService.latest(p1id);
					String symptoms = tr1.getSymptoms();
					String disease = tr1.getDisease();
					String prescription = tr1.getPrescription();
					Treatment t= new Treatment();
					if(symptoms.equalsIgnoreCase("")) {
						symptoms= treatment.getSymptoms();
					}
					if(disease.equalsIgnoreCase("")) {
						disease= treatment.getDisease();
					}
					if(prescription.equalsIgnoreCase("")) {
						prescription= treatment.getPrescription();
					}
					t.setPid(p1id);
					t.setSymptoms(symptoms);
					t.setDisease(disease);
					t.setPrescription(prescription);
					t.setDoctor(d.getId());
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
					LocalDateTime dt= LocalDateTime.now();
					t.setTime(dt);
//					pat1.setSymptoms(symptoms);
//					pat1.setDisease(disease);
//					pat1.setPrescription(prescription);
					treatmentService.add(t);
	//				patient_detailsService.updatepatdet(p1id, pat1);
					attr.addFlashAttribute("msg", "Updated");
					return "redirect:/patprofile/{id}";

				}
				String msg = "The specified patient is not your patient";
				attr.addFlashAttribute("msg", msg);
				return "redirect:/docprofile";
			}

			if (r.equalsIgnoreCase("Admin")) {
				
				Integer w1 = a.getWard();
				Integer bed = a.getBed();
				a.setPid(p1id);
				LocalDateTime time= LocalDateTime.now();
				a.setTime(time);
				allotmentService.add(a);
				//allotmentService.update(a, p1id);
				// int p1id= patientService.getpatientid(id).getPid();
				//patient_detailsService.updatepatdet(p1id, pat1);
				attr.addFlashAttribute("msg", "Updated");
				return "redirect:/patprofile/{id}";
			}

		}

		return "redirect:/patprofile/{id}";
	}


	//--------------------------Edit Blood------------------------

	@RequestMapping(value = "patprofile/editblood/{id}", method = RequestMethod.GET)
	public String editblood(@PathVariable() int id, Model m, HttpSession session, RedirectAttributes attr) {

		Users u = (Users) session.getAttribute("users");
		if (u != null) {
			if (u.getRole().equalsIgnoreCase("Patient")) {
				attr.addFlashAttribute("msg", "Page restricted");
				return "redirect:/patientprofile";
			}
			if (u.getRole().equalsIgnoreCase("Admin")) {
				m.addAttribute("id", id);
//				String[] b= new String[8];
//				b[0]="A";b[1]="B";b[2]="AB";b[3]="O";b[4]="A-";b[5]="B-";b[6]="O-";b[7]="AB-";
				ArrayList<String> b= new ArrayList<String>();
				b.add("A");b.add("B");b.add("AB");b.add("O");b.add("A-");b.add("B-");b.add("O-");b.add("AB-");
				m.addAttribute("b", b);
				return "editblood";
			}
			m.addAttribute("id", id);

			return "editblood";
		}
		attr.addFlashAttribute("msg", "You must be logged in as doctor/admin");
		return "redirect:/home";
	}

	@RequestMapping(value = "patprofile/editblood/{id}", method = RequestMethod.POST)
	public String editblood(@PathVariable() int id, Model m, Patient p, HttpSession session, RedirectAttributes attr,
			PatientDetails pat_det) {
		PatientDetails pat1 = patient_detailsService.get_patient_details(id);
		Users u = (Users) session.getAttribute("users");
		String r = u.getRole();

		Patient p1 = patientService.getpatientid(id);
		int p1id = p1.getPid();

		if (p1id == id) {
			if (r.equalsIgnoreCase("Admin")) {
				String b1 = pat_det.getBloodgroup();
				pat1.setBloodgroup(b1);
				// int p1id= patientService.getpatientid(id).getPid();
				patient_detailsService.updatepatdet(p1id, pat1);
				attr.addFlashAttribute("msg", "Updated");
				return "redirect:/patprofile/{id}";
			}

		}

		return "redirect:/patprofile/{id}";
	}


	
	
	// -------------------------Update status----------------------

	@RequestMapping(value = "patprofile/changestatus/{id}")
	public String changestatus(Model m, @PathVariable() int id, HttpSession session, RedirectAttributes attr) {
		Users u = (Users) session.getAttribute("users");
		if (u == null) {
			attr.addFlashAttribute("msg", "You must be logged in as doctor");
			return "redirect:/doctorlogin";
		}
		String r = u.getRole();
		if (r.equalsIgnoreCase("Patient")) {
			attr.addFlashAttribute("msg", "Action restricted");
			return "redirect:/patientprofile";
		}
		patient_detailsService.updatestatus(id);
		//allotmentService.delete(id);
		return "redirect:/patprofile/{id}";
	}
	
	
	//-------------------------Treatment history---------------------
	
	@RequestMapping(value="patprofile/treatmenthistory/{id}")
	public String treatmenthistory(Model m, @PathVariable() int id, HttpSession session, RedirectAttributes attr) {
		Users u= (Users) session.getAttribute("users");
		if(u!=null) {
		String role= u.getRole();
		if(role.equalsIgnoreCase("Doctor")||role.equalsIgnoreCase("Admin")) {
			Patient p= patientService.getpatientid(id);
			List<Treatment> t= treatmentService.get_pat_treatment(id);
			List<Doctor> d= doctorService.getall();
			m.addAttribute("d", d);
			m.addAttribute("t", t);
			m.addAttribute("p", p);
			return "treatmenthistory";
		}
		else if(role.equalsIgnoreCase("Patient")) {
			String em= u.getEmail();
			Patient p= patientService.getpatient(em);
			int pid= p.getPid();
			if(pid==id) {
				List<Treatment> t= treatmentService.get_pat_treatment(id);
				List<Doctor> d= doctorService.getall();
				m.addAttribute("d", d);
				m.addAttribute("t", t);
				m.addAttribute("p", p);
				return "treatmenthistory";
			}
		}
		attr.addFlashAttribute("msg", "Restricted");
		return "redirect:/patientprofile";
		}
		attr.addFlashAttribute("msg", "Must be logged in as doctor");
		return "redirect:/doctorlogin";
		
	}

	
	//-------------------------------Doctor info----------------------
	@RequestMapping(value="/docinfo/{id}")
	public String docinfo(HttpSession session, Model m, @PathVariable() int id, RedirectAttributes attr) {
		Users u= (Users) session.getAttribute("users");
		if(u!=null) {
		if(u.getId()==id) {
		String role= u.getRole();
		if(role.equalsIgnoreCase("Doctor")) {
			String em= u.getEmail();
			Doctor d= doctorService.getdoctor(em);
			int docid = d.getId();
			Contact c = contactService.getcontact(d.getContact());
			Department dept = departmentService.getdepartmentid(d.getDepartment());
			m.addAttribute("dept", dept);
			m.addAttribute("c", c);
			m.addAttribute("user", d);
			return "docinfo";
		}
		}
		return "restricted";
		}
		attr.addFlashAttribute("msg", "You must be logged in as doctor");
		return "redirect:/doctorlogin";
	}
	
}
