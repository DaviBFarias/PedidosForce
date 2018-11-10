package force.pedidos.pedidosforce.dominio;

import java.util.ArrayList;

public class Produto {

    private int codigoProduto;
    private String nomeProduto;
    private ArrayList<Produto> arrayProduto = new ArrayList<Produto>();


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

    public ArrayList<Produto> getArrayProduto() {
        return arrayProduto;
    }

    public void setArrayProduto(ArrayList<Produto> arrayProduto) {
        this.arrayProduto = arrayProduto;
    }



}
