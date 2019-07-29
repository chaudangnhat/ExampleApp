package com.example.examplefuturifuapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examplefuturifuapplication.R;
import com.example.examplefuturifuapplication.listeners.ItemClickListener;
import com.example.examplefuturifuapplication.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private Context context;
    private List<Product> mProducts;
    private ItemClickListener itemProductListenner;
    private boolean isGrid;


    public void setItemProductListenner(ItemClickListener itemProductListenner) {
        this.itemProductListenner = itemProductListenner;
    }

    public ProductAdapter(Context mContext, List<Product> mProducts, boolean isGrid) {
        this.context = mContext;
        this.mProducts = mProducts;
        this.isGrid = isGrid;
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View convertView;

        convertView = layoutInflater.inflate(isGrid ? R.layout.item_grid_product :R.layout.item_product, viewGroup, false);

        return new ViewHolder(convertView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Product product = mProducts.get(i);
        viewHolder.onBind(product, i);
    }


    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivIamges;
        TextView tvName;
        TextView tvSubName;
        TextView tvDescription;
        TextView tvRate;
        LinearLayout layoutAll;

        public ViewHolder(final View view) {
            super(view);
            ivIamges = view.findViewById(R.id.iv_image);
            tvName = view.findViewById(R.id.tv_name);
            tvSubName = view.findViewById(R.id.tv_subname);
            tvDescription = view.findViewById(R.id.tv_description);
            tvRate = view.findViewById(R.id.rate);
            layoutAll = view.findViewById(R.id.layout_all);
        }

        public void onBind(final Product product, int position) {
            Picasso.with(context).load(product.getUrlImage()).into(ivIamges);
            tvName.setText(product.getName());
            tvSubName.setText(product.getSubName());
            tvDescription.setText(product.getDescription());
            if(tvRate != null){
                tvRate.setText(String.valueOf(product.getRate()));
            }
            layoutAll.setOnClickListener((v) -> itemProductListenner.ItemClick(position));
        }
    }
}
