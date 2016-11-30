package com.juserzhang.android_dialog_toasts;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.juserzhang.android_dialog_toasts.CustomDialog.CallBack;

public class MainActivity extends Activity {

    private Button button;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                CustomDialog dialog = new CustomDialog(MainActivity.this);
                dialog.createDialog("确定", "提示", "您确定要删除吗？", new CallBack() {
                    @Override
                    public void isConfirm(boolean flag) {
                        // TODO Auto-generated method stub
                        System.out.println("----->>" + flag);
                        if (flag) {
                            //dosomething.....判断执行业务逻辑
                        }
                    }
                });
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                CustomDialog dialog = new CustomDialog(MainActivity.this);
                // LayoutInflater layoutInflater = getLayoutInflater();
                dialog.createToasts("网络有有异常!!", getLayoutInflater());

            }
        });
    }

    private void init() {
        button = (Button) this.findViewById(R.id.button1);
        button2 = (Button) this.findViewById(R.id.button2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
