package force.pedidos.pedidosforce;

import android.graphics.Movie;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import force.pedidos.pedidosforce.dominio.Produto;

public class ProdutosAdapter extends RecyclerView.Adapter<ProdutosAdapter.MyViewHolder> {

    private List<Produto> listaProdutos;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        public TextView nomeItem;
        public TextView saldoItem;
        public TextView codItem;
        CheckBox checkItem;
        EditText qtdItem;

        public MyViewHolder(View view) {
            super(view);
            cv = (CardView)itemView.findViewById(R.id.cv_item);
            codItem = (TextView)itemView.findViewById(R.id.codItem);
            nomeItem = (TextView)itemView.findViewById(R.id.nomeItem);
            saldoItem = (TextView)itemView.findViewById(R.id.saldoItem);
            checkItem = (CheckBox)itemView.findViewById(R.id.checkItem);
            qtdItem = (EditText)itemView.findViewById(R.id.qtdItem);
        }
    }


    public ProdutosAdapter(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.linha_itens, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Produto pr = listaProdutos.get(position);
        holder.codItem.setText(String.valueOf(pr.getCodigoProduto()));
        holder.nomeItem.setText(String.valueOf(pr.getNomeProduto().substring(0,14)));
        holder.saldoItem.setText(String.valueOf(pr.getSaldoProduto()));
        //holder.qtdItem.setText("");
    }

    @Override
    public int getItemCount() {
        return listaProdutos.size();
    }
}