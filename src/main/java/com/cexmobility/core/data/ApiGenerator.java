package com.cexmobility.core.data;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Yeray Rguez on 04/03/2019.
 */
public class ApiGenerator<T> {

    private static final long TIMEOUT = 30;
    private Class<T> apiServiceClass;

    public ApiGenerator(Class<T> apiServiceClass) {
        this.apiServiceClass = apiServiceClass;
    }

    public T createService(String url) {
        return createService(url, false, false);
    }

    private T createService(String url, boolean requireAuth, boolean requireRefresh) {
        // Logging level
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        //if (BuildConfig.DEBUG) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        //} else {
        //    logging.setLevel(HttpLoggingInterceptor.Level.NONE);
        //}

        // Create OkHttpClient with timeout
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS);

        // Check if require authentication
        //if (requireAuth)
        //    httpClient.addInterceptor(new RefreshInterceptor(requireRefresh));

        // Set log interceptor
        httpClient.addInterceptor(logging);

        // Build OkHttpClient instance
        OkHttpClient client = httpClient.build();

        // Build retrofit instance
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client);
        Retrofit retrofit = builder.build();

        return retrofit.create(apiServiceClass);
    }


}
