package com.vishnu.service;

import com.vishnu.model.Training;

/**
 * Created by Administrator on 2018/10/27 0027.
 */
public interface TrainingService {
    boolean addTraining(Training training);
    boolean deleteTraining(int taid);
    Training getTrainingById(int taid);
}
