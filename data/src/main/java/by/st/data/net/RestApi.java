package by.st.data.net;

import java.util.List;

import by.st.data.entity.responses.RateResponse;
import io.reactivex.Observable;

import by.st.domain.entity.Rate;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApi {
    @GET("Rates")
    Observable<List<RateResponse>> getRates(@Query("periodicity") int periodicity);
}
