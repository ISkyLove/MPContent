package lc.mpcontent.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lin on 16-5-22.
 */
public abstract class BaseFragment extends Fragment {

    protected View mRootView;

    protected abstract void initView();

    protected abstract void initEvent();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutID(),null);
        initView();
        initEvent();
        return mRootView;
    }

    protected abstract int getLayoutID();

    public View getRootView(){
        return mRootView;
    }
}
