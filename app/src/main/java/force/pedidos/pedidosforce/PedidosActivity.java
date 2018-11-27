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
import force.pedidos.pedidosforce.data.ConexaoPedido;
import force.pedidos.pedidosforce.dominio.Cliente;
import force.pedidos.pedidosforce.dominio.Pedido;

public class PedidosActivity extends AppCompatActivity {

    private TextView mTextMessage;
    Pedido pedido = new Pedido();

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
        final ConexaoCliente repository = new ConexaoCliente( PedidosActivity.this);
        ArrayList<Cliente> clientesArray = repository.getClienteArray();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, clientesArray);

        final Spinner SpinnerCliente = (Spinner)  findViewById(R.id.spinnerCliente);
        SpinnerCliente.setAdapter(adapter);


        Button botaoItem = (Button) findViewById(R.id.additem);
        botaoItem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent itens = new Intent(PedidosActivity.this, ItemPedidoActivity.class);
                itens.putExtra("sampleObject", pedido);
                startActivity(itens);
            }

        });

        Button botaoEnviar = (Button) findViewById(R.id.button);
        botaoEnviar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Spinner  cliente  = (Spinner)findViewById(R.id.spinnerCliente);
                Spinner  tabela   = (Spinner)findViewById(R.id.spinnerTabela);
                Spinner  pagamento  = (Spinner)findViewById(R.id.spinnerPagamento);
                EditText obs = (EditText)findViewById(R.id.obs);

                pedido.setCliente(cliente.getSelectedItem().toString());
                pedido.setPagamento(pagamento.getSelectedItem().toString());
                pedido.setObs(obs.getText().toString());
                pedido.setTabelaPreco(tabela.getSelectedItem().toString());

                ConexaoPedido cp = new ConexaoPedido(PedidosActivity.this);
                cp.cadastrarPedido(pedido);
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        //Verificando se há algum pedido na memória
        Intent intent = getIntent();
        if(getIntent().hasExtra("sampleObject")){
            pedido = (Pedido) intent.getSerializableExtra("sampleObject");
            ((EditText)findViewById(R.id.textView5)).setText(pedido.getItens().size());
        }
    }
}