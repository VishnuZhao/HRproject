package com.vishnu.service.impl;

import com.vishnu.dao.TrainingDao;
import com.vishnu.model.Training;
import com.vishnu.service.TrainingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/10/27 0027.
 */
@Service
public class TrainingServiceImpl implements TrainingService {

    @Resource
    private TrainingDao trainingDao;

    @Override
    public boolean addTraining(Training training) {
        if (training==null){
            return false;
        }
        trainingDao.addTraining(training);
        return true;
    }

    @Override
    public boolean deleteTraining(int taid) {
        if (taid<10000){
            return false;
        }
        trainingDao.deleteTraining(taid);
        return true;
    }

    @Override
    public Training getTrainingById(int taid) {
        if (taid<10000){
            return null;
        }
        return trainingDao.getTrainingById(taid);
    }
}
