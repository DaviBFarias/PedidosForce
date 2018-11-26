package force.pedidos.pedidosforce.dominio;


public class Produto {

    private int codigoProduto;
    private String nomeProduto;

    public Produto(){};

    public Produto(int codigoProduto, String nomeProduto) {
        this.setCodigoProduto(codigoProduto);
        this.setNomeProduto(nomeProduto);
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
}
