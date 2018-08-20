package by.st.currencydisplay.presentation.screens.list;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import by.st.currencydisplay.databinding.ActivityRateListBinding;
import by.st.currencydisplay.presentation.base.BaseMvvmActivity;

import by.st.currencydisplay.R;

public class RateListActivity extends BaseMvvmActivity<RateListViewModel,
        ActivityRateListBinding, RateListRouter>  {


    @Override
    protected RateListViewModel provideViewModel() {

        return ViewModelProviders.of(this).get(RateListViewModel.class);
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_rate_list;
    }

    @Override
    protected RateListRouter provideRouter() {
        return null;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.rateList.setLayoutManager(new LinearLayoutManager(this));
        binding.rateList.setAdapter(viewModel.adapter);
        binding.rateList.setHasFixedSize(true);
    }
}
