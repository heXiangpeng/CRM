package huayuan.com.crm.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import huayuan.com.crm.R;


/**
 * 新增日程
 */

public class AddNewSchelduleActivity extends AppCompatActivity {

    private ImageView image_title_back,image_title_right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_scheldule);
        try {
            initview();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    private void initview() throws Exception{


        image_title_back = (ImageView) findViewById(R.id.image_title_back);
        image_title_right = (ImageView) findViewById(R.id.image_title_right);
        image_title_right.setVisibility(View.GONE);
        TextView tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("新增日程");






    }
}
