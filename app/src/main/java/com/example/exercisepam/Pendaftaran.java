package com.example.exercisepam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Pendaftaran extends AppCompatActivity {
    EditText edtNama, edtAlamat, edtEmail, edtPassword, edtrepass;
    Button bdaftar, bbatal;
    RadioButton rblaki, rbpr, rbislam, rbhindu, rbpenganut,
            rbkatolik, rbbudha, rbkonghucu, rbkristen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran);

        edtNama = findViewById(R.id.ednama);
        edtAlamat = findViewById(R.id.edalamat);
        edtEmail = findViewById(R.id.edmail);
        edtPassword = findViewById(R.id.edpass);
        edtrepass = findViewById(R.id.edrepass);
        bdaftar = findViewById(R.id.daftar);
        bbatal = findViewById(R.id.batal);
        rblaki = findViewById(R.id.rbLaki);
        rbpr = findViewById(R.id.rbPerempuan);
        rbislam = findViewById(R.id.rbIslam);
        rbhindu = findViewById(R.id.rbHindu);
        rbpenganut = findViewById(R.id.rbPenganut);
        rbkatolik = findViewById(R.id.rbKatolik);
        rbbudha = findViewById(R.id.rbBudha);
        rbkonghucu = findViewById(R.id.rbKonghucu);
        rbkristen = findViewById(R.id.rbKristen);

        bdaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtNama.getText().toString().length() == 0) {
                    edtNama.setError("Nama Tidak Boleh Kosong");
                }

                if (edtAlamat.getText().toString().length() == 0) {
                    edtAlamat.setError("Alamat Tidak Boleh Kosong");
                }

                if (edtEmail.getText().toString().length() == 0) {
                    edtEmail.setError("Email Tidak Boleh Kosong");

                } else if (!Patterns.EMAIL_ADDRESS.matcher(edtEmail.getText().toString()).matches()){
                    edtEmail.setError("Mohon Masukkan Email yang Benar");
                }

                if (edtPassword.getText().toString().length() == 0) {
                    edtPassword.setError("Password Tidak Boleh Kosong");

                } else if (edtPassword.getText().toString().length() < 6) {
                    edtPassword.setError("Panjang Password Minimal 6 Huruf");
                }

                if (edtrepass.getText().toString().length() == 0) {
                    edtrepass.setError("Re-Password Tidak Boleh Kosong");

                } else if (!edtrepass.getText().toString().equals(edtPassword.getText().toString())){
                    edtrepass.setError("Password Tidak Sama");
                }

                if (edtPassword.length() != 0 && edtAlamat.length() != 0 && edtEmail.length() != 0
                        && edtPassword.length() != 0 && edtrepass.length() !=0 && edtPassword.length() >= 6
                        && edtPassword.getText() == edtPassword.getText()) {
                    Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil",
                            Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                }
            }
        });

        bbatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

    }
}