package com.example.a2003project.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.a2003project.R;
import com.example.a2003project.activity.fragment.classify.ClassifyFragment;
import com.example.a2003project.activity.fragment.home.HomeFragment;
import com.example.a2003project.activity.fragment.my.MyFragment;
import com.example.a2003project.activity.fragment.shopping.Shopping_CartFragment;
import com.example.a2003project.activity.fragment.subject.SubjectFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private ArrayList<Fragment> fragments;
    private MyFragmentAdapter myFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        viewPager = findViewById(R.id.vp);
        radioGroup = findViewById(R.id.rg);
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());//TODO 首页
        fragments.add(new SubjectFragment());// TODO 专题
        fragments.add(new ClassifyFragment());//TODO 分类
        fragments.add(new Shopping_CartFragment());// TODO 购物车
        fragments.add(new MyFragment());// TODO 我的

        myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(myFragmentAdapter);
        radioGroup.setOnCheckedChangeListener(this);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                RadioButton rb = (RadioButton) radioGroup.getChildAt(position);
                rb.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){

            case R.id.rb_home:
                viewPager.setCurrentItem(0);
                break;

            case R.id.rb_subject:
                viewPager.setCurrentItem(1);
                break;
            case R.id.rb_classify:
                viewPager.setCurrentItem(2);
                break;

            case R.id.rb_shopping_cart:
                viewPager.setCurrentItem(3);
                break;
            case R.id.rb_my:
                viewPager.setCurrentItem(4);
                break;
        }
    }

    class MyFragmentAdapter extends FragmentPagerAdapter {

        private ArrayList<Fragment> list;

        public MyFragmentAdapter(FragmentManager fm, ArrayList<Fragment> list) {
            super(fm);
            this.list = list;
        }

        public MyFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}