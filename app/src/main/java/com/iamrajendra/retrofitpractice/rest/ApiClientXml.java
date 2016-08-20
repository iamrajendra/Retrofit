package com.iamrajendra.retrofitpractice.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by rajendraverma on 20-08-2016.
 */
public class ApiClientXml {
    private static Retrofit retrofit;
    private  static  String BASE_URL ="http://www.w3schools.com";

    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
