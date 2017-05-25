package huayuan.com.crm.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import huayuan.com.crm.R;
import huayuan.com.crm.activity.AddNoteTextActivity;
import huayuan.com.crm.adapter.remarkAdapter;

/**
 * 备注
 *
 *
 */
public class remarksFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private ListView list_remarks;
    private remarkAdapter adapter;
    private FloatingActionButton btn_addschedule;

    private ImageView image_title_back,image_title_right;

    public remarksFragment() {

    }
    public static remarksFragment newInstance(String param1, String param2) {
        remarksFragment fragment = new remarksFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_remarks, container, false);
        initview(view);
        return view;
    }

    private void initview(View view) {
        list_remarks = (ListView) view.findViewById(R.id.list_remarks);
        adapter = new remarkAdapter(getActivity());
        list_remarks.setAdapter(adapter);
        image_title_back = (ImageView) view.findViewById(R.id.image_title_back);
        image_title_right = (ImageView) view.findViewById(R.id.image_title_right);
        image_title_back.setVisibility(View.GONE);
        TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_title.setText("备注");
        btn_addschedule = (FloatingActionButton) view.findViewById(R.id.btn_addschedule);
        btn_addschedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newNote = new Intent(getActivity(), AddNoteTextActivity.class);
                startActivity(newNote);
            }
        });
    }

}
