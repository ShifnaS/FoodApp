package info.apatrix.foodapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import info.apatrix.foodapp.R;
import info.apatrix.foodapp.model.History;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {
    private List<History> historyList;

    public HistoryAdapter(List<History> historyList) {
        this.historyList = historyList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.history_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        History history = historyList.get(position);
        holder.tv_date.setText(history.getDate());
        holder.tv_total.setText(history.getPrice());
        holder.tv_orderId.setText(history.getOrder_id());
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_date, tv_orderId, tv_price,tv_order_completed,tv_total;

        public MyViewHolder(View view) {
            super(view);
            tv_date = (TextView) view.findViewById(R.id.date);
            tv_orderId = (TextView) view.findViewById(R.id.order_id);
            tv_price = (TextView) view.findViewById(R.id.total);
            tv_order_completed = (TextView) view.findViewById(R.id.order_completed);
            tv_total = (TextView) view.findViewById(R.id.total_text);



        }
    }
}
