package com.vishnu.service.impl;

import com.vishnu.dao.InterviewDao;
import com.vishnu.model.Interview;
import com.vishnu.service.InterviewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/10/24 0024.
 */
@Service
public class InterviewServiceImpl implements InterviewService {
    @Resource
    private InterviewDao interviewDao;

    @Override
    public boolean addInterview(Interview interview) {
        if (interview==null){
            return false;
        }
        interviewDao.addInterview(interview);
        return true;
    }

    @Override
    public Interview getInterviewById(int it_id) {
        if (it_id<10000){
            return null;
        }
        return interviewDao.getInterviewById(it_id);
    }

    @Override
    public Interview getInterviewByMessId(int messid) {
        if (messid<10000){
            return null;
        }
        return interviewDao.getInterviewByMessId(messid);
    }

    @Override
    public Interview getInterviewByOther(Interview interview) {
        if (interview==null){
            return null;
        }
        return interviewDao.getInterviewByOther(interview);
    }

    @Override
    public boolean updateInterview(Interview interview) {
        if (interview==null){
            return false;
        }
        interviewDao.updateInterview(interview);
        return true;
    }
}
