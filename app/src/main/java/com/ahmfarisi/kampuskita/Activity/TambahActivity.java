package com.ahmfarisi.kampuskita.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ahmfarisi.kampuskita.API.APIRequestData;
import com.ahmfarisi.kampuskita.API.RetroServer;
import com.ahmfarisi.kampuskita.Model.ModelResponse;
import com.ahmfarisi.kampuskita.R;

import retrofit2.Call;

public class TambahActivity extends AppCompatActivity {
    private EditText etNama, etKota, etAlamat;
    private Button btnTambah;
    private String nama, kota, alamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etNama = findViewById(R.id.et_nama);
        etKota = findViewById(R.id.et_kota);
        etAlamat = findViewById(R.id.et_alamat);
        btnTambah = findViewById(R.id.btn_tambah);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama = etNama.getText().toString();
                kota = etKota.getText().toString();
                alamat = etAlamat.getText().toString();

                if(nama.trim().isEmpty()){
                    etNama.setError("Nama Tidak Boleh Kosong!!!!");
                }
                else if(kota.trim().isEmpty()){
                    etKota.setError("Kota Tidak Boleh Kosong!!!");
                }
                else if(alamat.trim().isEmpty()){
                    etAlamat.setError("Alamat Tidak Boleh Kosong!!!");
                }
                else{
                    tambahKampus();
                }
            }
        });
    }
    private void tambahKampus(){
        APIRequestData API = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ModelResponse> proses = API.ardCreate(nama, kota, alamat);

    }
}