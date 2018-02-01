package com.example.satya.newsflash;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

//import com.squareup.picasso.Picasso;

import java.util.ArrayList;

//import com.daimajia.androidanimations.library.Techniques;
//import com.daimajia.androidanimations.library.YoYo;

/**
 * Created by satya on 01-Feb-17.
 */

public class HMyAdapterTab3 extends RecyclerView.Adapter<HMyAdapterTab3.MyViewHolder> {
    ArrayList<HFeedItemTab3> feedItemTab3s;
    Context context;
    public HMyAdapterTab3(Context context, ArrayList<HFeedItemTab3> feedItemTab3s){
        this.feedItemTab3s = feedItemTab3s;
        this.context=context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.custom_row_news_item,parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //YoYo.with(Techniques.Bounce).playOn(holder.cardView);
        final HFeedItemTab3 current= feedItemTab3s.get(position);
        holder.Title.setText(current.getTitle());
        holder.Description.setText(current.getDescription());
        holder.Date.setText(current.getPubDate());
       // Picasso.with(context).load(current.getThumbnailUrl()).into(holder.Thumbnail);
       holder.cardView.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
              Intent intent=new Intent(context,NewsDetails.class);
              intent.putExtra("link",current.getLink());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return feedItemTab3s.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Title,Description,Date;
      //  ImageView Thumbnail;
        CardView cardView;
        public MyViewHolder(View itemView) {
            super(itemView);
            Title= (TextView) itemView.findViewById(R.id.title_text);
            Description= (TextView) itemView.findViewById(R.id.description_text);
            Date= (TextView) itemView.findViewById(R.id.date_text);
          // Thumbnail= (ImageView) itemView.findViewById(R.id.thumbnail);
            cardView= (CardView) itemView.findViewById(R.id.cardview);
        }
    }
}

