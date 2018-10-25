package com.vishnu.service;

import com.vishnu.model.Interview;

/**
 * Created by Administrator on 2018/10/24 0024.
 */
public interface InterviewService {
    boolean addInterview(Interview interview);
    Interview getInterviewById(int it_id);
    Interview getInterviewByMessId(int messid);
    Interview getInterviewByOther(Interview interview);
    boolean updateInterview(Interview interview);
}
