package force.pedidos.pedidosforce;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import agency.tango.materialintroscreen.MessageButtonBehaviour;
import agency.tango.materialintroscreen.SlideFragmentBuilder;

public class IntroActivity extends MaterialIntroActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(new SlideFragmentBuilder()
            .backgroundColor(R.color.colorDark)
            .buttonsColor(R.color.colorPrimaryDark)
            .title(getResources().getString(R.string.title1))
            .description(getResources().getString(R.string.description1))
            .image(R.mipmap.forcavenda)


            //.possiblePermissions(new String[]{Manifest.permission.CALL_PHONE, Manifest.permission.READ_SMS})
            //.possiblePermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})


            .build(),
            new MessageButtonBehaviour(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showMessage(getResources().getString(R.string.mensagem1));
                }
            }, getResources().getString(R.string.botao1)));
    }

    @Override
    public void onFinish() {
        super.onFinish();
       // Toast.makeText(this, getResources().getString(R.string.final_mensagem), Toast.LENGTH_SHORT).show();
       // Toast.makeText(this, "Entendeu Andreilson?", Toast.LENGTH_SHORT).show();
        View v = new View(this);
        Intent login = new Intent(v.getContext(), LoginActivity.class);
        startActivity(login);
    }


  /* @Override
    public void finish() {
        super.onFinish();
        View v = new View(this);
        Intent pedido = new Intent(v.getContext(), PedidosActivity.class);
        startActivity(pedido);
    }
*/

}