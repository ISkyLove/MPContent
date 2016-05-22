package lc.mpcontent.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by lin on 16-5-22.
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
    public View rootView;
    public BaseViewHolder(View itemView) {
        super(itemView);
        rootView = itemView;
    }
}
