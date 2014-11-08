package controllers;

import java.util.ArrayList;

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
		
		if ( validacao( user, model ) ){
			Long id = facade.inserirUsuario( user );
			
			if ( id != null ){
				user.setId( id );
			}			
		}
		
		return "cadastroUsuario";
	}
	
	private boolean validacao( Usuario user, Model model ){
		
		ArrayList<String> msgsErro = new ArrayList();
		
		if ( user.getUsuario() != null && user.getSenha() != null && user.getEmail() != null ){
			if ( user.getUsuario().isEmpty() || user.getSenha().isEmpty() || user.getEmail().isEmpty() ){
				msgsErro.add("Todos os campos são obrigatórios");
				model.addAttribute("validacao", false);
				model.addAttribute("msgsErro", msgsErro );
				
				return false;
			}
		}else{
			msgsErro.add("Todos os campos são obrigatórios");
			model.addAttribute("validacao", false);
			model.addAttribute("msgsErro", msgsErro );
			
			return false;
		}
		return true;
	}
	
}