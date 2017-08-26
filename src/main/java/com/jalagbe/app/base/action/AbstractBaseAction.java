package com.jalagbe.app.base.action;

import java.util.Map;

/**
 * Created by rahma on 8/26/2017.
 */
public abstract class AbstractBaseAction {

    protected abstract Map<String, ?> processResponse(Object object);

    protected abstract boolean validateRequestParams(Object object);

}
