package com.example.gifapps.database;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gifapps.R;

public class DaftarActivity extends AppCompatActivity {
    private AppDatabase appDatabase;
    private Button btnSimpan, btnLihat;
    private EditText etName, etEmail, etAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);


        btnSimpan = findViewById(R.id.btn_simpan);
        btnLihat = findViewById(R.id.btn_lihat);

        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        etAlamat = findViewById(R.id.et_alamat);

        appDatabase = AppDatabase.iniDB(getApplicationContext());

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DataDiri dataDiri = new DataDiri();

                dataDiri.setName(etName.getText().toString());
                dataDiri.setEmail(etEmail.getText().toString());
                dataDiri.setAlamat(etAlamat.getText().toString());

                appDatabase.dao().insertData(dataDiri);
                etName.setText("");
                etEmail.setText("");
                etAlamat.setText("");
            }
        });

        btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LihatDataActivity.class);

                startActivity(intent);

            }
        });
    }
}
