package br.senai.sp.jandira.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.senai.sp.jandira.dao.ContatoDAO;
import br.senai.sp.jandira.model.Contato;

import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class FrmAgenda extends JFrame {

	private JPanel painelPrincipal;
	private JTable tabelaContatos;
	private JScrollPane scrollTabela;
	private JPanel painelTabela;
	
	public FrmAgenda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/agenda10.png")));
		setTitle("Agenda de Contatos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 428);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JPanel painelTitulo = new JPanel();
		painelTitulo.setBackground(new Color(0, 0, 0));
		painelTitulo.setBounds(0, 0, 538, 90);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(null);
		
		JLabel lblTituloTela = new JLabel(" Agenda");
		lblTituloTela.setForeground(new Color(255, 255, 255));
		lblTituloTela.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/agenda10.png")));
		lblTituloTela.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 28));
		lblTituloTela.setBounds(172, 23, 171, 56);
		painelTitulo.add(lblTituloTela);
		
		painelTabela = new JPanel();
		painelTabela.setBorder(new TitledBorder(null, "Contatos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		painelTabela.setBounds(10, 101, 518, 233);
		painelPrincipal.add(painelTabela);
		painelTabela.setLayout(null);
		
		montarTabela();
		
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		painelBotoes.setBounds(10, 334, 518, 55);
		painelPrincipal.add(painelBotoes);
		painelBotoes.setLayout(null);
		
		JButton btnNovo = new JButton("");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmDadosAgenda contato = new FrmDadosAgenda("NOVO");
				contato.setVisible(true);
			}
		});
		btnNovo.setToolTipText("Adicionar contato");
		btnNovo.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/add1.png")));
		btnNovo.setBounds(10, 11, 89, 33);
		painelBotoes.add(btnNovo);
		
		JButton btnEditar = new JButton("");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
				int linha;	
				linha = tabelaContatos.getSelectedRow();
				
				int id;	
				id = (int)tabelaContatos.getValueAt(linha, 0);
				
			
				ContatoDAO contatoDao = new ContatoDAO();
				
				System.out.println(contatoDao.getContato(id).getNome());
				System.out.println(contatoDao.getContato(id).getCelular());
				
				FrmDadosAgenda contato = new FrmDadosAgenda("EDITAR");
				//contato.setVisible(true);
			}
		});
		btnEditar.setToolTipText("Editar contato");
		btnEditar.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/edit.png")));
		btnEditar.setBounds(109, 11, 89, 33);
		painelBotoes.add(btnEditar);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmDadosAgenda contato = new FrmDadosAgenda("EXCLUIR");
				contato.setVisible(true);
			}
		});
		btnExcluir.setToolTipText("Excluir contato");
		btnExcluir.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/delete.png")));
		btnExcluir.setBounds(209, 11, 89, 33);
		painelBotoes.add(btnExcluir);
		
		JButton btnSair = new JButton("");
		btnSair.setToolTipText("Sair da Aplica\u00E7\u00E3o");
		btnSair.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/sair.png")));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSair.setBounds(451, 11, 57, 33);
		painelBotoes.add(btnSair);
		
		
	}
	
	public void montarTabela(){
		scrollTabela = new JScrollPane();
		scrollTabela.setBounds(10, 22, 498, 200);
		painelTabela.add(scrollTabela);
		
		tabelaContatos = new JTable();
		
		DefaultTableModel modeloTabela = new DefaultTableModel();
		String[] nomesColunas = {"ID", "NOME", "E-MAIL"};
		modeloTabela.setColumnIdentifiers(nomesColunas);
		
		ContatoDAO contatoDAO = new ContatoDAO ();
		ArrayList<Contato> contatos = new ArrayList();
		
		contatos = contatoDAO.getContatos();
		
		Object[] linha = new Object[3];
		
		for (Contato contato : contatos){
			linha[0] = contato.getId();
			linha[1] = contato.getNome();
			linha[2] = contato.getEmail();
			modeloTabela.addRow(linha);
		}
		
		
		
		tabelaContatos.setModel(modeloTabela);
		
		
		
		
		
		
		/*tabelaContatos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"ID", "NOME", "E-MAIL"
			}
		));*/
		
		tabelaContatos.getColumnModel().getColumn(0).setPreferredWidth(41);
		tabelaContatos.getColumnModel().getColumn(1).setPreferredWidth(167);
		tabelaContatos.getColumnModel().getColumn(2).setPreferredWidth(195);
		scrollTabela.setViewportView(tabelaContatos);
	}
	
}
