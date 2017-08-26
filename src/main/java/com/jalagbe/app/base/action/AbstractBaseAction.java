package com.jalagbe.app.base.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by rahma on 8/26/2017.
 */
public abstract class AbstractBaseAction {

    protected abstract Map<String, ?> processResponse(Object object);

    protected abstract boolean validateRequestParams(Object object);

    protected String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

}
