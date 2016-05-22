package lc.mpcontent;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import lc.mpcontent.adapter.MainViewPageAdapter;
import lc.mpcontent.base.BaseActivity;
import lc.mpcontent.base.BaseFragment;
import lc.mpcontent.control.MainMenuCtrl;
import lc.mpcontent.control.base.TabViewCtrl;
import lc.mpcontent.fragment.BlogFrament;
import lc.mpcontent.fragment.CollectFrament;
import lc.mpcontent.fragment.MeFrament;
import lc.mpcontent.fragment.WebFrament;

public class MainActivity extends BaseActivity implements TabViewCtrl.onTabChangeListen,ViewPager.OnPageChangeListener{

    private TabViewCtrl mtagsView;

    private BaseFragment webFragment,blogFragment,collectFragment,meFragment;

    private ViewPager mViewPager;

    private MainViewPageAdapter mMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    @Override
    protected void initView() {
        mtagsView = new MainMenuCtrl(findViewById(R.id.main_botom_menu));
        mViewPager = (ViewPager) findViewById(R.id.main_content);

        mMainAdapter = new MainViewPageAdapter(getSupportFragmentManager());
        webFragment = new WebFrament();
        blogFragment = new BlogFrament();
        collectFragment = new CollectFrament();
        meFragment = new MeFrament();
        mMainAdapter.add(webFragment);
        mMainAdapter.add(blogFragment);
        mMainAdapter.add(collectFragment);
        mMainAdapter.add(meFragment);
        mViewPager.setAdapter(mMainAdapter);
        mViewPager.setCurrentItem(0);
        mtagsView.NotifyTabChange(0);
    }

    @Override
    protected void initEvent() {
        mtagsView.setOnTabChangeListen(this);
        mViewPager.addOnPageChangeListener(this);
    }

    @Override
    public void OnTabChange(int tab) {
        if(mViewPager!=null){
            mViewPager.setCurrentItem(tab,false);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
         if(mtagsView!=null){
             mtagsView.NotifyTabChange(position);
         }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
