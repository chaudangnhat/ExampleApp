package com.example.examplefuturifuapplication.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.examplefuturifuapplication.R;
import com.example.examplefuturifuapplication.adapters.ViewPagerAdapter;
import com.example.examplefuturifuapplication.fragments.CheckOutFragment;
import com.example.examplefuturifuapplication.fragments.HomeFragment;
import com.example.examplefuturifuapplication.fragments.OrderFragment;
import com.example.examplefuturifuapplication.fragments.ProfileFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private static final int TAB_HOME = 0;
    private static final int TAB_ORDER = 1;
    private static final int TAB_PROFILE = 2;
    private static final int TAB_CHECKOUT = 3;

    public ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    public TabLayout tabLayout;

    private HomeFragment homeFragment;
    private TextView tvHome;
    private TextView tvOrder;
    private TextView tvProfile;
    private TextView tvCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initViewPager();
    }

    private void initViews() {
        tabLayout = findViewById(R.id.tabs);
        ViewCompat.setElevation(tabLayout, 15);
        tabLayout.setOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (tvHome != null && tvOrder != null && tvProfile != null && tvCheckout != null) {
                    if (position == TAB_HOME) {
                        tvHome.setTextColor(getResources().getColor(R.color.colorAccent));
                        tvOrder.setTextColor(getResources().getColor(R.color.color_title_tab));
                        tvProfile.setTextColor(getResources().getColor(R.color.color_title_tab));
                        tvCheckout.setTextColor(getResources().getColor(R.color.color_title_tab));
                    } else if (position == TAB_ORDER) {
                        tvHome.setTextColor(getResources().getColor(R.color.color_title_tab));
                        tvOrder.setTextColor(getResources().getColor(R.color.colorAccent));
                        tvProfile.setTextColor(getResources().getColor(R.color.color_title_tab));
                        tvCheckout.setTextColor(getResources().getColor(R.color.color_title_tab));
                    } else if (position == TAB_PROFILE) {
                        tvHome.setTextColor(getResources().getColor(R.color.color_title_tab));
                        tvOrder.setTextColor(getResources().getColor(R.color.color_title_tab));
                        tvProfile.setTextColor(getResources().getColor(R.color.colorAccent));
                        tvCheckout.setTextColor(getResources().getColor(R.color.color_title_tab));
                    } else if (position == TAB_CHECKOUT) {
                        tvHome.setTextColor(getResources().getColor(R.color.color_title_tab));
                        tvOrder.setTextColor(getResources().getColor(R.color.color_title_tab));
                        tvProfile.setTextColor(getResources().getColor(R.color.color_title_tab));
                        tvCheckout.setTextColor(getResources().getColor(R.color.colorAccent));
                    }
                }

                invalidateOptionsMenu();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager = findViewById(R.id.view_pager);
        viewPager.setOnTouchListener((v, event) -> false);

    }

    private void initViewPager() {
        viewPager.setOffscreenPageLimit(4);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        homeFragment = new HomeFragment();
        viewPagerAdapter.addFragment(homeFragment);
        viewPagerAdapter.addFragment(new OrderFragment());
        viewPagerAdapter.addFragment(new ProfileFragment());
        viewPagerAdapter.addFragment(new CheckOutFragment());

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(0);

        View tabHome = LayoutInflater.from(this).inflate(R.layout.tab, null);
        ImageView imHome = tabHome.findViewById(R.id.im_tab_icon);
        imHome.setPadding(4, 4, 4, 4);
        imHome.setImageResource(R.drawable.ic_tab_home);
        tvHome = tabHome.findViewById(R.id.title_tab);
        tvHome.setText("Main");
        tvHome.setTextColor(getResources().getColor(R.color.colorAccent));
        tabLayout.getTabAt(TAB_HOME).setCustomView(tabHome);

        View tabNews = LayoutInflater.from(this).inflate(R.layout.tab, null);
        ImageView imNews = tabNews.findViewById(R.id.im_tab_icon);
        imNews.setPadding(4, 4, 4, 4);
        imNews.setImageResource(R.drawable.ic_tab_order);
        tvOrder = tabNews.findViewById(R.id.title_tab);
        tvOrder.setText("Order");
        tabLayout.getTabAt(TAB_ORDER).setCustomView(tabNews);

        View tabCart = LayoutInflater.from(this).inflate(R.layout.tab, null);
        ImageView imCart = tabCart.findViewById(R.id.im_tab_icon);
        imCart.setImageResource(R.drawable.ic_tab_profile);
        imCart.setPadding(4, 4, 4, 4);
        tvProfile = tabCart.findViewById(R.id.title_tab);
        tvProfile.setText("Profile");
        tabLayout.getTabAt(TAB_PROFILE).setCustomView(tabCart);

        View tabFavorite = LayoutInflater.from(this).inflate(R.layout.tab, null);
        ImageView imFavorite = tabFavorite.findViewById(R.id.im_tab_icon);
        imFavorite.setImageResource(R.drawable.ic_tab_checkout);
        tvCheckout = tabFavorite.findViewById(R.id.title_tab);
        tvCheckout.setText("Checkout");
        tabLayout.getTabAt(TAB_CHECKOUT).setCustomView(tabFavorite);
    }
}
