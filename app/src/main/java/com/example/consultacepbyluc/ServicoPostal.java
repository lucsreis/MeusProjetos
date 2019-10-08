package com.example.consultacepbyluc;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ServicoPostal  {

    @GET("{cep}")
    Call<Endereço> getEndereco(@Path("cep") String cep);






}
