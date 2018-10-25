package com.vishnu.service.impl;

import com.vishnu.dao.MessageDao;
import com.vishnu.model.Message;
import com.vishnu.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/10/24 0024.
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDao messageDao;
    @Override
    public boolean addMessage(Message message) {
        if (message==null){
            return false;
        }
        messageDao.addMessage(message);
        return true;
    }

    @Override
    public boolean updateMessage(Message message) {
        if (message==null){
            return false;
        }
        messageDao.updateMessage(message);
        return true;
    }

    @Override
    public Message getMessageById(int me_id) {
        if (me_id<10000){
            return null;
        }
        return messageDao.getMessageById(me_id);
    }

    @Override
    public List<Message> getMessageByUid(int uid) {
        if (uid<10000){
            return null;
        }
        return messageDao.getMessageByUid(uid);
    }

    @Override
    public List<Message> getMessageByEmp_id(int emp_id) {
        if (emp_id<10000){
            return null;
        }
        return messageDao.getMessageByEmpId(emp_id);
    }

    @Override
    public Message getMessageByItid(int itid) {
        if (itid<10000){
            return null;
        }
        return messageDao.getMessageByItid(itid);
    }

    @Override
    public List<Message> getMessageByAcceptInt() {
        return messageDao.getMessageByAcceptInt();
    }
}
