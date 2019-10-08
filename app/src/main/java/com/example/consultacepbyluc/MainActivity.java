package com.example.consultacepbyluc;

import android.os.Bundle;

import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText cepInserir;
    private Button consultar;
    private TextView endereçoRecebido;
    private Retrofit retrofit;
    private static final String BASE_URL = "http://api.postmon.com.br/v1/cep/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        cepInserir = findViewById(R.id.input_cep);
        consultar = findViewById(R.id.button_consultar);
        endereçoRecebido = findViewById(R.id.endereco_recebido);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solicitarEndereco();
            }
        });



    }



    private void solicitarEndereco() {
        String cep = cepInserir.getText().toString();

        ServicoPostal service = retrofit.create(ServicoPostal.class);

        Call<Endereço> call = service.getEndereco(cep.trim());

        call.enqueue(new Callback<Endereço>() {
            @Override
            public void onResponse(Call<Endereço> call, Response<Endereço> response) {
                if (response.isSuccessful()) {
                    Endereço endereço = response.body();

                    String stringEndereço = "Cidade: " + endereço.getCidade() + "\n" +
                            "Bairro: " + endereço.getBairro() + "\n" +
                            "Logradouro: " + endereço.getLogradouro();

                    endereçoRecebido.setText(stringEndereço);
                }else {
                    Toast.makeText(MainActivity.this, "Cep nao encontrado", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Endereço> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Não foi possível realizar a requisição", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
