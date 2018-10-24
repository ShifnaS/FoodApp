package info.apatrix.foodapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import info.apatrix.foodapp.R;
import info.apatrix.foodapp.model.Products;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.MyViewHolder> {
    private Context context;
    private List<Products> cartList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, description, price;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            description = view.findViewById(R.id.description);
            price = view.findViewById(R.id.price);
            thumbnail = view.findViewById(R.id.thumbnail);
        }
    }


    public ProductListAdapter(Context context, List<Products> cartList) {
        this.context = context;
        this.cartList = cartList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Products item = cartList.get(position);
        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());
        holder.price.setText("₹" + item.getPrice());

        Glide.with(context)
                .load(item.getThumbnail())
                .into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public void removeItem(int position) {
        cartList.remove(position);
        // notify the item removed by position
        // to perform recycler view delete animations
        // NOTE: don't call notifyDataSetChanged()
        notifyItemRemoved(position);
    }

    public void restoreItem(Products item, int position) {
        cartList.add(position, item);
        // notify item added by position
        notifyItemInserted(position);
    }

}
