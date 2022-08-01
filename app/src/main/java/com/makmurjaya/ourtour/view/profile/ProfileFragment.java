package com.makmurjaya.ourtour.view.profile;
// Tanggal Pengerjaan: 01-08-2022
// Dandi Ahmadin - 10119033 - IF1
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.makmurjaya.ourtour.R;
import com.makmurjaya.ourtour.models.ProfileModel;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {
    ViewPager2 viewPager2;
    List<ProfileModel> profileList;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        viewPager2 = view.findViewById(R.id.profile_collection);
        profileList = new ArrayList<>();

        int[] image = {
                R.drawable.hayinananta10119005,
                R.drawable.ilhamzaki10119006,
                R.drawable.rizalsihombing10119028,
                R.drawable.mikhlas10119022,
                R.drawable.dandiahmadin10119033};
        String[] nama = {"Hayin Ananta", "Ilham Zaki","Rizal Sihombing", "Muhammad Ikhlas Naufalsyah Ranau","Dandi Ahmadin"};
        String[] nim = {"10119005", "10119006","10119028", "10119022", "10119033"};
        String[] kelas = {"IF1", "IF1", "IF1","IF1","IF1"};

        for (int i=0; i < image.length; i++){
            ProfileModel item = new ProfileModel(image[i], nama[i], nim[i], kelas[i]);
            profileList.add(item);
        }

        ViewPagerProfileAdapter adapter = new ViewPagerProfileAdapter(profileList);

        viewPager2.setAdapter(adapter);
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(2);
        viewPager2.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);


        return view;
    }
}