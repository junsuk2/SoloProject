package com.example.service;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import com.example.dao.RegionDao;
import com.example.dao.RegionDaoStub;
import com.example.dto.Region;
import com.example.exception.DuplicationException;
import com.example.exception.UserNotFoundException;
import com.example.util.myBatisUtil;

public class RegionServiceStub implements RegionService {
	RegionDao rDao = new RegionDaoStub();

	// 1. singleton
	private RegionServiceStub() {

	}

	private static RegionServiceStub service = new RegionServiceStub();

	public static RegionServiceStub getRegionService() {
		return service;
	}

	public List<Region> getAllRegion() {
		try (SqlSession session = myBatisUtil.getInstance().getSession()) {
			return rDao.getAllRegion(session);
		}
	}

	@Override
	public Region getRegion(int regionId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		try (SqlSession session = myBatisUtil.getInstance().getSession()) {
			Region region = rDao.getRegion(session, regionId);
			if (region != null) {
				return region;
			} else {
				throw new UserNotFoundException(regionId);
			}

		}
	}

	@Override
	public int addRegion(Region region) throws DuplicationException {

		try (SqlSession session = myBatisUtil.getInstance().getSession()) {
			int result = rDao.addRegion(session, region);
			if (result == 1) {
				session.commit();
			}
			return result;
		} catch (PersistenceException e) {
			throw new DuplicationException(region.getRegionId());
		}

	}

	@Override
	public int updateRegion(Region region) throws UserNotFoundException {
		// TODO Auto-generated method stub
		try (SqlSession session = myBatisUtil.getInstance().getSession()) {
			int result = rDao.updateRegion(session, region);
			if (result == 1) {
				session.commit();
				return result;
			} else {
				throw new UserNotFoundException(region.getRegionId());
			}
		
		}
	}

	@Override
	public int deleteRegion(int regionId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		try(SqlSession session = myBatisUtil.getInstance().getSession()){
			int result = rDao.deleteRegion(session, regionId);
			if(result ==0){
				throw new UserNotFoundException(regionId);
			}else{
				session.commit();
				return result;
			}
		}
	}
}
