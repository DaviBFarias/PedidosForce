package force.pedidos.pedidosforce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);



        // ativar botao que chama a class autentica.
        Button botao = (Button) findViewById(R.id.pedido);
        botao.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent digitarPedido = new Intent(v.getContext(), PedidosActivity.class);
                startActivity(digitarPedido);

            }
        });
    }







}
