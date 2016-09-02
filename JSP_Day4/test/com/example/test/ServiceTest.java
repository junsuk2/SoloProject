package com.example.test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.dao.RegionDao;
import com.example.dao.RegionDaoStub;
import com.example.dto.Region;
import com.example.exception.UserNotFoundException;
import com.example.service.RegionService;
import com.example.service.RegionServiceStub;
import com.example.util.ContextLoadListener;
import com.example.util.myBatisUtil;

public class ServiceTest {
	
	@Test
	public void test() throws UserNotFoundException {
		RegionService service = RegionServiceStub.getRegionService();
		Region region = service.getRegion(50);
		logger.trace("region:{}",region);
		assertThat(region.getRegionId(),is(50));
		assertThat(region.getRegionName(),is("junsuk2"));
	}
	
	@Test(expected=UserNotFoundException.class)
	public void testGetFail() throws UserNotFoundException {
		RegionService service = RegionServiceStub.getRegionService();
		Region region = service.getRegion(-1);
	}
	
	static Logger logger = LoggerFactory.getLogger(ServiceTest.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegionDao rDao = new RegionDaoStub();
		
			SqlSession session = myBatisUtil.getInstance().getSession();
			Region region = new Region(5,"junsuk22");
			rDao.updateRegion(session, region);
			


	}

}
