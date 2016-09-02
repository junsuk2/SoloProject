package com.example.test;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.example.dao.EmpDao;
import com.example.dao.EmpDaoImpl;
import com.example.dto.Employee;
import com.example.service.EmpServiceDao;
import com.example.service.EmpServiceDaoImpl;
import com.example.util.myBatisUtil;

public class DaoTest {

	
	@Test
	public void test() {
		EmpDao dao = new EmpDaoImpl();
		EmpServiceDao service = EmpServiceDaoImpl.getService();
		try(SqlSession session = myBatisUtil.getInstance().getSession()){
			service.searchById("S");
		}
		
	}

}
