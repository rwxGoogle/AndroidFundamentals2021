package com.example.androidfundamentals;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder> {
    private static final String TAG = PhotosAdapter.class.getSimpleName();
    private List<String> photoList;
    private List<DataSource.Person> personList;

    PhotosAdapter(List<String> photoList, List<DataSource.Person> personList) {
        this.photoList = photoList;
        this.personList = personList;
    }

    @NonNull
    @Override
    public PhotosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View recyclerView = layoutInflater.inflate(R.layout.item_photo, parent, false);
        return new PhotosViewHolder(recyclerView);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotosAdapter.PhotosViewHolder holder, int position) {
//        String photo = photoList.get(position);
//        String photoNr = String.valueOf(position);
//        holder.photo.setText(photo);
//        holder.photoNr.setText(photoNr);

        String name = personList.get(position).getName();
        String age = personList.get(position).getAge();
        holder.photo.setText(name);
        holder.photoNr.setText(age);

        if (position == 1) {
            holder.image.setImageResource(R.drawable.ic_launcher_foreground);
        }

        holder.photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "POSITION CLICK: text= " + name + " position= " + position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    static class PhotosViewHolder extends RecyclerView.ViewHolder {
        TextView photo;
        TextView photoNr;
        ImageView image;

        public PhotosViewHolder(View itemView) {
            super(itemView);
            photo = itemView.findViewById(R.id.photo);
            photoNr = itemView.findViewById(R.id.photoNr);
            image = itemView.findViewById(R.id.image);
        }
    }
}
