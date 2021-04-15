package com.example.exercisepam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bLogin;
    EditText tEmail, tPassword;
    String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bLogin = findViewById(R.id.bLogIn);
        tEmail = findViewById(R.id.inputmail);
        tPassword = findViewById(R.id.inputpass);

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = tEmail.getText().toString();
                password = tPassword.getText().toString();

                String mail = "admin@mail.com";
                String pass = "123456";

                if (email.equals(mail) && password.equals(pass)) {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Login Sukses!", Toast.LENGTH_LONG);
                    t.show();

                    Bundle b = new Bundle();
                    b.putString("a", email.trim());
                    b.putString("b", password.trim());

                    Intent i = new Intent(getApplicationContext(), Home.class);
                    i.putExtras(b);
                    startActivity(i);
                } else {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email atau Password Salah!", Toast.LENGTH_LONG);
                    t.show();
                }

                if (tEmail.getText().toString().length() == 0) {
                    tEmail.setError("Email Tidak Boleh Kosong");
                }

                if (tPassword.getText().toString().length() == 0) {
                    tPassword.setError("Password Tidak Boleh Kosong");

                } else if (tPassword.getText().toString().length() < 6) {
                    tPassword.setError("Panjang Password Minimal 6 Huruf");
                }
            }
        });
    }

    public void BelumTerdaftar(View view) {
        Intent intent = new Intent(MainActivity.this, Pendaftaran.class);
        startActivity(intent);
    }
}

