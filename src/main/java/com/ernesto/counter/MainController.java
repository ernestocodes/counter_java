package com.ernesto.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 1);
		} else {
			Integer currentCount = (Integer) session.getAttribute("count");
			session.setAttribute("count", currentCount + 1);
		}
		return "counterIndex.jsp";
	}

	@RequestMapping("/counter")
	public String showCounter(HttpSession session, Model model) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 1);
		}
		Integer currentCount = (Integer) session.getAttribute("count");
		model.addAttribute("count", currentCount);
		return "showCount.jsp";
	}
}
