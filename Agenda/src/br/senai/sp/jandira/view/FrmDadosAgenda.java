package br.senai.sp.jandira.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class FrmDadosAgenda extends JFrame {

	private JPanel painelPrincipal;
	private JTextField textId;
	private JTextField textNome;
	private JTextField textEmail;
	private JTextField textCelular;
	private JTextField textTelefone;
	private JTextField textDtNascimento;

	public FrmDadosAgenda(String operacao) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmDadosAgenda.class.getResource("/br/senai/sp/jandira/imagens/agenda10.png")));
		setBounds(100, 100, 482, 453);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JPanel painelTitulo = new JPanel();
		painelTitulo.setBackground(new Color(128, 128, 128));
		painelTitulo.setForeground(new Color(255, 255, 255));
		painelTitulo.setBounds(0, 0, 466, 83);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(null);
		
		JLabel lblTituloTela = new JLabel("Contatos");
		lblTituloTela.setForeground(new Color(255, 255, 255));
		lblTituloTela.setIcon(new ImageIcon(FrmDadosAgenda.class.getResource("/br/senai/sp/jandira/imagens/agenda.png")));
		lblTituloTela.setFont(new Font("Lucida Console", Font.BOLD, 35));
		lblTituloTela.setBounds(10, 21, 228, 51);
		painelTitulo.add(lblTituloTela);
		
		JLabel lblNovo = new JLabel(operacao);
		lblNovo.setForeground(new Color(255, 0, 0));
		lblNovo.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNovo.setBounds(348, 21, 82, 38);
		painelTitulo.add(lblNovo);
		
		JPanel painelTabela = new JPanel();
		painelTabela.setBorder(new TitledBorder(null, "Dados do Contato", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelTabela.setBounds(10, 94, 446, 278);
		painelPrincipal.add(painelTabela);
		painelTabela.setLayout(null);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Verdana", Font.BOLD, 12));
		lblID.setBounds(10, 21, 29, 22);
		painelTabela.add(lblID);
		
		textId = new JTextField();
		textId.setEnabled(false);
		textId.setBounds(40, 24, 42, 20);
		painelTabela.add(textId);
		textId.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNome.setBounds(104, 25, 54, 14);
		painelTabela.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(154, 23, 268, 20);
		painelTabela.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Verdana", Font.BOLD, 12));
		lblEmail.setBounds(10, 54, 54, 14);
		painelTabela.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(10, 70, 426, 20);
		painelTabela.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Verdana", Font.BOLD, 12));
		lblCelular.setBounds(10, 101, 64, 14);
		painelTabela.add(lblCelular);
		
		textCelular = new JTextField();
		textCelular.setBounds(10, 114, 120, 20);
		painelTabela.add(textCelular);
		textCelular.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Verdana", Font.BOLD, 12));
		lblTelefone.setBounds(212, 101, 69, 14);
		painelTabela.add(lblTelefone);
		
		textTelefone = new JTextField();
		textTelefone.setBounds(212, 114, 177, 20);
		painelTabela.add(textTelefone);
		textTelefone.setColumns(10);
		
		JLabel lblDtNascimento = new JLabel("Data de Nascimento:");
		lblDtNascimento.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDtNascimento.setBounds(10, 145, 148, 14);
		painelTabela.add(lblDtNascimento);
		
		textDtNascimento = new JTextField();
		textDtNascimento.setBounds(10, 158, 160, 20);
		painelTabela.add(textDtNascimento);
		textDtNascimento.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Endere\u00E7o:");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 189, 72, 14);
		painelTabela.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(80, 189, 160, 78);
		painelTabela.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		JButton btnSalvar = new JButton("");
		btnSalvar.setIcon(new ImageIcon(FrmDadosAgenda.class.getResource("/br/senai/sp/jandira/imagens/salvar.png")));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSalvar.setBounds(10, 372, 89, 42);
		painelPrincipal.add(btnSalvar);
		
		JButton btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(FrmDadosAgenda.class.getResource("/br/senai/sp/jandira/imagens/sair.png")));
		btnSair.setBounds(367, 372, 89, 42);
		painelPrincipal.add(btnSair);
	}
}
