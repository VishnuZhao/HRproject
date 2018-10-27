package com.vishnu.dao;

import com.vishnu.model.Training;

import java.util.List;

/**
 * Created by Administrator on 2018/10/27 0027.
 */
public interface TrainingDao {
    void addTraining(Training training);
    void deleteTraining(int taid);
    Training getTrainingById(int taid);
}
