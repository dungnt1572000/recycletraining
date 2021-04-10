package com.example.addproducttocart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;
import com.aurelhubert.ahbottomnavigation.notification.AHNotification;

public class MainActivity extends AppCompatActivity {
    AHBottomNavigation ahBottomNavigation;
    AHBottomNavigationViewPager ahBottomNavigationViewPager;
    ViewPagerAdapter viewPagerAdapter;
    View viewEndAnimation;
    ImageView viewAnimation;
    int mcountproduct;



    public View getViewEndAnimation() {
        return viewEndAnimation;
    }

    public ImageView getViewAnimation() {
        return viewAnimation;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewEndAnimation = (View) findViewById(R.id.viewendAnimation);
        viewAnimation = (ImageView) findViewById(R.id.viewAnimation);
        ahBottomNavigation = (AHBottomNavigation) findViewById(R.id.AHBottomNavigation);
        ahBottomNavigationViewPager = (AHBottomNavigationViewPager) findViewById(R.id.AHBottomNavigationViewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        ahBottomNavigationViewPager.setAdapter(viewPagerAdapter);
        ahBottomNavigationViewPager.setPagingEnabled(true);
        // Create items
        AHBottomNavigationItem product = new AHBottomNavigationItem(R.string.product, R.drawable.product, R.color.purple_200);
        AHBottomNavigationItem card = new AHBottomNavigationItem(R.string.card, R.drawable.card, R.color.teal_200);
        AHBottomNavigationItem notice = new AHBottomNavigationItem(R.string.notice, R.drawable.notice, R.color.black);

// Add items
        ahBottomNavigation.addItem(product);
        ahBottomNavigation.addItem(card);
        ahBottomNavigation.addItem(notice);
        ahBottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                ahBottomNavigationViewPager.setCurrentItem(position);

                return true;
            }
        });
        ahBottomNavigationViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                    ahBottomNavigation.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    public void setCounttoCart(int count){
        mcountproduct = count;
        AHNotification notification = new AHNotification.Builder()
                .setText(String.valueOf(mcountproduct))
                .setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.red))
                .setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white))
                .build();
        ahBottomNavigation.setNotification(notification, 1);
    }
    public int getMcountproduct() {
        return mcountproduct;
    }
}