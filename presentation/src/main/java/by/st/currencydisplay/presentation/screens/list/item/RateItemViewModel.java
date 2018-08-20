package by.st.currencydisplay.presentation.screens.list.item;

import android.databinding.ObservableField;

import by.st.currencydisplay.presentation.base.recycler.BaseItemViewModel;
import by.st.domain.entity.Rate;

public class RateItemViewModel extends BaseItemViewModel<Rate> {
    public ObservableField<String> bynRate = new ObservableField<>();
    public ObservableField<String> description = new ObservableField<>();

    @Override
    public void setItem(Rate rate) {
        String currencyAbbreviation = rate.getCur_Abbreviation();
        int currencyScale = rate.getCur_Scale();
        String currencyName = rate.getCur_Name();
        double currencyOfficialRate = rate.getCur_OfficialRate();
        this.bynRate.set(currencyAbbreviation + " " + currencyOfficialRate + " BYN");
        this.description.set(currencyName + " за " + currencyScale + " ед.");
    }
}
