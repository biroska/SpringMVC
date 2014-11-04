package controllers;

import javax.servlet.http.HttpSession;

import modelo.Usuario;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import facade.FacadeImpl;

@Controller
public class LoginController {
	
	@Autowired
	FacadeImpl facade;
	
	final static Logger logger = Logger.getLogger(LoginController.class);
	
	@RequestMapping("logar")
	public String logar( Usuario user, HttpSession session ){
		System.out.println("LoginController.logar(): " + user.getUsuario() +" - "+ user.getSenha() );
		
		logger.info("This is an info log entry: " + user.getUsuario() +" - "+ user.getSenha() );
		logger.warn("This is warn : " + user.getUsuario() +" - "+ user.getSenha() );
		logger.error("This is error : " + user.getUsuario() +" - "+ user.getSenha() );
		logger.fatal("This is fatal : " + user.getUsuario() +" - "+ user.getSenha() );
		
//		facade.inserirUsuario(user);
		
		if ( facade.autenticausuarioSenha( user ) ){
			session.setAttribute("usuarioLogado", user );
			return "forward:principal";
		}else{
			return "login";
		}
	}
	
	@RequestMapping("logoff")
	public String logoff( Usuario user, HttpSession session ){
		System.out.println("LoginController.logoff()");
		session.removeAttribute("usuarioLogado");
		return "login";
	}
}