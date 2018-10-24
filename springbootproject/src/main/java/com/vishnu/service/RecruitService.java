package com.vishnu.service;

import com.vishnu.model.Recruit;

import java.util.List;

/**
 * Created by Administrator on 2018/10/23 0023.
 */
public interface RecruitService {
    boolean saveRecruit(Recruit recruit);
    boolean deleteRecruit(int rc_id);
    boolean updateRecruit(Recruit recruit);
    Recruit getRecruitById(int rc_id);
    List<Recruit> getAllOnSaleRecruit();
    List<Recruit> getRecruitByPage(int pageNo,int pageSize);
}
