package com.example.examplefuturifuapplication.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examplefuturifuapplication.R;
import com.example.examplefuturifuapplication.adapters.RecipesAdapter;
import com.example.examplefuturifuapplication.adapters.RecipesVideoAdapter;
import com.example.examplefuturifuapplication.listeners.ItemClickListener;
import com.example.examplefuturifuapplication.listeners.RxSearchProduct;
import com.example.examplefuturifuapplication.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener, ItemClickListener {

    private RelativeLayout layoutToolbar;
    private RelativeLayout layoutSearch;
    private ImageView ivBack;
    private ImageView ivSearch;
    private ImageView ivCloseSearch;
    private RecyclerView rvRecipes;
    private RecyclerView rvRecipesVideos;

    private List<Product> products;
    private RecipesAdapter recipesAdapter;
    private RecipesVideoAdapter recipesVideoAdapter;
    private EditText edSearch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        layoutSearch = findViewById(R.id.layout_search);
        layoutToolbar = findViewById(R.id.layout_toolbar);
        ivBack = findViewById(R.id.iv_back);
        ivCloseSearch = findViewById(R.id.btn_close_search);
        ivSearch = findViewById(R.id.iv_search);
        ivSearch.setOnClickListener(this);
        ivBack.setOnClickListener(this);
        ivCloseSearch.setOnClickListener(this);
        edSearch = findViewById(R.id.ed_search);

        rvRecipes = findViewById(R.id.list_recipes);
        rvRecipesVideos = findViewById(R.id.list_video);

        initDatabaseProduct();
        initViewProducts();

        setRxSearchProduct(edSearch);

    }


    private void initViewProducts() {

        LinearLayoutManager layoutManagerRecipes = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recipesAdapter = new RecipesAdapter(this, products);
        recipesAdapter.setItemClickListener(this);
        rvRecipes.setLayoutManager(layoutManagerRecipes);
        rvRecipes.setAdapter(recipesAdapter);

        LinearLayoutManager layoutManagerRecipesVideo = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recipesVideoAdapter = new RecipesVideoAdapter(this, products);
        recipesVideoAdapter.setItemClickListener(this);
        rvRecipesVideos.setLayoutManager(layoutManagerRecipesVideo);
        rvRecipesVideos.setAdapter(recipesVideoAdapter);
    }

    @SuppressLint("CheckResult")
    private void setRxSearchProduct(EditText editText) {
        RxSearchProduct.fromSearchView(editText)
                .debounce(2000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::setContactSearch);
    }

    private void setContactSearch(String query) {
        recipesAdapter.getFilter().filter(query);
        recipesVideoAdapter.getFilter().filter(query);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = getCurrentFocus();
        if (view == null) {
            view = new View(this);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void initDatabaseProduct() {
        products = new ArrayList<>();

        products.add(new Product(1, "Product1 - C1", "Sub Product 1", "Description product 1",
                "https://media.self.com/photos/5a735744d976453b80c0fa44/4:3/w_746,c_limit/0717-sheet-pan-vegetarian-summer-bowl-lg.jpg", 4.5,
                "ingrendients product 1", "100$", "300g", "type1",
                1, "450", "500", "300", "200"));
        products.add(new Product(2, "Product2 - C1", "Sub Product 2", "Description product 2",
                "https://media.self.com/photos/5a735744d976453b80c0fa44/4:3/w_746,c_limit/0717-sheet-pan-vegetarian-summer-bowl-lg.jpg", 4.5,
                "ingrendients product 1", "100$", "300g", "type1",
                1, "450", "500", "300", "200"));
        products.add(new Product(3, "Product3 - C1", "Sub Product 3", "Description product 3",
                "https://media.self.com/photos/5a735744d976453b80c0fa44/4:3/w_746,c_limit/0717-sheet-pan-vegetarian-summer-bowl-lg.jpg", 4.5,
                "ingrendients product 1", "100$", "300g", "type1",
                1, "450", "500", "300", "200"));
        products.add(new Product(4, "Product4 - C1", "Sub Product 4 ", "Description product 4",
                "https://media.self.com/photos/5a735744d976453b80c0fa44/4:3/w_746,c_limit/0717-sheet-pan-vegetarian-summer-bowl-lg.jpg", 4.5,
                "ingrendients product 1", "100$", "300g", "type1",
                1, "450", "500", "300", "200"));
        products.add(new Product(5, "Product4 - C1", "Sub Product 5", "Description product 5",
                "https://media.self.com/photos/5a735744d976453b80c0fa44/4:3/w_746,c_limit/0717-sheet-pan-vegetarian-summer-bowl-lg.jpg", 4.5,
                "ingrendients product 1", "100$", "300g", "type1",
                1, "450", "500", "300", "200"));

        products.add(new Product(1, "Product1 - C2", "Sub Product 1", "Description product 1",
                "https://media.self.com/photos/5a735744d976453b80c0fa44/4:3/w_746,c_limit/0717-sheet-pan-vegetarian-summer-bowl-lg.jpg", 4.5,
                "ingrendients product 1", "100$", "300g", "type1",
                1, "450", "500", "300", "200"));
        products.add(new Product(2, "Product2 - C2", "Sub Product 2", "Description product 2",
                "https://media.self.com/photos/5a735744d976453b80c0fa44/4:3/w_746,c_limit/0717-sheet-pan-vegetarian-summer-bowl-lg.jpg", 4.5,
                "ingrendients product 1", "100$", "300g", "type1",
                1, "450", "500", "300", "200"));
        products.add(new Product(3, "Product3 - C2", "Sub Product 2", "Description product 3",
                "https://media.self.com/photos/5a735744d976453b80c0fa44/4:3/w_746,c_limit/0717-sheet-pan-vegetarian-summer-bowl-lg.jpg", 4.5,
                "ingrendients product 1", "100$", "300g", "type1",
                1, "450", "500", "300", "200"));
        products.add(new Product(4, "Product4 - C2", "Sub Product 2", "Description product 4",
                "https://media.self.com/photos/5a735744d976453b80c0fa44/4:3/w_746,c_limit/0717-sheet-pan-vegetarian-summer-bowl-lg.jpg", 4.5,
                "ingrendients product 1", "100$", "300g", "type1",
                1, "450", "500", "300", "200"));
        products.add(new Product(5, "Product5 - C2", "Sub Product 2", "Description product 5",
                "https://media.self.com/photos/5a735744d976453b80c0fa44/4:3/w_746,c_limit/0717-sheet-pan-vegetarian-summer-bowl-lg.jpg", 4.5,
                "ingrendients product 1", "100$", "300g", "type1",
                1, "450", "500", "300", "200"));

    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_close_search) {
            setViewSearch(false);
            hideKeyboard();
        } else if (view.getId() == R.id.iv_search) {
            setViewSearch(true);
        } else if (view.getId() == R.id.iv_back) {
            onBackPressed();
        }

    }

    private void setViewSearch(boolean isSearch){
        layoutToolbar.setVisibility(isSearch ? View.GONE : View.VISIBLE);
        layoutSearch.setVisibility(isSearch ? View.VISIBLE : View.GONE);
    }

    @Override
    public void ItemClick(int position) {
        Intent intent = new Intent(this, ProductDetailActivity.class);
        intent.putExtra("Product", products.get(position));
        startActivity(intent);
        overridePendingTransition(R.anim.enter, R.anim.exit);

    }
}
