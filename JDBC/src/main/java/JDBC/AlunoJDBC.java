package JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import  java.sql.Date;

import entities.Aluno;

public class AlunoJDBC {
	
	
	Connection con;
	String sql;
	PreparedStatement pst;
	
	public void salvar(Aluno a) throws IOException, SQLException {

		Connection con = db.getConexao();
		System.out.println("Conex?o realizada com sucesso");
		
		sql = "insert into aluno(Nome, Sexo, Dt_Nasc) values (?, ?, ?)";
		
		pst = con.prepareStatement(sql);
		pst.setString(1, a.getNome());
		pst.setString(2, a.getSexo());

		Date dataSql = new Date(a.getDt_Nasc().getTime());
		pst.setDate(3, dataSql);
		
		pst.executeUpdate();
		System.out.println("Cadastro do aluno realizado com sucesso");
		
		db.closeConexao();
		System.out.println("Conex?o finalizada com sucesso");
	}
	
	public List<Aluno> listar() throws IOException, SQLException {
		Connection con = db.getConexao();
		List<Aluno> ListaAluno = new ArrayList<>();
		Statement st = con.createStatement();
		sql = "select * from aluno";
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			Aluno a = new Aluno();
			a.setNome(rs.getString(1));
			a.setSexo(rs.getString(2));
			a.setDt_Nasc(rs.getDate("dt_nasc"));
			a.setId(rs.getInt(4));
			ListaAluno.add(a);
		}
		rs.close();
		st.close();
		db.closeConexao();
		return ListaAluno;
	}
	
	public void Apagar(int id) throws SQLException, IOException {
		Connection con = db.getConexao();
		sql = "delete from ALUNO where ID = ?";
		pst = con.prepareStatement(sql);
		pst.setInt(1, id);
		pst.executeUpdate();
		System.out.println("Aluno " + id + " apagado com sucesso!");
	}
	
	public void Alterar(Aluno a) throws IOException, SQLException {
		Connection con = db.getConexao();
		sql = "update ALUNO set NOME = ?, SEXO = ?, DT_NASC = ? where ID = ?";
		pst = con.prepareStatement(sql);
		
		pst.setString(1, a.getNome());
		pst.setString(2, a.getSexo());
		Date dataSql = new Date(a.getDt_Nasc().getTime());
		pst.setDate(3, dataSql);
		pst.setInt(4, a.getId());
		pst.executeUpdate();
		System.out.println("Aluno" + a.getNome() + " alterado com sucesso!");
		
	}
	
}
