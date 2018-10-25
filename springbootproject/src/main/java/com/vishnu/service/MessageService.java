package com.vishnu.service;

import com.vishnu.model.Message;

import java.util.List;

/**
 * Created by Administrator on 2018/10/24 0024.
 */
public interface MessageService {
    boolean addMessage(Message message);
    boolean updateMessage(Message message);
    Message getMessageById(int me_id);
    List<Message> getMessageByUid(int uid);
    List<Message> getMessageByEmp_id(int emp_id);
    Message getMessageByItid(int itid);
    List<Message> getMessageByAcceptInt();
}
