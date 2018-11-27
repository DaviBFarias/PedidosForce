package force.pedidos.pedidosforce;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.PermissionChecker;
import android.view.View;

import java.security.Permission;
import java.util.ArrayList;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import agency.tango.materialintroscreen.MessageButtonBehaviour;
import agency.tango.materialintroscreen.SlideFragmentBuilder;
import force.pedidos.pedidosforce.data.ConexaoCliente;
import force.pedidos.pedidosforce.data.ConexaoPedido;
import force.pedidos.pedidosforce.dominio.ItemPedido;
import force.pedidos.pedidosforce.dominio.Pedido;

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
            .neededPermissions(new String[]{Manifest.permission.READ_CONTACTS, Manifest.permission.READ_SMS})
            .build(),
            new MessageButtonBehaviour(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showMessage(getResources().getString(R.string.mensagem1));
                }
            }, getResources().getString(R.string.botao1)));

        addSlide(new SlideFragmentBuilder()

                .backgroundColor(R.color.colorDark)
                .buttonsColor(R.color.colorPrimaryDark)
                .title(getResources().getString(R.string.title1))
                .description(getResources().getString(R.string.description1))
                .image(R.mipmap.forcavenda)
                .build(),
                new MessageButtonBehaviour(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onFinish();
                    }
                }, getResources().getString(R.string.botao2)));
    }

    @Override
    public void onFinish() {
        super.onFinish();
        new ConexaoCliente(IntroActivity.this);
        View v = new View(this);
        Intent login = new Intent(v.getContext(), LoginActivity.class);
        startActivity(login);
    }

    public void mockPedidoTeste(){
        ConexaoPedido cp = new ConexaoPedido(IntroActivity.this);

        //Montando pedido teste
        int idPedido = 1;
        String cliente = "12345678925";
        String tabelaPreco = "PROMOCIONAL";
        String pagamento = "Á VISTA";
        String obs = "Pedido teste";
        ArrayList<ItemPedido> itens = new ArrayList<>();
        itens.add(new ItemPedido(1, 1, ""));
        Pedido ped = new Pedido(idPedido, cliente, tabelaPreco, pagamento, obs, itens);

        cp.cadastrarPedido(ped);
    }
}