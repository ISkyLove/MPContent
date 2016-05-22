package lc.mpcontent.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import lc.mpcontent.base.BaseFragment;

/**
 * Created by lin on 16-5-22.
 */
public class MainViewPageAdapter extends FragmentPagerAdapter {

    List<BaseFragment> mFragments;

    public MainViewPageAdapter(FragmentManager fm) {
        super(fm);
        mFragments = new ArrayList<BaseFragment>();
    }

    public void add(BaseFragment item){
        mFragments.add(item);
    }

    @Override
    public Fragment getItem(int position) {
        if(mFragments!=null&&mFragments.size()>(position)){
            return mFragments.get(position);
        }
        return null;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        if(mFragments!=null){
            return mFragments.size();
        }
        return 0;
    }
}
