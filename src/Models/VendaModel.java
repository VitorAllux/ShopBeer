package Models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VendaModel {
    private Integer id;
    private Date data;
    private Double valor;
    private String pagamento;

    
    public VendaModel() {
    	id = 0;
    	valor = (double) 0;
    	pagamento = "";
    	data = new Date(0);
    }
    
    public VendaModel(VendaModel venda) {
    	this.id = venda.getId();
    	this.valor = venda.getValor();
    	this.pagamento = venda.getPagamento();
    }
    
    public VendaModel setPagamento(String pagamento) {
    	this.pagamento = pagamento;
    	return this;
    }
    
    public String getPagamento() {
    	return pagamento;
    }

    public Integer getId() {
        return id;
    }

    public VendaModel setId(int id) {
        this.id = id;
		return this;

    }

    public Double getValor() {
        return valor;
    }

    public VendaModel setValor(Double valor) {
        this.valor = valor;
		return this;

    }

    public String getdata() {
    	return new SimpleDateFormat("dd/MM/yyyy").format(data);
        
    }

    public VendaModel setdata(Date data) {
        this.data = data;
		return this;
    }

}
