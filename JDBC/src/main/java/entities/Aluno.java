package entities;
import java.util.Date;

public class Aluno {
	
	
	private int id;
	private String Nome;
	private String Sexo;
	private Date Dt_Nasc;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getSexo() {
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}
	public Date getDt_Nasc() {
		return Dt_Nasc;
	}
	public void setDt_Nasc(Date dt_Nasc) {
		Dt_Nasc = dt_Nasc;
	}
	
}
