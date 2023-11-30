package com.app.wallpaper_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView categoryRecyclerView;
    private ViewPager2 wallpaperViewPager;

    private List<String> categoryList;
    private List<List<String>> wallpaperDataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize data
        initData();

        // Initialize RecyclerViews
        categoryRecyclerView = findViewById(R.id.categoryRecyclerView);
        wallpaperViewPager = findViewById(R.id.wallpaperViewPager);

        // Set up Category RecyclerView
        CategoryAdapter categoryAdapter = new CategoryAdapter(categoryList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryRecyclerView.setAdapter(categoryAdapter);

        // Set up Wallpaper ViewPager with RecyclerView
        WallpaperPagerAdapter wallpaperPagerAdapter = new WallpaperPagerAdapter(wallpaperDataList);
        wallpaperViewPager.setAdapter(wallpaperPagerAdapter);

        // Sync Category and Wallpaper ViewPager
        categoryAdapter.setOnItemClickListener(position -> wallpaperViewPager.setCurrentItem(position, true));
        wallpaperViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                categoryRecyclerView.smoothScrollToPosition(position);
                categoryAdapter.setSelectedItem(position);
            }
        });
    }

    private void initData() {
        // Sample data for categories
        categoryList = new ArrayList<>();
        categoryList.add("3D Wallpaper");
        categoryList.add("Animal");
        categoryList.add("Natural");
        categoryList.add("Vegetable");
        categoryList.add("Temple");

        // Sample data for wallpaper names
        wallpaperDataList = new ArrayList<>();

        // 3D Wallpaper
        wallpaperDataList.add(new ArrayList<>());
        wallpaperDataList.get(0).add("Abstract 1");
        wallpaperDataList.get(0).add("Abstract 2");
        wallpaperDataList.get(0).add("Abstract 3");

        // Animal
        wallpaperDataList.add(new ArrayList<>());
        wallpaperDataList.get(1).add("Elephant");
        wallpaperDataList.get(1).add("Tiger");
        wallpaperDataList.get(1).add("Panda");

        // Natural
        wallpaperDataList.add(new ArrayList<>());
        wallpaperDataList.get(2).add("Mountains");
        wallpaperDataList.get(2).add("Waterfall");
        wallpaperDataList.get(2).add("Sunset");

        // Vegetable
        wallpaperDataList.add(new ArrayList<>());
        wallpaperDataList.get(3).add("Broccoli");
        wallpaperDataList.get(3).add("Carrot");
        wallpaperDataList.get(3).add("Tomato");

        // Temple
        wallpaperDataList.add(new ArrayList<>());
        wallpaperDataList.get(4).add("Ancient Temple");
        wallpaperDataList.get(4).add("Modern Temple");
        wallpaperDataList.get(4).add("Asian Temple");
    }

}