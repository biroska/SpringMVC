package controllers;

import modelo.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import facade.FacadeImpl;

@Controller
public class UsuarioController {

	@Autowired
	FacadeImpl facade;
	
	@RequestMapping("cadastroUsuario")
	public String cadastroUsuario( Usuario user, Model model ){
		
		Long id = facade.inserirUsuario( user );
		
		if ( id != null ){
			user.setId( id );
		}
		
		return "cadastroUsuario";
	}
}