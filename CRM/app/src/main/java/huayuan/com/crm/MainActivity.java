package huayuan.com.crm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;

import huayuan.com.crm.fragment.clientFragment;
import huayuan.com.crm.fragment.groupFragment;
import huayuan.com.crm.fragment.remarksFragment;
import huayuan.com.crm.fragment.scheduleFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    BottomNavigationBar bottomNavigationBar;
    private ArrayList<Fragment> fragments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    private void initview(){

        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.navigation_bar);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);




            bottomNavigationBar
                    .addItem(new BottomNavigationItem(R.mipmap.tabbar_home_richeng, "日程").setActiveColorResource(R.color.colorPrimary))
                    .addItem(new BottomNavigationItem(R.mipmap.tabbar_home_beizhu, "备注").setActiveColorResource(R.color.colorPrimary))
                    .addItem(new BottomNavigationItem(R.mipmap.tabbar_home_kehu, "客户").setActiveColorResource(R.color.colorPrimary))
                    .addItem(new BottomNavigationItem(R.mipmap.tabbar_home_wode, "小组").setActiveColorResource(R.color.colorPrimary))
                    .setFirstSelectedPosition(0)
                    .initialise();
            fragments = getFragments();

        setDefaultFragment();
        bottomNavigationBar.setTabSelectedListener(this);
    }

    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.home_fragment, scheduleFragment.newInstance("首页",""));
        transaction.commit();
    }


    private ArrayList<Fragment> getFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(scheduleFragment.newInstance("日程",""));
        fragments.add(remarksFragment.newInstance("备注",""));
        fragments.add(clientFragment.newInstance("客户",""));
        fragments.add(groupFragment.newInstance("小组",""));




        return fragments;
    }


    @Override
    public void onTabSelected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                if (fragment.isAdded()) {
                    ft.replace(R.id.home_fragment, fragment);
                } else {
                    ft.add(R.id.home_fragment, fragment);
                }
                ft.commitAllowingStateLoss();
            }
        }

    }

    @Override
    public void onTabUnselected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                ft.remove(fragment);
                ft.commitAllowingStateLoss();
            }
        }

    }

    @Override
    public void onTabReselected(int position) {

    }



}
