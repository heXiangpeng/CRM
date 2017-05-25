package huayuan.com.crm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import huayuan.com.crm.R;

/**
 * Created by lenovo on 2017/5/16.
 */

public class remarkAdapter extends BaseAdapter{
    private Context context;
    private LayoutInflater mInflater = null;

    public remarkAdapter(Context context){
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        scheduleAdapter.ViewHolder holder;
        if(convertView == null)
        {
            holder = new scheduleAdapter.ViewHolder();
            convertView = mInflater.inflate(R.layout.item_remark, null);
//            holder.img = (ImageView)item.findViewById(R.id.img)
//            holder.title = (TextView)item.findViewById(R.id.title);
//            holder.info = (TextView)item.findViewById(R.id.info);
            convertView.setTag(holder);
        }else
        {
            holder = (scheduleAdapter.ViewHolder)convertView.getTag();
//            holder.img.setImageResource(R.drawable.ic_launcher);
//            holder.title.setText("Hello");
//            holder.info.setText("World");
        }

        return convertView;
    }

    static class ViewHolder
    {

        public TextView time;
        public TextView info;
    }
}
