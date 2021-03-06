package com.yfeng.payutil.paypwd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yfeng.payutil.paypwd.listener.OnPwdInputListener;
import com.yfeng.payutil.paypwd.view.PasswordInputView;

public class MainActivity extends AppCompatActivity {

    private Button btnShowPwdDialog;
    private PasswordInputView pwdInputView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }


    /**
     * 初始化视图
     */
    private void initView() {
        btnShowPwdDialog = (Button) findViewById(R.id.btn_show_pwd_dialog);
    }

    /**
     * 初始化事件
     */
    private void initEvent() {
        pwdInputView = new PasswordInputView(MainActivity.this);
        btnShowPwdDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pwdInputView.show();
            }
        });
        pwdInputView.setOnPwdInputListener(new OnPwdInputListener() {
            @Override
            public void onPwdInput(String password) {
                Toast.makeText(MainActivity.this, password, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
