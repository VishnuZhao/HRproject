package com.vishnu.service.impl;

import com.vishnu.dao.RecruitDao;
import com.vishnu.model.Recruit;
import com.vishnu.service.RecruitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/10/23 0023.
 */
@Service
public class RecruitServiceImpl implements RecruitService{
    @Resource
    private RecruitDao recruitDao;
    @Override
    public boolean saveRecruit(Recruit recruit) {
        if (recruit==null){
            return false;
        }
        recruitDao.saveRecruit(recruit);
        return true;
    }

    @Override
    public boolean deleteRecruit(int rc_id) {
        if (rc_id<10000){
            return false;
        }
        recruitDao.deleteRecruit(rc_id);
        return true;
    }

    @Override
    public boolean updateRecruit(Recruit recruit) {
        if (recruit==null){
            return false;
        }
        recruitDao.updateRecruit(recruit);
        return true;
    }

    @Override
    public Recruit getRecruitById(int rc_id) {
        if (rc_id<10000){
            return null;
        }
        return recruitDao.getRecruitById(rc_id);
    }

    @Override
    public List<Recruit> getAllOnSaleRecruit() {
        return recruitDao.getAllOnSaleRecruit();
    }

    @Override
    public List<Recruit> getRecruitByPage(int pageNo) {
        if (pageNo<=0){
            return null;
        }

        return recruitDao.getRecruitByPage(pageNo);
    }
}
