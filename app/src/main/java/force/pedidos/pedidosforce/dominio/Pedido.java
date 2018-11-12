package force.pedidos.pedidosforce.dominio;

import java.util.ArrayList;

public class Pedido {


     private Cliente cliente;
     private int codigoPagamento;
     private ArrayList<Produto> arrayProduto = new ArrayList<Produto>();

     public ArrayList<Produto> getArrayProduto() {
          return arrayProduto;
     }

     public void setArrayProduto(ArrayList<Produto> arrayProduto) {
          this.arrayProduto = arrayProduto;
     }



}
