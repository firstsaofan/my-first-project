package com.itheima.service.impl;

import com.itheima.dao.ISysLogDao;
import com.itheima.domain.SysLog;
import com.itheima.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class sysLogServiceImpl implements ISysLogService {
    @Autowired
    private ISysLogDao sysLogDao;

    public void save(SysLog log) {
        sysLogDao.save(log);
    }

    public List<SysLog> findAll() {
        return sysLogDao.findAll();
    }
}
