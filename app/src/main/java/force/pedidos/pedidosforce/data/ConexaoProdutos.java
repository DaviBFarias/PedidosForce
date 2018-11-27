package force.pedidos.pedidosforce.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import force.pedidos.pedidosforce.database.DatabaseHelper;
import force.pedidos.pedidosforce.dominio.Cliente;
import force.pedidos.pedidosforce.dominio.Produto;

public class ConexaoProdutos {
    DatabaseHelper databaseHelper;

    public ConexaoProdutos(Context context){
        databaseHelper =  new DatabaseHelper(context);
    }

    public void cadastrarProduto(Produto pr){
        //Não implementado
    }

    public Integer excluirProduto(int CodProduto){
        //Não implementado
        return 0;
    }

    public Produto getProduto(int codProduto){

        Cursor cursor =  databaseHelper.GetConexaoDataBase().rawQuery("SELECT * FROM produtos WHERE codProduto= '"+ codProduto+"'",null);

        if(cursor.getCount() == 0){
            return null;
        }else {
            cursor.moveToFirst();

            //Retornando produto
            Produto pr = new Produto();

            pr.setCodigoProduto(cursor.getInt(cursor.getColumnIndex("codProduto")));
            pr.setNomeProduto(cursor.getString(cursor.getColumnIndex("nomeProduto")));
            pr.setSaldoProduto(cursor.getInt(cursor.getColumnIndex("saldoProduto")));
            return pr;
        }
    }

    public ArrayList<Produto> getProdutoArray () {
        ArrayList<Produto> Produtos = new ArrayList<>();
        Cursor cursor = databaseHelper.GetConexaoDataBase().rawQuery("SELECT * FROM produtos ", null);

        if (cursor != null && cursor.moveToFirst()) {
            do  {
                //Retornando Produtos
                Produto pr = new Produto();

                pr.setCodigoProduto(cursor.getInt(cursor.getColumnIndex("codProduto")));
                pr.setNomeProduto(cursor.getString(cursor.getColumnIndex("nomeProduto")));
                pr.setSaldoProduto(cursor.getInt(cursor.getColumnIndex("saldoProduto")));
                Produtos.add(pr);

            } while(cursor.moveToNext());

        }
        return Produtos;
    }

    public ArrayList<Produto> getProdutoArray (String nome) {
        ArrayList<Produto> Produtos = new ArrayList<>();
        Cursor cursor = databaseHelper.GetConexaoDataBase().rawQuery("SELECT * FROM produtos WHERE nomeProduto like '%"+nome+"%'", null);

        if (cursor != null && cursor.moveToFirst()) {
            do  {
                //Retornando Produtos
                Produto pr = new Produto();

                pr.setCodigoProduto(cursor.getInt(cursor.getColumnIndex("codProduto")));
                pr.setNomeProduto(cursor.getString(cursor.getColumnIndex("nomeProduto")));
                pr.setSaldoProduto(cursor.getInt(cursor.getColumnIndex("saldoProduto")));
                Produtos.add(pr);

            } while(cursor.moveToNext());

        }
        return Produtos;
    }

    public void alterarProduto(Produto pr){
        //Não implementado
    }

    public int getEstoqueProduto(int codProduto){
        Cursor cursor = databaseHelper.GetConexaoDataBase().rawQuery("SELECT saldoProduto FROM produtos where codProduto = "+ codProduto, null);
        cursor.moveToFirst();
        return cursor.getInt(cursor.getColumnIndex("saldoProduto"));
    }

    public void atualizarEstoqueProduto(int codProduto, int estoqueAtual){
        ContentValues contentValues = new ContentValues();

        /*MONTA OS PARAMENTROS PARA REALIZAR UPDATE NOS CAMPOS*/
        contentValues.put("saldoProduto", estoqueAtual);

        databaseHelper.GetConexaoDataBase().update("produtos", contentValues, "codProduto= "+ codProduto, null);
    }
}
