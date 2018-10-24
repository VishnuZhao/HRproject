package com.vishnu.service;

import com.vishnu.model.Position;

import java.util.List;

/**
 * Created by Administrator on 2018/10/23 0023.
 */
public interface PositionService {
    boolean addPosition(Position position);
    boolean deletePosition(int pos_id);
    boolean updatePosition(Position position);
    Position getPositionById(int pos_id);
    List<Position> getAllPosition();
}
