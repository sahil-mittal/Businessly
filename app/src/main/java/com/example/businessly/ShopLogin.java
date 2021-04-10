package com.example.businessly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ShopLogin extends AppCompatActivity
{
    private  EditText name;
    private EditText password;
    private  TextView info;
    private Button login;
    private  int counter=5;
    @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_shop_login);
            name=(EditText)findViewById(R.id.txtShopId);
            password=(EditText)findViewById(R.id.txtShopPass);
            info=(TextView) findViewById(R.id.txtInfo);
            login=(Button)findViewById(R.id.btnShopLogin);

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    validate(name.getText().toString(),password.getText().toString());
                }
            });
        }
    private void validate(String userName,String userPass)
    {
        if(userName.equals("Admin") && userPass.equals("admin"))
        {
            Intent intent=new Intent(ShopLogin.this,ShopDashBoard.class);
            startActivity(intent);
        }
        else
        {
            counter--;

            info.setText("No. of attempts remaining: "+String.valueOf(counter));

            if(counter==0)
            {
                login.setEnabled(false);
            }
        }
    }

}