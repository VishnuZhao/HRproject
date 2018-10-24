package com.vishnu.dao;

import com.vishnu.model.Recruit;

import java.util.List;

/**
 * Created by Administrator on 2018/10/23 0023.
 */
public interface RecruitDao {
    void saveRecruit(Recruit recruit);
    void deleteRecruit(int rc_id);
    void updateRecruit(Recruit recruit);
    Recruit getRecruitById(int rc_id);
    List<Recruit> getAllOnSaleRecruit();
    List<Recruit> getRecruitByPage(int pageNo, int pageSize);
}
