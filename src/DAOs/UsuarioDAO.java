package DAOs;

import java.util.List;

import modelo.Usuario;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAO extends UtilDAO {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean autenticausuarioSenha( Usuario user ){
		
		String sql = " SELECT id FROM usuario " +
		             "  WHERE usuario = ? " +
				     "  AND   senha = ? ";
		
		List query = getJdbcTemplate().query( sql,
				                 new Object[] { user.getUsuario(),
				   								user.getSenha() },
				   								new BeanPropertyRowMapper(Usuario.class) );
		
//		List<Usuario> userResult = ( List<Usuario> ) getJdbcTemplate().queryForList(sql,
//																		new Object[] { user.getUsuario(),
//																					   user.getSenha() },
//																					   new BeanPropertyRowMapper(Usuario.class) );

	return ( "biroska".equalsIgnoreCase( user.getUsuario() ) &&
			 "123456".equalsIgnoreCase( user.getSenha() ) );
	}
	
	public Long inserirUsuario( Usuario user ){
		
		String sql = " INSERT INTO usuario " +
		             " (id, usuario, senha, email) VALUES " +
				     " ( ?,       ?,     ?,     ?)";
		        
int regGravado = getJdbcTemplate().update(sql, new Object[] {
		        		                 user.getId(),
		        		                 user.getUsuario(),
		        		                 user.getSenha(),
		        		                 user.getEmail() });

System.out.println("UsuarioDAO.inserirUsuario(): " + regGravado );
		        
		return new Long( regGravado );
	}
}
