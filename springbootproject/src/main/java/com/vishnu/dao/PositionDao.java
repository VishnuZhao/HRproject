package com.vishnu.dao;

import com.vishnu.model.Position;
import javafx.geometry.Pos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/23 0023.
 */
public interface PositionDao{
    void addPosition(Position position);
    void deletePosition(int pos_id);
    void updatePosition(Position position);
    Position getPositionById(int pos_id);
    List<Position> getPositionByDepid(int depid);
    List<Position> getAllPosition();
    Position getPositionByNameAndDepid(HashMap map);
}
