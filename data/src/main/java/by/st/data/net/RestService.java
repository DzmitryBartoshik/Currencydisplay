package by.st.data.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import by.st.data.entity.responses.RateResponse;
import by.st.domain.entity.Rate;
import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestService {
    private RestApi restApi;
    private Gson gson;
    private static final String RATES_REQUEST_URL = "http://www.nbrb.by/API/ExRates/";
    private ErrorParserTransformer errorParserTransformer;

    @Inject
    public RestService() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient
                .Builder()
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();

        gson = new GsonBuilder()
                .create();

        this.restApi = new Retrofit
                .Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(RATES_REQUEST_URL)
                .client(okHttpClient)
                .build()
                .create(RestApi.class);

        errorParserTransformer = new ErrorParserTransformer(gson);
    }

    public Observable<List<RateResponse>> getRates() {
        return restApi
                .getRates(0)
                .compose(errorParserTransformer.<List<RateResponse>, HttpError>parseHttpError());
    }
}
