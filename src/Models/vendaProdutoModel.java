package Models;

public class vendaProdutoModel {
	private Integer id, idProduto, idVenda;
	

	public vendaProdutoModel() {
		setId(0);
		setIdProduto(0);
		setIdVenda(0);
	}


	public Integer getId() {
		return id;
	}


	public vendaProdutoModel setId(Integer id) {
		this.id = id;
		return this;
	}


	public Integer getIdProduto() {
		return idProduto;
	}


	public vendaProdutoModel setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
		return this;
	}


	public Integer getIdVenda() {
		return idVenda;
	}


	public vendaProdutoModel setIdVenda(Integer idVenda) {
		this.idVenda = idVenda;
		return this;
	}
	
	
	
}
