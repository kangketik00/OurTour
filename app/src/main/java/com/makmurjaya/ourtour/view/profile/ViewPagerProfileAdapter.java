package com.makmurjaya.ourtour.view.profile;
// Tanggal Pengerjaan: 24-07-2022
// Hayin Ananta - 10119005 - IF1
// Ilham Zaki - 10119006 - IF1
// Rizal Sihombing - 10119028 - IF1
// Muhammad Ikhlas Naufalsyah Ranau - 10119022 - IF1
// Dandi Ahmadin - 10119033 - IF1
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makmurjaya.ourtour.R;
import com.makmurjaya.ourtour.models.ProfileModel;

import java.util.List;

public class ViewPagerProfileAdapter extends RecyclerView.Adapter<ViewPagerProfileAdapter.ViewHolder> {
    List<ProfileModel> profileList;

    public ViewPagerProfileAdapter(List<ProfileModel> profileList) {
        this.profileList = profileList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.profil_mahasiswa_card,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProfileModel profileItem = profileList.get(position);
        holder.iv_profile_image.setImageResource(profileItem.getImage());
        holder.tv_profile_nama.setText(profileItem.getNama());
        holder.tv_profile_nim.setText(profileItem.getNim());
        holder.tv_profile_kelas.setText(profileItem.getKelas());
    }

    @Override
    public int getItemCount() {
        if(profileList != null) return profileList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_profile_image;
        TextView tv_profile_nama, tv_profile_nim, tv_profile_kelas ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_profile_image = itemView.findViewById(R.id.profile_image);
            tv_profile_nama = itemView.findViewById(R.id.profile_nama);
            tv_profile_nim = itemView.findViewById(R.id.profile_nim);
            tv_profile_kelas = itemView.findViewById(R.id.profile_kelas);
        }
    }
}
