package com.project.mod.fawasell.ui.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.project.mod.fawasell.R;

public class DisplayHelper {

    //region Public Members

    public static void displayMessageAlertDialog(Context context, String title, String message) {
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(context, R.style.AlertDialogCustom);

        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setIcon(R.drawable.ic_error)
                .show();
    }

    public static void hideSoftKeyboard(Activity activity) {
        if (activity == null) return;

        View view = activity.getCurrentFocus();

        if (view == null) return;

        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);

        if (inputMethodManager == null) return;

        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    //endregion
}
