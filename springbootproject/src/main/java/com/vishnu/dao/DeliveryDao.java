package com.vishnu.dao;

import com.vishnu.model.Delivery;

import java.util.List;

/**
 * Created by Administrator on 2018/10/24 0024.
 */
public interface DeliveryDao {
    void addDelivery(Delivery delivery);
    void updateDelivery(Delivery delivery);
    void deleteDelivery(int dv_id);
    List<Delivery> getAllDelivery();
    Delivery getDeliveryById(int id);
}
