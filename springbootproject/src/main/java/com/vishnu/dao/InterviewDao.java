package com.vishnu.dao;

import com.vishnu.model.Interview;

import java.util.List;

/**
 * Created by Administrator on 2018/10/24 0024.
 */
public interface InterviewDao {
    void addInterview(Interview interview);
    void updateInterview(Interview interview);
    Interview getInterviewById(int it_id);
    Interview getInterviewByMessId(int messid);
    Interview getInterviewByOther(Interview interview);
}
