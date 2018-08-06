package com.bignerdranch.android.photogallery.view;

import android.support.v4.app.Fragment;

public class MainActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return ListPicturesFragment.newInstance();
    }
}
