package force.pedidos.pedidosforce.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import force.pedidos.pedidosforce.database.DatabaseHelper;
import force.pedidos.pedidosforce.dominio.Cliente;

public class ConexaoCliente {
    DatabaseHelper databaseHelper;

    public ConexaoCliente(Context context){
        databaseHelper =  new DatabaseHelper(context);
    }
    public void cadastrarCliente(String razaoSocial, String nomeFantasia, String cgcCpf, String tipoCliente){
        if(getCliente(cgcCpf) == null) {
            ContentValues contentValues = new ContentValues();

            /*MONTA OS PARAMENTROS PARA REALIZAR UPDATE NOS CAMPOS*/
            contentValues.put("razaoSocial", razaoSocial);
            contentValues.put("nomeFantasia", nomeFantasia);
            contentValues.put("cgcCpf", cgcCpf);
            contentValues.put("tipoCliente", tipoCliente);

            /*REALIZANDO INSE NA TABELA*/
            databaseHelper.GetConexaoDataBase().insert("cadastro_cliente", null, contentValues);
        }
    }
    public Integer excluirCliente(String cgcCpf){
        //EXCLUINDO  REGISTRO E RETORNANDO O NÚMERO DE LINHAS AFETADAS
        return databaseHelper.GetConexaoDataBase().delete("cadastro_cliente","cgcCpf = '?'", new String[]{cgcCpf});
    }
    public Cliente getCliente(String cgcCpf){


        Cursor cursor =  databaseHelper.GetConexaoDataBase().rawQuery("SELECT * FROM cadastro_cliente WHERE cgcCpf= '"+ cgcCpf+"'",null);

        if(cursor.getCount() == 0){
            return null;
        }else{
            cursor.moveToFirst();

            //RETORNANDO CLIENTE
            Cliente cl = new Cliente();
            cl.setRazaoSocial(cursor.getString(cursor.getColumnIndex("razaoSocial")));
            cl.setNomeFantasia(cursor.getString(cursor.getColumnIndex("nomeFantasia")));
            cl.setCgcCpf(cursor.getString(cursor.getColumnIndex("cgcCpf")));
            cl.setTipoCliente(cursor.getString(cursor.getColumnIndex("tipoCliente")));
            return cl;
        }
    }
}
