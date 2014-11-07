package controllers;

import modelo.Usuario;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioController {
	
	@RequestMapping("cadastroUsuario")
	public String cadastroUsuario( Usuario user, Model model ){
		return "cadastroUsuario";
	}
}