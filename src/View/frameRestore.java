/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Dimension;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import BackupAndRestore.PostgresRestore;
import Daos.ConfigDAO;
import Models.ConfigModel;

/**
 *
 * @author vitor
 */
public class frameRestore extends javax.swing.JInternalFrame {

	/**
	 * Creates new form frameRestore
	 */

	public frameRestore(Connection conn) {
		initComponents();
		configDao = new ConfigDAO(conn);

		try {
			config = configDao.getConfig(0);
			fixFields();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String dirBackup;
	private String nomeArquivo = "";
	private ConfigDAO configDao;
	private ConfigModel config;
	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		txtSenha = new javax.swing.JTextField();
		btnSalvar = new javax.swing.JButton();
		btnCancelar = new javax.swing.JButton();
		btnDirBackup = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		txtDirBackup = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		txtDirRestore = new javax.swing.JTextField();
		btnDirRestore = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();
		txtNome = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		txtPorta = new javax.swing.JTextField();
		txtIp = new javax.swing.JTextField();
		txtUsuario = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();

		setClosable(true);
		setIconifiable(true);
		setTitle("Restore");

		txtSenha.setText("admin");
		txtSenha.setToolTipText("Senha do Banco");
		txtSenha.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtSenhaActionPerformed(evt);
			}
		});

		btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/disquetex32.png"))); // NOI18N
		btnSalvar.setToolTipText("Salvar");
		btnSalvar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSalvarActionPerformed(evt);
			}
		});

		btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/proibido.png"))); // NOI18N
		btnCancelar.setToolTipText("Cancelar");
		btnCancelar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCancelarActionPerformed(evt);
			}
		});

		btnDirBackup.setText("...");
		btnDirBackup.setToolTipText("Buscar");
		btnDirBackup.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDirBackupActionPerformed(evt);
			}
		});

		jLabel1.setText("Diretório Backup");

		txtDirBackup.setText("Documentos");
		txtDirBackup.setToolTipText("Selecione o backup");
		txtDirBackup.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtDirBackupActionPerformed(evt);
			}
		});

		jLabel2.setText("Diretório PgRestore");

		txtDirRestore.setText("V:\\PostgreSQL\\13\\bin\\pg_restore.exe");
		txtDirRestore.setToolTipText("Diretório de registro");
		txtDirRestore.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtDirRestoreActionPerformed(evt);
			}
		});

	btnDirRestore.setText("...");
		btnDirRestore.setToolTipText("Buscar");
		btnDirRestore.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDirRestoreActionPerformed(evt);
			}
		});

		jLabel3.setText("Nome do Banco");

		txtNome.setText("BeerDB");
		txtNome.setToolTipText("Nome do Banco");
		txtNome.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtNomeActionPerformed(evt);
			}
		});

		jLabel4.setText("Senha do Banco");

		txtPorta.setText("5432");
		txtPorta.setToolTipText("Senha do Banco");
		txtPorta.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtPortaActionPerformed(evt);
			}
		});

		txtIp.setText("localhost");
		txtIp.setToolTipText("Senha do Banco");
		txtIp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtIpActionPerformed(evt);
			}
		});

		txtUsuario.setText("admin");
		txtUsuario.setToolTipText("Senha do Banco");
		txtUsuario.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtUsuarioActionPerformed(evt);
			}
		});

		jLabel6.setText("Usuário");

		jLabel7.setText("IP");

		jLabel8.setText("Porta");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addComponent(btnSalvar).addGap(18, 18, 18)
								.addComponent(btnCancelar))
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addComponent(txtDirRestore, javax.swing.GroupLayout.PREFERRED_SIZE,
														311, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(btnDirRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup()
												.addComponent(txtDirBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 311,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(btnDirBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup().addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addGroup(layout.createSequentialGroup()
														.addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE,
																100, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18).addComponent(jLabel4))
												.addGroup(layout.createSequentialGroup()
														.addComponent(txtUsuario,
																javax.swing.GroupLayout.PREFERRED_SIZE, 100,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jLabel8)))
												.addGap(18, 18, 18)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(txtPorta, javax.swing.GroupLayout.PREFERRED_SIZE,
																100, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE,
																100, javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addComponent(txtIp, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
												javax.swing.GroupLayout.PREFERRED_SIZE))))
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(8, 8, 8)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(btnSalvar)
						.addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1).addComponent(txtDirBackup,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(btnDirBackup))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(btnDirRestore)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2).addComponent(txtDirRestore,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3)
						.addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel4).addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtPorta, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel8))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel6)))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel7)
						.addComponent(txtIp, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addContainerGap(41, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		if (txtDirRestore.getText().isEmpty() || txtDirBackup.getText().isEmpty() || txtNome.getText().isEmpty()
				|| txtSenha.getText().isEmpty() || txtUsuario.getText().isEmpty() || txtDirRestore.getText().equals(" ") || txtDirBackup.getText().equals(" ") || txtNome.getText().equals(" ")
				|| txtSenha.getText().equals(" ") || txtUsuario.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "falha!", JOptionPane.ERROR_MESSAGE,
					new javax.swing.ImageIcon(getClass().getResource("/Imagens/sinal-de-avisox32.png")));
		} else if (nomeArquivo.equals("")) {
			JOptionPane.showMessageDialog(null, "Selecione um arquivo de backup!", "falha!", JOptionPane.ERROR_MESSAGE,
					new javax.swing.ImageIcon(getClass().getResource("/Imagens/sinal-de-avisox32.png")));
		}
		new PostgresRestore(dirBackup, txtDirRestore.getText().toString(),
				txtNome.getText().toString(), txtSenha.getText().toString(), txtUsuario.getText().toString(),
				txtIp.getText().toString(), txtPorta.getText().toString());
	}

	private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void btnDirBackupActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		JFileChooser chooser = new JFileChooser(
				new File("C:\\Users\\" + System.getProperty("user.name") + "\\Documents"));
		chooser.setDialogTitle("Selecione o destino");
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			System.out.println(chooser.getSelectedFile().getAbsolutePath());
			nomeArquivo = chooser.getSelectedFile().getName();
			System.out.println(nomeArquivo);
			dirBackup = chooser.getSelectedFile().getAbsolutePath();
			txtDirBackup.setText(chooser.getSelectedFile().getAbsolutePath());
		}
	}

	private void txtDirBackupActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void txtDirRestoreActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void btnDirRestoreActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		JFileChooser chooser = new JFileChooser(
				new File("C:\\Users\\" + System.getProperty("user.name") + "\\Documents"));
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setDialogTitle("Selecione o diretorio do pg_dump");
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			if (!chooser.getSelectedFile().getName().equals("pg_dump.exe")) {
				JOptionPane.showMessageDialog(null, "Arquivo inválido", "Inválido!", JOptionPane.ERROR_MESSAGE,
						new javax.swing.ImageIcon(getClass().getResource("/Imagens/sinal-de-avisox32.png")));
			} else {
				txtDirRestore.setText(chooser.getSelectedFile().getPath());
			}
		}
	}

	private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void txtPortaActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void txtIpActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	public void setPosicao() {
		Dimension d = this.getDesktopPane().getSize();
		this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
	}

	public void fixFields() {
		txtDirRestore.setText(config.getPgRestore());
		txtNome.setText(config.getNomeBanco());
		txtSenha.setText(config.getSenhaBanco());
		txtUsuario.setText(config.getUserBanco());
		txtPorta.setText(config.getPortaBanco());
		txtIp.setText(config.getIpBanco());
	}

	// Variables declaration - do not modify
	private javax.swing.JButton btnCancelar;
	private javax.swing.JButton btnDirBackup;
	private javax.swing.JButton btnDirRestore;
	private javax.swing.JButton btnSalvar;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JTextField txtDirBackup;
	private javax.swing.JTextField txtDirRestore;
	private javax.swing.JTextField txtIp;
	private javax.swing.JTextField txtNome;
	private javax.swing.JTextField txtPorta;
	private javax.swing.JTextField txtSenha;
	private javax.swing.JTextField txtUsuario;
	// End of variables declaration
}
