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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;

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
		painelPrincipal.setBackground(Color.LIGHT_GRAY);
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JPanel painelTitulo = new JPanel();
		painelTitulo.setBackground(Color.BLACK);
		painelTitulo.setBounds(0, 0, 538, 90);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(null);
		
		JLabel lblTituloTela = new JLabel(" Agenda");
		lblTituloTela.setForeground(new Color(255, 255, 255));
		lblTituloTela.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/agenda10.png")));
		lblTituloTela.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 28));
		lblTituloTela.setBounds(172, 23, 171, 56);
		painelTitulo.add(lblTituloTela);
		
		
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		JLabel lblData = new JLabel();
		lblData.setForeground(Color.WHITE);
		lblData.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblData.setBounds(438, 11, 90, 14);
		
		Date dataAtual = new Date();
		
		lblData.setText(data.format(dataAtual));
		
		
		painelTitulo.add(lblData);
		
		painelTabela = new JPanel();
		painelTabela.setBackground(Color.LIGHT_GRAY);
		painelTabela.setBorder(new TitledBorder(null, "Contatos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		painelTabela.setBounds(10, 101, 518, 233);
		painelPrincipal.add(painelTabela);
		painelTabela.setLayout(null);
		
		montarTabela();
		
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setBackground(Color.LIGHT_GRAY);
		painelBotoes.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		painelBotoes.setBounds(10, 334, 518, 55);
		painelPrincipal.add(painelBotoes);
		painelBotoes.setLayout(null);
		
		JButton btnNovo = new JButton("");
		btnNovo.setBackground(SystemColor.controlHighlight);
		btnNovo.setForeground(Color.WHITE);
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
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBackground(SystemColor.controlHighlight);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
				try { int linha;	
				linha = tabelaContatos.getSelectedRow();
				
				int id;	
				id = (int)tabelaContatos.getValueAt(linha, 0);
				
			
				ContatoDAO contatoDao = new ContatoDAO();
				Contato contato = contatoDao.getContato(id);
				
				
				FrmDadosAgenda frmContato = new FrmDadosAgenda("EDITAR");
				frmContato.setTxtId(String.valueOf(contato.getId()));
				frmContato.setTxtNome(contato.getNome());
				frmContato.setTxtEmail(contato.getEmail());
				frmContato.setTxtCelular(contato.getCelular());
				frmContato.setTxtTelefone(contato.getTelefone());
				frmContato.setTxtArea(contato.getEndereco());
				frmContato.setTxtDtNascimento(contato.getDtNasc());
				frmContato.setCbSexo(contato.getSexo());
				
				
				
				frmContato.setVisible(true);
					
				} catch (Exception erro){
					JOptionPane.showMessageDialog(null, "Selecione um contato!","Atenção",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnEditar.setToolTipText("Editar contato");
		btnEditar.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/edit.png")));
		btnEditar.setBounds(109, 11, 89, 33);
		painelBotoes.add(btnEditar);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setBackground(SystemColor.controlHighlight);
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
		btnSair.setForeground(Color.BLACK);
		btnSair.setBackground(SystemColor.controlHighlight);
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
