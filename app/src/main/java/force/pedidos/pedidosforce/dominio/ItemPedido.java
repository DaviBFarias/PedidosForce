package force.pedidos.pedidosforce.dominio;

public class ItemPedido extends Pedido {

    int codProduto;
    int qtdProduto;
    String obsItem;

    public ItemPedido(){};

    public ItemPedido(int codProduto, int qtdProduto, String obsItem){
        this.setCodProduto(codProduto);
        this.setQtdProduto(qtdProduto);
        this.setObsItem(obsItem);
    };


    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public String getObsItem() {
        return obsItem;
    }

    public void setObsItem(String obsItem) {
        this.obsItem = obsItem;
    }
}
