package force.pedidos.pedidosforce;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{

    CardView card;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


     card =(CardView) findViewById(R.id.addpedido);

       card.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){

            case R.id.addpedido : i = new Intent(this, PedidosActivity.class); startActivity(i); break;

            default:Toast.makeText(this, "Entendeu Andreilson?", Toast.LENGTH_SHORT).show(); break;

        }

    }
}