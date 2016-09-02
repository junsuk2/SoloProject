package com.example.service;

import java.util.List;

import com.example.dto.Region;
import com.example.exception.DuplicationException;
import com.example.exception.UserNotFoundException;

public interface RegionService {
	List<Region> getAllRegion();
	/**
	 * 주어진 regionId에 해당하는 region 객체 전달
	 * @param regionId
	 * @return regionId로 조회된 region 객체
	 * @throws UserNotFoundException
	 */
	Region getRegion(int regionId) throws UserNotFoundException;
	/**
	 * Region 정보의 저장을 Dao에게 요청한다.
	 * @param region
	 * @return
	 * @throws DuplicationException이 발생한다.
	 */
	int addRegion(Region region) throws DuplicationException;	
	
	int updateRegion(Region region) throws UserNotFoundException;
	
	int deleteRegion(int regionId) throws UserNotFoundException;
}
