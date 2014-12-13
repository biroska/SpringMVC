package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Usuario;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAO extends UtilDAO {

	private boolean controleWhere;
	
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Usuario> buscaUsuario( Usuario user ){
		
		controleWhere = false;
		
		ArrayList<Object> parametros = new ArrayList<Object>();
		
		String sql = " SELECT *  FROM usuario ";
		
		if ( user.getUsuario() != null && !user.getUsuario().isEmpty() ){
			sql = sql + controleWhere( controleWhere ) + " usuario = ? ";
			parametros.add( user.getUsuario() );
		}
		
		if ( user.getEmail() != null && !user.getEmail().isEmpty() ){
			sql = sql + controleWhere( controleWhere ) + " email = ? ";
			parametros.add( user.getEmail() );
		}
		
		
		List<Usuario> queryForList = null;
		try {
			queryForList = getJdbcTemplate().query( sql, new BeanPropertyRowMapper (Class.forName("modelo.Usuario") ), parametros.toArray() );
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		List<Usuario> queryForList = getJdbcTemplate().query( sql, new BeanPropertyRowMapper(Usuario.class), parametros.toArray() );
		
		System.out.println("UsuarioDAO.buscaUsuario(): " + queryForList.size() );
		
		return null;
	}
	
	private String controleWhere( boolean controle ){
		controleWhere = true;
		return controle ? " and " : " where ";
	}
}