package com.vishnu.service;

import com.vishnu.model.TrainingRecord;

import java.util.List;

/**
 * Created by Administrator on 2018/10/27 0027.
 */
public interface TrainingRecordService {
    boolean addTR(TrainingRecord trainingRecord);
    TrainingRecord getTRById(int trid);
    List<TrainingRecord> getTRByEmpId(int empid);
    List<TrainingRecord> getAllTR();
}
