package force.pedidos.pedidosforce.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import force.pedidos.pedidosforce.database.DatabaseHelper;
import force.pedidos.pedidosforce.dominio.Cliente;

public class ConexaoCliente {

    DatabaseHelper databaseHelper;
    public ConexaoCliente(){

    }

    public ConexaoCliente(Context context){
        databaseHelper =  new DatabaseHelper(context);
    }

    public void cadastrarCliente(String nomeCliente, String cgcCpf, String tipoCliente, String endereco,
                                 String cidade, String UF, String CEP){
        if(getCliente(cgcCpf) == null) {

            ContentValues contentValues = new ContentValues();

            /*MONTA OS PARAMENTROS PARA REALIZAR UPDATE NOS CAMPOS*/
            contentValues.put("nomeCliente", nomeCliente);
            contentValues.put("cgcCpf", cgcCpf);
            contentValues.put("tipoCliente", tipoCliente);
            contentValues.put("endereco", endereco);
            contentValues.put("cidade", cidade);
            contentValues.put("UF", UF);
            contentValues.put("CEP", CEP);

            /*REALIZANDO INSERT NA TABELA*/
            databaseHelper.GetConexaoDataBase().insert("cadastro_cliente", null, contentValues);
        }
    }

    public Integer excluirCliente(String cgcCpf){
        //EXCLUINDO  REGISTRO E RETORNANDO O NÚMERO DE LINHAS AFETADAS
        return databaseHelper.GetConexaoDataBase().delete("cadastro_cliente","cgcCpf = ?", new String[]{cgcCpf});
    }

    public Cliente getCliente(String cgcCpf){


        Cursor cursor =  databaseHelper.GetConexaoDataBase().rawQuery("SELECT * FROM cadastro_cliente WHERE cgcCpf= '"+ cgcCpf+"'",null);

        if(cursor.getCount() == 0){
            return null;
        }else{
            cursor.moveToFirst();

            //RETORNANDO CLIENTE
            Cliente cl = new Cliente();

            cl.setNomeCliente(cursor.getString(cursor.getColumnIndex("nomeCliente")));
            cl.setCgcCpf(cursor.getString(cursor.getColumnIndex("cgcCpf")));
            cl.setTipoCliente(cursor.getString(cursor.getColumnIndex("tipoCliente")));
            cl.setEndereco(cursor.getString(cursor.getColumnIndex("endereco")));
            cl.setCidade(cursor.getString(cursor.getColumnIndex("cidade")));
            cl.setUF(cursor.getString(cursor.getColumnIndex("UF")));
            cl.setCEP(cursor.getString(cursor.getColumnIndex("CEP")));
            return cl;
        }
    }

    public ArrayList<Cliente> getClienteArray () {

        ArrayList<Cliente> clientes = new ArrayList<>();

        Cursor cursor = databaseHelper.GetConexaoDataBase().rawQuery("SELECT * FROM cadastro_cliente ", null);

        if (cursor != null && cursor.moveToFirst()) {
            do  {
                    //RETORNANDO CLIENTE
                    Cliente cl = new Cliente();

                    cl.setNomeCliente(cursor.getString(cursor.getColumnIndex("nomeCliente")));
                    cl.setCgcCpf(cursor.getString(cursor.getColumnIndex("cgcCpf")));
                    cl.setTipoCliente(cursor.getString(cursor.getColumnIndex("tipoCliente")));
                    cl.setEndereco(cursor.getString(cursor.getColumnIndex("endereco")));
                    cl.setCidade(cursor.getString(cursor.getColumnIndex("cidade")));
                    cl.setUF(cursor.getString(cursor.getColumnIndex("UF")));
                    cl.setCEP(cursor.getString(cursor.getColumnIndex("CEP")));
                    clientes.add(cl);
                    //cursor.moveToNext();

            } while(cursor.moveToNext());

        }
        return clientes;
    }

    public void alterarCliente(String nomeCliente, String cgcCpf, String tipoCliente, String endereco,
                               String cidade, String UF, String CEP){
        if(getCliente(cgcCpf) != null) {
            ContentValues contentValues = new ContentValues();

            /*MONTA OS PARAMENTROS PARA REALIZAR UPDATE NOS CAMPOS*/
            contentValues.put("nomeCliente", nomeCliente);
            contentValues.put("cgcCpf", cgcCpf);
            contentValues.put("tipoCliente", tipoCliente);
            contentValues.put("endereco", endereco);
            contentValues.put("cidade", cidade);
            contentValues.put("UF", UF);
            contentValues.put("CEP", CEP);

            databaseHelper.GetConexaoDataBase().update("cadastro_cliente", contentValues, "cgcCpf= ?", new String[]{cgcCpf} );
            //databaseHelper.GetConexaoDataBase().update("cadastro_cliente", contentValues, "cgcCpf= '"+ cgcCpf+"'", null);
            //new String[]{cgcCpf}
        }
    }
}
