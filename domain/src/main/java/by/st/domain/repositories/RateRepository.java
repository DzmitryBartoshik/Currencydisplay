package by.st.domain.repositories;

import java.util.List;

import by.st.domain.entity.Rate;
import io.reactivex.Observable;

public interface RateRepository {
    Observable<List<Rate>> getRates();
}
