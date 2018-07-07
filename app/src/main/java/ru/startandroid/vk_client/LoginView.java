package ru.startandroid.vk_client;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

import ru.startandroid.vk_client.View.UserPageView;

public class LoginView extends AppCompatActivity implements View.OnClickListener {

    Button btnEnter;
    TextView tvAppName, tvWarning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("FUCK", this.getClass().toString() + " created");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("FUCK", this.getClass().toString() + " resumed");
    }

    private void init() {
        findElements();
        initListeners();
    }
    private void initListeners() {
        btnEnter.setOnClickListener(this);
    }
    private void findElements() {
        btnEnter = (Button) findViewById(R.id.btnEnter);
        tvAppName = (TextView) findViewById(R.id.tvAppName);
        tvWarning = (TextView) findViewById(R.id.tvWarning);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnEnter:
            {
                String scope[] = {VKScope.FRIENDS};
                VKSdk.login(this, scope);
                startActivity(new Intent(getApplicationContext(), UserPageView.class));
            }

        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                // Пользователь успешно авторизовался
                res.saveTokenToSharedPreferences(getApplication(), "VK_TOKEN");

            }
            @Override
            public void onError(VKError error) {
                // Произошла ошибка авторизации (например, пользователь запретил авторизацию)
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
