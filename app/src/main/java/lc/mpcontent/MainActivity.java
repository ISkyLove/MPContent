package lc.mpcontent;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import lc.mpcontent.base.BaseActivity;
import lc.mpcontent.base.BaseFragment;
import lc.mpcontent.control.MainMenuCtrl;
import lc.mpcontent.control.base.TabViewCtrl;

public class MainActivity extends BaseActivity implements TabViewCtrl.onTabChangeListen,ViewPager.OnPageChangeListener{

    private TabViewCtrl mtagsView;

    private BaseFragment webFragment,blogFragment,collectFragment,meFragment;

    private ViewPager mViewPager;

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
    }

    @Override
    protected void initEvent() {
        mtagsView.setOnTabChangeListen(this);
        mViewPager.addOnPageChangeListener(this);
    }

    @Override
    public void OnTabChange(int tab) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
