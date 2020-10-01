package Daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.VendaModel;

public class vendaDAO extends BaseDAO {

	public vendaDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<VendaModel> getAllVendas() throws SQLException {
		ResultSet result = null;
		result = this.select("*").from("vendas")
				// .orderBy(" pontos desc, id ")
				.apply();
		ArrayList<VendaModel> vendaList = new ArrayList<VendaModel>();
		while (result.next()) {
			if (result.getInt("id") > 0) {
				vendaList.add(new VendaModel().setId(result.getInt("id")).setdata(result.getDate("data"))
						.setValor(result.getDouble("valor")).setPagamento(result.getString("pagamento")));
			}
		}
		return vendaList;
	}

	public VendaModel getOneVenda(Integer id) throws SQLException {
		ResultSet result = null;
		result = this.select("*").from("vendas").where("id", "=", id.toString()).apply();

		if (result.next()) {
			VendaModel venda = new VendaModel().setId(result.getInt("id")).setdata(result.getDate("data"))
					.setValor(result.getDouble("valor")).setPagamento(result.getString("pagamento"));
			return venda;
		} else {
			return null;
		}
	}

	/*public ProdutoModel getOneProdutoBar(String barCode) throws SQLException {
		ResultSet result = null;
		result = this.select("*").from("produto").where("barcode", "=", "'" + barCode + "%'").apply();

		if (result.next()) {
			ProdutoModel produto = new ProdutoModel().setId(result.getInt("id")).setNome(result.getString("nome"))
					.setCategoria(result.getString("categoria")).setPreco(result.getDouble("preco"))
					.setQuantidade(result.getInt("quantidade")).setBarCode(result.getString("barCode"))
					.setValDate(result.getDate("valDate"));
			return produto;
		} else {
			return null;
		}
	}

	public ArrayList<ProdutoModel> getAllProductsDesc(String desc) throws SQLException {
		ResultSet result = null;
		result = this.select("*").from("produto").where("nome", "LIKE", "'" + desc + "%'").apply();
		ArrayList<ProdutoModel> produtoList = new ArrayList<ProdutoModel>();
		while (result.next()) {
			if (result.getInt("id") > 0) {
				produtoList.add(new ProdutoModel().setId(result.getInt("id")).setNome(result.getString("nome"))
						.setCategoria(result.getString("categoria")).setPreco(result.getDouble("preco"))
						.setQuantidade(result.getInt("quantidade")).setBarCode(result.getString("barCode"))
						.setValDate(result.getDate("valDate")));
			}
		}
		return produtoList;
	}
*/
	public void createVenda(VendaModel venda) throws SQLException {
		this.insertInto("vendas", "data, valor, pagamento")
				.values(quoteStr(venda.getdata()) + ", " + venda.getValor().toString() + ", " + quoteStr(venda.getPagamento()))
				.commit();
	}

	public void updateVenda(VendaModel venda) throws SQLException {
		this.update("vendas")
				.setValue(" data = " + quoteStr(venda.getdata()) + ", valor = " + venda.getValor().toString() + ", pagamento = " + quoteStr(venda.getPagamento()))
				.where("id", "=", Integer.toString((venda.getId()))).commit();
	}

	public void deleteProduto(int id) throws SQLException {
		this.delete().from("venda").where("id", "=", "id").commit();
	}

}
