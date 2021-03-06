package application;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.io.IOException;
import java.sql.Connection;
import java.util.Date;

import JDBC.AlunoJDBC;
import JDBC.db;
import entities.Aluno;

public class Programa {

	public static void main(String[] args) throws IOException, ParseException, SQLException {
		// TODO Auto-generated method stub
			Scanner console = new Scanner(System.in);
		
			Aluno a = new Aluno();
			AlunoJDBC acaoBanco =  new AlunoJDBC();

			System.out.println("Nome: ");
			String nome = console.nextLine();
			a.setNome(nome);
			
			System.out.println("Sexo: ");
			String sexo = console.nextLine();
			a.setSexo(sexo);
			
			System.out.println("Data Nascimento: ");
			String data = console.nextLine()
;			Date dataUtil = new Date(data);			
			a.setDt_Nasc(dataUtil);
			
			acaoBanco.salvar(a);
			
			System.out.println(" \nListando todos os alunos cadastrados: \n");
			for (Aluno c : acaoBanco.listar()) {
				System.out.println("Id: " + c.getId() + ", Nome: " + c.getNome() + ", Sexo: " + c.getSexo() + ", Data de Nascimento: " + c.getDt_Nasc());
			}
			
			System.out.println(" \n Digite id do aluno que deseja apagar: \n");
			int id = console.nextInt();
			acaoBanco.Apagar(id);
			

			System.out.println(" \n Digite os novos dados do aluno que deseja alterar e seu id(DEVE SER MANTIDO O MESMO): \n");
			Aluno b = new Aluno();
			
			System.out.println("ID: ");
			int idAlterar = console.nextInt();
			b.setId(idAlterar);
			
			System.out.println("Nome: ");
			String nomeAlterar = console.nextLine();
			b.setNome(nomeAlterar);
			
			System.out.println("Sexo: ");
			String sexoAlterar = console.nextLine();
			b.setSexo(sexoAlterar);
			
			System.out.println("Data Nascimento: ");
			String dataAlterar = console.nextLine();
			Date dataUtilAlterar = new Date(dataAlterar);			
			b.setDt_Nasc(dataUtilAlterar);
			
			acaoBanco.Alterar(b);


	}

}
