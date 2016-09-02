package com.example.test;

import org.apache.ibatis.session.SqlSession;

import com.example.dao.RegionDao;
import com.example.dao.RegionDaoStub;
import com.example.dto.Region;
import com.example.exception.DuplicationException;
import com.example.exception.UserNotFoundException;
import com.example.service.RegionService;
import com.example.service.RegionServiceStub;
import com.example.util.myBatisUtil;

public class test {
	public static void main(String[] args){
		RegionDao rDao = new RegionDaoStub();
		
		SqlSession session = myBatisUtil.getInstance().getSession();

		RegionService service = RegionServiceStub.getRegionService();
		try {
			service.deleteRegion(50);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
