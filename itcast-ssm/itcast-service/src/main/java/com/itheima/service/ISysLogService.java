package com.itheima.service;

import com.itheima.domain.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ISysLogService {


    public void save(SysLog log);

    public List<SysLog> findAll();
}
