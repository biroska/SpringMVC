package controllers;

import java.util.List;

import modelo.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import facade.FacadeImpl;

@Controller
public class LoginController {
	
	@Autowired
	FacadeImpl facade;
	
	@RequestMapping("logar")
	public String logar( Usuario user ){
		System.out.println("LoginController.logar(): " + user.getUsuario() +" - "+ user.getSenha() );
		if ( facade.autenticausuarioSenha( user ) ){
			return "forward:principal";
		}else{
			return "login";
		}
	}
}