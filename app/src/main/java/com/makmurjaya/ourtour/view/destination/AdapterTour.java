    package com.makmurjaya.ourtour.view.destination;
// Tanggal Pengerjaan: 25-07-2022
// Ilham Zaki - 10119006 - IF1
// Muhammad Ikhlas Naufalsyah Ranau - 10119022 - IF1


    import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.makmurjaya.ourtour.R;
import com.makmurjaya.ourtour.models.ModelTour;

import java.util.List;

public class AdapterTour extends RecyclerView.Adapter<AdapterTour.TourViewHolder> {
    private Context context;
    private List<ModelTour> mList;
    private Activity activity;
    DatabaseReference db = FirebaseDatabase.getInstance().getReference();

    public AdapterTour(List<ModelTour> mList, Activity activity) {
        this.activity = activity;
        this.mList = mList;
    }

    @NonNull
    @Override
    public TourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewItem = inflater.inflate(R.layout.tour_card_layout, parent, false);
        context = parent.getContext();
        return new TourViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull TourViewHolder holder, int position) {
        final ModelTour data = mList.get(position);
        Glide.with(context)
                .load(data.getImgurl())
                .into(holder.iv_imgurl);
        holder.tv_title.setText(data.getTitle());
        holder.tv_location.setText(data.getLocation());
        holder.tv_rating.setText(data.getRating());

        holder.tour_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, TourDetailActivity.class);
                intent.putExtra("imgurl", data.getImgurl());
                intent.putExtra("title", data.getTitle());
                intent.putExtra("rating", data.getRating());
                intent.putExtra("location", data.getLocation());
                intent.putExtra("description", data.getDescription());
                intent.putExtra("latitude", data.getLatitude());
                intent.putExtra("longitude", data.getLongitude());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class TourViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title,
                tv_location,
                tv_rating;
        ImageView iv_imgurl;
        CardView tour_card;

        public TourViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_imgurl = itemView.findViewById(R.id.tour_card_image);
            tv_title = itemView.findViewById(R.id.tour_card_title);
            tv_location = itemView.findViewById(R.id.tour_card_location);
            tv_rating = itemView.findViewById(R.id.tour_card_rating);
            tour_card = itemView.findViewById(R.id.tour_card);
        }
    }
}
