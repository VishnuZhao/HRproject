package com.vishnu.service.impl;

import com.vishnu.dao.TrainingRecordDao;
import com.vishnu.model.TrainingRecord;
import com.vishnu.service.TrainingRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/10/27 0027.
 */
@Service
public class TrainingRecordServiceImpl implements TrainingRecordService {

    @Resource
    private TrainingRecordDao trainingRecordDao;
    @Override
    public boolean addTR(TrainingRecord trainingRecord) {
        if (trainingRecord==null){
            return false;
        }
        trainingRecordDao.addTR(trainingRecord);
        return true;
    }

    @Override
    public TrainingRecord getTRById(int trid) {
        if (trid<10000){
            return null;
        }
        return trainingRecordDao.getTRById(trid);
    }

    @Override
    public List<TrainingRecord> getTRByEmpId(int empid) {
        if (empid<10000){
            return null;
        }
        return trainingRecordDao.getTRByEmpId(empid);
    }

    @Override
    public List<TrainingRecord> getAllTR() {
        return trainingRecordDao.getAllTR();
    }
}
