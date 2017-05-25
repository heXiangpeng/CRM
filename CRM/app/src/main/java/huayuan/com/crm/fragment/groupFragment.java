package huayuan.com.crm.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.Utils;

import huayuan.com.crm.R;
import huayuan.com.crm.adapter.groupAdapter;
import huayuan.com.crm.adapter.groupItemDecoration;

/**
 * 小组
 */
public class groupFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private RecyclerView recy_group;
    private groupAdapter adapter;

    private ImageView image_title_back,image_title_right;

    public groupFragment() {

    }

    public static groupFragment newInstance(String param1, String param2) {
        groupFragment fragment = new groupFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_group, container, false);
        initview(view);
        initdata();
        return view;
    }

    private void initview(View view){
        recy_group = (RecyclerView) view.findViewById(R.id.recy_group);
        image_title_back = (ImageView) view.findViewById(R.id.image_title_back);
        image_title_right = (ImageView) view.findViewById(R.id.image_title_right);
        image_title_right.setImageResource(R.mipmap.set);
        image_title_back.setVisibility(View.GONE);
        TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_title.setText("我的");

    }

    private void initdata(){
        adapter = new groupAdapter(getContext());
        Utils.init(getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recy_group.addItemDecoration(new groupItemDecoration());
        recy_group.setLayoutManager(layoutManager);
        recy_group.setAdapter(adapter);
    }

}
