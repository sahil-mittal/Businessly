package com.example.businessly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;
    public void customerLogin(View view)
    {

    }

    public void shopLogin()
    {
        Intent intent=new Intent(this,ShopLogin.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button) findViewById(R.id.shop);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shopLogin();
            }
        });
    }
}