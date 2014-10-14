package DAOs;

import modelo.Usuario;

import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAO {

	public boolean autenticausuarioSenha( Usuario user ){
		
	return ( "biroska".equalsIgnoreCase( user.getUsuario() ) &&
			 "123456".equalsIgnoreCase( user.getSenha() ) );
	}
}
