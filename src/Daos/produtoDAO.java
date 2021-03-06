package Daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.ProdutoModel;

public class produtoDAO extends BaseDAO {

	public produtoDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<ProdutoModel> getAllProducts() throws SQLException {
		ResultSet result = null;
		result = this.select("*").from("produto")
				// .orderBy(" pontos desc, id ")
				.apply();
		ArrayList<ProdutoModel> produtoList = new ArrayList<ProdutoModel>();
		while (result.next()) {
			if (result.getInt("id") > 0) {
				produtoList.add(new ProdutoModel().setId(result.getInt("id")).setNome(result.getString("nome"))
						.setCategoria(result.getString("categoria")).setPreco(result.getDouble("preco")).setPrecoCusto(result.getDouble("precoCusto"))
						.setQuantidade(result.getInt("quantidade")).setBarCode(result.getString("barcode")).setValDate(result.getDate("valDate")));
			}
		}
		return produtoList;
	}
	
	public ProdutoModel getOneProduto(Integer id) throws SQLException {
		ResultSet result = null;
		result = this.select("*")
				.from("produto")
				.where("id", "=", id.toString())
				.apply();

		if(result.next()) {
			ProdutoModel produto = new ProdutoModel().setId(result.getInt("id")).setNome(result.getString("nome"))
					.setCategoria(result.getString("categoria")).setPreco(result.getDouble("preco")).setPrecoCusto(result.getDouble("precoCusto"))
					.setQuantidade(result.getInt("quantidade")).setBarCode(result.getString("barcode")).setValDate(result.getDate("valDate"));
			return produto;
		}else {
			return null;
		}
	}
	
	public ProdutoModel getOneProdutoBar(String barcode) throws SQLException {
		ResultSet result = null;
		result = this.select("*")
				.from("produto")
				.where("barcode", "like", "'"+barcode+"%'")
				.apply();

		if(result.next()) {
			ProdutoModel produto = new ProdutoModel().setId(result.getInt("id")).setNome(result.getString("nome"))
					.setCategoria(result.getString("categoria")).setPreco(result.getDouble("preco")).setPrecoCusto(result.getDouble("precoCusto"))
					.setQuantidade(result.getInt("quantidade")).setBarCode(result.getString("barcode")).setValDate(result.getDate("valDate"));
			return produto;
		}else {
			return null;
		}
	}
	
	
	public ArrayList<ProdutoModel> getAllProductsDesc(String desc) throws SQLException {
		ResultSet result = null;
		result = this.select("*")
				.from("produto")
				.where("Lower(nome)", "LIKE", "lower('"+desc+"%')")
				.apply();
		ArrayList<ProdutoModel> produtoList = new ArrayList<ProdutoModel>();
		while (result.next()) {
			if (result.getInt("id") > 0) {
				produtoList.add(new ProdutoModel().setId(result.getInt("id")).setNome(result.getString("nome"))
						.setCategoria(result.getString("categoria")).setPreco(result.getDouble("preco")).setPrecoCusto(result.getDouble("precoCusto"))
						.setQuantidade(result.getInt("quantidade")).setBarCode(result.getString("barcode")).setValDate(result.getDate("valDate")));
			}
		}
		return produtoList;
	}
	
	
	public void createProduto(ProdutoModel produto) throws SQLException {
		this.insertInto("produto",
				"nome, categoria, preco, precoCusto, quantidade, barcode, valdate")
		.values(quoteStr(produto.getNome()) +
				", "+quoteStr(produto.getCategoria()) +
				", " + produto.getPreco().toString() +
				", " + produto.getPrecoCusto().toString() +
				", " + Integer.toString(produto.getQuantidade()) +
				", " +quoteStr(produto.getBarCode()) +
				", " + quoteStr(produto.getValDate())) 
		.commit();
	}

	public void updateProduto(ProdutoModel produto) throws SQLException {
		this.update("produto")
		.setValue(
				" nome = " + quoteStr(produto.getNome())+
				", categoria = " + quoteStr(produto.getCategoria())+ 
				", preco = " + produto.getPreco().toString() +
				", precoCusto = " + produto.getPrecoCusto().toString() +
				", quantidade = " + Integer.toString(produto.getQuantidade()) +
				", barcode = " + quoteStr(produto.getBarCode()) +
				", valdate = " + quoteStr(produto.getValDate())
				)
		.where("id", "=", Integer.toString((produto.getId())))
		.commit();
	}
	
	public void deleteProduto(String barcode) throws SQLException {
		this.delete()
		.from("produto")
		.where("barcode", "LIKE", "'"+barcode+"%'")
		.commit();
	}


}
