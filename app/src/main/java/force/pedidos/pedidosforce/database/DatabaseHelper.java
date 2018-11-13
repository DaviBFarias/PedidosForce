package force.pedidos.pedidosforce.database;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "bancoPedidosForce";
    Context context;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder stringBuilderCreateTable = new StringBuilder();

        stringBuilderCreateTable.append(" CREATE TABLE tb_pessoa (");
        stringBuilderCreateTable.append("        id_pessoa      INTEGER PRIMARY KEY AUTOINCREMENT, ");
        stringBuilderCreateTable.append("        ds_nome        TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_endereco    TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        fl_sexo        TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        dt_nascimento  TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        fl_estadoCivil TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        fl_ativo       INT     NOT NULL )           ");


        db.execSQL(stringBuilderCreateTable.toString());


        StringBuilder stringBuilderCreateTable2 = new StringBuilder();

        stringBuilderCreateTable2.append(" CREATE TABLE cadastro_cliente (");
        stringBuilderCreateTable2.append("        cgcCpf      TEXT    NOT NULL PRIMARY KEY,            ");
        stringBuilderCreateTable2.append("        nomeCliente      TEXT,            ");
        stringBuilderCreateTable2.append("        tipoCliente      TEXT    NOT NULL,            ");
        stringBuilderCreateTable2.append("        endereco      TEXT    NOT NULL,            ");
        stringBuilderCreateTable2.append("        cidade      TEXT    NOT NULL,            ");
        stringBuilderCreateTable2.append("        UF      TEXT    NOT NULL,            ");
        stringBuilderCreateTable2.append("        CEP      TEXT     NOT NULL )           ");


        db.execSQL(stringBuilderCreateTable2.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versaoAntiga, int versaoNova) {
        //db.execSQL("CREATE TABLE PESSOA ( ID NUMBER, NOME TEXT, VALOR TEXT);");
        try {
            createTables( db );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createTables(SQLiteDatabase db) throws IOException {
        AssetManager manager = context.getAssets();

        InputStream inputStream = null;
        BufferedReader reader = null;

        try {
            inputStream = manager.open("DatabaseConstants.FOLDER_DATABASE_ASSETS" +
                    File.separator + "DatabaseConstants.FILE_SCRIPT_DATABASE");

            reader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder stringBuilder = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }

            String[] sqls = stringBuilder.toString().split(";");

            for (String sql : sqls) {
                db.execSQL(sql);
            }

        } catch (IOException e) {
            throw e;
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                throw e;
            }
        }
    }
    public SQLiteDatabase GetConexaoDataBase(){
        return this.getWritableDatabase();
    }
}