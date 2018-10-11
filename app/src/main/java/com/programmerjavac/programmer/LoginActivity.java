package com.programmerjavac.programmer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText editTextusername,editTextpassword;
    Button buttonLogin,buttonSignup;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextusername=findViewById(R.id.editText_username);
        editTextpassword=findViewById(R.id.editText_password);
        buttonLogin=findViewById(R.id.button_Login);
        buttonSignup=findViewById(R.id.button_Signup);

        dbHelper=new DBHelper(LoginActivity.this);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (editTextusername.getText().toString().equals(""))
                {
                    editTextusername.setError("Email Required!");
                }
                else if (editTextpassword.getText().toString().equals(""))
                {
                    editTextpassword.setError("Password Required");
                }
                else
                {
                    boolean success=dbHelper.checkUser(
                            editTextusername.getText().toString(),
                            editTextpassword.getText().toString());
                    if (success)
                    {
                        Toast.makeText(LoginActivity.this, "successfully login", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(LoginActivity.this,ContentActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, "invalid user!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
