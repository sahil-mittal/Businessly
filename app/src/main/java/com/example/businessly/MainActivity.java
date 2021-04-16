package com.example.businessly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.businessly.CustomerLoginActivity;

public class MainActivity extends AppCompatActivity {

    public void customerLogin()
    {
        Intent intent=new Intent(this, CustomerSignInActivity.class);
        startActivity(intent);
        finish();
    }

    public void shopLogin()
    {
        Intent intent=new Intent(this,ShopLogin.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.shop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shopLogin();
            }
        });

        findViewById(R.id.customer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customerLogin();
            }
        });
        /*Button closeButton = (Button) findViewById(R.id.shop);
        closeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // TODO:
                // This function closes Activity Two
                // Hint: use Context's finish() method
                finish();
            }
        });*/

    }
}