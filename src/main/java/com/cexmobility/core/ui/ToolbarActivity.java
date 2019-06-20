package com.cexmobility.core.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;

import com.cexmobility.core.R;
import com.cexmobility.core.utils.enums.ToolbarActions;

public abstract class ToolbarActivity extends BaseActivity {

    private Toolbar toolbar;
    private TextView toolbarTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void setToolbar(ToolbarActions toolbarAction, @StringRes int title) {
        this.toolbar = findViewById(R.id.toolbar);
        this.toolbarTitle = findViewById(R.id.toolbar_title);

        if (!toolbarAction.equals(ToolbarActions.NONE))
        {
            setSupportActionBar(toolbar);

            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayShowTitleEnabled(false);
                switch (toolbarAction) {
                    case BACK:
                        actionBar.setDisplayHomeAsUpEnabled(true);
                        break;
                    case MENU:
                        actionBar.setDisplayHomeAsUpEnabled(true);
                        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white);
                        break;
                }
            }

            if (title != 0)
                this.setToolbarTitle(getString(title));
        }
    }

    protected void setToolbarTitle(String title) {
        this.toolbarTitle.setText(title);
    }

}
