package com.jalagbe.app.service.impl;

import com.jalagbe.app.dao.CategoryImageDao;
import com.jalagbe.app.entity.CategoryImage;
import com.jalagbe.app.service.CategoryImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rahma on 8/27/2017.
 */

@Service
public class CategoryImageServiceImpl implements CategoryImageService {

    @Autowired
    private CategoryImageDao categoryImageDao;

    @Override
    public boolean save(CategoryImage object) throws Exception {
        return categoryImageDao.insert(object);
    }

    @Override
    public boolean delete(CategoryImage object) throws Exception {
        return categoryImageDao.deleteTableData(object);
    }

    @Override
    public boolean update(CategoryImage object) throws Exception {
        return categoryImageDao.updateTableData(object);
    }

    @Override
    public List<CategoryImage> getAll() throws Exception {
        return categoryImageDao.getAll();
    }

    @Override
    public CategoryImage get(Integer id) throws Exception {
        return categoryImageDao.get(id);
    }

    @Override
    public List<CategoryImage> getDataBy(String columnName, String input) throws Exception {
        return null;
    }
}
