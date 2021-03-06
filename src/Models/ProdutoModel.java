/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author vitor
 */
public class ProdutoModel {
    private int id;
    private String nome;
    private String categoria;
    private Double preco;
    private Double precoCusto;
	private int quantidade;
    private String barCode;
    private Date valDate;
    
    public ProdutoModel() {
    	id = 0;
    	nome = "";
    	categoria = "";
    	precoCusto = (double) 0;
    	preco = (double) 0;
    	quantidade = 0;
    	barCode = "";
    	valDate = new Date(0);
    }
    
    public ProdutoModel(ProdutoModel produto) {
    	this.id = produto.getId();
    	this.nome = produto.getNome();
    	this.categoria = produto.getCategoria();
    	this.preco = produto.getPreco();
    	this.precoCusto = produto.getPrecoCusto();
    	this.quantidade = produto.getQuantidade();
    	this.barCode = produto.getBarCode();
    }
    
    public String getCategoria() {
		return categoria;
	}

	public ProdutoModel setCategoria(String categoria) {
		this.categoria = categoria;
		return this;

	}


    public int getId() {
        return id;
    }

    public ProdutoModel setId(int id) {
        this.id = id;
		return this;

    }

    public String getNome() {
        return nome;
    }

    public ProdutoModel setNome(String nome) {
        this.nome = nome;
		return this;

    }

    public Double getPreco() {
        return preco;
    }

    public ProdutoModel setPreco(Double preco) {
        this.preco = preco;
		return this;

    }
    
    public Double getPrecoCusto() {
        return precoCusto;
    }

    public ProdutoModel setPrecoCusto(Double precoCusto) {
        this.precoCusto = precoCusto;
		return this;

    }

    public int getQuantidade() {
        return quantidade;
    }

    public ProdutoModel setQuantidade(int quantidade) {
        this.quantidade = quantidade;
		return this;

    }

    public String getBarCode() {
        return barCode;
    }

    public ProdutoModel setBarCode(String barCode) {
        this.barCode = barCode;
		return this;

    }

    public String getValDate() {
    	return new SimpleDateFormat("dd/MM/yyyy").format(valDate);
        
    }

    public ProdutoModel setValDate(Date valDate) {
        this.valDate = valDate;
		return this;
    }

}
