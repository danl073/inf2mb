package br.senai.sp.jandira.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import br.senai.sp.jandira.dbUtils.Conexao;
import br.senai.sp.jandira.model.Contato;

public class ContatoDAO { 
	
	private Contato contato;
	
	public void gravar () {
		
	String sql = "INSERT INTO contatos" 
			+ "(nome, dtNasc, email, endereco, telefone, celular, sexo)" 
			+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	
	PreparedStatement stm = null;
	
	try {
		stm = Conexao.abrirConexao().prepareStatement(sql);
		stm.setString(1, contato.getNome());
		stm.setString(2, contato.getDtNasc());
		stm.setString(3, contato.getEmail());
		stm.setString(4, contato.getEndereco());
		stm.setString(5, contato.getTelefone());
		stm.setString(6, contato.getCelular());
		stm.setString(7, contato.getSexo());
		stm.execute();
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
	
		
	}
	
	public void atualizar () {
		
	}
	
	public void excluir () {
	
	}
	
	
	public Contato getContato (int id) {
		return contato; 
	}
	
	public void setContato(Contato contato){
		this.contato = contato;
	}
	
	
	public ArrayList<Contato> getContatos () {
		ArrayList<Contato> contatos = new ArrayList<>();
		
		return contatos;
	}
}
