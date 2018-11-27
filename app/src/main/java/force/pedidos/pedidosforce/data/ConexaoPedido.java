package force.pedidos.pedidosforce.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import force.pedidos.pedidosforce.database.DatabaseHelper;
import force.pedidos.pedidosforce.dominio.ItemPedido;
import force.pedidos.pedidosforce.dominio.Pedido;
import force.pedidos.pedidosforce.dominio.Produto;

public class ConexaoPedido {

    DatabaseHelper databaseHelper;

    public ConexaoPedido(){

    }

    public ConexaoPedido(Context context){
        databaseHelper =  new DatabaseHelper(context);
    }

    public void cadastrarPedido(Pedido pd){
        //Não implementado
    }

    public Integer excluirPedido(int CodPedido){
        //Não implementado
        return 0;
    }

    public Pedido getPedido(int codPedido){
        Pedido pd = new Pedido();
        return pd;
    }

    public ArrayList<Pedido> getPedidosArray () {
        ArrayList<Pedido> Pedidos = new ArrayList<>();
        Cursor cursor = databaseHelper.GetConexaoDataBase().rawQuery("SELECT * FROM pedidos ", null);

        if (cursor != null && cursor.moveToFirst()) {
            do  {
                //Retornando Produtos
                Pedido pd = new Pedido();

                int idPedido = cursor.getInt(cursor.getColumnIndex("idPedido"));
                pd.setIdPedido(idPedido);
                pd.setCliente(cursor.getString(cursor.getColumnIndex("cgcCpf")));
                pd.setTabelaPreco(cursor.getString(cursor.getColumnIndex("tabelaPreco")));
                pd.setPagamento(cursor.getString(cursor.getColumnIndex("formaPagamento")));
                pd.setObs(cursor.getString(cursor.getColumnIndex("observacao")));
                pd.setItens(this.getItensPedido(idPedido));
                Pedidos.add(pd);

            } while(cursor.moveToNext());

        }
        return Pedidos;
    }

    public void alterarPedido(Pedido pd){
        //Não implementado
    }

    public ArrayList<ItemPedido> getItensPedido(int idPedido){
        ArrayList<ItemPedido> itens = new ArrayList<>();
        Cursor cursor = databaseHelper.GetConexaoDataBase().rawQuery("SELECT * FROM itens_pedido where idPedido = "+idPedido, null);

        if (cursor != null && cursor.moveToFirst()) {
            do  {
                //Retornando Produtos
                ItemPedido ip = new ItemPedido();

                ip.setCodProduto(cursor.getInt(cursor.getColumnIndex("codProduto")));
                ip.setQtdProduto(cursor.getInt(cursor.getColumnIndex("qtdProduto")));
                ip.setObsItem(cursor.getString(cursor.getColumnIndex("observacao")));
                itens.add(ip);

            } while(cursor.moveToNext());

        }
        return itens;
    }
}
