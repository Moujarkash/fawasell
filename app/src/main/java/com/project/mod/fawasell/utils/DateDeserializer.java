package com.project.mod.fawasell.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

import java.lang.reflect.Type;
import java.util.Date;

public class DateDeserializer implements JsonDeserializer<Date> {

    //region Constants

    private static final String TAG = DateDeserializer.class.getSimpleName();

    //endregion

    //region JsonDeserializer Members

    @Override
    public Date deserialize(JsonElement element, Type arg1, JsonDeserializationContext arg2) {
        String dateString = element.getAsString();
        Long dateLong = Long.parseLong(dateString);

        return new Date(dateLong * 1000);
    }

    //endregion
}
