package controllers;

import javax.servlet.http.HttpSession;

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
	public String logar( Usuario user, HttpSession session ){
		System.out.println("LoginController.logar(): " + user.getUsuario() +" - "+ user.getSenha() );
		if ( facade.autenticausuarioSenha( user ) ){
			session.setAttribute("usuarioLogado", user );
			return "forward:principal";
		}else{
			return "login";
		}
	}
}