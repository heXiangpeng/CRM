package huayuan.com.crm.adapter;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blankj.utilcode.util.SizeUtils;

/**
 * Created by lenovo on 2017/5/16.
 */

public class groupItemDecoration extends RecyclerView.ItemDecoration {
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if(parent.getChildAdapterPosition(view)==1){
            outRect.top = SizeUtils.dp2px(20);
        }
        if(parent.getChildAdapterPosition(view)>1 && parent.getChildAdapterPosition(view)<6){
            outRect.top = 3;
        }
        if(parent.getChildAdapterPosition(view)==6){
            outRect.top = SizeUtils.dp2px(20);
        }
        if(parent.getChildAdapterPosition(view)>6){
            outRect.top = SizeUtils.dp2px(10);
        }
    }
}
