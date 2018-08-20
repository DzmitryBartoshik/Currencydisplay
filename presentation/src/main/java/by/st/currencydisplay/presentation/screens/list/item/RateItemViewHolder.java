package by.st.currencydisplay.presentation.screens.list.item;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import by.st.currencydisplay.databinding.ItemRateBinding;
import by.st.currencydisplay.presentation.base.recycler.BaseItemViewHolder;
import by.st.domain.entity.Rate;

public class RateItemViewHolder extends BaseItemViewHolder<Rate, RateItemViewModel, ItemRateBinding> {
    public static RateItemViewHolder rateItemViewHolder;

    public RateItemViewHolder(RateItemViewModel viewModel, ItemRateBinding binding) {
        super(viewModel, binding);
    }

    public static RateItemViewHolder create(ViewGroup parent, RateItemViewModel viewModel) {
        ItemRateBinding binding = ItemRateBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new RateItemViewHolder(viewModel, binding);
    }

    @Override
    public RateItemViewModel getViewModel() {
        return super.getViewModel();
    }

    public static RateItemViewHolder getViewHolder() {
        return rateItemViewHolder;
    }

}
