package com.vishnu.service.impl;

import com.vishnu.dao.ResumeDao;
import com.vishnu.model.Resume;
import com.vishnu.service.ResumeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/10/22 0022.
 */
@Service
public class ResumeServiceImpl implements ResumeService {
    @Resource
    private ResumeDao resumeDao;
    @Override
    public boolean saveResume(Resume resume) {
        if (resume==null){
            return false;
        }
        resumeDao.saveResume(resume);
        return true;
    }

    @Override
    public boolean deleteResume(int re_id) {
        if (re_id<10000){
            return false;
        }
        resumeDao.deleteResume(re_id);
        return true;
    }

    @Override
    public boolean updateResume(Resume resume) {
        if (resume==null){
            return false;
        }
        resumeDao.updateResume(resume);
        return true;
    }

    @Override
    public Resume getResumeById(int re_id) {
        if (re_id<10000){
            return null;
        }
        return resumeDao.getResumeById(re_id);
    }

    @Override
    public List<Resume> getResumeByUid(int uid) {
        if (uid<10000){
            return null;
        }
        return resumeDao.getResumeByUid(uid);
    }
}
