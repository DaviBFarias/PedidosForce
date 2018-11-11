package force.pedidos.pedidosforce.data;

import android.content.ContentValues;
import android.content.Context;
import force.pedidos.pedidosforce.database.DatabaseHelper;
import android.database.Cursor;

public class ClasseConexaoTeste {
    DatabaseHelper databaseHelper;

    public ClasseConexaoTeste(Context context){

        databaseHelper =  new DatabaseHelper(context);

    }
    public void Inserir(){
        ContentValues contentValues =  new ContentValues();

        /*MONTA OS PARAMENTROS PARA REALIZAR UPDATE NOS CAMPOS*/
        contentValues.put("ds_nome", "Davi");
        contentValues.put("ds_endereco", "casa 1");
        contentValues.put("fl_sexo", "Masculino");
        contentValues.put("dt_nascimento", "15-06-1992");
        contentValues.put("fl_estadoCivil", "Casado");
        contentValues.put("fl_ativo", "Ativo");

        /*REALIZANDO INSE NA TABELA*/
        databaseHelper.GetConexaoDataBase().insert("tb_pessoa",null,contentValues);
    }
    public Integer Excluir(int codigo){
        //EXCLUINDO  REGISTRO E RETORNANDO O NÚMERO DE LINHAS AFETADAS
        return databaseHelper.GetConexaoDataBase().delete("tb_pessoa","id_pessoa = ?", new String[]{Integer.toString(codigo)});
    }
    public String GetPessoa(int codigo){


        Cursor cursor =  databaseHelper.GetConexaoDataBase().rawQuery("SELECT ds_nome FROM tb_pessoa WHERE id_pessoa= "+ codigo,null);

        if(cursor.getCount() == 0){
            return "Registro não encontrado!";
        }else{
            cursor.moveToFirst();

            //RETORNANDO A PESSOA
            return cursor.getString(cursor.getColumnIndex("ds_nome"));
        }


    }
}
