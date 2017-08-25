package com.jalagbe.app.action;

import com.jalagbe.app.base.action.AbstractBaseAction;
import com.jalagbe.app.base.action.BaseAction;
import com.jalagbe.app.model.CategoryModel;
import com.jalagbe.app.model.JalagbeResponse;

import java.util.Map;

/**
 * Created by rahma on 8/21/2017.
 */
public class CategoryAction extends AbstractBaseAction implements BaseAction<CategoryModel>{
    @Override
    protected Map<String, ?> processResponse(Object object) {
        return null;
    }

    @Override
    protected boolean validateRequestParams(Object object) {
        return false;
    }

    @Override
    public Map<String, ?> execute() {
        return null;
    }

    @Override
    public JalagbeResponse execute(CategoryModel model) {
        return null;
    }
}
