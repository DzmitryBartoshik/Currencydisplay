package by.st.currencydisplay.presentation.screens.list;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import by.st.currencydisplay.databinding.ActivityRateListBinding;
import by.st.currencydisplay.presentation.base.BaseMvvmActivity;

import by.st.currencydisplay.R;
import by.st.currencydisplay.presentation.screens.list.item.helper.SimpleItemTouchHelperCallback;

public class RateListActivity extends BaseMvvmActivity<RateListViewModel,
        ActivityRateListBinding, RateListRouter> {
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
        adapterSettings();
    }

    public void adapterSettings() {
        binding.rateList.setLayoutManager(new LinearLayoutManager(this));
        binding.rateList.setAdapter(viewModel.adapter);

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(viewModel.adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rate_list);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}
