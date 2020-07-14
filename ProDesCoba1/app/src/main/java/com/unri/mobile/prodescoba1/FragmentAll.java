package com.unri.mobile.prodescoba1;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.unri.mobile.prodescoba1.Adapter.GridAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

public class FragmentAll extends Fragment {
    RelativeLayout dotsLayout;
    GridView gridView;
    private int[] mImageId = new int[]{R.drawable.air, R.drawable.pantai, R.drawable.rumah};
    private String [] text = new String[] {"Wisata", "Kuliner", "Kriya", "Lainnya"};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.all_fragment, container, false);

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        gridView = (GridView) view.findViewById(R.id.grid_view);
        //dotsLayout = (RelativeLayout) view.findViewById(R.id.layoutDots);

        viewPager.setClipToPadding(false);
        viewPager.setPadding(0, 0, 100, 0);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());

        ImageAdapter adapter = new ImageAdapter(getActivity());
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        gridView.setAdapter(new GridAdapter(getActivity(), text));

        return view;
    }
}