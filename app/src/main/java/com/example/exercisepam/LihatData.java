package com.example.exercisepam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LihatData extends AppCompatActivity {
    TextView tvnama, tvnomor;
    public static String nohp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        tvnama = findViewById(R.id.tvNamaKontak);
        tvnomor = findViewById(R.id.tvNomorTelepon);

        Bundle bundle = getIntent().getExtras();
        String nama = bundle.getString("a");

        switch (nama) {
            case "Inayah":
                tvnama.setText("Inayah M");
                tvnomor.setText("08122233344");
                nohp = tvnomor.getText().toString();
                break;
            case "Ilham":
                tvnama.setText("Ilham R");
                tvnomor.setText("08132243455");
                nohp = tvnomor.getText().toString();
                break;
            case "Eris":
                tvnama.setText("Eris J");
                tvnomor.setText("08122453344");
                nohp = tvnomor.getText().toString();
                break;
            case "Fikri":
                tvnama.setText("M Fikri");
                tvnomor.setText("081255533344");
                nohp = tvnomor.getText().toString();
                break;
            case "Maul":
                tvnama.setText("Maul M");
                tvnomor.setText("08126633344");
                nohp = tvnomor.getText().toString();
                break;
            case "Intan":
                tvnama.setText("Intan S");
                tvnomor.setText("08122555344");
                nohp = tvnomor.getText().toString();
                break;
            case "Vina":
                tvnama.setText("Vina R");
                tvnomor.setText("08125556344");
                nohp = tvnomor.getText().toString();
                break;
            case "Gita":
                tvnama.setText("Gita S");
                tvnomor.setText("08199233344");
                nohp = tvnomor.getText().toString();
                break;
            case "Lutfi":
                tvnama.setText("Lutfi M");
                tvnomor.setText("08122233234");
                nohp = tvnomor.getText().toString();
                break;
            case "Vian":
                tvnama.setText("Vian M");
                tvnomor.setText("0812969344");
                nohp = tvnomor.getText().toString();
                break;
        }
    }
}