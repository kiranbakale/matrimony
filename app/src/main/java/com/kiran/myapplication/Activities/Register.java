package com.kiran.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.kiran.myapplication.Api;
import com.kiran.myapplication.Fragments.Suggested_user;
import com.kiran.myapplication.PreferenceHelper;
import com.kiran.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Register extends AppCompatActivity{

    private EditText etname,etusername,etemail,etpass;
    private Button btnregister;
    private TextView tvlogin;
    private PreferenceHelper preferenceHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        getSupportActionBar().hide();

        preferenceHelper = new PreferenceHelper(this);

        if(preferenceHelper.getIsLogin()){
            Intent intent = new Intent(Register.this, Suggested_user.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            this.finish();
        }

        etname = (EditText) findViewById(R.id.etname);
        etusername = (EditText) findViewById(R.id.etusername);
        etemail = (EditText) findViewById(R.id.etemail);
        etpass = (EditText) findViewById(R.id.etpass);
        btnregister = (Button) findViewById(R.id.btnregister);
        tvlogin = (TextView) findViewById(R.id.tvlogin);

//        if(etname.getText().toString().isEmpty()) {
//            Toast.makeText(this, "plz enter your name ", Toast.LENGTH_SHORT).show();
//        } if(etusername.getText().toString().isEmpty()) {
//            Toast.makeText(this, "plz enter your username ", Toast.LENGTH_SHORT).show();
//        } if(etemail.getText().toString().isEmpty()) {
//            Toast.makeText(this, "plz enter your email ", Toast.LENGTH_SHORT).show();
//        } if(etpass.getText().toString().isEmpty()) {
//            Toast.makeText(this, "plz enter your password", Toast.LENGTH_SHORT).show();
//        }
        tvlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this,Login.class);
                startActivity(intent);
                Register.this.finish();
            }
        });

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this,Login.class);
                startActivity(intent);

                Toast.makeText(Register.this, "Registered", Toast.LENGTH_SHORT).show();
//                registerMe();
            }
        });

    }

    private void registerMe() {

        final String name = etname.getText().toString();
        final String email = etemail.getText().toString();
        final String password = etpass.getText().toString();
        final String username = etusername.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.REGIURL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<String> call = api.getUserRegi(name,username,email,password);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("Responsestring", response.body().toString());
                //Toast.makeText()
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.i("onSuccess", response.body().toString());

                        String jsonresponse = response.body().toString();
                        try {
                            parseRegData(jsonresponse);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    } else {
                        Log.i("onEmptyResponse", "Returned empty response");//Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }

    private void parseRegData(String response) throws JSONException {

        JSONObject jsonObject = new JSONObject(response);
        if (jsonObject.optString("status").equals("true")){

            saveInfo(response);

            Toast.makeText(Register.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Register.this, Suggested_user.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            this.finish();
        }else {

            Toast.makeText(Register.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
        }
    }

    private void saveInfo(String response){

        preferenceHelper.putIsLogin(true);
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.getString("status").equals("true")) {
                JSONArray dataArray = jsonObject.getJSONArray("data");
                for (int i = 0; i < dataArray.length(); i++) {

                    JSONObject dataobj = dataArray.getJSONObject(i);
                    preferenceHelper.putName(dataobj.getString("fullname"));
                    preferenceHelper.putUsername(dataobj.getString("username"));
                    preferenceHelper.putEmail(dataobj.getString("email"));

                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
