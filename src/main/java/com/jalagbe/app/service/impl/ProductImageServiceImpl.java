package com.jalagbe.app.service.impl;

import com.jalagbe.app.dao.ProductImageDao;
import com.jalagbe.app.entity.ProductImage;
import com.jalagbe.app.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rahma on 9/10/2017.
 */
@Service
public class ProductImageServiceImpl implements ProductImageService {
    @Autowired
    private ProductImageDao productImageDao;

    @Override
    public boolean save(ProductImage object) throws Exception {
        return productImageDao.insert(object);
    }

    @Override
    public boolean delete(ProductImage object) throws Exception {
        return productImageDao.deleteTableData(object);
    }

    @Override
    public boolean update(ProductImage object) throws Exception {
        return productImageDao.updateTableData(object);
    }

    @Override
    public List<ProductImage> getAll() throws Exception {
        return productImageDao.getAll();
    }

    @Override
    public ProductImage get(Integer id) throws Exception {
        return productImageDao.get(id);
    }

    @Override
    public List<ProductImage> getDataBy(String columnName, String input) throws Exception {
        return productImageDao.getDataByColumnName(columnName, input);
    }
}
