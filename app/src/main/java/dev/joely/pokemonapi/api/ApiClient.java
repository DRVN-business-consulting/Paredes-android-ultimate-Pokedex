package dev.joely.pokemonapi.api;

import android.content.Context;
import dev.joely.pokemonapi.utils.TokenManager;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Interceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class ApiClient {

    private static Retrofit retrofit = null;
    private static TokenManager tokenManager;

    public static Retrofit getClient(Context context) {
        if (retrofit == null) {
            tokenManager = new TokenManager(context);

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public okhttp3.Response intercept(Chain chain) throws IOException {
                            Request originalRequest = chain.request();
                            String token = tokenManager.getToken();
                            if (token != null) {
                                Request newRequest = originalRequest.newBuilder()
                                        .header("Authorization", "Bearer " + token)
                                        .build();
                                return chain.proceed(newRequest);
                            }
                            return chain.proceed(originalRequest);
                        }
                    })
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl("https://a508-202-90-134-36.ngrok-free.app")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
