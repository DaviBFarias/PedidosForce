package force.pedidos.pedidosforce;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

    Button botao = (Button) findViewById(R.id.additem);
        botao.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText cliente;
                EditText tbpreco;
                EditText pagamento;
                EditText obs;

                //passando parametros
                cliente = (EditText) findViewById(R.id.cliente);
                tbpreco = (EditText) findViewById(R.id.tbpreco);
                pagamento = (EditText) findViewById(R.id.pagamento);
                obs = (EditText) findViewById(R.id.obs);
                int codigoPagamento = 1;
                Pedido ped = new Pedido(codigoPagamento, cliente.getText().toString(), tbpreco.getText().toString(),pagamento.getText().toString(),obs.getText().toString());

                // testando retorno
                String retorno = ped.cadastraPedido();

                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, retorno, duration);
                toast.show();

                //limpando campos
                cliente.setText("");
                tbpreco.setText("");
                pagamento.setText("");
                obs.setText("");

            }


        });
    }

}