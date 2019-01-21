package com.project.mod.fawasell.utils;

import android.content.Context;
import android.net.ConnectivityManager;

import java.net.InetAddress;

public class GeneralHelper {

    //region Members

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return connectivityManager.getActiveNetworkInfo() != null;
    }

    //endregion
}
