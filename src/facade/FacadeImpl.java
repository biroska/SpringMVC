package facade;

import java.util.List;

import modelo.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import DAOs.UsuarioDAO;

@Repository
public class FacadeImpl {

	@Autowired
	UsuarioDAO usuarioDao;
	
	public boolean autenticausuarioSenha( Usuario user ){
		return usuarioDao.autenticausuarioSenha(user);
	}
	
	public Long inserirUsuario( Usuario user ){
		
		return usuarioDao.inserirUsuario(user);
	}
	
	public List<Usuario> buscaUsuario( Usuario user ){
		
		return usuarioDao.buscaUsuario(user);
	}
	
}
