package lc.mpcontent.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by lin on 16-5-22.
 */
public abstract class BaseRVAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {

    protected List<T> mDatas;
    protected Context mContext;

    public interface OnRVItemClickListen{
        void OnRVItemClick(int position);
    }

    protected OnRVItemClickListen mrvItemClickListen;

    public void setOnRVItemClickListen(OnRVItemClickListen listen){
        mrvItemClickListen = listen;
    }

    public BaseRVAdapter(Context context,List<T> data){
        mDatas = data;
        mContext = context;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(mContext).inflate(getItemLayoutID(),null);
        return getViewHolder(root);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, final int position) {
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mrvItemClickListen!=null){
                    mrvItemClickListen.OnRVItemClick(position);
                }
            }
        });
        BindItem(holder, mDatas.get(position));
    }


    @Override
    public int getItemCount() {
        if(mDatas!=null){
            return mDatas.size();
        }
        return 0;
    }

    protected abstract int getItemLayoutID();

    protected abstract BaseViewHolder getViewHolder(View itemview);

    protected abstract void BindItem(BaseViewHolder holder,T t);
}
