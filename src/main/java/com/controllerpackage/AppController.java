package com.controllerpackage;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entities.Contact;
import com.entities.Department;
import com.entities.Doctor;
import com.entities.Patient;
import com.entities.PatientDetails;
import com.entities.Users;
import com.models.LoginDetails;
import com.services.UserServiceImpl;
import com.validation.UserValidation;
import com.services.*;

@Controller
public class AppController extends MainControl{
	
	

	// ----------------------------Home page-------------------------------

	@RequestMapping("/")
	public String index() {
		return "redirect:/home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		Map<String, ?> flashmsg = RequestContextUtils.getInputFlashMap(req);
		if (flashmsg != null) {
			String msg = (String) flashmsg.get("msg");
			return "index";
		}
		return "index";
	}



	// ----------------------------Admin login-----------------------------------

	@RequestMapping(value = "/adminlogin", method = RequestMethod.GET)
	public String adminlogin(Model m, HttpSession session, RedirectAttributes attr, HttpServletRequest req) {
		Users a = (Users) session.getAttribute("users");
		Map<String, ?> flashmsg = RequestContextUtils.getInputFlashMap(req);

		if (a != null) {
			String r = a.getRole();
			if (r.equals("Doctor")) {
				attr.addFlashAttribute("msg",
						"You are already logged in as doctor...please logout before logging in as admin!");
				return "redirect:/docprofile";
			} else if (r.equals("Patient")) {
				attr.addFlashAttribute("msg",
						"You are already logged in as patient...please logout before logging in as admin!");

				return "redirect:/patientprofile";
			} else {
				attr.addFlashAttribute("msg", "You are already logged in.");

				return "redirect:/adminprofile";
			}

		}
		if (flashmsg != null) {
			String msg = (String) flashmsg.get("msg");
			return "adminlogin";
		}
		m.addAttribute("msg", "");
		return "adminlogin";
	}

	@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
	public String adminloginimpl(@RequestParam("username") String username, @RequestParam("password") String pwd, Model m, HttpSession session,
			RedirectAttributes attr) {

		Users a = (Users) session.getAttribute("users");

		if (a != null) {
			String r = a.getRole();
			if (r.equals("Doctor")) {
				attr.addFlashAttribute("msg",
						"You are already logged in as doctor...please logout before logging in as admin!");
				return "redirect:/docprofile";
			} else if (r.equals("Patient")) {
				attr.addFlashAttribute("msg",
						"You are already logged in as patient...please logout before logging in as admin!");

				return "redirect:/patientprofile";
			} else {
				attr.addFlashAttribute("msg", "You are already logged in.");

				return "redirect:/adminprofile";
			}
		}
		
		String requiredUsername= "admin";
		String requiredPassword= "admin";
		if(username.equals(requiredUsername) && pwd.equals(requiredPassword)) {
			Users u= new Users();
			u.setRole("Admin");
			session.setAttribute("users", u);
			return "redirect:/adminprofile";
		}
		attr.addFlashAttribute("msg", "Wrong Username/Password");
		return "redirect:/adminlogin";
		

	}

	// ---------------------------------Doctor Login------------------------------

	@RequestMapping(value = "/doctorlogin", method = RequestMethod.GET)
	public String doctorlogin(Model m, HttpSession session, RedirectAttributes attr, HttpServletRequest req) {
		Users a = (Users) session.getAttribute("users");
		Map<String, ?> flashmsg = RequestContextUtils.getInputFlashMap(req);
		if (a != null) {
			String r = a.getRole();
			if (r.equals("Doctor")) {
				attr.addFlashAttribute("msg",
						"You are already logged in as doctor...please logout before logging in as admin!");
				return "redirect:/docprofile";
			} else if (r.equals("Patient")) {
				attr.addFlashAttribute("msg",
						"You are already logged in as patient...please logout before logging in as admin!");

				return "redirect:/patientprofile";
			} else {
				attr.addFlashAttribute("msg", "You are already logged in.");

				return "redirect:/adminprofile";
			}

		}
		if (flashmsg != null) {
			String msg = (String) flashmsg.get("msg");
			return "doclogin";
		}

		return "doclogin";
	}

