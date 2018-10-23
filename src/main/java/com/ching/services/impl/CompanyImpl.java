package com.ching.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ching.dao.CompanyMapper;
import com.ching.entity.Company;
import com.ching.services.Companyser;



@Service("companyser")
@Transactional
public class CompanyImpl implements Companyser {
	@Autowired
	private CompanyMapper companymapper;


    public int addPerson(Company p) {
        // TODO Auto-generated method stub
        return companymapper.addPerson(p);
    }


    public int deletperson(String id) {
        // TODO Auto-generated method stub
        return companymapper.deletperson(id);
    }


    public int updatePerson(Company p) {
        // TODO Auto-generated method stub
        return companymapper.updatePerson(p);
    }


    public Company findpPersonId(String id) {
        // TODO Auto-generated method stub
        return companymapper.findpPersonId(id);
    }


    public int deletall(String[] id) {
        // TODO Auto-generated method stub
        return companymapper.deletall(id);
    }


    public List<Company> findPersonAll() {
        // TODO Auto-generated method stub
        return companymapper.findPersonAll();
    }


    public List<Company> findPersonmohu(String name) {
        // TODO Auto-generated method stub
        return companymapper.findPersonmohu(name);
    }


    public List<Company> findPersonPage(int current, int size) {
        // TODO Auto-generated method stub
        return companymapper.findPersonPage(current, size);
    }


    public List<Company> findPersonPagemohu(String name, int current, int size) {
        // TODO Auto-generated method stub
        return companymapper.findPersonPagemohu(name, current, size);
    }


    public int findCountPage() {
        // TODO Auto-generated method stub
        return companymapper.findCountPage();
    }



}
