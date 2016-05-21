package lc.mpcontent.base;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by lin on 16-5-21.
 * base parents activity for all child acivity
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    public void finish() {
        super.finish();
       // overridePendingTransition();
    }

    protected  abstract void initView();
    protected  abstract void initEvent();
}
