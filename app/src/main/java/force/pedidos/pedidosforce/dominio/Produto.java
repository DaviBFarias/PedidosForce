package force.pedidos.pedidosforce.dominio;


public class Produto {

    private int codigoProduto;
    private String nomeProduto;
    private int saldoProduto;
    private int qtdProduto;

    public Produto(){};

    public Produto(int codigoProduto, String nomeProduto, int saldoProduto, int qtdProduto) {
        this.setCodigoProduto(codigoProduto);
        this.setNomeProduto(nomeProduto);
        this.setSaldoProduto(saldoProduto);
        this.setQtdProduto(qtdProduto);
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getSaldoProduto() {
        return saldoProduto;
    }

    public void setSaldoProduto(int saldoProduto) {
        this.saldoProduto = saldoProduto;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }
}
