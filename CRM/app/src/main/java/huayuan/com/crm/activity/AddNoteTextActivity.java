package huayuan.com.crm.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.yanzhenjie.album.Album;

import java.io.File;
import java.util.ArrayList;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import huayuan.com.crm.R;
import okhttp3.Call;
import okhttp3.Response;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;




public class AddNoteTextActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView image_title_back,image_title_right;
    private LinearLayout linear_uploadimg;

    private static final int ACTIVITY_REQUEST_SELECT_PHOTO = 100;
    private static final int ACTIVITY_REQUEST_TAKE_PICTURE = 101;
    private static final int ACTIVITY_REQUEST_PREVIEW_PHOTO = 102;

    private ArrayList<String> mImageList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note_text);
        initview();
        adpaterOneStep();


    }

    private void adpaterOneStep(){
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {//文字
                String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
                if (sharedText != null) {
                    Log.e("","");
                }
            } else if (type.startsWith("image/")) {//单张图片和文字
                String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
                if (sharedText != null) {
                    Log.e("","");
                }
                Uri imageUri = intent.getParcelableExtra(Intent.EXTRA_STREAM);
                Log.e("","");

            }
        } else if (Intent.ACTION_SEND_MULTIPLE.equals(action) && type != null) {//多张图片
            if (type.startsWith("image/")) {
                ArrayList<Uri> imageUris = intent.getParcelableArrayListExtra(Intent.EXTRA_STREAM);
                for (Uri uri : imageUris) {
                    Log.e("","");
                }
            }
        }
    }

    private void initview(){
        image_title_back = (ImageView) findViewById(R.id.image_title_back);
        image_title_right = (ImageView) findViewById(R.id.image_title_right);
        image_title_right.setVisibility(View.GONE);
        TextView tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("新增笔记");
        linear_uploadimg = (LinearLayout) findViewById(R.id.linear_uploadimg);
        linear_uploadimg.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.linear_uploadimg:
                Album.album(AddNoteTextActivity.this)
                        .requestCode(999) // Request code.
                        .toolBarColor(ContextCompat.getColor(this, R.color.colorPrimary)) // Toolbar color.
                        .statusBarColor(ContextCompat.getColor(this, R.color.colorPrimary)) // StatusBar color.
                        .navigationBarColor(ContextCompat.getColor(this, R.color.colorPrimary)) // NavigationBar color.
                        .title("相册") // Title.

                        .selectCount(1) // Choose up to a few pictures.
                        .columnCount(2) // Number of albums.
                        .camera(true) // Have a camera function.
                        .checkedList(mImageList) // Has selected the picture, automatically select.
                        .start();

                break;
        }
    }


    public static String decrypt(String cipherText, String key, String iv) {
        try {

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes("utf-8"), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes("utf-8"));

            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);

            byte[] decrypted = cipher.doFinal(Base64.decode(cipherText.getBytes(),Base64.DEFAULT));
            return new String(decrypted, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 999) {
            if (resultCode == RESULT_OK) { // Successfully.
                // Parse select result.
                ArrayList<String> imageList = Album.parseResult(data);
                Luban.get(this)
                        .load( new File(imageList.get(0)))                     //传人要压缩的图片
                        .putGear(Luban.THIRD_GEAR)      //设定压缩档次，默认三挡
                        .setCompressListener(new OnCompressListener() { //设置回调

                            @Override
                            public void onStart() {
                                // TODO 压缩开始前调用，可以在方法内启动 loading UI
                            }
                            @Override
                            public void onSuccess(File file) {
                                // TODO 压缩成功后调用，返回压缩后的图片文件
                                OkGo.post("http://120.26.113.9:8080/users/upload ")//
                                        .tag(this)//
                                        .isMultipart(true)       // 强制使用 multipart/form-data 表单上传（只是演示，不需要的话不要设置。默认就是false）
                                        .params("image", "paramValue1") 		// 这里可以上传参数
                                        .params("url",file)   // 可以添加文件上传
                                        .execute(new StringCallback() {


                                            @Override
                                            public void onSuccess(String s, Call call, Response response) {

                                                try {
//                                                    String a =AesEncryptionUtil.desEncrypt(s);
                                                    String a = decrypt(s,"1111111111111111","0123456789abcdef");
                                                    Log.e("","");
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }


                                            }
                                        });
                            }

                            @Override
                            public void onError(Throwable e) {
                                // TODO 当压缩过去出现问题时调用
                            }
                        }).launch();    //启动压缩




                Log.e("","");
            } else if (resultCode == RESULT_CANCELED) {
                // User canceled.
            }
        }

    }
}
