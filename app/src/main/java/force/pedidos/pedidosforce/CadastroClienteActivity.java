package force.pedidos.pedidosforce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import force.pedidos.pedidosforce.dominio.Cliente;

import force.pedidos.pedidosforce.data.ConexaoCliente;


public class CadastroClienteActivity extends AppCompatActivity {


    private EditText cpfCliente;
    private EditText nomeCliente;
    private EditText enderecoCliente;
    private EditText cidadeCliente;
    private EditText cepCliente;
    private Spinner ufCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);



       cpfCliente = (EditText) findViewById(R.id.CgcCpf);
       nomeCliente = (EditText) findViewById(R.id.nomeCliente);
       enderecoCliente = (EditText) findViewById(R.id.enderecoCliente);
       cidadeCliente = (EditText) findViewById(R.id.cidadeCliente);
       cepCliente = (EditText) findViewById(R.id.cepCliente);
       ufCliente = (Spinner)  findViewById(R.id.spinnerUF);


        final ConexaoCliente repository = new ConexaoCliente( CadastroClienteActivity.this);

        // EXCLUIR CLIENTES DA BASE DE DADOS
        CardView botaoDeletar =(CardView) findViewById(R.id.delete);
        botaoDeletar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                 if(repository.excluirCliente(cpfCliente.getText().toString()) >= 1){
                     Toast.makeText(v.getContext(), "Cliente Excluido!", Toast.LENGTH_SHORT).show();
                 } else {
                     Toast.makeText(v.getContext(), "Cliente Não Excluído!", Toast.LENGTH_SHORT).show();
                   }
                 limpaTelaCliente();
            }

        });
        // EDITANDO O CLIENTE  NA BASE DE DADOS
       CardView botaoEditar =(CardView) findViewById(R.id.edite);
        botaoEditar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if ( repository.getCliente(cpfCliente.getText().toString()) != null) {
                    Cliente cli = repository.getCliente(cpfCliente.getText().toString());
                    repository.alterarCliente(nomeCliente.getText().toString(), cpfCliente.getText().toString(),"",enderecoCliente.getText().toString(),cidadeCliente.getText().toString(), ufCliente.getSelectedItem().toString(),cepCliente.getText().toString());
                    Toast.makeText(v.getContext(), "Cliente Alterado!", Toast.LENGTH_SHORT).show();
                    limpaTelaCliente();
                } else {
                    Toast.makeText(v.getContext(), "Cliente não encontrado!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        // INSERINDO CLIENTE NA BASE DE DADOS
        CardView botaoGravar =(CardView) findViewById(R.id.grava);
        botaoGravar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                repository.cadastrarCliente(nomeCliente.getText().toString(), cpfCliente.getText().toString(),"",enderecoCliente.getText().toString(),cidadeCliente.getText().toString(), ufCliente.getSelectedItem().toString(),cepCliente.getText().toString());
                Toast.makeText(v.getContext(), "Cliente Inserido!", Toast.LENGTH_SHORT).show();
                limpaTelaCliente();
            }
        });

        // CONSULTANDO CLIENTE NA BASE DE DADOS
        CardView botaoConsultar =(CardView) findViewById(R.id.pesquisa);
        botaoConsultar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ( repository.getCliente(cpfCliente.getText().toString()) != null){
                    Cliente cli =  repository.getCliente(cpfCliente.getText().toString());
                    atualizaTelaCliente(cli);
                    Toast.makeText(v.getContext(),"Cliente Encontrado:" + cli.getNomeCliente(), Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(v.getContext(), "Cliente não encontrado!", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }

    public void atualizaTelaCliente(Cliente cli){
        cpfCliente.setText(String.valueOf(cli.getCgcCpf()));
        nomeCliente.setText(String.valueOf(cli.getNomeCliente()));
        enderecoCliente.setText(String.valueOf(cli.getEndereco()));
        cidadeCliente.setText(String.valueOf(cli.getCidade()));
        cepCliente.setText(String.valueOf(cli.getCEP()));

        List<String> listUF  = Arrays.asList(getResources().getStringArray(R.array.base_uf));
        int index  = listUF.indexOf(cli.getUF());
        ufCliente.setSelection(index);
    }

    public void limpaTelaCliente(){
        cpfCliente.setText(String.valueOf(""));
        nomeCliente.setText(String.valueOf(""));
        enderecoCliente.setText(String.valueOf(""));
        cidadeCliente.setText(String.valueOf(""));
        cepCliente.setText(String.valueOf(""));
        ufCliente.setSelection(0);
    }

}
