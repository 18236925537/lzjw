package com.controller.oracle;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pojo.po.User;
import com.service.IUserService;

@Controller
@RequestMapping("/user/")
public class UserController {
	
	@Resource
	private IUserService userService;

	@RequestMapping(value = "findAll", method = RequestMethod.POST)
	public String findAll(Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "user";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(User user, Model model) {
		int id = userService.add(user);
		model.addAttribute("id", id);
		return "user";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(User user, Model model) {
		userService.update(user);
		model.addAttribute("updateFlag", true);
		return "user";
	}
}
