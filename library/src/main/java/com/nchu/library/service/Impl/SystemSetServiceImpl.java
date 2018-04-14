package com.nchu.library.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nchu.library.dao.SystemSetDao;
import com.nchu.library.entity.SystemSet;
import com.nchu.library.service.SystemSetService;

@Service
public class SystemSetServiceImpl implements SystemSetService{
	@Autowired
    private SystemSetDao systemSetDao;
	public static final int SUCCESS=0;
	public static final int FAUILT=1;
	@Override
	public List<SystemSet> querySystem() {
		// TODO Auto-generated method stub
		return systemSetDao.querySystemSet();
	}
	@Override
	@Transactional
	public int updateSystemSet(SystemSet systemSet) {
		// TODO Auto-generated method stub
		try {
			int effNum=systemSetDao.modifySystemSet(systemSet);
			if(effNum>0) {
				return SUCCESS;
			}
			return FAUILT;
		}catch(Exception e) {
			throw new RuntimeException();
		}
	}
	@Override
	public int querySystemCount(SystemSet systemSet) {
		// TODO Auto-generated method stub
		return systemSetDao.querySystemCount(systemSet);
	}

}
