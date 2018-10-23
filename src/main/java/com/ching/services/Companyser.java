package com.ching.services;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ching.entity.Company;

public interface Companyser  {
	public int  addPerson(Company p );
	public int  deletperson(String  id );
	public int  updatePerson(Company  p );
	public Company  findpPersonId(String id);
	public int deletall(@Param("asd")String id[]);
	public List<Company > findPersonAll();
	public List<Company > findPersonmohu(String name);
	public List<Company > findPersonPage(@Param("current")int current,@Param("size")int size);
	public List<Company> findPersonPagemohu(@Param("name")String name,@Param("current")int current,@Param("size")int size);
	public int findCountPage();

}
