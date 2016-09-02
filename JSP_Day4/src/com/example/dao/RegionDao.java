package com.example.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.example.dto.Region;

public interface RegionDao {
	List<Region> getAllRegion(SqlSession session);
	/**
	 * RegionId를 입력받아서 해당하는 RegionName을 리턴한다.
	 * @param regionId
	 * @return
	 */
	Region getRegion(SqlSession session,int regionId);
	
	int addRegion(SqlSession session, Region region);
	
	int updateRegion(SqlSession session, Region region);
	
	int deleteRegion(SqlSession session, int regionId);
}