	@RequestMapping(value = "/doctorlogin", method = RequestMethod.POST)
	public String doctorlogin(@ModelAttribute("logindetails") LoginDetails l, Model m, HttpSession session,
			RedirectAttributes attr) {

		Users a = (Users) session.getAttribute("users");

		if (a != null) {
			String r = a.getRole();
			if (r.equals("Doctor")) {
				attr.addFlashAttribute("msg",
						"You are already logged in as doctor...please logout before logging in as admin!");
				return "redirect:/docprofile";
			} else if (r.equals("Patient")) {
				attr.addFlashAttribute("msg",
						"You are already logged in as patient...please logout before logging in as admin!");

				return "redirect:/patientprofile";
			} else {
				attr.addFlashAttribute("msg", "You are already logged in.");

				return "redirect:/adminprofile";
			}
		}

		String em = l.getEmail();
		String pwd = l.getPassword();

		int i = userService.loginuser(em, pwd);

		if (i == 0) {
			m.addAttribute("msg", "Wrong email/password");
			return "doclogin";
		}
		else if(i==2) {
			m.addAttribute("msg", "Data not found");
			return "doclogin";
		}
		else {

			Users u1 = userService.getuser(em);
			String r = u1.getRole();

			if (r.equals("Doctor")) {
				session.setAttribute("users", u1);
				return "redirect:/docprofile";
			}
			m.addAttribute("msg", "You are not Doctor");
			return "doclogin";

		}

	}

	// -------------------------------Patient Login---------------------------

	@RequestMapping(value = "/patientlogin", method = RequestMethod.GET)
	public String patientlogin(Model m, HttpSession session, RedirectAttributes attr, HttpServletRequest req) {
		Users a = (Users) session.getAttribute("users");
		if (a != null) {
			String r = a.getRole();
			if (r.equals("Doctor")) {
				attr.addFlashAttribute("msg",
						"You are already logged in as doctor...please logout before logging in as admin!");
				return "redirect:/docprofile";
			} else if (r.equals("Patient")) {
				attr.addFlashAttribute("msg",
						"You are already logged in as patient...please logout before logging in as admin!");

				return "redirect:/patientprofile";
			} else {
				attr.addFlashAttribute("msg", "You are already logged in.");

				return "redirect:/adminprofile";
			}

		}
		Map<String, ?> flashmsg = RequestContextUtils.getInputFlashMap(req);
		if (flashmsg != null) {
			String msg = (String) flashmsg.get("msg");
			return "patientlogin";
		}
		return "patientlogin";
	}

	@RequestMapping(value = "/patientlogin", method = RequestMethod.POST)
	public String patientlogin(@ModelAttribute("logindetails") LoginDetails l, Model m, HttpSession session,
			RedirectAttributes attr) {

		Users a = (Users) session.getAttribute("users");

		if (a != null) {
			String r = a.getRole();
			if (r.equals("Doctor")) {
				attr.addFlashAttribute("msg",
						"You are already logged in as doctor...please logout before logging in as admin!");
				return "redirect:/docprofile";
			} else if (r.equals("Patient")) {
				attr.addFlashAttribute("msg",
						"You are already logged in as patient...please logout before logging in as admin!");

				return "redirect:/patientprofile";
			} else {
				attr.addFlashAttribute("msg", "You are already logged in.");

				return "redirect:/adminprofile";
			}
		}

		String em = l.getEmail();
		String pwd = l.getPassword();

		int i = userService.loginuser(em, pwd);

		if (i == 0) {
			m.addAttribute("msg", "Wrong email/password");
			return "patientlogin";
		} else {

			Users u1 = userService.getuser(em);
			String r = u1.getRole();

			if (r.equals("Patient")) {
				session.setAttribute("users", u1);
				return "redirect:/patientprofile";
			}

			m.addAttribute("msg", "You are not Patient");
			return "patientlogin";

		}

	}

