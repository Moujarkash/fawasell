package com.project.mod.fawasell.repositories.base;

import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class BaseRepository {

    //region Constants

    private static final String TAG = BaseRepository.class.getSimpleName();

    //endregion

    //region Members

    protected String getSignature(Object... values){
        String signature = null;
        String md5 = "MD5";
        byte[] bytes;
        try{
            if(values == null) return null;

            MessageDigest digest = java.security.MessageDigest
                    .getInstance(md5);

            for (Object value : values) {
                if(value != null){
                    digest.update(value.toString().getBytes());
                }
            }

            byte messageDigest[] = digest.digest();

            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }

            signature = hexString.toString();
        }catch (NoSuchAlgorithmException e){
            Log.e(TAG, e.getMessage(), e);
        }
        return signature;
    }

    //endregion
}
