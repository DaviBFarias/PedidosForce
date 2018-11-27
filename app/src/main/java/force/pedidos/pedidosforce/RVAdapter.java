package force.pedidos.pedidosforce;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import force.pedidos.pedidosforce.dominio.ItemPedido;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ItemViewHolder>{



    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView nomeItem;
        TextView saldoItem;
        CheckBox checkItem;
        EditText qtdItem;



        ItemViewHolder(View itemView) {
            super(itemView);
             cv = (CardView)itemView.findViewById(R.id.cv_item);
             nomeItem = (TextView)itemView.findViewById(R.id.nomeItem);
             saldoItem = (TextView)itemView.findViewById(R.id.saldoItem);
             //checkItem = (CheckBox)itemView.findViewById(R.id.checkItem);
             //qtdItem = (EditText)itemView.findViewById(R.id.qtdItem);

        }
    }

    List<ItemPedido> itensPedido;

    RVAdapter(List<ItemPedido> itensPedido){
        this.itensPedido = itensPedido;
    }

    @Override
    public int getItemCount() {
        return itensPedido.size();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_item_pedido, viewGroup, false);
        ItemViewHolder pvh = new ItemViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder itemViewHolder, int i) {
        //itemViewHolder.checkItem  .setText(persons.get(i).name);
        itemViewHolder.nomeItem.setText(itensPedido.get(i).getObsItem());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}