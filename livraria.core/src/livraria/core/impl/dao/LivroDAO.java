package livraria.core.impl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import livraria.dominio.CategoriaEstado;
import livraria.dominio.EntidadeDominio;
import livraria.dominio.Livro;

public class LivroDAO extends AbstractJdbcDAO {
	
	public LivroDAO() {
		super("livro", "id");		
	}
	public void salvar(EntidadeDominio entidade) {
		openConnection();
		PreparedStatement pst=null;
		Livro livro = (Livro)entidade;
		
		
		try {
			connection.setAutoCommit(false);						
			StringBuilder sql = new StringBuilder();
			
			sql.append("INSERT INTO livro(");
			sql.append("data_criacao , status , ano , titulo , edicao , ISBN , ");
			sql.append("numPag , sinopse , autor_id , editora_id , dimensoes_id ,");
			sql.append( "grupo_prec_id, custo) VALUES (sysdate(),true,?,?,?,?,?,?,?,?,?,?,?)");		
			
			pst = connection.prepareStatement(sql.toString(), 
					Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, livro.getAno());
			pst.setString(2, livro.getTitulo());
			pst.setString(3, livro.getEdicao());
			pst.setString(4, livro.getISBN());
			pst.setString(5, livro.getNumPag());
			pst.setString(6, livro.getSinopse());
			pst.setInt(7, livro.getAutor().getId());
			pst.setInt(8, livro.getEditora().getId());
			pst.setInt(9, livro.getDimensoes().getId());
			pst.setInt(10, livro.getGrupoPrecificacao().getId());
			pst.setDouble(11, livro.getCusto());
			pst.executeUpdate();	
			
			ResultSet rs = pst.getGeneratedKeys();
			int id=0;
			if(rs.next())
				id = rs.getInt(1);
			livro.setId(id);			
			connection.commit();		
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();			
		}finally{
			try {
				pst.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		

	}
	@Override
	public void alterar(EntidadeDominio entidade) throws SQLException {
		openConnection();
		PreparedStatement pst=null;
		Livro livro = (Livro)entidade;		
		
		try {
			connection.setAutoCommit(false);			
					
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE livro SET");
			sql.append("ano=?, titulo=?, edicao=?, ISBN=?, ");
			sql.append("numPag=?, sinopse=?, grupo_prec_id=?, autor_id=?, editora_id=?, dimensoes_id=?");
			sql.append("WHERE id=?");				
			
			pst = connection.prepareStatement(sql.toString());

			pst.setString(1, livro.getAno());
			pst.setString(2, livro.getTitulo());
			pst.setString(3, livro.getEdicao());
			pst.setString(4, livro.getISBN());
			pst.setString(5, livro.getNumPag());
			pst.setString(6, livro.getSinopse());
			pst.setInt(7, livro.getGrupoPrecificacao().getId());
			pst.setInt(8, livro.getAutor().getId());
			pst.setInt(9, livro.getEditora().getId());
			pst.setInt(10, livro.getDimensoes().getId());
			pst.setInt(11, livro.getId());


			pst.executeUpdate();			
			connection.commit();		
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();			
		}finally{
			try {
				pst.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
				
	}
	@Override
	public void excluir(EntidadeDominio entidade) throws SQLException {
		openConnection();
		PreparedStatement pst=null;
		Livro livro = (Livro)entidade;		
		
		try {
			
			
			connection.setAutoCommit(false);			
					
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE condicao SET");
			sql.append("descricao=?, estado=?, idModificador=?, categ_inat_id=?, dataModificacao= sysdate()");
			sql.append("WHERE id=?;");	
			sql.append("UPDATE livro SET");
			sql.append("status=?,condicao_id=? ");
			sql.append("WHERE id=?;");	
			
			pst = connection.prepareStatement(sql.toString());

			pst.setString(1, livro.getCondicao().getDescricao());
			pst.setString(2, livro.getCondicao().getEstado());
			pst.setInt(3, livro.getCondicao().getIdModificador());
			pst.setInt(4, livro.getCondicao().getCategoria().getId());
			pst.setInt(5, livro.getCondicao().getId());
			pst.setBoolean(6, livro.isStatus());
			pst.setInt(7, livro.getCondicao().getId());
			pst.setInt(8, livro.getId());

			} catch (SQLException e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();			
			}finally{
				try {
					pst.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

	}
	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
		PreparedStatement pst = null;
		
		Livro livro = (Livro)entidade;
		String sql=null;
		if(livro.getTitulo() == null){
			livro.setTitulo("");
		}
		
		if(livro.getId() == null && livro.getTitulo().equals("")){
			sql = "SELECT * FROM tb_produto";
		}else if(livro.getId() != null && livro.getDescricao().equals("")){
			sql = "SELECT * FROM tb_produto WHERE id_pro=?";
		}else if(livro.getId() == null && !livro.getDescricao().equals("")){
			sql = "SELECT * FROM tb_produto WHERE descricao like ?";
		
		}
	
		
		return null;
	}
}