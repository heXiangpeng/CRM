package huayuan.com.crm.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import huayuan.com.crm.R;

/**
 * Created by lenovo on 2017/5/16.
 */

public class groupAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static enum group_TYPE {
        ITEM_TYPE_head,
        ITEM_TYPE_foot
    }

    private LayoutInflater layoutInflater;
    private Context context;
    private String[] titles = {"开启团队","团队简报","团队资料","添加成员","人事变更","我的客服","我要反馈","安全退出"};

    public groupAdapter(Context context){
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){

            return group_TYPE.ITEM_TYPE_head.ordinal();
        }else{

            return group_TYPE.ITEM_TYPE_foot.ordinal();
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == group_TYPE.ITEM_TYPE_head.ordinal()){
            return new headViewHolder(layoutInflater.inflate(R.layout.group_headname,parent,false));

        }else{
            return new footViewHolder(layoutInflater.inflate(R.layout.group_setitem,parent,false));

        }
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof headViewHolder){

        }else if(holder instanceof footViewHolder){

            ((footViewHolder) holder).tv_setname.setText(titles[position-1]);

        }

    }

    @Override
    public int getItemCount() {
        return 9;
    }

    public static class headViewHolder extends RecyclerView.ViewHolder{
       public headViewHolder(View view){
           super(view);
        }

    }

    public static class footViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_setname;
        public footViewHolder(View view){
            super(view);
            tv_setname =(TextView) view.findViewById(R.id.tv_setname);
        }

    }
}
