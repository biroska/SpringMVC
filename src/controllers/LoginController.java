package controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import modelo.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import facade.FacadeImpl;

@Controller
public class LoginController {
	
	@Autowired
	FacadeImpl facade;
	
//	final static Logger logger = Logger.getLogger(LoginController.class);
	
	@RequestMapping("logar")
	public String logar( Usuario user, Model model, HttpSession session ){
		System.out.println("LoginController.logar(): " + user.getUsuario() +" - "+ user.getSenha() );
		
//		logger.info("This is an info log entry: " + user.getUsuario() +" - "+ user.getSenha() );
//		logger.warn("This is warn : " + user.getUsuario() +" - "+ user.getSenha() );
//		logger.error("This is error : " + user.getUsuario() +" - "+ user.getSenha() );
//		logger.fatal("This is fatal : " + user.getUsuario() +" - "+ user.getSenha() );
		
		if ( validacao( user, model ) ){
			session.setAttribute("usuarioLogado", user );
			return "forward:menuInicio";
		}
		return "login";
	}
	
	private boolean validacao( Usuario user, Model model ){
		
		ArrayList<String> msgsErro = new ArrayList();
		
		if ( ( user.getUsuario() == null || user.getSenha() == null ) ||
			 ( ( user.getUsuario() != null && user.getUsuario().isEmpty() ) ||
			   ( user.getSenha() != null && user.getSenha().isEmpty() ) ) ){
			
			msgsErro.add("Forneça o usuário e senha");
			
			model.addAttribute("validacao", false);
			model.addAttribute("msgsErro", msgsErro );
			
			return false;
		}
		
		if ( !facade.autenticausuarioSenha( user ) ){
			msgsErro.add("Usuário ou Senha inválidos");
			
			model.addAttribute("validacao", false);
			model.addAttribute("msgsErro", msgsErro );
			
			return false;
		}
		
		return true;
	}
}