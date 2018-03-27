package com.xmh.youtubeanim;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xmh.youtubeanim.fragment.ActivityFragment;
import com.xmh.youtubeanim.fragment.HomeFragment;
import com.xmh.youtubeanim.fragment.MediaFragment;
import com.xmh.youtubeanim.fragment.PopularFragment;
import com.xmh.youtubeanim.fragment.SubscribeFragment;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager vpFragments;

    private HomeFragment mHomeFragment = new HomeFragment();
    private PopularFragment mPopularFragment = new PopularFragment();
    private SubscribeFragment mSubscribeFragment = new SubscribeFragment();
    private ActivityFragment mActivityFragment = new ActivityFragment();
    private MediaFragment mMediaFragment = new MediaFragment();
    private List<Fragment> mFragments = Arrays.asList(mHomeFragment, mPopularFragment, mSubscribeFragment, mActivityFragment, mMediaFragment);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        vpFragments = findViewById(R.id.vp_fragments);
        vpFragments.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
    }

    public void onNavigationClick(View v) {
        switch (v.getId()) {
            case R.id.btn_home:
                vpFragments.setCurrentItem(mFragments.indexOf(mHomeFragment));
                break;
            case R.id.btn_activity:
                vpFragments.setCurrentItem(mFragments.indexOf(mActivityFragment));
                break;
            case R.id.btn_media:
                vpFragments.setCurrentItem(mFragments.indexOf(mMediaFragment));
                break;
            case R.id.btn_popular:
                vpFragments.setCurrentItem(mFragments.indexOf(mPopularFragment));
                break;
            case R.id.btn_subscribe:
                vpFragments.setCurrentItem(mFragments.indexOf(mSubscribeFragment));
                break;
        }
    }

    private class FragmentAdapter extends FragmentPagerAdapter {

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }
}
