package com.todolist.todolists.jpa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class controller {
	private Repository1 repo;

	public controller(Repository1 repo, service serv) {
		super();
		this.repo = repo;
	}

	@GetMapping("showall")
	public String showall(ModelMap model) {
		model.addAttribute("hai", repo.findAll());
//		model.put("hai","laddu");
		return "showall2";
	}

	@GetMapping("addone")
	public String addaone(ModelMap model) {
		Todo1 todo1 = new Todo1(512, "raju", "cse");
		model.put("all", todo1);
		return "addtoshow";
	}

	@PostMapping("addone")
	public String addaone1(ModelMap model, Todo1 todos) {
		repo.save(todos);

		return "redirect:showall";

	}
}
