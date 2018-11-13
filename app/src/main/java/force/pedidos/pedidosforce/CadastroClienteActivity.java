package force.pedidos.pedidosforce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class CadastroClienteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);

        EditText cpfCliente;
        EditText nomeCliente;
        EditText enderecoCliente;
        EditText cidadeCliente;
        EditText cepCliente;
        Spinner ufCliente;

       cpfCliente = (EditText) findViewById(R.id.CgcCpf);
       nomeCliente = (EditText) findViewById(R.id.nomeCliente);
       enderecoCliente = (EditText) findViewById(R.id.enderecoCliente);
       cidadeCliente = (EditText) findViewById(R.id.cidadeCliente);
       cepCliente = (EditText) findViewById(R.id.cepCliente);
       ufCliente = (Spinner)  findViewById(R.id.spinnerUF);


        CardView c1 =(CardView) findViewById(R.id.delete);
        c1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Toast.makeText(v.getContext(), "Entendeu Andreilson?", Toast.LENGTH_SHORT).show();

            }

        });

      /*  CardView c2 =(CardView) findViewById(R.id.edite);
        c2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {



            }
        });

        CardView c3 =(CardView) findViewById(R.id.grava);
        c3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });


        CardView c4 =(CardView) findViewById(R.id.pesquisa);
        c4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });




*/
    }



}
