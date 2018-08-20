package by.st.data.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import by.st.data.entity.responses.RateResponse;
import by.st.data.net.RestService;
import by.st.domain.entity.Rate;
import by.st.domain.repositories.RateRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class RateRepositoryImpl implements RateRepository {
    private RestService restService;

    @Inject
    public RateRepositoryImpl(RestService restService) {
        this.restService = restService;
    }

    @Override
    public Observable<List<Rate>> getRates() {

        return restService.getRates()
                .map(new Function<List<RateResponse>, List<Rate>>() {
                    @Override
                    public List<Rate> apply(List<RateResponse> rateResponses) throws Exception {
                      List<Rate>  rates = getRates(rateResponses);
                        return rates;
                    }
                });
    }

    public List<Rate> getRates(List<RateResponse> rateResponses) {
        List<Rate> rates = new ArrayList<>();
        for (RateResponse rateResponse : rateResponses) {
            Rate rate = new Rate();
            rate.setCur_ID(rateResponse.getCur_ID());
            rate.setDate(rateResponse.getDate());
            rate.setCur_Abbreviation(rateResponse.getCur_Abbreviation());
            rate.setCur_Scale(rateResponse.getCur_Scale());
            rate.setCur_Name(rateResponse.getCur_Name());
            rate.setCur_OfficialRate(rateResponse.getCur_OfficialRate());
            rates.add(rate);
        }
        return rates;
    }
}
