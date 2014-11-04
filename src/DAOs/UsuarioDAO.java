package DAOs;

import modelo.Usuario;

import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAO extends UtilDAO {

	public boolean autenticausuarioSenha( Usuario user ){
		
	return ( "biroska".equalsIgnoreCase( user.getUsuario() ) &&
			 "123456".equalsIgnoreCase( user.getSenha() ) );
	}
	
	public boolean inserirUsuario( Usuario user ){
		
		String sql = " INSERT INTO usuario " +
		             " (id, usuario, senha, email) VALUES " +
				     " ( ?,       ?,     ?,     ?)";
		        
int regGravado = getJdbcTemplate().update(sql, new Object[] {
		        		                 user.getId(),
		        		                 user.getUsuario(),
		        		                 user.getSenha(),
		        		                 user.getEmail() });

System.out.println("UsuarioDAO.inserirUsuario(): " + regGravado );
		        
		return regGravado > 0;
	}
}
