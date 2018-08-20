package by.st.domain.usescases;

import java.util.List;
import io.reactivex.Observable;
import javax.inject.Inject;

import by.st.domain.entity.Rate;
import by.st.domain.executors.PostExecutionThread;
import by.st.domain.repositories.RateRepository;
import by.st.domain.usescases.BaseUseCase;

public class GetListRateUseCase extends BaseUseCase {

    private RateRepository rateRepository;

    @Inject
    public GetListRateUseCase(RateRepository rateRepository,PostExecutionThread postExecutionThread){
        super(postExecutionThread);
        this.rateRepository=rateRepository;
    }
    public Observable<List<Rate>> getRates(){
        return rateRepository
                .getRates()
                .subscribeOn(executionThread)
                .observeOn(postExecutionThread);
    }
}
