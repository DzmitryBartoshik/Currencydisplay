package by.st.currencydisplay.injection;

import javax.inject.Singleton;

import by.st.currencydisplay.presentation.screens.list.RateListViewModel;
import dagger.Component;

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {
    void runInject(RateListViewModel listViewModel);
}
