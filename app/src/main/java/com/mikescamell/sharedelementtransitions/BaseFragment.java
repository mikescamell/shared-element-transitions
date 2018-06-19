package com.mikescamell.sharedelementtransitions;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewTreeObserver;

public class BaseFragment extends Fragment {

    protected void scheduleStartPostponedTransition(final View sharedElement) {
        sharedElement.getViewTreeObserver().addOnPreDrawListener(
                new ViewTreeObserver.OnPreDrawListener() {
                    @Override
                    public boolean onPreDraw() {
                        sharedElement.getViewTreeObserver().removeOnPreDrawListener(this);
                        startPostponedEnterTransition();
                        return true;
                    }
                });
    }
}
