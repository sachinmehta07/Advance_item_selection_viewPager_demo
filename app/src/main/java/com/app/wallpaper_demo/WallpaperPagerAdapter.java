package com.app.wallpaper_demo;


// WallpaperPagerAdapter.java
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.List;

public class WallpaperPagerAdapter extends RecyclerView.Adapter<WallpaperPagerAdapter.WallpaperViewHolder> {

    private List<List<String>> wallpaperDataList;

    public WallpaperPagerAdapter(List<List<String>> wallpaperDataList) {
        this.wallpaperDataList = wallpaperDataList;
    }

    @NonNull
    @Override
    public WallpaperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wallpaper, parent, false);
        return new WallpaperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WallpaperViewHolder holder, int position) {
        List<String> wallpaperNames = wallpaperDataList.get(position);

        // Set up RecyclerView for wallpaper names
        WallpaperNameAdapter wallpaperNameAdapter = new WallpaperNameAdapter(wallpaperNames);
        holder.wallpaperRecyclerView.setAdapter(wallpaperNameAdapter);

        // Set layout manager for the RecyclerView
        GridLayoutManager layoutManager = new GridLayoutManager(holder.itemView.getContext(), 3);
        holder.wallpaperRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public int getItemCount() {
        return wallpaperDataList.size();
    }

    static class WallpaperViewHolder extends RecyclerView.ViewHolder {
        RecyclerView wallpaperRecyclerView;

        public WallpaperViewHolder(@NonNull View itemView) {
            super(itemView);
            wallpaperRecyclerView = itemView.findViewById(R.id.wallpaperRecyclerView);
        }
    }
}
