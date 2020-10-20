/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Desktop;
import java.awt.Dimension;
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
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

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
import Daos.vendaProdutoDAO;
import Models.ProdutoModel;

/**
 *
 * @author vitor
 */
public class frameProdutos extends javax.swing.JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Creates new form frameProdutos
	 */
	private Connection conn;
	private produtoDAO produtoDao;
	private vendaProdutoDAO vendaProdutoDao;
	private DefaultTableModel model;
	private ProdutoModel produtoChange;
	private ArrayList<ProdutoModel> listChange;
	private boolean isInserting = true;
	private JDateChooser valDate;
	private SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

	public frameProdutos(Connection conn) {
		this.conn = conn;
		produtoDao = new produtoDAO(conn);
		vendaProdutoDao = new vendaProdutoDAO(conn);
		valDate = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		valDate.setDate(new Date());
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
		txtNome = new javax.swing.JTextField();
		ComboboxProdutos = new javax.swing.JComboBox<>();
		btnSalvar = new javax.swing.JButton();
		btnBuscar = new javax.swing.JButton();
		btnDeletar = new javax.swing.JButton();
		btnCancelar = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		btnImprimir = new javax.swing.JButton();
		txtBarCode = new javax.swing.JTextField();
		txtValidade = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		txtValor = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		txtQuantidade = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPrecoCusto = new javax.swing.JTextField();
		try {
			MaskFormatter mask = new MaskFormatter("##/##/####");
			mask.setPlaceholderCharacter('_');
			txtValidade = new JFormattedTextField(mask);
		} catch (Exception e) {
			// TODO: handle exception
		}
		jScrollPane2 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();

		setClosable(true);
		setIconifiable(true);
		setTitle("Cadastro de Produtos");

		jLabel1.setText("Nome do produto");

		txtNome.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtNomeActionPerformed(evt);
			}
		});

		ComboboxProdutos.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "Selecione", "Bebida", "Alimento", "Item", "Outros" }));

		btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/disquetex32.png"))); // NOI18N
		btnSalvar.setToolTipText("Salvar");
		btnSalvar.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btnSalvarActionPerformed(evt);
					fixTable();
				} catch (ParseException e) {
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
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btnImprimirActionPerformed(evt);
				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/procurar.png"))); // NOI18N
		btnBuscar.setToolTipText("Procurar");
		btnBuscar.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnBuscarActionPerformed(evt);
			}
		});

		btnDeletar
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lixeira-de-reciclagem_preta.png"))); // NOI18N
		btnDeletar.setToolTipText("Deletar");
		btnDeletar.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btnDeletarActionPerformed(evt);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar.png"))); // NOI18N
		btnCancelar.setToolTipText("Cancelar");
		btnCancelar.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btnCancelarActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		jLabel2.setText("Codigo de Barras");

		txtBarCode.setToolTipText("");
		txtBarCode.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtBarCodeActionPerformed(evt);
			}
		});

		txtValidade.setToolTipText("");
		txtValidade.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtBarCodeActionPerformed(evt);
			}
		});

		jLabel3.setText("Valor");

		txtValor.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtValorActionPerformed(evt);
			}
		});

		jLabel4.setText("Quantidade");

		txtQuantidade.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtQuantidadeActionPerformed(evt);
			}
		});

		jLabel5.setText("Data de Validade");
		
        jLabel6.setText("Valor de Custo");

        txtPrecoCusto.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoCustoActionPerformed(evt);
            }
        });
        

		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null,null }, { null, null, null, null, null,null },
						{ null, null, null, null, null,null }, { null, null, null, null, null ,null} },
				new String[] { "Codigo", "Nome", "Valor", "ValorCusto", "Quantidade", "Data de Validade" }));
		jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                    .addComponent(valDate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(35, 35, 35)
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtBarCode, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(65, 65, 65)
                                            .addComponent(jLabel6)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtPrecoCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(ComboboxProdutos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(50, 50, 50)))
                        
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeletar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboboxProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBarCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecoCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(valDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        pack();
	}// </editor-fold>//GEN-END:initComponents

	private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtNomeActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtNomeActionPerformed

	private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) throws ParseException {// GEN-FIRST:event_btnSalvarActionPerformed
		// TODO add your handling code here:

		try {
			isInserting = verificaUpdate();
			if (isInserting) {
				boolean flag = true;
				if (txtNome.getText().isEmpty() || txtBarCode.getText().isEmpty() || txtQuantidade.getText().isEmpty()
						|| txtValor.getText().isEmpty() || txtPrecoCusto.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "campos!",
							JOptionPane.ERROR_MESSAGE,
							new javax.swing.ImageIcon(getClass().getResource("/Imagens/sinal-de-avisox32.png")));
				} else if (ComboboxProdutos.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "Selecione uma categoria", "categoria!",
							JOptionPane.ERROR_MESSAGE,
							new javax.swing.ImageIcon(getClass().getResource("/Imagens/sinal-de-avisox32.png")));
					/*
					 * } else if (!checkDate(txtValidade.getText())) {
					 * JOptionPane.showMessageDialog(null, "Data Inv�lida", "data!",
					 * JOptionPane.ERROR_MESSAGE, new
					 * javax.swing.ImageIcon(getClass().getResource("/Imagens/sinal-de-avisox32.png"
					 * )));
					 */
				} else {
					try {
						System.out.println(produtoDao.getOneProdutoBar(txtBarCode.getText().toString()).getNome());
					} catch (Exception e) {
						// TODO: handle exception
						flag = false;

					}
					if (flag == false) {
						getFields();
						produtoDao.createProduto(produtoChange);
						btnCancelar.doClick();
						JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!!", "Sucesso!",
								JOptionPane.INFORMATION_MESSAGE,
								new javax.swing.ImageIcon(getClass().getResource("/Imagens/verificado.png")));
					} else {
						JOptionPane.showMessageDialog(null, "Produto ja cadastrado!", "falha!",
								JOptionPane.ERROR_MESSAGE,
								new javax.swing.ImageIcon(getClass().getResource("/Imagens/sinal-de-avisox32.png")));
					}
				}
			} else {
				fazUpdate();
				fixTable();
				JOptionPane.showMessageDialog(null, "Atualiza��es realizadas!", "Sucesso!",
						JOptionPane.INFORMATION_MESSAGE,
						new javax.swing.ImageIcon(getClass().getResource("/Imagens/verificado.png")));
			}
		} catch (SQLException e) {
		}

	}// GEN-LAST:event_btnSalvarActionPerformed

	private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBuscarActionPerformed
		// TODO add your handling code here:
		String text;
		text = (String) JOptionPane.showInputDialog(null, "Informe o nome do produto:", "busca",
				JOptionPane.DEFAULT_OPTION, new javax.swing.ImageIcon(getClass().getResource("/Imagens/zoomx64.png")),
				null, "");
		ArrayList<ProdutoModel> readList;
		try {
			readList = produtoDao.getAllProductsDesc(text);
			if (readList.size() > 0) {
				model.setRowCount(0);
				for (ProdutoModel produtoModel : readList) {

					InsertRow(produtoModel);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Nenhum produto encontrado!", "falha!", JOptionPane.ERROR_MESSAGE,
						new javax.swing.ImageIcon(getClass().getResource("/Imagens/sinal-de-avisox64.png")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// GEN-LAST:event_btnBuscarActionPerformed

	private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) throws ParseException {// GEN-FIRST:event_btnDeletarActionPerformed
		// TODO add your handling code here:
		if (jTable1.getSelectedRow() < 0) {
			JOptionPane.showMessageDialog(null, "Nenhum produto Selecionado!", "falha!", JOptionPane.ERROR_MESSAGE,
					new javax.swing.ImageIcon(getClass().getResource("/Imagens/sinal-de-avisox32.png")));
		} else {
			int row = jTable1.getSelectedRow();
			String cod = model.getValueAt(row, 0).toString();
			try {
				if (vendaProdutoDao.getAllVendas(produtoDao.getOneProdutoBar(cod).getId()).size() > 0) {
					JOptionPane.showMessageDialog(null, "Produto presente em alguma venda!", "falha!",
							JOptionPane.ERROR_MESSAGE,
							new javax.swing.ImageIcon(getClass().getResource("/Imagens/sinal-de-avisox64.png")));
				} else {
					produtoDao.deleteProduto(cod);
					fixTable();
					JOptionPane.showMessageDialog(null, "Produto deletado com sucesso!!", "Sucesso!",
							JOptionPane.INFORMATION_MESSAGE,
							new javax.swing.ImageIcon(getClass().getResource("/Imagens/verificado.png")));
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}// GEN-LAST:event_btnDeletarActionPerformed

	private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {// GEN-FIRST:event_btnCancelarActionPerformed
		// TODO add your handling code here:
		txtBarCode.setText(null);
		txtNome.setText(null);
		txtQuantidade.setText(null);
		txtValidade.setText(null);
		valDate.setDate(new Date());
		txtValor.setText(null);
		txtPrecoCusto.setText(null);
		ComboboxProdutos.setSelectedIndex(0);
		fixTable();

	}// GEN-LAST:event_btnCancelarActionPerformed

	private void txtBarCodeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtBarCodeActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtBarCodeActionPerformed

	private void txtValorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtValorActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtValorActionPerformed

	private void txtQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtQuantidadeActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtQuantidadeActionPerformed
    private void txtPrecoCustoActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
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
				Paragraph p = new Paragraph("Relat�rio de produtos " + fmt.format(new Date()),
						FontFactory.getFont(FontFactory.TIMES_BOLD));
				p.setAlignment(Element.ALIGN_CENTER);
				document.add(p);
				document.add(new Paragraph("\n"));
				
				
				PdfPTable table = new PdfPTable(6);
				table.setWidthPercentage(100);
				table.addCell("Codigo");//0
				table.addCell("Nome");//1
				table.addCell("Pre�o");//2
				table.addCell("Pre�o de Custo");
				table.addCell("Quantidade");//3
				table.addCell("Data Val");//4
				table.addCell(" ");
				table.addCell(" ");
				table.addCell(" ");
				table.addCell(" ");
				table.addCell(" ");
				table.addCell(" ");
				for (int i = 0; i < model.getRowCount(); i++) {
					table.addCell(model.getValueAt(i, 0).toString());
					table.addCell(model.getValueAt(i, 1).toString());
					table.addCell(model.getValueAt(i, 2).toString());
					table.addCell(model.getValueAt(i, 3).toString());
					table.addCell(model.getValueAt(i, 4).toString());
					table.addCell(model.getValueAt(i, 5).toString());
				}
				table.addCell(" ");
				table.addCell(" ");
				table.addCell(" ");
				table.addCell(" ");
				table.addCell(" ");
				table.addCell(" ");
				
				document.add(table);
				

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

	public void setPosicao() {
		Dimension d = this.getDesktopPane().getSize();
		this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
	}

	private void fixTable() throws SQLException {
		this.model = (DefaultTableModel) jTable1.getModel();
		model.setRowCount(0);
		ArrayList<ProdutoModel> list = new ArrayList<ProdutoModel>();
		list = produtoDao.getAllProducts();
		listChange = list;
		for (ProdutoModel produto : list) {
			InsertRow(produto);
		}
	}

	private void InsertRow(ProdutoModel produto) {
		model.addRow(new String[] { produto.getBarCode(), produto.getNome(), Double.toString(produto.getPreco()), Double.toString(produto.getPrecoCusto()),
				Integer.toString(produto.getQuantidade()), produto.getValDate() });

	}

	private void getFields() throws ParseException {
		if (produtoChange == null) {
			produtoChange = new ProdutoModel();
		}
		produtoChange.setNome(txtNome.getText());
		produtoChange.setBarCode(txtBarCode.getText());
		produtoChange.setCategoria(ComboboxProdutos.getSelectedItem().toString());
		produtoChange.setPreco(Double.valueOf(txtValor.getText().replace(",",".")));
		produtoChange.setPrecoCusto(Double.valueOf(txtPrecoCusto.getText().replace(",",".")));
		produtoChange.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
		produtoChange.setValDate(valDate.getDate());

	}

	private boolean verificaUpdate() {
		for (int i = 0; i < model.getRowCount(); i++) {
			if (!listChange.get(i).getNome().equals(model.getValueAt(i, 1).toString())
					|| !(listChange.get(i).getBarCode().equals(model.getValueAt(i, 0).toString()))
					|| !(listChange.get(i).getPreco() == Double.parseDouble(model.getValueAt(i, 2).toString().replace(",",".")))
					|| !(listChange.get(i).getPrecoCusto() == Double.parseDouble(model.getValueAt(i, 3).toString().replace(",",".")))
					|| !(listChange.get(i).getQuantidade() == Integer.parseInt(model.getValueAt(i, 4).toString()))
					|| !(listChange.get(i).getValDate().equals(model.getValueAt(i, 5).toString()))) {
				return false;
			}
		}
		return true;
	}

	private void fazUpdate() throws ParseException, SQLException {
		ProdutoModel produto = new ProdutoModel();
		for (int i = 0; i < model.getRowCount(); i++) {
			if (!listChange.get(i).getNome().equals(model.getValueAt(i, 1).toString())
					|| !(listChange.get(i).getBarCode().equals(model.getValueAt(i, 0).toString()))
					|| !(listChange.get(i).getPreco() == Double.parseDouble(model.getValueAt(i, 2).toString()))
					|| !(listChange.get(i).getPrecoCusto() == Double.parseDouble(model.getValueAt(i, 3).toString()))
					|| !(listChange.get(i).getQuantidade() == Integer.parseInt(model.getValueAt(i, 4).toString()))
					|| !(listChange.get(i).getValDate().equals(fmt.parse(model.getValueAt(i, 5).toString())))) {
				produto.setId(listChange.get(i).getId());
				produto.setNome(model.getValueAt(i, 1).toString());
				produto.setCategoria(listChange.get(i).getCategoria());
				produto.setBarCode(model.getValueAt(i, 0).toString());
				produto.setPreco(Double.parseDouble(model.getValueAt(i, 2).toString().replace(",",".")));
				produto.setPrecoCusto(Double.parseDouble(model.getValueAt(i, 3).toString().replace(",",".")));
				produto.setQuantidade(Integer.parseInt(model.getValueAt(i, 4).toString()));
				produto.setValDate(fmt.parse((String) model.getValueAt(i, 5)));
				produtoDao.updateProduto(produto);
				produto = new ProdutoModel();
			}
		}
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JComboBox<String> ComboboxProdutos;
	private javax.swing.JButton btnBuscar;
	private javax.swing.JButton btnCancelar;
	private javax.swing.JButton btnDeletar;
	private javax.swing.JButton btnSalvar;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JButton btnImprimir;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField txtBarCode;
	private javax.swing.JTextField txtNome;
	private javax.swing.JTextField txtQuantidade;
	private javax.swing.JTextField txtValidade;
    private javax.swing.JTextField txtPrecoCusto;
    private javax.swing.JLabel jLabel6;
	private javax.swing.JTextField txtValor;
	// End of variables declaration//GEN-END:variables
}
