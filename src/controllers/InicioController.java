package controllers;

import java.util.ArrayList;
import java.util.List;

import modelo.Usuario;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioController {
	
	private List<Usuario> usuarios;

	@RequestMapping("principal")
	public String principal( Usuario user, Model model ){
		System.out.println("UsuarioController.principal()");
		iniciarListaUsusarios();
		model.addAttribute("usuario", user );
		model.addAttribute("abaSelecionada", "inicio" );
		model.addAttribute("exibeMenu", true );
		model.addAttribute("usuarios", usuarios );
		return "principal";
	}
	
	private void iniciarListaUsusarios(){
		int qtdUsers = 5;
		usuarios = new ArrayList<Usuario>( qtdUsers );
		for (int i = 1; i < qtdUsers ; i++) {
			usuarios.add( new Usuario( Long.valueOf(i), String.valueOf( "usuario_" + i ), "123456" ) );
		}
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}