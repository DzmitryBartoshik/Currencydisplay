package by.st.currencydisplay.app;

import android.app.Application;

import by.st.currencydisplay.injection.AppComponent;
import by.st.currencydisplay.injection.DaggerAppComponent;


public class App extends Application {
    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent
                .builder()
                .build();
    }
}
