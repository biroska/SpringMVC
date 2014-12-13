package controllers;

import javax.servlet.http.HttpSession;

import modelo.Usuario;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController {
	
	final static Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping("logoff")
	public String logoff( HttpSession session ){
		
		Usuario user = (Usuario) session.getAttribute("usuarioLogado");
		
		String msg = "MenuController.logoff - Usuario: "; 
		
		if ( user != null ){
			logger.info( msg + user.getUsuario() );
		}else{
			logger.info( msg );
		}
		
		session.removeAttribute("usuarioLogado");
		return "login";
	}
	
	@RequestMapping("menuInicio")
	public String inicio( Usuario user, Model model ){
		logger.info( "MenuController.inicio()" );
		
		model.addAttribute("abaSelecionada", "inicio" );
		return "principal";
	}
	
	@RequestMapping("menuCadastroUsuario")
	public String cadastroUsuario( Usuario user, Model model ){
		logger.info( "MenuController.cadastroUsuario()" );
		
		model.addAttribute("abaSelecionada", "usuario" );
		return "cadastroUsuario";
	}
	
	@RequestMapping("menuConsultaUsuario")
	public String consultaUsuario( Usuario user, Model model ){
		logger.info( "MenuController.consultaUsuario()" );
		
		model.addAttribute("abaSelecionada", "usuario" );
		return "forward:consultaUsuario";
	}
}
