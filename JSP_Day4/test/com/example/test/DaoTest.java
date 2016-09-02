package com.example.test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.apache.ibatis.session.SqlSession;
import java.sql.SQLException;

import com.example.dto.Region;
import com.example.exception.UserNotFoundException;
import com.example.service.RegionService;
import com.example.service.RegionServiceStub;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.util.myBatisUtil;

import com.example.dao.RegionDao;
import com.example.dao.RegionDaoStub;

public class DaoTest {


	@Test
	public void test() {
		RegionDao rDao = new RegionDaoStub();
		SqlSession session = myBatisUtil.getInstance().getSession();
		Region region = new Region(5,"asdas");
		rDao.updateRegion(session, region);
		assertThat(region.getRegionId(),is(5));
	}

}
