/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Daos.produtoDAO;
import Daos.vendaDAO;
import Daos.vendaProdutoDAO;
import Models.ProdutoModel;

/**
 *
 * @author vitor
 */
public class FrameVendas extends javax.swing.JInternalFrame {

	/**
	 * Creates new form frameProdutos
	 */

	/**
	 * Creates new form FrameVendas
	 */
	private Connection conn;
	private produtoDAO produtoDao;
	private vendaDAO vendaDao;
	private vendaProdutoDAO vendaProdutoDao;
	private DefaultTableModel model;
	private ProdutoModel produto, produtoChange;
	private ArrayList<ProdutoModel> listChange;
	private boolean isInserting = true;
	private SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

	public FrameVendas(Connection conn) {
		this.conn = conn;
		produtoDao = new produtoDAO(conn);
		vendaDao = new vendaDAO(conn);
		vendaProdutoDao = new vendaProdutoDAO(conn);
		initComponents();
		try {
			fixTable();
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
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		txtData = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		JScrollPane = new javax.swing.JScrollPane();
		JTable = new javax.swing.JTable();
		txtBarcode = new javax.swing.JTextField();
		btnBuscar = new javax.swing.JButton();
		btnDeletar = new javax.swing.JButton();
		btnSalvar1 = new javax.swing.JButton();
		txtValor = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		btnCancelar = new javax.swing.JButton();
		btnCancelar1 = new javax.swing.JButton();
		jLabel4 = new javax.swing.JLabel();
		ComboPagamento = new javax.swing.JComboBox<>();

		jLabel1.setText("Data:");
		setClosable(true);
		setIconifiable(true);
		setTitle("Vendas");

		txtData.setEditable(false);
		txtData.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtData.setBackground(Color.LIGHT_GRAY);
		txtData.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtDataActionPerformed(evt);
			}
		});
		txtData.setText(fmt.format(new Date(System.currentTimeMillis())));
		txtData.setFocusable(false);

		jLabel2.setText("Produto:");

		JTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null } },
				new String[] { "Codigo", "Nome", "Valor", "Duantidade" }));
		JScrollPane.setViewportView(JTable);

		txtBarcode.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					txtBarcodeActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		txtBarcode.setRequestFocusEnabled(true);

		btnBuscar.setText("Buscar");
		btnBuscar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnBuscarActionPerformed(evt);
			}
		});

		btnDeletar
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lixeira-de-reciclagem preta.png"))); // NOI18N
		btnDeletar.setToolTipText("Deletar");
		btnDeletar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDeletarActionPerformed(evt);
			}
		});

		btnSalvar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/disquetex32.png"))); // NOI18N
		btnSalvar1.setToolTipText("Adicionar");
		btnSalvar1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSalvar1ActionPerformed(evt);
			}
		});

		txtValor.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		txtValor.setForeground(new java.awt.Color(255, 153, 0));
		txtValor.setEditable(false);
		txtValor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtValor.setToolTipText("Valor Total");
		txtValor.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});
		txtValor.setFocusable(false);

		jLabel3.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
		jLabel3.setForeground(new java.awt.Color(255, 153, 0));
		jLabel3.setText("Valor Total:");

		btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar.png"))); // NOI18N
		btnCancelar.setToolTipText("Cancelar");
		btnCancelar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCancelarActionPerformed(evt);
			}
		});

		btnCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/sal�riox32.png"))); // NOI18N
		btnCancelar1.setToolTipText("Finalizar Venda");
		btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCancelar1ActionPerformed(evt);
			}
		});

		jLabel4.setText("Metodo de Pagamento:");

		ComboPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "Selecione", "Dinheiro", "Cartao", "Cheque", "Outro" }));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel2).addComponent(jLabel1))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addComponent(txtBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 141,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18).addComponent(btnBuscar).addGap(18, 18, 18)
												.addComponent(jLabel4)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(ComboPagamento, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup()
								.addComponent(btnSalvar1, javax.swing.GroupLayout.PREFERRED_SIZE, 55,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 55,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 55,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184,
										Short.MAX_VALUE)
								.addComponent(jLabel3)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 93,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(btnCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 84,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
						.addGroup(layout.createSequentialGroup().addComponent(JScrollPane).addGap(10, 10, 10)))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1)
						.addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2)
						.addComponent(btnBuscar).addComponent(txtBarcode).addComponent(jLabel4)
						.addComponent(ComboPagamento, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18)
				.addComponent(JScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 258,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(btnSalvar1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
						.addComponent(btnDeletar, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCancelar1, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(jLabel3,
										javax.swing.GroupLayout.PREFERRED_SIZE, 41,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(txtValor, javax.swing.GroupLayout.Alignment.TRAILING))
				.addContainerGap().addGap(15, 15, 15)));
		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void fixTable() throws SQLException {
		this.model = (DefaultTableModel) JTable.getModel();
		model.setRowCount(0);
	}

	private void InsertRow(ProdutoModel produto2) {
		model.addRow(new String[] { produto2.getBarCode().toString(), produto2.getNome().toString(),
				Double.toString(produto2.getPreco()), "1" });
	}

	private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtDataActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtDataActionPerformed

	private void txtBarcodeActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {// GEN-FIRST:event_txtBarcodeActionPerformed
		try {
			InsertRow(produtoDao.getOneProdutoBar(txtBarcode.getText().toString()));
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Produto n�o cadastrado!", "falha!", JOptionPane.ERROR_MESSAGE,
					new javax.swing.ImageIcon(getClass().getResource("/Imagens/sinal-de-avisox32.png")));
		}
		double valor = 0;
		for(int i =0;i< model.getRowCount(); i++) {
			valor += Double.parseDouble(model.getValueAt(i,2).toString());
		}
		txtValor.setText(new Double(valor).toString());
		txtBarcode.setText(null);

	}// GEN-LAST:event_txtBarcodeActionPerformed

	private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeletarActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnDeletarActionPerformed

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField1ActionPerformed

	private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelarActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnCancelarActionPerformed

	private void btnSalvar1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSalvar1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnSalvar1ActionPerformed

	private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelar1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnCancelar1ActionPerformed

	private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBuscarActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnBuscarActionPerformed

	public void setPosicao() {
		Dimension d = this.getDesktopPane().getSize();
		this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JComboBox<String> ComboPagamento;
	private javax.swing.JScrollPane JScrollPane;
	private javax.swing.JTable JTable;
	private javax.swing.JButton btnBuscar;
	private javax.swing.JButton btnCancelar;
	private javax.swing.JButton btnCancelar1;
	private javax.swing.JButton btnDeletar;
	private javax.swing.JButton btnSalvar1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JTextField txtValor;
	private javax.swing.JTextField txtBarcode;
	private javax.swing.JTextField txtData;
	// End of variables declaration//GEN-END:variables
}