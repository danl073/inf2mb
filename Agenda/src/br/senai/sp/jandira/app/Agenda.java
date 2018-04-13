package br.senai.sp.jandira.app;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.senai.sp.jandira.dbUtils.Conexao;
import br.senai.sp.jandira.view.FrmAgenda;

public class Agenda {
	
	public static void main(String[] args) {
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		String sql= "SELECT + FROM contatos";
		
	
		try {
			stm = Conexao.abrirConexao().prepareStatement(sql);
			rs = stm.executeQuery();
			
			while (rs.next()){
				System.out.println("ID:" + rs.getString("id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		FrmAgenda agenda = new FrmAgenda ();
		agenda.setVisible(true);

	}

}
