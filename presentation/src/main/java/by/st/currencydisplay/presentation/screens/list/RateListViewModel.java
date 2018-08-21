package by.st.currencydisplay.presentation.screens.list;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import by.st.currencydisplay.app.App;
import by.st.currencydisplay.presentation.base.BaseViewModel;
import by.st.currencydisplay.presentation.base.recycler.ClickedItemModel;
import by.st.currencydisplay.presentation.screens.list.item.RateListAdapter;
import by.st.domain.entity.Rate;
import by.st.domain.usescases.GetListRateUseCase;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RateListViewModel extends BaseViewModel<RateListRouter> {

    public RateListAdapter adapter = new RateListAdapter();

    @Inject
    public GetListRateUseCase listRateUseCase;

    @Override
    protected void runInject() {
        App.getAppComponent().runInject(this);
    }

    public RateListViewModel() {
        getRateList();
        adapterClickObserver();
    }

    public void getRateList() {

        listRateUseCase.getRates().subscribe(new Observer<List<Rate>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<Rate> rates) {
                adapter.setItems(rates);
            }

            @Override
            public void onError(Throwable e) {
                router.showError(e);
            }

            @Override
            public void onComplete() {
            }
        });
    }

    public void adapterClickObserver() {
        adapter.observeItemClick().subscribe(new Observer<ClickedItemModel>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ClickedItemModel clickedItemModel) {
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
