package by.st.currencydisplay.injection;

import android.content.Context;

import javax.inject.Singleton;

import by.st.currencydisplay.executor.UIThread;
import by.st.data.net.RestService;
import by.st.data.repositories.RateRepositoryImpl;
import by.st.domain.executors.PostExecutionThread;
import by.st.domain.repositories.RateRepository;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return context;
    }

    @Provides
    public static RateRepository provideCurrencyRepository() {
        return new RateRepositoryImpl(new RestService());
    }

    @Provides
    @Singleton
    public static PostExecutionThread provideUIThread(UIThread uiThread){
        return uiThread;
    }
}
