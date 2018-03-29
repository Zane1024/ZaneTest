package com.example.em.mi.pig.com.shohuodizi;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.em.mi.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.em.mi.bean.URL.url;

/**
 * 登录界面
 * Created by Administrator on 2017-07-10.
 * login_but 登录按钮
 * login_username 账号
 * login_pwd 密码
 */

public class Login_J extends Activity implements View.OnClickListener {
    private Button login_but;
    private EditText login_username, login_pwd;
    private List<NameValuePair> params;
    //提示框
    private ProgressDialog dialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        dialog=new ProgressDialog(this);
        dialog.setTitle("提示");
        dialog.setMessage("正在登录,请稍候...");

        login_but = (Button)findViewById(R.id.login_but);
        login_username = (EditText)findViewById(R.id.login_username);
        login_pwd = (EditText)findViewById(R.id.login_pwd);


        login_username.setOnClickListener(this);
        login_pwd.setOnClickListener(this);
        login_but.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {


        params = new ArrayList<NameValuePair>();

        Map<String, String> params=new HashMap<String, String>();
        params.put("url", url);
        params.put("userName", "c1000001");
        params.put("password", "abc123");

        switch (view.getId()){
            case R.id.login_but:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //获取 账号 密码
                            String name =  login_username.getText().toString();
                            String pwd =  login_pwd.getText().toString();

                            //创建请求对象里的参数
                            List<NameValuePair> paras = new ArrayList<NameValuePair>();
                            //创建参数容器
                            BasicNameValuePair username = new BasicNameValuePair("userName", name);
                            BasicNameValuePair userpsw = new BasicNameValuePair("password", pwd);
                            //将参数放入list表中
                            paras.add(username);
                            paras.add(userpsw);
                            String names = doPost(paras,url);
                            Log.d("name","name_________________"+name);
                            //JSON解析
                            //parseJSONWithJSONObject(names);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                try {
                    //new Mysy().execute("c1000001","abc123");
                    //String names = doPost(paras,url);
                    //Toast.makeText(this,"登录"+names,Toast.LENGTH_SHORT).show();
                    //parseJson(json);
                } catch (Exception e) {
                    Toast.makeText(this,"登录失败",Toast.LENGTH_SHORT).show();
                    Log.i("e","eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"+e);
                    e.printStackTrace();
                }
                break;
        }
    }

    /**
     * 访问数据库并返回JSON数据字符串
     *
     * @param params 向服务器端传的参数
     * @param url
     * @return
     * @throws Exception
     */
    public String doPost(List<NameValuePair> params, String url)
            throws Exception {
        String result = null;
        // 获取HttpClient对象
        HttpClient httpClient = new DefaultHttpClient();
        // 新建HttpPost对象
        HttpPost httpPost = new HttpPost(url);
        if (params != null) {
            // 设置字符集
            HttpEntity entity = new UrlEncodedFormEntity(params, HTTP.UTF_8);
            // 设置参数实体
            httpPost.setEntity(entity);
        }

         /*// 连接超时
         httpClient.getParams().setParameter(
                 CoreConnectionPNames.CONNECTION_TIMEOUT, 3000);
         // 请求超时
         httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,
                 3000);*/
        // 获取HttpResponse实例
        HttpResponse httpResp = httpClient.execute(httpPost);
        // 判断是够请求成功
        if (httpResp.getStatusLine().getStatusCode() == 200) {
            // 获取返回的数据
            result = EntityUtils.toString(httpResp.getEntity(), "UTF-8");
        } else {
            Log.i("HttpPost", "HttpPost方式请求失败");
        }
        Log.i("result", "--------------------result--------------parseJSONWithJSONObject(result)-------"+result);
        return result;
    }

//网络请求  成功Demo
 /*class Mysy extends AsyncTask{
    //定义一个变量用于保存服务器返回来的信息
    public  String result="";

    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        super.onPreExecute();
        //显示进度条
        dialog.show();
    }
    @Override
    protected Object doInBackground(Object... arg0) {
        // TODO Auto-generated method stub
        String name = arg0[0].toString();
        String psw = arg0[1].toString();
        Log.i("用户信息", name+","+psw);
        if(TextUtils.isEmpty(name)!=true && TextUtils.isEmpty(psw)!=true){
            Log.i("用户信息1", name+","+psw);
            //给发服务器发送请求
            HttpPost request = new HttpPost(url);
            //创建请求对象里的参数
            List<NameValuePair> paras = new ArrayList<NameValuePair>();
            //创建参数容器
            BasicNameValuePair username = new BasicNameValuePair("userName", name);
            BasicNameValuePair userpsw = new BasicNameValuePair("password", psw);
            //将参数放入list表中
            paras.add(username);
            paras.add(userpsw);
            //创建一个请求的标识
            BasicNameValuePair flag = new BasicNameValuePair("flag", "1");
            paras.add(flag);
            try {
                //创建数据实体
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paras, "GBK");
                //将数据实体放入到请求对象里
                request.setEntity(entity);
                //创建http的客户对象
                DefaultHttpClient dhc = new DefaultHttpClient();
                //创建一个响应对象用于接收服务器返回的信息
                HttpResponse response =  dhc.execute(request);
                //定义一个变量保存连接服务器的状态
                int status = response.getStatusLine().getStatusCode();
                //根据状态码的值判断服务器是否连接成功
                if(status==200){
                    //定义一个字节流数据用于保存从相应对象中解释出来的数据
                    byte b[] = new byte[2048];
                    //获取相应对象中的数据
                    b = EntityUtils.toByteArray(response.getEntity());
                    //将字节流转换成字符串
                    result = new String(b,"UTF-8");
                    //Analysis(result);
                }
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ClientProtocolException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        Log.i("result", "--------------------------------------------,"+result);

        return result;
    }

    @Override
    protected void onPostExecute(Object result) {
        // TODO Auto-generated method stub
        super.onPostExecute(result);
        dialog.dismiss();
        Log.i("","result______"+result);
        //tv_tips.setText(result.toString());
    }

}*/
    /**
     * 解析
     *
     * @throws JSONException
     */
    private void parseJSONWithJSONObject(String jsonData) {
        try {

            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String result = jsonObject.getString("result");
                String message = jsonObject.getString("message");
                Log.d("result", "result is " + result);
                Log.d("message", "message is " + message);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
