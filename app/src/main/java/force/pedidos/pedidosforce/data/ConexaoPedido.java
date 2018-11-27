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
    ConexaoProdutos cp;

    public ConexaoPedido(){

    }

    public ConexaoPedido(Context context){
        databaseHelper =  new DatabaseHelper(context);
        cp = new ConexaoProdutos(context);
    }

    public void cadastrarPedido(Pedido pd){

        //Salvando cabeçalho dos pedidos
        ContentValues contentValues = new ContentValues();

        /*MONTA OS PARAMENTROS PARA REALIZAR INSERT NOS CAMPOS*/
        contentValues.put("cgcCpf", pd.getCliente());
        contentValues.put("tabelaPreco", pd.getTabelaPreco());
        contentValues.put("formaPagamento", pd.getPagamento());
        contentValues.put("observacao", pd.getObs());

        /*REALIZANDO INSERT NA TABELA*/
        databaseHelper.GetConexaoDataBase().insert("pedidos", null, contentValues);

        //Salvando Itens do pedido
        int idPedido = this.getIdUltimoPedidoSalvo();
        ArrayList<ItemPedido> ip = new ArrayList<>();
        ip = pd.getItens();
        for (ItemPedido item : ip) {
            int codProduto = item.getCodProduto();
            //Salvando cabeçalho dos pedidos
            contentValues = new ContentValues();

            /*MONTA OS PARAMENTROS PARA REALIZAR INSERT NOS CAMPOS*/
            contentValues.put("idPedido", idPedido);
            contentValues.put("codProduto", codProduto);
            contentValues.put("qtdProduto", item.getQtdProduto());
            if(item.getObsItem() != null) {
                contentValues.put("observacao", item.getObsItem());
            }

            /*REALIZANDO INSERT NA TABELA*/
            databaseHelper.GetConexaoDataBase().insert("itens_pedido", null, contentValues);

            //Atualizando estoque
            int estoqueAtual = cp.getEstoqueProduto(codProduto) - 1;
            cp.atualizarEstoqueProduto(codProduto, estoqueAtual);
        }
    }

    public Integer excluirPedido(int CodPedido){
        //Não implementado
        return 0;
    }

    public Pedido getPedido(int idPedido){
        Pedido pd = new Pedido();
        Cursor cursor = databaseHelper.GetConexaoDataBase().rawQuery("SELECT * FROM pedidos where id = "+idPedido, null);

        if (cursor != null && cursor.moveToFirst()) {
            do  {
                pd.setIdPedido(cursor.getInt(cursor.getColumnIndex("id")));
                pd.setCliente(cursor.getString(cursor.getColumnIndex("cgcCpf")));
                pd.setTabelaPreco(cursor.getString(cursor.getColumnIndex("tabelaPreco")));
                pd.setPagamento(cursor.getString(cursor.getColumnIndex("formaPagamento")));
                pd.setObs(cursor.getString(cursor.getColumnIndex("observacao")));
                pd.setItens(this.getItensPedido(idPedido));

            } while(cursor.moveToNext());

        }
        return pd;
    }

    public ArrayList<Pedido> getPedidosArray () {
        ArrayList<Pedido> Pedidos = new ArrayList<>();
        Cursor cursor = databaseHelper.GetConexaoDataBase().rawQuery("SELECT * FROM pedidos ", null);

        if (cursor != null && cursor.moveToFirst()) {
            do  {
                //Retornando Produtos
                Pedido pd = new Pedido();

                int idPedido = cursor.getInt(cursor.getColumnIndex("id"));
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

    public int getIdUltimoPedidoSalvo(){
        Cursor cursor = databaseHelper.GetConexaoDataBase().rawQuery("SELECT max(id) as id FROM pedidos", null);
        return cursor.getInt(cursor.getColumnIndex("id"));
    }
}
