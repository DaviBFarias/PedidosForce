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
        stringBuilderCreateTable.append("CREATE TABLE cadastro_cliente (\n" +
                "    cgcCpf      TEXT NOT NULL\n" +
                "                     PRIMARY KEY,\n" +
                "    nomeCliente TEXT NOT NULL,\n" +
                "    tipoCliente TEXT NOT NULL,\n" +
                "    endereco    TEXT NOT NULL,\n" +
                "    cidade      TEXT NOT NULL,\n" +
                "    UF          TEXT NOT NULL,\n" +
                "    CEP         TEXT NOT NULL\n" +
                ");");
        db.execSQL(stringBuilderCreateTable.toString());

        stringBuilderCreateTable = new StringBuilder();
        stringBuilderCreateTable.append("CREATE TABLE pedidos (\n" +
                "    id             INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    cgcCpf         TEXT    NOT NULL,\n" +
                "    tabelaPreco    TEXT    NOT NULL,\n" +
                "    formaPagamento TEXT    NOT NULL,\n" +
                "    observacao     TEXT    NOT NULL,\n" +
                "    idItens        INTEGER NOT NULL\n" +
                ");");
        db.execSQL(stringBuilderCreateTable.toString());

        stringBuilderCreateTable = new StringBuilder();
        stringBuilderCreateTable.append("CREATE TABLE produtos (\n" +
                "    codProduto  INTEGER NOT NULL\n" +
                "                        PRIMARY KEY,\n" +
                "    nomeProduto TEXT    NOT NULL\n" +
                ");");
        db.execSQL(stringBuilderCreateTable.toString());

        stringBuilderCreateTable = new StringBuilder();
        stringBuilderCreateTable.append("CREATE TABLE itens_pedido (\n" +
                "    idItem     INTEGER PRIMARY KEY AUTOINCREMENT\n" +
                "                       NOT NULL,\n" +
                "    idPedido   INTEGER NOT NULL,\n" +
                "    codProduto INTEGER NOT NULL,\n" +
                "    qtdProduto INTEGER NOT NULL,\n" +
                "    observacao TEXT\n" +
                ");");
        db.execSQL(stringBuilderCreateTable.toString());

        stringBuilderCreateTable = new StringBuilder();
        stringBuilderCreateTable.append("INSERT INTO cadastro_cliente (CEP,UF,cidade,endereco,tipoCliente,nomeCliente,cgcCpf) " +
                "VALUES (52369852,'PE','Recife','Rua Samoel Mendes','PF','Roberval Meridiano',12345678925);");
        db.execSQL(stringBuilderCreateTable.toString());
        stringBuilderCreateTable = new StringBuilder();
        stringBuilderCreateTable.append("INSERT INTO cadastro_cliente (CEP,UF,cidade,endereco,tipoCliente,nomeCliente,cgcCpf) " +
                "VALUES (12369852,'PE','Olinda','Rua Feira Nova','PF','Juliana Alberta',65485678925);");
        db.execSQL(stringBuilderCreateTable.toString());
        stringBuilderCreateTable = new StringBuilder();
        stringBuilderCreateTable.append("INSERT INTO cadastro_cliente (CEP,UF,cidade,endereco,tipoCliente,nomeCliente,cgcCpf) " +
                "VALUES (28969835,'PE','Recife','Av Sebastiao','PF','Tamires Farias',56987678925);");
        db.execSQL(stringBuilderCreateTable.toString());
        stringBuilderCreateTable = new StringBuilder();
        stringBuilderCreateTable.append("INSERT INTO produtos (nomeProduto,codProduto) VALUES ('Linha CD2345 Azul',1);");
        db.execSQL(stringBuilderCreateTable.toString());
        stringBuilderCreateTable = new StringBuilder();
        stringBuilderCreateTable.append("INSERT INTO produtos (nomeProduto,codProduto) VALUES ('Linha CD2345 Amarela',2);");
        db.execSQL(stringBuilderCreateTable.toString());
        stringBuilderCreateTable = new StringBuilder();
        stringBuilderCreateTable.append("INSERT INTO produtos (nomeProduto,codProduto) VALUES ('Linha CD012 Verde',3);");
        db.execSQL(stringBuilderCreateTable.toString());


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