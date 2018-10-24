package com.vishnu.service.impl;

import com.vishnu.dao.PositionDao;
import com.vishnu.model.Position;
import com.vishnu.service.PositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/10/23 0023.
 */
@Service
public class PositionServiceImpl implements PositionService{
    @Resource
    private PositionDao positionDao;
    @Override
    public boolean addPosition(Position position) {
        if (position==null){
            return false;
        }
        positionDao.addPosition(position);
        return true;
    }

    @Override
    public boolean deletePosition(int pos_id) {
        if (pos_id<10000){
            return false;
        }
        positionDao.deletePosition(pos_id);
        return true;
    }

    @Override
    public boolean updatePosition(Position position) {
        if (position==null){
            return false;
        }
        positionDao.updatePosition(position);
        return true;
    }

    @Override
    public Position getPositionById(int pos_id) {
        if (pos_id<10000){
            return null;
        }
        return positionDao.getPositionById(pos_id);
    }

    @Override
    public List<Position> getAllPosition() {
        return positionDao.getAllPosition();
    }
}
