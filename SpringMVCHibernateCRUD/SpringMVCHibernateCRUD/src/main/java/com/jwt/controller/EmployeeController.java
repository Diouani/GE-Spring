package com.jwt.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jwt.model.Address;
import com.jwt.model.Role;
import com.jwt.model.Users;

import com.jwt.service.AddressService;
import com.jwt.service.RoleService;
import com.jwt.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;


@Controller
public class EmployeeController {



	public EmployeeController() {
		System.out.println("EmployeeController()");
	}
    @Autowired
    private RoleService roleService;
	
	@Autowired
	private AddressService addressService;
    @Autowired
	private UsersService usersService;

	@GetMapping(value = "/")
	public ModelAndView firstpage(ModelAndView model) throws IOException {
		if(model.isEmpty()){
			model.setViewName("login");
			return model;
		}else{
			model.setViewName("home");
			return model;
		}

	}

@GetMapping("/admin/Logout")
public ModelAndView logout(HttpServletRequest request,ModelAndView model){
	HttpSession session=request.getSession();
	session.invalidate();
	model.setViewName("login");
	return model;

}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("loginForm") Users user  , ModelAndView model , HttpServletRequest request) throws IOException {
		System.out.println("login controller");
		String username = user.getEmail();
		String password = user.getPassword();
		System.out.println(usersService.login(username, password));
		if (usersService.login(username, password) == 1) {
			Users userLogged = usersService.findByEmail(username);
			long userId =  userLogged.getUserId();
			Role role = userLogged.getRole();
			HttpSession session = request.getSession();

			session.setAttribute("UserId" , userId );
			session.setAttribute("role" , role.getName());
//
//			response.sendRedirect("home");
			return new ModelAndView("redirect:admin/home");
		} else {
//			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
//			rd.include(request,response);
//			response.sendRedirect("/");
			return new ModelAndView("redirect:");
		}

//				model.setViewName("test");

	}
	@GetMapping ("/admin/home")
	public ModelAndView home(ModelAndView model){


		model.addObject("users", usersService.getAll());
		model.setViewName("home");
		return model;

	}



	@RequestMapping(value = "/admin/add", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {



		model.addObject("roles", roleService.getAll());
		model.setViewName("addUser");
		return model;
	}



	@PostMapping(value = "/admin/add")
	public ModelAndView saveEmployee(@RequestParam Map<String,String> requestParams, HttpServletRequest request) {
		System.out.println("hello");
		System.out.println(request.getServletPath());
		String email = requestParams.get("email");
		String firstName = requestParams.get("first_name");
		String lastName = requestParams.get("last_name");
		String password = requestParams.get("password");
		String country = requestParams.get("country");
		int roleid = Integer.parseInt(requestParams.get("role"));
		Role role = roleService.find(roleid);
		String city = requestParams.get("city");
		String street = requestParams.get("street");
		Users user = new Users();
		Address address = new Address();
		Role roleObject = new Role();
		user.setRole(role);
		user.setEmail(email);
		user.setFirst_name(firstName);
		user.setLast_name(lastName);
		user.setPassword(password);
		address.setCity(city);
		address.setStreet(street);
		address.setCountry(country);
		System.out.println(address);
		System.out.println(roleObject);

			System.out.println("TESTADD");
			user.setAddress(address);
			System.out.println(user);
			usersService.add(user);



//
			return new ModelAndView("redirect:home");

	}
//
	@RequestMapping(value = "/admin/delete", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		usersService.delete(employeeId);
		return new ModelAndView("redirect:home");
	}

	@RequestMapping(value = "/admin/update", method = RequestMethod.GET)
	public ModelAndView editEmployee(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		Users employee = usersService.find(employeeId);
		List<Role> roles = roleService.getAll();
		ModelAndView model = new ModelAndView("updateUser");
		model.addObject("user", employee);
        model.addObject("roles", roles);
		return model;
	}


	@PostMapping(value = "/admin/update")
	public ModelAndView update(@RequestParam Map<String,String> requestParams, HttpServletRequest request) {

		System.out.println(request.getServletPath());
		String email = requestParams.get("email");
		String firstName = requestParams.get("first_name");
		String lastName = requestParams.get("last_name");
		String password = requestParams.get("password");
		String country = requestParams.get("country");
		int roleid = Integer.parseInt(requestParams.get("role"));
		Role role = roleService.find(roleid);
		String city = requestParams.get("city");
		String street = requestParams.get("street");
		Users user = new Users();
		Address address = new Address();
		Role roleObject = new Role();
		user.setRole(role);
		user.setEmail(email);
		user.setFirst_name(firstName);
		user.setLast_name(lastName);
		user.setPassword(password);
		address.setCity(city);
		address.setStreet(street);
		address.setCountry(country);
		System.out.println(address);
		System.out.println(roleObject);
			int idUser = Integer.parseInt(request.getParameter("idUser"));
			user.setUserId(idUser);
			Long idAddress = Long.parseLong(request.getParameter("idAddress"));
			address.setIdAddress(idAddress);
			Address address1 = addressService.update(address);
			System.out.println(address1);
			user.setAddress(address1);
			System.out.println(user);
			usersService.update(user);
			System.out.println("TESTUPDATE");



//
		return new ModelAndView("redirect:home");

	}



}