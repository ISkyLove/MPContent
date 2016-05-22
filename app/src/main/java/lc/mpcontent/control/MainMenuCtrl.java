package lc.mpcontent.control;


import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import lc.mpcontent.R;
import lc.mpcontent.control.base.TabViewCtrl;

/**
 * Created by lin on 16-5-21.
 * main menu control
 */
public class MainMenuCtrl extends TabViewCtrl implements View.OnClickListener {

    public static final int TAB_WEB = 0;
    public static final int TAB_BLOG = 1;
    public static final int TAB_COLLECT = 2;
    public static final int TAB_ME = 3;

    private int cur_tab = 0;

    private RelativeLayout rlWeb;
    private RelativeLayout rlBlog;
    private RelativeLayout rlCollect;
    private RelativeLayout rlMe;

    private TextView tvWeb;
    private TextView tvBlog;
    private TextView tvCollect;
    private TextView tvMe;


    public MainMenuCtrl(View tabview) {
        mTabsView = tabview;
        initView();
        initEvent();
    }

    @Override
    protected void initView() {
        rlWeb = (RelativeLayout) mTabsView.findViewById(R.id.main_menu_it_web);
        rlBlog = (RelativeLayout) mTabsView.findViewById(R.id.main_menu_it_blog);
        rlCollect = (RelativeLayout) mTabsView.findViewById(R.id.main_menu_it_collect);
        rlMe = (RelativeLayout) mTabsView.findViewById(R.id.main_menu_it_me);

        tvWeb = (TextView) mTabsView.findViewById(R.id.main_menu_it_web_tx);
        tvBlog = (TextView) mTabsView.findViewById(R.id.main_menu_it_blog_tx);
        tvCollect = (TextView) mTabsView.findViewById(R.id.main_menu_it_collect_tx);
        tvMe = (TextView) mTabsView.findViewById(R.id.main_menu_it_me_tx);
    }

    @Override
    protected void initEvent() {
        rlWeb.setOnClickListener(this);
        rlBlog.setOnClickListener(this);
        rlCollect.setOnClickListener(this);
        rlMe.setOnClickListener(this);
    }

    @Override
    public void NotifyTabChange(int tab) {
        initAllTab();
        setTabSelect(tab);
    }

    @Override
    protected void initAllTab() {
        tvWeb.setSelected(false);
        tvBlog.setSelected(false);
        tvCollect.setSelected(false);
        tvMe.setSelected(false);
    }

    @Override
    protected void setTabSelect(int tab) {
        switch (tab) {
            case TAB_WEB:
                tvWeb.setSelected(true);
                cur_tab = TAB_WEB;
                break;
            case TAB_BLOG:
                tvBlog.setSelected(true);
                cur_tab = TAB_BLOG;
                break;
            case TAB_COLLECT:
                tvCollect.setSelected(true);
                cur_tab = TAB_COLLECT;
                break;
            case TAB_ME:
                tvMe.setSelected(true);
                cur_tab = TAB_ME;
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_menu_it_web:
                cur_tab = TAB_WEB;
                break;
            case R.id.main_menu_it_blog:
                cur_tab = TAB_BLOG;
                break;
            case R.id.main_menu_it_collect:
                cur_tab = TAB_COLLECT;
                break;
            case R.id.main_menu_it_me:
                cur_tab = TAB_ME;
                break;
        }
        NotifyTabChange(cur_tab);
    }
}
