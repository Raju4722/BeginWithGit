package com.todolist.todolists.restapi;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.net.URI;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.todolist.todolists.restapi.Exception.UsernameNottFoundException;


@RestController
public class Rcontroller {
	private MessageSource msgsour;
	private Rservice serv;
	public Rcontroller(Rservice serv,MessageSource msgsour) {
		super();
		this.serv = serv;
		this.msgsour = msgsour;
	}
	@GetMapping("users")
     public List<UserDeta> giveit() {
    	
    	 return serv.getall();
     }
//	@GetMapping("give/{id}")
//	public User getone(@PathVariable int id) {
//		User gotone = serv.gettingone(id);
//		if(gotone==null) {
//			throw new UsernameNottFoundException("id:"+id);
//		}
//		return gotone;
//		
//	}
	@GetMapping("user/{id}")
	public EntityModel<UserDeta> getone(@PathVariable int id) {
		UserDeta gotone = serv.gettingone(id);
		if(gotone==null) {
			throw new UsernameNottFoundException("id:"+id);
		}
		EntityModel<UserDeta> entmod = EntityModel.of(gotone);
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).giveit());
		entmod.add(link.withRel("all-users"));
		
		return entmod;
		
	}
	@PostMapping("user")
	public ResponseEntity<UserDeta> createuser(@RequestBody UserDeta user){
		UserDeta user2 = serv.add(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user2.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@DeleteMapping("del/{id}")
	public void deleting(@PathVariable int id) {
		serv.deleting(id);
	}
//	@GetMapping("internation")
//	public String internationalized() {
//			Locale locale = LocaleContextHolder.getLocale();
//			return msgsour.getMessage("good.morning.message", null, "Default mess", locale);
//	}
}
