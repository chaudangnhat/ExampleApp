package com.example.examplefuturifuapplication.fragments;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.examplefuturifuapplication.R;
import com.example.examplefuturifuapplication.activities.ProductDetailActivity;
import com.example.examplefuturifuapplication.activities.SearchActivity;
import com.example.examplefuturifuapplication.adapters.ProductAdapter;
import com.example.examplefuturifuapplication.listeners.ItemClickListener;
import com.example.examplefuturifuapplication.model.Caterory;
import com.example.examplefuturifuapplication.model.Product;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements ItemClickListener, View.OnClickListener {

    private ViewPager mPager;
    private RecyclerView rvProducts;
    private View layout;
    private List<Caterory> caterories;
    private List<Product> products;
    private ProductAdapter productAdapter;

    private TextView mTitle;
    private Toolbar mToolbar;

    private boolean isGrid;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_home, container, false);

        mToolbar = layout.findViewById(R.id.toolbar);
        mTitle = mToolbar.findViewById(R.id.toolbar_title);
        rvProducts = layout.findViewById(R.id.list_item);
        ViewCompat.setElevation(mToolbar, 8);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (mToolbar != null)
            activity.setSupportActionBar(mToolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity.getSupportActionBar().setDisplayShowTitleEnabled(false);
        activity.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back_24dp);

        initDatabadeCategory();
        initDatabaseProduct(caterories.get(0));
        initViewProducts();
        mTitle.setText(caterories.get(0).getTitle());
        mTitle.setOnClickListener(view -> createPopup());
        return layout;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        MenuInflater inflaterMenu = getActivity().getMenuInflater();
        inflaterMenu.inflate(R.menu.home_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            getActivity().finish();
        } else if (item.getItemId() == R.id.action_form_list) {
            isGrid = !isGrid;
            initViewProducts();
        } else if(item.getItemId() ==R.id.action_search){
            Intent intent = new Intent(getActivity(), SearchActivity.class);
            startActivity(intent);
            getActivity().overridePendingTransition(R.anim.enter, R.anim.exit);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
    }

    private void createPopup() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Choose Category: ");
        String[] titleCategory = new String[caterories.size()];
        for (int i = 0; i < caterories.size(); i++) {
            titleCategory[i] = caterories.get(i).getTitle();
        }

        builder.setItems(titleCategory, (dialog, item) -> {
            mTitle.setText(caterories.get(item).getTitle());
            initDatabaseProduct(caterories.get(item));
            initViewProducts();
        });

        builder.setCancelable(false)
                .setNegativeButton("CANCEL", (dialog, id) -> dialog.dismiss());

        AlertDialog alert = builder.create();
        alert.show();
    }

    private void initViewProducts() {

        LinearLayoutManager layoutManager;
        if (isGrid) {
            layoutManager = new GridLayoutManager(getContext(), 2);
        } else {
            layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        }
        productAdapter = new ProductAdapter(getActivity(), products, isGrid);
        productAdapter.setItemProductListenner(this);
        rvProducts.setLayoutManager(layoutManager);
        rvProducts.setAdapter(productAdapter);
    }

    @Override
    public void ItemClick(int position) {

        Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
        intent.putExtra("Product", products.get(position));
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.enter, R.anim.exit);
    }

    private void initDatabadeCategory() {
        caterories = new ArrayList<>();
        caterories.add(new Caterory(1, "Vegetarian"));
        caterories.add(new Caterory(2, "Healthy"));

    }

    private void initDatabaseProduct(Caterory caterory) {
        products = new ArrayList<>();

        if (caterory.getId() == 1) {
            products.add(new Product(1, "Product1 - C1", "Sub Product 1", "Description product 1",
                    "https://media.self.com/photos/5a735744d976453b80c0fa44/4:3/w_746,c_limit/0717-sheet-pan-vegetarian-summer-bowl-lg.jpg", 4.5,
                    "ingrendients product 1", "100$", "300g","type1",
                    1,"450","500","300","200"));
            products.add(new Product(2, "Product2 - C1", "Sub Product 2", "Description product 2",
                    "https://i.redd.it/rxwnsjds95521.jpg", 4.5,
                    "ingrendients product 1", "100$", "300g","type1",
                    1,"450","500","300","200"));
            products.add(new Product(3, "Product3 - C1", "Sub Product 3", "Description product 3",
                    "https://www.tasteofhome.com/wp-content/uploads/2018/01/Scrum-Delicious-Burgers_EXPS_CHMZ19_824_B10_30_2b-696x696.jpg", 4.5,
                    "ingrendients product 1", "100$", "300g","type1",
                    1,"450","500","300","200"));
            products.add(new Product(4, "Product4 - C1", "Sub Product 4 ", "Description product 4",
                    "https://media.self.com/photos/5a735744d976453b80c0fa44/4:3/w_746,c_limit/0717-sheet-pan-vegetarian-summer-bowl-lg.jpg", 4.5,
                    "ingrendients product 1", "100$", "300g","type1",
                    1,"450","500","300","200"));
            products.add(new Product(5, "Product4 - C1", "Sub Product 5", "Description product 5",
                    "https://media.self.com/photos/5a735744d976453b80c0fa44/4:3/w_746,c_limit/0717-sheet-pan-vegetarian-summer-bowl-lg.jpg", 4.5,
                    "ingrendients product 1", "100$", "300g","type1",
                    1,"450","500","300","200"));
        } else if (caterory.getId() == 2) {
            products.add(new Product(1, "Product1 - C2", "Sub Product 1", "Description product 1",
                    "https://media.self.com/photos/5a735744d976453b80c0fa44/4:3/w_746,c_limit/0717-sheet-pan-vegetarian-summer-bowl-lg.jpg", 4.5,
                    "ingrendients product 1", "100$", "300g","type1",
                    1,"450","500","300","200"));
            products.add(new Product(2, "Product2 - C2", "Sub Product 2", "Description product 2",
                    "https://media.self.com/photos/5a735744d976453b80c0fa44/4:3/w_746,c_limit/0717-sheet-pan-vegetarian-summer-bowl-lg.jpg", 4.5,
                    "ingrendients product 1", "100$", "300g","type1",
                    1,"450","500","300","200"));
            products.add(new Product(3, "Product3 - C2", "Sub Product 2", "Description product 3",
                    "https://media.self.com/photos/5a735744d976453b80c0fa44/4:3/w_746,c_limit/0717-sheet-pan-vegetarian-summer-bowl-lg.jpg", 4.5,
                    "ingrendients product 1", "100$", "300g","type1",
                    1,"450","500","300","200"));
            products.add(new Product(4, "Product4 - C2", "Sub Product 2", "Description product 4",
                    "https://media.self.com/photos/5a735744d976453b80c0fa44/4:3/w_746,c_limit/0717-sheet-pan-vegetarian-summer-bowl-lg.jpg", 4.5,
                    "ingrendients product 1", "100$", "300g","type1",
                    1,"450","500","300","200"));
            products.add(new Product(5, "Product5 - C2", "Sub Product 2", "Description product 5",
                    "https://media.self.com/photos/5a735744d976453b80c0fa44/4:3/w_746,c_limit/0717-sheet-pan-vegetarian-summer-bowl-lg.jpg", 4.5,
                    "ingrendients product 1", "100$", "300g","type1",
                    1,"450","500","300","200"));
        }
    }

}
