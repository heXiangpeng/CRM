package huayuan.com.crm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;




import huayuan.com.crm.R;

/**
 * Created by lenovo on 2017/5/9.
 */

public class scheduleAdapter extends BaseAdapter {
    private LayoutInflater mInflater = null;

    private Context context;
    public scheduleAdapter(Context context)
    {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 40;
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
        ViewHolder holder;
        if(convertView == null)
        {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.schedule_item, null);
//            holder.img = (ImageView)item.findViewById(R.id.img)
//            holder.title = (TextView)item.findViewById(R.id.title);
//            holder.info = (TextView)item.findViewById(R.id.info);
            convertView.setTag(holder);
        }else
        {
            holder = (ViewHolder)convertView.getTag();
//            holder.img.setImageResource(R.drawable.ic_launcher);
//            holder.title.setText("Hello");
//            holder.info.setText("World");
        }

        return convertView;
    }
    static class ViewHolder
    {
        public ImageView img;
        public TextView title;
        public TextView info;
    }
}
