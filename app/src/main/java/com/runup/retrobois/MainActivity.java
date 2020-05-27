package com.runup.retrobois;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.runup.retrobois.helper.RetroClient;
import com.runup.retrobois.helper.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText user, password;
    Retrofit retrofit;
    Button getToken;
    TextView myToken;
    String baseUrl = "http://ardhymax.site/api/";
    RetroClient mRetroClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRetroClient = new RetrofitClient().getClient().create(RetroClient.class);
        user = findViewById(R.id.user);
        password = findViewById(R.id.password);
        getToken = findViewById(R.id.btnToken);
        myToken = findViewById(R.id.myToken);
        getToken.setOnClickListener(v -> {
//            Login log = new Login(user.getText().toString(), password.getText().toString());
//            Retrofit.Builder builder = new Retrofit.Builder().baseUrl(baseUrl).
//                    addConverterFactory(GsonConverterFactory.create());
//            retrofit = builder.build();
//            RetroClient client = retrofit.create(RetroClient.class);
//            Call<ModelSuccess> call = client.loginA(log);
//            try {
//                call.enqueue(new Callback<ModelSuccess>() {
//                    @Override
//                    public void onResponse(Call<ModelSuccess> call, Response<ModelSuccess> response) {
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<ModelSuccess> call, Throwable t) {
//
//                    }
//                });
//
//            }catch (Exception e){
//                Log.i("Error",e.getMessage());
//            }
            Call<ModelSuccess> postKontakCall = mRetroClient.loginA(new Login(user.getText().toString(), password.getText().toString()));
            postKontakCall.enqueue(new Callback<ModelSuccess>() {
                @Override
                public void onResponse(Call<ModelSuccess> call, Response<ModelSuccess> response) {
//                    myToken.setText();
                    finish();
                }

                @Override
                public void onFailure(Call<ModelSuccess> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Error Bous", Toast.LENGTH_LONG).show();
                }
            });
        });
    }
}
