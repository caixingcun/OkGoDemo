## 基于 OkGo 的二次封装

## OkGo  有 okgo okrx okrx2等  这里只是将 okgo部分拿出来用


## 使用步骤

 # 3. 代码调用
       /**

         * @param url 请求地址
         * @param tag  用于取消请求
         * @param map  参数键值对
         * @param callback 回调
         * @param <T>  返回类型
         */
      OkUtil.getRequets("http://192.168.1.79:3000/okgo_get", this, new HashMap<String, String>(), new JsonCallback<ResponseBean<SimpleBean>>() {
                @Override
                public void onSuccess(Response<ResponseBean<SimpleBean>> response) {

                    mTv.setText(response.body().Result.getName() + "-" + response.body().Result.getHabby());
                }
            });