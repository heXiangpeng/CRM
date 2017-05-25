package huayuan.com.crm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import huayuan.com.crm.MainActivity;
import huayuan.com.crm.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_login,btn_register;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initview();
    }
    private void initview(){
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_register = (Button) findViewById(R.id.btn_register);
        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                Intent main = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(main);

                break;

            case R.id.btn_register:
                Intent register = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(register);


                break;
        }

    }
}
