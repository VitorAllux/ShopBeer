/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import Daos.ConfigDAO;
import Models.ConfigModel;

/**
 *
 * @author vitor
 */
public class frameConfig extends javax.swing.JInternalFrame {

	/**
	 * Creates new form frameConfig
	 */

	private ConfigDAO configDao;
	private ConfigModel config;
	private ConfigModel configChange;
	public frameConfig(Connection conn) {
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

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		txtPgDump = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		txtRestore = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		btnDump = new javax.swing.JButton();
		btnRestore = new javax.swing.JButton();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		txtBanco = new javax.swing.JTextField();
		txtUser = new javax.swing.JTextField();
		txtSenha = new javax.swing.JTextField();
		txtIp = new javax.swing.JTextField();
		txtPorta = new javax.swing.JTextField();
		ComboBox = new javax.swing.JComboBox<>();
		checkAutoBackup = new javax.swing.JCheckBox();
		btnSalvar = new javax.swing.JButton();
		btnCancelar = new javax.swing.JButton();
		jLayeredPane1 = new javax.swing.JLayeredPane();
		jLabel8 = new javax.swing.JLabel();

		setClosable(true);
		setIconifiable(true);
		setTitle("Configura��es");

		jLabel1.setText("Diret�rio PgDump");

		jLabel2.setText("Diret�rio PgRestore");

		jLabel3.setText("Nome Banco");

		jLabel4.setText("Usu�rio Banco");

		btnDump.setText("...");
		btnDump.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDumpActionPerformed(evt);
			}
		});

		btnRestore.setText("...");
		btnRestore.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnRestoreActionPerformed(evt);
			}
		});

		jLabel5.setText("Senha Banco");

		jLabel6.setText("Ip Banco");

		jLabel7.setText("Porta Banco");

		ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "Desativado", "1 hora", "2 horas", "4 horas", "8 horas" }));

		checkAutoBackup.setText("Auto Backup");
		checkAutoBackup.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
					ComboBox.setEnabled(true);
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					ComboBox.setEnabled(false);
					ComboBox.setSelectedIndex(0);
				}
			}
		});
		checkAutoBackup.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				checkAutoBackupActionPerformed(evt);
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

		jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/configuracoesx256.png"))); // NOI18N

		jLayeredPane1.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

		javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
		jLayeredPane1.setLayout(jLayeredPane1Layout);
		jLayeredPane1Layout
				.setHorizontalGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jLayeredPane1Layout.createSequentialGroup().addComponent(jLabel8,
								javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE)));
		jLayeredPane1Layout.setVerticalGroup(jLayeredPane1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jLayeredPane1Layout.createSequentialGroup().addComponent(jLabel8,
						javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 35, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jLabel7)
								.addComponent(jLabel5).addComponent(jLabel4).addComponent(jLabel2).addComponent(jLabel1)
								.addComponent(checkAutoBackup).addComponent(jLabel3).addComponent(jLabel6))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(txtPgDump, javax.swing.GroupLayout.PREFERRED_SIZE, 373,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18).addComponent(btnDump,
												javax.swing.GroupLayout.PREFERRED_SIZE, 32,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
												layout.createSequentialGroup().addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(txtPorta, javax.swing.GroupLayout.PREFERRED_SIZE,
																103, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.TRAILING,
																		false)
																.addComponent(txtIp,
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(txtSenha,
																		javax.swing.GroupLayout.Alignment.LEADING,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 103,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
														.addComponent(txtBanco,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.PREFERRED_SIZE, 103,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																txtUser, javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.PREFERRED_SIZE, 103,
																javax.swing.GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jLayeredPane1,
																javax.swing.GroupLayout.PREFERRED_SIZE, 279,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
												.createSequentialGroup()
												.addComponent(txtRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 373,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18).addComponent(btnRestore,
														javax.swing.GroupLayout.PREFERRED_SIZE, 32,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(32, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup().addGap(22, 22, 22).addComponent(btnSalvar).addGap(18, 18, 18)
						.addComponent(btnCancelar)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(13, 13, 13)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGap(13, 13, 13)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(checkAutoBackup))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel1)
										.addComponent(txtPgDump, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(btnDump))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel2)
										.addComponent(txtRestore, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(btnRestore))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(txtIp, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel6)).addGap(18, 18, 18)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(txtPorta, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel7))
												.addGap(18, 18, 18)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(txtBanco, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel3))
												.addGap(18, 18, 18)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel4))
												.addGap(18, 18, 18)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE,
																14, javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(14, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		try {
			getfields();
			configDao.updateConfig(configChange);
			config = configDao.getConfig(0);
			JOptionPane.showMessageDialog(null, "Configura��es Salvas!", "Sucesso!",
					JOptionPane.INFORMATION_MESSAGE,
					new javax.swing.ImageIcon(getClass().getResource("/Imagens/verificado.png")));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		fixFields();
	}

	public void setPosicao() {
		Dimension d = this.getDesktopPane().getSize();
		this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
	}

	private void checkAutoBackupActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}
	
    private void btnDumpActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
		JFileChooser chooser = new JFileChooser(
				new File("C:\\Users\\" + System.getProperty("user.name") + "\\Documents"));
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setDialogTitle("Selecione o diretorio do pg_dump");
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			if (!chooser.getSelectedFile().getName().equals("pg_dump.exe")) {
				JOptionPane.showMessageDialog(null, "Arquivo inv�lido", "Inv�lido!", JOptionPane.ERROR_MESSAGE,
						new javax.swing.ImageIcon(getClass().getResource("/Imagens/sinal-de-avisox32.png")));
			} else {
				txtPgDump.setText(chooser.getSelectedFile().getPath());
			}
		}
    }
    
    private void btnRestoreActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    	JFileChooser chooser = new JFileChooser(
				new File("C:\\Users\\" + System.getProperty("user.name") + "\\Documents"));
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setDialogTitle("Selecione o diretorio do pg_dump");
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			if (!chooser.getSelectedFile().getName().equals("pg_dump.exe")) {
				JOptionPane.showMessageDialog(null, "Arquivo inv�lido", "Inv�lido!", JOptionPane.ERROR_MESSAGE,
						new javax.swing.ImageIcon(getClass().getResource("/Imagens/sinal-de-avisox32.png")));
			} else {
				txtRestore.setText(chooser.getSelectedFile().getPath());
			}
		}
    }   

	public void getfields() {
		if (txtBanco.getText().isEmpty() || txtIp.getText().isEmpty() || txtPgDump.getText().isEmpty()
				|| txtPorta.getText().isEmpty() || txtRestore.getText().isEmpty() || txtSenha.getText().isEmpty()
				|| txtUser.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "falha!", JOptionPane.ERROR_MESSAGE,
					new javax.swing.ImageIcon(getClass().getResource("/Imagens/sinal-de-avisox32.png")));
		}else {
			configChange = new ConfigModel();
			configChange.setId(0);
			configChange.setIpBanco(txtIp.getText().toString());
			configChange.setNomeBanco(txtBanco.getText().toString());
			configChange.setPgDump(txtPgDump.getText().toString());
			configChange.setPgRestore(txtRestore.getText().toString());
			configChange.setPortaBanco(txtPorta.getText().toString());
			configChange.setSenhaBanco(txtSenha.getText().toString());
			configChange.setUserBanco(txtUser.getText().toString());
			if(checkAutoBackup.isSelected()) {
				int op = ComboBox.getSelectedIndex();
				switch (op) {
				case 1: {
					configChange.setAutoBackup(Integer.toString(3600000));
					break;
				}
				case 2: {
					configChange.setAutoBackup(Integer.toString(7200000));
					break;
				}
				case 3: {
					configChange.setAutoBackup(Integer.toString(14400000));
					break;
				}
				case 4: {
					configChange.setAutoBackup(Integer.toString(28800000));
					break;
				}
				}
			}
			
		}
	}

	public void fixFields() {
		txtBanco.setText(config.getNomeBanco());
		txtIp.setText(config.getIpBanco());
		txtPgDump.setText(config.getPgDump());
		txtPorta.setText(config.getPortaBanco());
		txtSenha.setText(config.getSenhaBanco());
		txtUser.setText(config.getUserBanco());
		txtRestore.setText(config.getPgRestore());
		if (!config.getAutoBackup().equals(" ")) {
			checkAutoBackup.setSelected(true);
			switch (Integer.parseInt(config.getAutoBackup())) {
			case 3600000: {
				ComboBox.setSelectedIndex(1);
				break;
			}
			case 7200000: {
				ComboBox.setSelectedIndex(2);
				break;
			}
			case 14400000: {
				ComboBox.setSelectedIndex(3);
				break;
			}
			case 28800000: {
				ComboBox.setSelectedIndex(4);
				break;
			}
			}
		} else {
			checkAutoBackup.setSelected(false);
			ComboBox.setSelectedIndex(0);
		}
	}

	// Variables declaration - do not modify
	private javax.swing.JComboBox<String> ComboBox;
	private javax.swing.JButton btnCancelar;
	private javax.swing.JButton btnDump;
	private javax.swing.JButton btnRestore;
	private javax.swing.JButton btnSalvar;
	private javax.swing.JCheckBox checkAutoBackup;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLayeredPane jLayeredPane1;
	private javax.swing.JTextField txtRestore;
	private javax.swing.JTextField txtBanco;
	private javax.swing.JTextField txtIp;
	private javax.swing.JTextField txtPgDump;
	private javax.swing.JTextField txtPorta;
	private javax.swing.JTextField txtSenha;
	private javax.swing.JTextField txtUser;
	// End of variables declaration
}
