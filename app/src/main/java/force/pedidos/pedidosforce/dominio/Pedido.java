package force.pedidos.pedidosforce.dominio;

public class Pedido {

     private int codigoPagamento;
    // private Cliente cliente;
    private String cliente;
     //private TabelaPreco tabelaPreco;
     private String tabelaPreco;
     private String pagamento, obs;

     public Pedido(int codigoPagamento, String cliente, String tabelaPreco, String pagamento, String obs){
          this.codigoPagamento = codigoPagamento;
          this.cliente = cliente;
          this.tabelaPreco = tabelaPreco;
          this.pagamento = pagamento;
          this.obs = obs;

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

    public String cadastraPedido(){



     return cliente + " " + tabelaPreco + " " + pagamento + " " +obs;

     }





}
