package com.example.examplefuturifuapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examplefuturifuapplication.R;
import com.example.examplefuturifuapplication.listeners.ItemClickListener;
import com.example.examplefuturifuapplication.model.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecipesVideoAdapter extends RecyclerView.Adapter<RecipesVideoAdapter.RecipesHolder> implements Filterable {

    private Context context;
    private List<Product> contactList;
    private List<Product> dataFilter;
    private String query = "";

    private ItemClickListener onItemClick;

    public void setItemClickListener(ItemClickListener onItemClick) {
        this.onItemClick = onItemClick;
    }


    public RecipesVideoAdapter(Context context, List<Product> contactList) {
        this.context = context;
        this.contactList = contactList;
        this.dataFilter = contactList;
    }

    public List<Product> getData() {
        return dataFilter;
    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                query = charSequence.toString();
                if (!query.isEmpty()) {
                    List<Product> filteredList = new ArrayList<>();
                    for (Product row : contactList) {
                        if (row.getName().toLowerCase().contains(query.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }
                    dataFilter = filteredList;

                } else {
                    dataFilter = contactList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = dataFilter;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                dataFilter = (ArrayList<Product>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }


    @NonNull
    @Override
    public RecipesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View convertView = inflater.inflate(R.layout.item_recipes_video, parent, false);
        return new RecipesHolder(convertView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipesHolder holder, int position) {
        if (position < dataFilter.size() )
            holder.onBindView(position);
    }

    @Override
    public int getItemCount() {
        return dataFilter.size();
    }

    class RecipesHolder extends RecyclerView.ViewHolder {

        private LinearLayout layoutAll;
        private TextView tvName;
        private TextView tvSubName;
        private ImageView ivImageProduct;
        private ImageView ivShowDetail;

        RecipesHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name_product);
            tvSubName = itemView.findViewById(R.id.tv_subname);
            ivImageProduct = itemView.findViewById(R.id.iv_image_product);
            ivShowDetail = itemView.findViewById(R.id.iv_show_detail);
            layoutAll = itemView.findViewById(R.id.layout_all);
        }

        public void onBindView(int position) {
            Product product = dataFilter.get(position);
            tvName.setText(product.getName());
            tvSubName.setText(product.getSubName());
            Picasso.with(context).load(product.getUrlImage()).into(ivImageProduct);
            layoutAll.setOnClickListener(view -> onItemClick.ItemClick(position));

        }
    }
}
