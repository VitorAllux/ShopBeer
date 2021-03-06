/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;

import Daos.produtoDAO;
import Daos.vendaDAO;
import Daos.vendaProdutoDAO;
import Models.ProdutoModel;
import Models.VendaModel;
import Models.vendaProdutoModel;

/**
 *
 * @author vitor
 */
public class frameRelVendas extends javax.swing.JInternalFrame {

	/**
	 * Creates new form frameRelVendas
	 */

	private Connection conn;
	private produtoDAO produtoDao;
	private vendaDAO vendaDao;
	private vendaProdutoDAO vendaProdutoDao;
	private DefaultTableModel model;
	private DefaultTableModel model2;
	private ArrayList<VendaModel> listChange;
	private JDateChooser dtInicial;
	private JDateChooser dtFinal;
	private SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

	public frameRelVendas(Connection conn) {
		this.conn = conn;
		produtoDao = new produtoDAO(conn);
		vendaDao = new vendaDAO(conn);
		vendaProdutoDao = new vendaProdutoDAO(conn);
		dtInicial = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		dtInicial.setDate(new Date());
		dtFinal = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		dtFinal.setDate(new Date());
		initComponents();
		txtBarCode2.requestFocus();
		try {
			fixTable();
			new VendaModel();
			new ProdutoModel();
			listChange = new ArrayList<VendaModel>();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public frameRelVendas() {
		initComponents();
		txtBarCode2.requestFocus();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jScrollPane = new javax.swing.JScrollPane();
		jTable = new javax.swing.JTable();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();
		btnBuscar = new javax.swing.JButton();
		btnDeletar = new javax.swing.JButton();
		btnImprimir = new javax.swing.JButton();
		btnCancelar = new javax.swing.JButton();
		label2 = new javax.swing.JLabel();
		label1 = new javax.swing.JLabel();
		jInternalFrame1 = new javax.swing.JInternalFrame();
		txtSecondDate = new javax.swing.JTextField();
		txtFirstDate = new javax.swing.JTextField();
		label3 = new javax.swing.JLabel();
		txtBarCode2 = new javax.swing.JTextField();
		txtBarCode2.setRequestFocusEnabled(true);

		jTable.setModel(new DefaultTableModel(new String[] { "id", "Data", "Metodo de Pagamento", "Valor", }, 0) {

			boolean[] canEdit = new boolean[] { false, false, false, false };

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return canEdit[column];
			}

		});

		jScrollPane.setViewportView(jTable);

		jTable2.setModel(new DefaultTableModel(new String[] { "Produto", "Quantidade", }, 0) {

			boolean[] canEdit = new boolean[] { false, false };

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return canEdit[column];
			}
		});
		jScrollPane2.setViewportView(jTable2);

		btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/procurar.png"))); // NOI18N
		btnBuscar.setToolTipText("Procurar");
		btnBuscar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btnBuscarActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnDeletar
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lixeira-de-reciclagem_preta.png"))); // NOI18N
		btnDeletar.setToolTipText("Deletar");
		btnDeletar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btnDeletarActionPerformed(evt);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/impressora.png"))); // NOI18N
		btnImprimir.setToolTipText("Imprimir");
		btnImprimir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btnImprimirActionPerformed(evt);
				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/proibido.png"))); // NOI18N
		btnCancelar.setToolTipText("Cancelar");
		btnCancelar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCancelarActionPerformed(evt);
			}
		});

		label2.setText("Data Final:");

		label1.setText("Data Inicial:");

		jTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					try {

						model2.setRowCount(0);
						int idVenda = Integer.parseInt(model.getValueAt(jTable.getSelectedRow(), 0).toString());
						ArrayList<ProdutoModel> list = vendaProdutoDao.getAllProdutos(idVenda);
						for (ProdutoModel produtoModel : list) {

							vendaProdutoModel vp = vendaProdutoDao.getOneVendaProduto(idVenda, produtoModel.getId());
							System.out.println(produtoModel.getNome() + "------" + idVenda);
							model2.addRow(new String[] { produtoModel.getNome(), vp.getQuantidade().toString() });

						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}

		});

		setClosable(true);
		setIconifiable(true);
		setTitle("Relat�rio de Vendas");

		javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
		jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
		jInternalFrame1Layout.setHorizontalGroup(jInternalFrame1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jInternalFrame1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										jInternalFrame1Layout
												.createSequentialGroup().addPreferredGap(
														javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addGap(12, 12, 12))
								.addGroup(jInternalFrame1Layout.createSequentialGroup().addGroup(jInternalFrame1Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jInternalFrame1Layout.createSequentialGroup()
												.addGroup(jInternalFrame1Layout.createParallelGroup(
														javax.swing.GroupLayout.Alignment.TRAILING))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(jInternalFrame1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(jInternalFrame1Layout.createSequentialGroup()
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(jInternalFrame1Layout.createSequentialGroup()
																		.addGap(26, 26, 26).addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))))
												.addGroup(jInternalFrame1Layout.createSequentialGroup()
														.addGap(18, 18, 18).addGap(18, 18, 18).addGap(18, 18, 18))))
										.addGap(0, 0, Short.MAX_VALUE)))
						.addContainerGap()));
		jInternalFrame1Layout.setVerticalGroup(jInternalFrame1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jInternalFrame1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
								false))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE))
						.addGap(18, 18, 18)
						.addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE))
						.addGap(18, 18, 18)
						.addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE))
						.addGap(18, 18, 18)
						.addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE))
						.addGap(18, 18, 18).addContainerGap()));

		txtSecondDate.setToolTipText("");
		txtSecondDate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtSecondDateActionPerformed(evt);
			}
		});

		txtFirstDate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtFirstDateActionPerformed(evt);
			}
		});

		label3.setText("Produto:");

		txtBarCode2.setToolTipText("Codigo de Barras");
		txtBarCode2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtBarCode2ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
								.addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup()

								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 55,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												.addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 55,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												.addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 55,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18).addComponent(btnDeletar,
														javax.swing.GroupLayout.PREFERRED_SIZE, 55,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(label1).addComponent(label3))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(txtBarCode2,
																javax.swing.GroupLayout.PREFERRED_SIZE, 153,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(layout.createSequentialGroup()
																.addComponent(dtInicial,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 153,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18, 18).addComponent(label2)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(dtFinal,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 153,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))))
								.addGap(0, 0, Short.MAX_VALUE)))
				.addContainerGap()).addGroup(
						layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
										.addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap()
								.addGroup(layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(layout.createSequentialGroup()
												.addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(1, 1, 1)))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(dtInicial, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(label2).addComponent(dtFinal,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(label3)
										.addComponent(txtBarCode2, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21,
										Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

										.addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 320,
												Short.MAX_VALUE)
										.addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 320,
												Short.MAX_VALUE))
								.addContainerGap())

				.addGroup(
						layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
										.addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))));

		pack();
	}// </editor-fold>

	private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) throws SQLException, ParseException {
		// TODO add your handling code here:]
		if (!comparaData(dtInicial.getDate(), dtFinal.getDate())) {
			JOptionPane.showMessageDialog(null, "Data inicial maior que data final", "falha!",
					JOptionPane.ERROR_MESSAGE,
					new javax.swing.ImageIcon(getClass().getResource("/Imagens/sinal-de-avisox32.png")));
		} else if (txtBarCode2.getText().isEmpty()) {
			listChange = null;
			listChange = vendaDao.getAllVendasDates(fmt.format(dtInicial.getDate()), fmt.format(dtFinal.getDate()));
			System.out.println(listChange.size());
			model.setRowCount(0);
			for (VendaModel vendaModel : listChange) {
				InsertRow(vendaModel);
			}

		} else {
			try {
				System.out.println(1);
				int idProduto = produtoDao.getOneProdutoBar(txtBarCode2.getText().toString()).getId();
				System.out.println(2);
				listChange = null;
				listChange = vendaProdutoDao.getAllVendas(idProduto);
				System.out.println(3);
				System.out.println(listChange.size());
				model.setRowCount(0);
				for (VendaModel vendaModel : listChange) {
					boolean flag = false;
					if (model.getColumnCount() > 0) {
						for (int i = 0; i < model.getRowCount(); i++) {
							if (vendaModel.getId().toString().equals(model.getValueAt(i, 0))) {
								flag = true;
							}
						}
					}
					if (!flag) {
						InsertRow(vendaModel);
					}
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Nenhum produto encontrado!", "falha!", JOptionPane.ERROR_MESSAGE,
						new javax.swing.ImageIcon(getClass().getResource("/Imagens/sinal-de-avisox32.png")));
			}
			txtBarCode2.setText(null);
		}

	}

	private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) throws NumberFormatException, SQLException {
		// TODO add your handling code here:
		// chooser
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setDialogTitle("Selecione o destino");

		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
			System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
			String text = (String) JOptionPane.showInputDialog(null, "Informe o nome do documento:", "documento",
					JOptionPane.DEFAULT_OPTION,
					new javax.swing.ImageIcon(getClass().getResource("/Imagens/disquetex64.png")), null, "");

			Rectangle layout = new Rectangle(PageSize.A4);
			layout.setBackgroundColor(new BaseColor(240, 217, 200));
			Document document = new Document(layout);
			String pathArchive = chooser.getSelectedFile() + ("\\" + text + ".pdf");
			try {
				PdfWriter.getInstance(document,
						new FileOutputStream(chooser.getSelectedFile() + ("\\" + text + ".pdf")));

				document.open();
				document.add(new Paragraph("\n"));
				Paragraph p = new Paragraph("Relat�rio de vendas " + new Date(),
						FontFactory.getFont(FontFactory.TIMES_BOLD));
				p.setAlignment(Element.ALIGN_CENTER);
				document.add(p);
				document.add(new Paragraph("\n"));
				p = new Paragraph("Data Inicial: " + fmt.format(dtInicial.getDate()) + " ---- Data Final: "
						+ fmt.format(dtFinal.getDate()));
				p.setAlignment(Element.ALIGN_CENTER);
				document.add(p);
				document.add(new Paragraph("\n"));
				PdfPTable table = new PdfPTable(4);
				table.setWidthPercentage(100);
				table.addCell("Id da Venda");
				table.addCell("Data da Venda");
				table.addCell("Metodo de Pagamento");
				table.addCell("valor da Venda");
				table.addCell(" ");
				table.addCell(" ");
				table.addCell(" ");
				table.addCell(" ");
				double valorTotal = 0;
				for (int i = 0; i < model.getRowCount(); i++) {
					table.addCell(model.getValueAt(i, 0).toString());
					table.addCell(model.getValueAt(i, 1).toString());
					table.addCell(model.getValueAt(i, 2).toString());
					table.addCell(model.getValueAt(i, 3).toString());
					valorTotal += Double.parseDouble(model.getValueAt(i, 3).toString());
				}
				table.addCell(" ");
				table.addCell(" ");
				table.addCell(" ");
				table.addCell(" ");
				table.addCell(" ");
				table.addCell(" ");
				table.addCell("Valor Total:");
				table.addCell(" " + valorTotal + " ");
				document.add(table);
				document.add(new Paragraph("\n\n"));

				PdfPTable table2 = new PdfPTable(3);
				table2.setWidthPercentage(50);
				table2.addCell("Id da venda");
				table2.addCell("Produtos");
				table2.addCell("Quantidade");
				table2.addCell(" ");
				table2.addCell(" ");
				table2.addCell(" ");
				ArrayList<ProdutoModel> list = new ArrayList<ProdutoModel>();
				for (int i = 0; i < model.getRowCount(); i++) {
					int idVenda = Integer.parseInt(model.getValueAt(i, 0).toString());
					list = vendaProdutoDao.getAllProdutos(idVenda);
					table2.addCell(model.getValueAt(i, 0).toString());
					table2.addCell(" ");
					table2.addCell(" ");
					for (ProdutoModel produtoModel : list) {
						table2.addCell(" ");
						table2.addCell(produtoModel.getNome());
						vendaProdutoModel vp = vendaProdutoDao.getOneVendaProduto(idVenda, produtoModel.getId());
						System.out.println(vp.getQuantidade());

						table2.addCell(vp.getQuantidade().toString());
					}
				}

				document.add(table2);

			} catch (FileNotFoundException | DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				document.close();
			}
			try {
				Desktop.getDesktop().open(new File(pathArchive));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("No Selection ");
		}
	}

	private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		try {
			fixTable();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dtFinal.setDate(new Date());
		dtInicial.setDate(new Date());
	}

	private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) throws NumberFormatException, SQLException {
		// TODO add your handling code here:
		if (jTable.getSelectedRow() < 0) {
			JOptionPane.showMessageDialog(null, "Nenhum produto Selecionado!", "falha!", JOptionPane.ERROR_MESSAGE,
					new javax.swing.ImageIcon(getClass().getResource("/Imagens/sinal-de-avisox32.png")));
		} else {

			int n = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja realizar esta a��o?", "Comfirma��o!",
					JOptionPane.YES_NO_OPTION, 0,
					new javax.swing.ImageIcon(getClass().getResource("/Imagens/sinal-de-avisox32.png")));
			if (n == 0) {
				int idVenda = Integer.parseInt(model.getValueAt(jTable.getSelectedRow(), 0).toString());
				System.out.println("id venda::" + idVenda);
				ArrayList<ProdutoModel> produtos = vendaProdutoDao.getAllProdutos(idVenda);
				System.out.println(produtos.size());
				// vendaProdutoDao.deleteVendaProduto(idVenda, idProduto);
				for (ProdutoModel produtoModel : produtos) {
					vendaProdutoDao.deleteVendaProduto(idVenda, produtoModel.getId());
				}
				System.out.println(idVenda);
				vendaDao.deleteVenda(idVenda);
				model.removeRow(jTable.getSelectedRow());
				JOptionPane.showMessageDialog(null, "Venda deletada com sucesso!!", "Sucesso!",
						JOptionPane.INFORMATION_MESSAGE,
						new javax.swing.ImageIcon(getClass().getResource("/Imagens/verificado.png")));
			}
		}
	}



	private void txtSecondDateActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void txtFirstDateActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void txtBarCode2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void fixTable() throws SQLException {
		this.model = (DefaultTableModel) jTable.getModel();
		this.model2 = (DefaultTableModel) jTable2.getModel();
		model2.setRowCount(0);
		model.setRowCount(0);
		ArrayList<VendaModel> list = new ArrayList<VendaModel>();
		list = vendaDao.getAllVendas();
		listChange = list;
		for (VendaModel venda : list) {
			InsertRow(venda);
		}
		txtBarCode2.requestFocus();
	}

	private void InsertRow(VendaModel venda) {
		model.addRow(new String[] { venda.getId().toString(), venda.getdata().toString(),
				venda.getPagamento().toString(), Double.toString(venda.getValor()) });

	}

	public void setPosicao() {
		Dimension d = this.getDesktopPane().getSize();
		this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
	}

	public boolean comparaData(Date dti, Date dtf) {
		if (dti.after(dtf)) {
			System.out.println("retorno false");
			return false;
		} else {
			System.out.println("retorno true");
			return true;
		}
	}

	// Variables declaration - do not modify
	private javax.swing.JButton btnBuscar;
	private javax.swing.JButton btnDeletar;
	private javax.swing.JButton btnCancelar;
	private javax.swing.JButton btnImprimir;
	private javax.swing.JInternalFrame jInternalFrame1;
	private javax.swing.JScrollPane jScrollPane;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTable jTable;
	private javax.swing.JTable jTable2;
	private javax.swing.JLabel label1;
	private javax.swing.JLabel label2;
	private javax.swing.JLabel label3;
	private javax.swing.JTextField txtBarCode2;
	private javax.swing.JTextField txtFirstDate;
	private javax.swing.JTextField txtSecondDate;
	// End of variables declaration
}
