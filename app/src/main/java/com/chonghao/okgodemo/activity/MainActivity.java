package com.chonghao.okgodemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.chonghao.okgodemo.R;
import com.chonghao.okgodemo.bean.ResponseBean;
import com.chonghao.okgodemo.bean.SimpleBean;
import com.chonghao.okgodemo.callbck.JsonCallback;
import com.chonghao.okgodemo.net.OkUtil;
import com.lzy.okgo.model.Response;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTv = (TextView) findViewById(R.id.tv);
        getRequest();
    }

    private void getRequest() {
        OkUtil.getRequets("http://192.168.1.79:3000/okgo_get", this, new HashMap<String, String>(), new JsonCallback<ResponseBean<SimpleBean>>() {
            @Override
            public void onSuccess(Response<ResponseBean<SimpleBean>> response) {

                mTv.setText(response.body().Result.getName() + "-" + response.body().Result.getHabby());
            }
        });
    }
}
