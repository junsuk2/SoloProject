package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.example.dto.Region;
import com.example.util.myBatisUtil;

public class RegionDaoStub implements RegionDao {

	String REGION_NS="com.example.regionMapper.";
	@Override
	public List<Region> getAllRegion(SqlSession session) {
		String stmt = REGION_NS+"selectAllRegion";
		return session.selectList(stmt);
	}
	
	public Region getRegion(SqlSession session,int regionId){
		String stmt = REGION_NS+"selectRegionId";
		return session.selectOne(stmt,regionId);
	}

	@Override
	public int addRegion(SqlSession session, Region region) {
		// TODO Auto-generated method stub
		String stmt = REGION_NS+"insertRegion";
		return session.insert(stmt, region);
		
		
	}

	@Override
	public int updateRegion(SqlSession session, Region region) {
		// TODO Auto-generated method stub
		String stmt = REGION_NS+"updateRegion";
		return session.update(stmt, region);
	}

	@Override
	public int deleteRegion(SqlSession session, int regionId) {
		// TODO Auto-generated method stub
		String stmt = REGION_NS+"deleteRegion";
		return session.delete(stmt,regionId);
	}

}
