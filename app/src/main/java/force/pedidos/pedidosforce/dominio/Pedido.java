package force.pedidos.pedidosforce.dominio;

import java.util.ArrayList;

public class Pedido {

    private int codigoPagamento;
    private String cliente;
    private String tabelaPreco;
    private String pagamento, obs;
    private ArrayList<ItemPedido> itens;

    public Pedido(){};

    public Pedido(int codigoPagamento, String cliente, String tabelaPreco, String pagamento, String obs, ArrayList<ItemPedido> itens){
        this.codigoPagamento = codigoPagamento;
        this.cliente = cliente;
        this.tabelaPreco = tabelaPreco;
        this.pagamento = pagamento;
        this.obs = obs;
        this.itens = itens;
    }

    public int getCodigoPagamento() {
        return codigoPagamento;
    }

    public void setCodigoPagamento(int codigoPagamento) {
        this.codigoPagamento = codigoPagamento;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTabelaPreco() {
        return tabelaPreco;
    }

    public void setTabelaPreco(String tabelaPreco) {
        this.tabelaPreco = tabelaPreco;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemPedido> itens) {
        this.itens = itens;
    }
}
