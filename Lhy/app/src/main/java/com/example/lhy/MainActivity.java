package com.example.lhy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView iv;
    boolean isChanged =true;
    EditText ed_get;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_send=findViewById(R.id.button);
        iv= findViewById(R.id.imageView);
        ed_get=findViewById(R.id.editText);
        btn_send.setOnClickListener(this);
    }
    public void onClick(View v) {
        String text = ed_get.getText().toString();
        Log.i("lhy", text);
        if (text.equals("lhy")) {
            if (isChanged) {
                iv.setImageResource(R.drawable.ly);
                Toast.makeText(this, "刘浩宇的壁纸已切换", Toast.LENGTH_LONG).show();
                //time(3000);
            }
            else {
                iv.setImageResource(R.drawable.lhy);
                Toast.makeText(this, "刘浩宇的壁纸已切换", Toast.LENGTH_LONG).show();
            }
        }
        else {
            ed_get.setText(null);
            Toast.makeText(this, "密码错误！\n"+"请重新输入密码", Toast.LENGTH_LONG).show();

        }
        isChanged = !isChanged;

    }

    public void time(int t){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ed_get.setText(null);
                iv.setImageResource(R.drawable.bz);
            }
        }, t);//ms后执行Runnable中的run方法
    }
}
