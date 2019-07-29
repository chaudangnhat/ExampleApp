package com.example.examplefuturifuapplication.activities;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;

import com.example.examplefuturifuapplication.R;
import com.example.examplefuturifuapplication.model.Product;
import com.squareup.picasso.Picasso;

public class ProductDetailActivity extends AppCompatActivity {

    private ImageView imageHeader;
    private TextView tvName;
    private TextView tvPrice;
    private TextView tvMass;
    private TextView tvDescription;
    private TextView tvIngredients;
    private TextView tvCalories;
    private TextView tvProtein;
    private TextView tvTotalFat;
    private TextView tvTotalCabs;
    private Product product;
    private Toolbar mToolbar;
    private TextView tvCount;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        mToolbar = findViewById(R.id.toolbar);
        tvName = findViewById(R.id.tv_title);
        tvPrice = findViewById(R.id.tv_price);
        tvMass = findViewById(R.id.tv_mass);
        tvDescription = findViewById(R.id.tv_description);
        tvIngredients = findViewById(R.id.tv_ingredients);
        tvCalories = findViewById(R.id.tv_calories);
        tvProtein = findViewById(R.id.tv_protein);
        tvTotalFat = findViewById(R.id.tv_total_fat);
        tvTotalCabs = findViewById(R.id.tv_total_carbs);
        tvCount = findViewById(R.id.tv_count);

        ViewCompat.setElevation(mToolbar, 8);
        if (mToolbar != null)
           setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back_24dp);
        product = (Product) getIntent().getSerializableExtra("Product");
        imageHeader = findViewById(R.id.iv_image_header);
        Picasso.with(this).load(product.getUrlImage()).into(imageHeader);
        tvName.setText(product.getName());
        tvPrice.setText(product.getPrice());
        tvMass.setText(product.getMass());
        tvDescription.setText(product.getDescription());
        tvIngredients.setText(product.getIngredients());
        tvCalories.setText(product.getCalories());
        tvProtein.setText(product.getProtein());
        tvTotalFat.setText(product.getTotalFat());
        tvTotalCabs.setText(product.getTotalCarbs());
        tvCount.setText(String.valueOf(product.getCount()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflaterMenu = getMenuInflater();
        inflaterMenu.inflate(R.menu.product_detail_menu, menu);
        MenuItem item = menu.findItem(R.id.action_order);
        SpannableString s = new SpannableString("Order");
        s.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.blue)), 0, s.length(), 0);
        item.setTitle(s);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
