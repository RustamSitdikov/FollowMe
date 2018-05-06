package com.sitdikovrm.followme.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sitdikovrm.followme.R;
import com.sitdikovrm.followme.activity.ImageActivity;
import com.sitdikovrm.followme.model.Image;

public class TapeAdapter extends RecyclerView.Adapter<TapeAdapter.ViewHolder>  {
    private Context mContext;
    private Image[] mImages;

    public TapeAdapter(Context context, Image[] images) {
        mContext = context;
        mImages = images;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View imageView = inflater.inflate(R.layout.tape_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(imageView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Image image = mImages[position];
        ImageView imageView = holder.mImageView;

        Glide.with(mContext)
                .load(image.getUrl())
                .into(imageView);
    }

    @Override
    public int getItemCount() {
        return mImages.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView mImageView;

        public ViewHolder(View itemView) {

            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.tape_image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                Image image = mImages[position];
                Intent intent = new Intent(mContext, ImageActivity.class);
                intent.putExtra(ImageActivity.ARG_IMAGE, image);
                mContext.startActivity(intent);
            }
        }
    }
}
