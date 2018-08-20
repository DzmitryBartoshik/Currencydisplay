package by.st.currencydisplay.presentation.screens.list.item;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import by.st.currencydisplay.presentation.base.recycler.BaseItemViewHolder;
import by.st.currencydisplay.presentation.base.recycler.BaseRecyclerViewAdapter;
import by.st.domain.entity.Rate;

public class RateListAdapter  extends BaseRecyclerViewAdapter<Rate, RateItemViewModel> {

    @NonNull
    @Override
    public BaseItemViewHolder<Rate, RateItemViewModel, ?> onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return  RateItemViewHolder.create(parent, new RateItemViewModel());
    }
}
