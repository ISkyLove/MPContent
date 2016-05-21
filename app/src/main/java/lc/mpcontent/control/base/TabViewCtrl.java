package lc.mpcontent.control.base;

import android.view.View;

/**
 * Created by lin on 16-5-21.
 */
public abstract class TabViewCtrl {


    protected View mTabsView;

    protected onTabChangeListen mTabChangeListen;

    protected int cur_tab = 0;

    public interface  onTabChangeListen{
        void OnTabChange(int tab);
    }

    /**
     * listen to inline tab change
     * @param listen
     */
    public void setOnTabChangeListen(onTabChangeListen listen){
        this.mTabChangeListen = listen;
    }

    protected abstract void initView();

    protected abstract void initEvent();

    /**
     * outline notify the tab has change
     * @param tab
     */
    public abstract void NotifyTabChange(int tab);

    protected abstract void initAllTab();

    protected abstract void setTabSelect(int tab);

    public View getTabsView(){
        return mTabsView;
    }

    public int getSelectTab(){
        return cur_tab;
    }

}