	// ------------------------------Logout----------------------------------

	@RequestMapping(value = "/logout")
	public String logout(Model m, HttpSession session) {
		Users u = (Users) session.getAttribute("users");
		if (u == null) {
			m.addAttribute("msg", "You must be logged in first!");
			return "adminlogin";
		} else {
			String r = u.getRole();
			session.removeAttribute("users");
			session.invalidate();
			m.addAttribute("msg", "Logout successfull");
			if (r.equals("Admin")) {
				return "adminlogin";
			} else if (r.equals("Doctor")) {
				return "doclogin";
			} else {
				return "patientlogin";
			}
		}

	}


	//-------------------Book appointment-------------------
	
	@RequestMapping(value="/bookappointment", method=RequestMethod.GET)
	public String bookappointment(Model m, HttpSession session, RedirectAttributes attr) {
		Users u= (Users) session.getAttribute("users");
		if(u!=null) {
			attr.addFlashAttribute("msg", "You need to logout first");
			String r= u.getRole();
			if(r.equalsIgnoreCase("Admin")) {return "redirect:/adminprofile";}
			else if(r.equalsIgnoreCase("Doctor")) {return "redirect:/docprofile";}
			return "redirect:/patientprofile";
		}
		List<Doctor> d= doctorService.getall();
		List<Department> dept= departmentService.getalldepartment();
		m.addAttribute("dept", dept);
		m.addAttribute("d", d);
		
		return "bookappointment";
	}
	
	@RequestMapping(value="/bookappointment", method= RequestMethod.POST)
	public String bookappointment(@ModelAttribute("patient") Patient p, Model m,@RequestParam("email") String email, @RequestParam("phone") String phone, RedirectAttributes attr) {
		
		String f_name= p.getFirst_name();
		String l_name= p.getLast_name();
		int did= p.getDoctor();
		String r= "Patient";
		String pwd= f_name+"@"+l_name;
		String msg= "Booked Appointment Successfully. Your password is "+pwd;
		Patient p1= patientService.getpatient(email);
		if(p1!=null) {
			int pid= p1.getPid();
			PatientDetails pat_det= patient_detailsService.get_patient_details(pid);
			int st= pat_det.getStatus();
			if(st==0) {
				patient_detailsService.updatestatus(pid);
				Users u= userService.getuser(email);
				if(u==null) {
					Users u1= new Users();
					u1.setEmail(email);
					u1.setFname(f_name);
					u1.setLname(l_name);
					u1.setRole(r);
					
					u1.setPassword(pwd);
					userService.registerUser(u1);
				}
				else {userService.forgotpwd(email, pwd);}
				attr.addFlashAttribute("msg", msg);
				return "redirect:/patientlogin";
			}
			patientService.updatepatientdoctor(pid, did);
			attr.addFlashAttribute("msg", msg);
			return "redirect:/patientlogin";
		}
		
		Contact c= new Contact();
		c.setPhone_no(phone);
		c.setEmail(email);
		contactService.savecontact(c);
		int cid= contactService.getcontactem(phone).getId();
		p.setContact(cid);
		patientService.addpatient(p);
		Patient p2= patientService.getpatient(email);
		PatientDetails pat_det1= new PatientDetails();
		pat_det1.setPid(p2.getPid());
		pat_det1.setStatus(1);
		patient_detailsService.add_patient_details(pat_det1);
		Users u= new Users();
		u.setEmail(email);
		u.setFname(f_name);
		u.setLname(l_name);
		u.setPassword(pwd);
		u.setRole(r);
		userService.registerUser(u);
		attr.addFlashAttribute("msg", msg);
		return "redirect:/patientlogin";
		
		
		
	}
	
	//--------------------patient front-----------------
	
	@RequestMapping(value="/patientfront")
	public String patientfront() {
		
		return "patientfront";
	}

}
