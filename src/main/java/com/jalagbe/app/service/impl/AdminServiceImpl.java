package com.jalagbe.app.service.impl;

import com.jalagbe.app.entity.Admin;
import com.jalagbe.app.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rahma on 8/15/2017.
 */

@Service
public class AdminServiceImpl implements AdminService {

    @Override
    public boolean save(Admin object) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Admin object) throws Exception {
        return false;
    }

    @Override
    public boolean update(Admin object) throws Exception {
        return false;
    }

    @Override
    public List<Admin> getAll() throws Exception {
        return null;
    }

    @Override
    public Admin get(Integer id) throws Exception {
        return null;
    }

    @Override
    public List<Admin> getDataBy(String columnName, String input) throws Exception {
        return null;
    }
}
