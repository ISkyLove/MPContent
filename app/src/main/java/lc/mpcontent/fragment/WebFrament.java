package lc.mpcontent.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.thefinestartist.finestwebview.FinestWebView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import lc.mpcontent.R;
import lc.mpcontent.adapter.WebAdapter;
import lc.mpcontent.android.AsyncTask;
import lc.mpcontent.base.BaseFragment;
import lc.mpcontent.base.BaseRVAdapter;
import lc.mpcontent.bean.WebBean;
import lc.mpcontent.utils.parser.BaseSAXParser;
import lc.mpcontent.utils.parser.WebDomParser;
import lc.mpcontent.utils.parser.WebSAXHandler;


/**
 * Created by lin on 16-5-22.
 */
public class WebFrament extends BaseFragment implements BaseRVAdapter.OnRVItemClickListen{

    RecyclerView mRecyclerView;
    WebAdapter mWebAdapter;
    List<WebBean> mdatas;
    private static final String WEB_XML_NAME = "webs.xml";

    @Override
    protected void initView() {
        mRecyclerView = (RecyclerView) mRootView.findViewById(R.id.web_data_view);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 3);
        mdatas = new ArrayList<WebBean>();
//        for(int i=0;i<20;i++){
//            WebBean item =new WebBean();
//            item.setTitle("me");
//            mdatas.add(item);
//        }
        mWebAdapter = new WebAdapter(getActivity(), mdatas);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mWebAdapter);


        try {
            new AsynXmlTask().execute(getResources().getAssets().open(WEB_XML_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void initEvent() {
        mWebAdapter.setOnRVItemClickListen(this);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.web_fragment_layout;
    }

    @Override
    public void OnRVItemClick(int position) {
        if(mdatas!=null&&mdatas.size()>position){
            WebBean item = mdatas.get(position);
            new FinestWebView.Builder(getActivity())
                    .titleDefault("MPContent")
                    .show(item.getUrl());
        }
    }

    public class AsynXmlTask extends AsyncTask<InputStream, Void, List> {

        @Override
        protected List doInBackground(InputStream... params) {
            InputStream xml = params[0];
            try {
                WebDomParser mParser = new WebDomParser();
                return mParser.getDataList(xml);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List list) {
            mdatas.clear();
            mdatas.addAll(list);
            if (mdatas != null && mdatas.size() > 0) {
                mWebAdapter.notifyDataSetChanged();
            }
        }
    }

}
