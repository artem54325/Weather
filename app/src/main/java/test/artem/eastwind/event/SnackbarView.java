package test.artem.eastwind.event;


import android.app.Activity;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;

public class SnackbarView implements Event{
    CoordinatorLayout layout;
    public SnackbarView(CoordinatorLayout layout) {
        this.layout = layout;
    }

    @Override
    public void view(String text) {
        Snackbar snackbar = Snackbar
                .make(layout, "Температура: " + text, Snackbar.LENGTH_LONG);
        snackbar.show();
    }
}
