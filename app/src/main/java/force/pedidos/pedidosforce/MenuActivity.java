package force.pedidos.pedidosforce;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MenuActivity extends AppCompatActivity {



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

       CardView card =(CardView) findViewById(R.id.addpedido);
        card.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent digitarPedido = new Intent(v.getContext(), PedidosActivity.class);
                startActivity(digitarPedido);
            }
        });

        CardView cardVi =(CardView) findViewById(R.id.consultpedidos);
        cardVi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent produtos = new Intent(v.getContext(), ProdutosActivity.class);
                startActivity(produtos);

            }
        });


        CardView cardV =(CardView) findViewById(R.id.addcliente);
       cardV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent digitarPedido = new Intent(v.getContext(), CadastroClienteActivity.class);
                startActivity(digitarPedido);
            }
        });

    }



}