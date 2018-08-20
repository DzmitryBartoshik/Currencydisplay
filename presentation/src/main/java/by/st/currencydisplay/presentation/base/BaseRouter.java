package by.st.currencydisplay.presentation.base;

import android.util.Log;
import android.widget.Toast;

import by.st.currencydisplay.R;
import by.st.domain.entity.error.Error;

public class BaseRouter <A extends BaseActivity> {
    protected A activity;

    public BaseRouter(A activity) {
        this.activity = activity;
    }

    public void goBack() {
        activity.onBackPressed();
    }

    public void finishActivity() {
        activity.finish();
    }

    public void showError(Throwable throwable) {

        if (throwable instanceof Error) {

            Error error = (Error) throwable;
            switch (error.getType()) {
                case INTERNET_IS_NOT_AVAILABLE: {
                    showTostError(R.string.error_internet_not_available);
                    break;
                }
                case SERVER_IS_NOT_AVAILABLE: {
                    showTostError(R.string.error_server_not_available);
                    break;
                }
                case SERVER_ERROR: {
                    showTostError(R.string.error_server);
                    break;
                }
                default: {
                    showTostError(R.string.error);
                }
            }
        }
    }

    private void showTostError(int messageErrorId) {
        Toast.makeText(activity, messageErrorId, Toast.LENGTH_SHORT)
                .show();
    }
}
