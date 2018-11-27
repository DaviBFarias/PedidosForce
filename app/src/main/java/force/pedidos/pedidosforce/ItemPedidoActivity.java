package force.pedidos.pedidosforce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import force.pedidos.pedidosforce.data.ConexaoProdutos;
import force.pedidos.pedidosforce.dominio.Pedido;
import force.pedidos.pedidosforce.dominio.Produto;

public class ItemPedidoActivity extends AppCompatActivity {

    private List<Produto> produtoList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ProdutosAdapter prAdapter;
    private ConexaoProdutos repository = new ConexaoProdutos( this);
    Intent intent = getIntent();
    Pedido pedido = (Pedido) intent.getSerializableExtra("sampleObject");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_pedido);

        recyclerView = (RecyclerView) findViewById(R.id.rv);

        prepareData();
        prAdapter = new ProdutosAdapter(produtoList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(prAdapter);

        Button botaoBuscar = (Button) findViewById(R.id.buttonprodutos);
        botaoBuscar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String nome = ((TextView) findViewById(R.id.buscaProdutos)).getText().toString();
                atualizarRegistros(nome);
            }
        });

        Button botaoAdicionar = (Button) findViewById(R.id.adicionarItens);
        botaoBuscar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //recyclerView.getAdapter()
            }
        });



    }

    private void prepareData() {
        produtoList = repository.getProdutoArray();
    }

    private void gravarItensPedido(){
        //pedido.setItens(produtoList);
    }

    private void atualizarRegistros(String nome) {
        produtoList = repository.getProdutoArray(nome);
        prAdapter = new ProdutosAdapter(produtoList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(prAdapter);
    }
}


