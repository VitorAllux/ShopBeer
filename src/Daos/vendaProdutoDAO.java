package Daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Models.ProdutoModel;
import Models.VendaModel;
import Models.vendaProdutoModel;

public class vendaProdutoDAO extends BaseDAO{
	
	public vendaProdutoDAO(Connection conn) {
		super(conn);
	}

	public ArrayList<vendaProdutoModel> getAllVendaProduto(Integer idVenda) throws SQLException {
		ResultSet result = null;
		result = this.select("*")
				.from("venda_produto")
				.where("id_vendas", "=", idVenda.toString())
				.orderBy("id_produto")
				.apply();
		ArrayList<vendaProdutoModel> vendaProdutoList = new ArrayList<vendaProdutoModel>();
		while(result.next()) {
			vendaProdutoList.add(new vendaProdutoModel()
							.setIdVenda(result.getInt("id_vendas"))
							.setIdProduto(result.getInt("id_produto"))
							);
		}
		return vendaProdutoList;
	}
	
	public ArrayList<ProdutoModel> getAllProdutos(Integer idVenda) throws SQLException {
		ResultSet result = null;
		result = this.select("id_produto")
				.from("venda_produto")
				.where("id_vendas", "=", idVenda.toString())
				.apply();
		ArrayList<ProdutoModel> produtoList = new ArrayList<ProdutoModel>();
		produtoDAO produtoDao = new produtoDAO(conn);
		Integer id = null;
		while(result.next()) {
			ProdutoModel produto = produtoDao.getOneProduto(result.getInt("id_produto"));
			produtoList.add(new ProdutoModel()
							.setId(produto.getId())
							.setNome(produto.getNome())
							);
		}
		return produtoList;
	}
	
	public ArrayList<VendaModel> getAllVendas(Integer idProduto) throws SQLException, ParseException {
		ResultSet result = null;
		result = this.select("id_vendas")
				.from("venda_produto")
				.where("id_produto", "=", idProduto.toString())
				.apply();
		ArrayList<VendaModel> vendaList = new ArrayList<VendaModel>();
		vendaDAO vendaDao = new vendaDAO(conn);
		Integer id = null;
		while(result.next()) {
			VendaModel venda = vendaDao.getOneVenda(result.getInt("id_vendas"));
			vendaList.add(new VendaModel()
							.setId(venda.getId())
							.setdata(venda.getdata2())
							.setValor(venda.getValor())
							.setPagamento(venda.getPagamento())
							);
		}
		return vendaList;
	}


	public vendaProdutoModel getOneVendaProduto(Integer idVenda, Integer idProduto) throws SQLException {
		ResultSet result = null;
		result = this.select("*")
				.from("venda_produto")
				.filter("id_vendas", "=", idVenda.toString(), true)
				.filter("id_produto", "=", idProduto.toString(), true)				
				.where()
				.apply();
		
		if(result.next()) {
			vendaProdutoModel vendaProduto = new vendaProdutoModel();
			return vendaProduto.setIdVenda(result.getInt("id_vendas"))
					.setIdProduto(result.getInt("id_produto"))
					.setQuantidade(result.getInt("quantidade"));
		}else {
			return null;
		}
	}

	public void createVendaProduto(ArrayList<ProdutoModel> vendaProduto, Integer venda) throws SQLException {
		deleteVendaProduto(venda, 0);

		for(ProdutoModel produtoVenda : vendaProduto) {
			this.insertInto("venda_produto", "id_vendas, id_produto, quantidade")
			.values(venda.toString() +", "+Integer.toString(produtoVenda.getId()) +", "+Integer.toString(produtoVenda.getQuantidade()))
			.setSql(getSql() + ";");			
		}
		commit();
	}

	public void deleteVendaProduto(Integer idVenda, Integer idProduto) throws SQLException {
		this.delete()
		.from("venda_produto")
		.filter("id_vendas", "=", idVenda.toString(), true)
		.filter("id_produto", "=", idProduto.toString(), false)				
		.where()
		.commit();
	}
}
