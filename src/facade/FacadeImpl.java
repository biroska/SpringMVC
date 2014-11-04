package facade;

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
		
//		user = new Usuario( new Long(4), "teste4", "123456");
		
		return usuarioDao.inserirUsuario(user);
	}
	
}
