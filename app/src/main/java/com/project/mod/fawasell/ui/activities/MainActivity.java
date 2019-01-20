package com.project.mod.fawasell.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;

import com.project.mod.fawasell.R;
import com.project.mod.fawasell.ui.fragments.CategoriesFragment;

import java.util.ArrayList;
import java.util.Objects;

import androidx.navigation.Navigation;

public class MainActivity extends AppCompatActivity implements CategoriesFragment.OnFragmentInteractionListener {

    //region Activity Members

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        centerTitle();
    }

    @Override
    public boolean onNavigateUp() {
        return Navigation.findNavController(this, R.id.nav_host_fragment).navigateUp();
    }

    //endregion

    //region Private Members

    private void centerTitle() {
        ArrayList<View> textViews = new ArrayList<>();

        getWindow().getDecorView().findViewsWithText(textViews, getTitle(), View.FIND_VIEWS_WITH_TEXT);

        if(textViews.size() > 0) {
            AppCompatTextView appCompatTextView = null;
            if(textViews.size() == 1) {
                appCompatTextView = (AppCompatTextView) textViews.get(0);
            } else {
                for(View v : textViews) {
                    if(v.getParent() instanceof Toolbar) {
                        appCompatTextView = (AppCompatTextView) v;
                        break;
                    }
                }
            }

            if(appCompatTextView != null) {
                ViewGroup.LayoutParams params = appCompatTextView.getLayoutParams();
                params.width = ViewGroup.LayoutParams.MATCH_PARENT;
                appCompatTextView.setLayoutParams(params);
                appCompatTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            }
        }
    }

    //endregion

    //region CategoriesFragment.OnFragmentInteractionListener

    @Override
    public void onFragmentInteraction(String title) {
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
    }

    //endregion
}
