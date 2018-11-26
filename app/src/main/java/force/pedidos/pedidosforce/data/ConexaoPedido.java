package force.pedidos.pedidosforce.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import force.pedidos.pedidosforce.database.DatabaseHelper;
import force.pedidos.pedidosforce.dominio.Pedido;

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
        return Pedidos;
    }

    public void alterarPedido(Pedido pd){
        //Não implementado
    }
}
