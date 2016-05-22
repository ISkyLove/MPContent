package lc.mpcontent.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import lc.mpcontent.R;
import lc.mpcontent.base.BaseRVAdapter;
import lc.mpcontent.base.BaseViewHolder;
import lc.mpcontent.bean.WebBean;

/**
 * Created by lin on 16-5-22.
 */
public class WebAdapter extends BaseRVAdapter<WebBean>{


    public WebAdapter(Context context, List<WebBean> data) {
        super(context, data);
    }

    @Override
    protected int getItemLayoutID() {
        return R.layout.web_item_layout;
    }

    @Override
    protected BaseViewHolder getViewHolder(View itemview) {
        return new WebHolderView(itemview);
    }

    @Override
    protected void BindItem(BaseViewHolder holder, WebBean webBean) {
        WebHolderView mWebHV = (WebHolderView) holder;
        mWebHV.title.setText(webBean.getTitle());
    }


    public class WebHolderView extends  BaseViewHolder{

        public ImageView img;
        public TextView title;

        public WebHolderView(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.web_item_img);
            title = (TextView) itemView.findViewById(R.id.web_item_tx);
        }
    }
}
