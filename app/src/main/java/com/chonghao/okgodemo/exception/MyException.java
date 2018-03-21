package com.chonghao.okgodemo.exception;

import com.chonghao.okgodemo.bean.BaseResponseBean;
import com.google.gson.Gson;

/**
 * Created by ccb on 2017/12/7.
 */

public class MyException extends IllegalStateException {

    private BaseResponseBean errorBean;

    public MyException(String s) {
        super(s);
        errorBean = new Gson().fromJson(s, BaseResponseBean.class);
    }

    public BaseResponseBean getErrorBean() {
        return errorBean;
    }
}
