package com.vishnu.dao;

import com.vishnu.model.Message;

import java.util.List;

/**
 * Created by Administrator on 2018/10/24 0024.
 */
public interface MessageDao {
    void addMessage(Message message);
    void updateMessage(Message message);
    Message getMessageById(int me_id);
    List<Message> getMessageByUid(int uid);
    List<Message> getMessageByEmpId(int emp_id);
    Message getMessageByItid(int itid);
    List<Message> getMessageByAcceptInt();
}
