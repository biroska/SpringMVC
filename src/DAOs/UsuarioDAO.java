package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import modelo.Usuario;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAO extends UtilDAO {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean autenticausuarioSenha( Usuario user ){
		
		String sql = " SELECT id FROM usuario " +
		             "  WHERE usuario = ? " +
				     "  AND   senha = ? ";
		
		List<Usuario> query = getJdbcTemplate().query( sql,
				                 new Object[] { user.getUsuario(),
				   								user.getSenha() },
				   								new BeanPropertyRowMapper(Usuario.class) );
		
		return ( query.size() == 1 && query.get( 0 ).getId() != null );
	}
	
	public Long inserirUsuario( final Usuario user ){
		
		final String sql = " INSERT INTO usuario " +
				           " (usuario, senha, email) VALUES " +
						   " (      ?,     ?,     ?)";
//		final Usuario usuario = new Usuario( user.getUsuario(), user.getUsuario(), user.getUsuario() );
		        
//		int regGravado = getJdbcTemplate().update(sql, new Object[] {
//					        						   user.getUsuario(),
//					        		                   user.getSenha(),
//					        		                   user.getEmail() } );
//
//		System.out.println("UsuarioDAO.inserirUsuario(): " + regGravado );
		        
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update( new PreparedStatementCreator() {
								  		public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
								  			   PreparedStatement ps = connection.prepareStatement( sql, new String[] { user.getUsuario(),
								  					   																   user.getSenha(),
								  					   																   user.getEmail() });
								            ps.setString(1, user.getUsuario() );
								            ps.setString(2, user.getSenha() );
								            ps.setString(3, user.getEmail() );
								            return ps;
								        }
								    },
								    keyHolder);
		
		return keyHolder.getKey().longValue();
	}
}
