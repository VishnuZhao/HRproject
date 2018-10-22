package com.vishnu.dao;

import com.vishnu.model.Resume;

import java.util.List;

/**
 * Created by Administrator on 2018/10/22 0022.
 */
public interface ResumeDao {
    void saveResume(Resume resume);
    void deleteResume(int re_id);
    void updateResume(Resume resume);
    Resume getResumeById(int re_id);
    List<Resume> getResumeByUid(int uid);
}
