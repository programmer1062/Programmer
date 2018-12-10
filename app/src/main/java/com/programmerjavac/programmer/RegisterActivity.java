package com.programmerjavac.programmer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText editTextusername,editTextpassword,editTextconfirmpassword;
    Button buttonSignup,buttonLogin;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextusername=findViewById(R.id.editText_username);
        editTextpassword=findViewById(R.id.editText_password);
        editTextconfirmpassword=findViewById(R.id.editText_confirmpassword);
        buttonSignup=findViewById(R.id.button_Signup);
        buttonLogin=findViewById(R.id.button_Login);

        dbHelper=new DBHelper(RegisterActivity.this);

        buttonSignup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (editTextusername.getText().toString().equals(""))
                {
                    editTextusername.setError("UserName Required!");
                }
                else if (editTextpassword.getText().toString().equals(""))
                {
                    editTextpassword.setError("Password Required!");
                }
                else if (editTextconfirmpassword.getText().toString().equals(""))
                {
                    editTextconfirmpassword.setError("Required!");
                }
                else if (!editTextpassword.getText().toString().equals(editTextconfirmpassword.getText().toString()))
                {
                    editTextpassword.setError("Password don't match!");
                }
                else
                {
                    boolean success=dbHelper.saveUser(editTextusername.getText().toString(),editTextpassword.getText().toString());
                    if (success)
                    {
                        Toast.makeText(RegisterActivity.this, "Registered User", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(RegisterActivity.this, "Already Registered!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        buttonLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
