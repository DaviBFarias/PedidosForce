package force.pedidos.pedidosforce;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import force.pedidos.pedidosforce.data.ConexaoCliente;
import force.pedidos.pedidosforce.dominio.Cliente;
import force.pedidos.pedidosforce.dominio.Pedido;

public class PedidosActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);
        final Context context = this;
        final ConexaoCliente repository = new ConexaoCliente( PedidosActivity.this);
        ArrayList<Cliente> clientesArray = repository.getClienteArray();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, clientesArray);

        final Spinner SpinnerCliente = (Spinner)  findViewById(R.id.spinnerCliente);
        SpinnerCliente.setAdapter(adapter);

        final Pedido pedido = new Pedido();


        Button botaoItem = (Button) findViewById(R.id.additem);
        botaoItem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent itens = new Intent(v.getContext(), ItemPedidoActivity.class);
                itens.putExtra("sampleObject", pedido);
                startActivity(itens);

            }

        });

        Button botaoSalvar = (Button) findViewById(R.id.additem);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

           Spinner  cliente  = (Spinner)findViewById(R.id.spinnerCliente);
           Spinner  tabela   = (Spinner)findViewById(R.id.spinnerTabela);
           Spinner  pagamento  = (Spinner)findViewById(R.id.spinnerPagamento);
           EditText obs = (EditText)findViewById(R.id.obs);

           pedido.setCliente(cliente.getSelectedItem().toString());
           pedido.setPagamento(pagamento.getSelectedItem().toString());
           pedido.setObs(obs.getText().toString());
           pedido.setTabelaPreco(tabela.getSelectedItem().toString());


            }

        });


    }

}