package com.app.wallpaper_demo;

// WallpaperNameAdapter.java
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class WallpaperNameAdapter extends RecyclerView.Adapter<WallpaperNameAdapter.WallpaperNameViewHolder> {

    private List<String> wallpaperNames;

    public WallpaperNameAdapter(List<String> wallpaperNames) {
        this.wallpaperNames = wallpaperNames;
    }

    @NonNull
    @Override
    public WallpaperNameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wallpaper_name, parent, false);
        return new WallpaperNameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WallpaperNameViewHolder holder, int position) {
        String wallpaperName = wallpaperNames.get(position);
        holder.textWallpaperName.setText(wallpaperName);
    }

    @Override
    public int getItemCount() {
        return wallpaperNames.size();
    }

    static class WallpaperNameViewHolder extends RecyclerView.ViewHolder {
        TextView textWallpaperName;

        public WallpaperNameViewHolder(@NonNull View itemView) {
            super(itemView);
            textWallpaperName = itemView.findViewById(R.id.textWallpaperName);
        }
    }
}
