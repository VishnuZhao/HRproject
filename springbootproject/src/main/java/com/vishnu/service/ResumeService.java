package com.vishnu.service;

import com.vishnu.model.Recruit;
import com.vishnu.model.Resume;

import java.util.List;

/**
 * Created by Administrator on 2018/10/22 0022.
 */
public interface ResumeService {
    boolean saveResume(Resume resume);
    boolean deleteResume(int re_id);
    boolean updateResume(Resume resume);
    Resume getResumeById(int re_id);
    List<Resume> getResumeByUid(int uid);

}
