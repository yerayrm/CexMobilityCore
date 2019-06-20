package com.cexmobility.core.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

public abstract class BaseFragment extends Fragment {

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResource(), container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onAttach(@NotNull Context context) {
        if (hasInjection())
            AndroidSupportInjection.inject(this);

        super.onAttach(context);

        initializeView();
    }

    protected abstract void initializeView();

    protected abstract int getLayoutResource();

    protected abstract boolean hasInjection();

}