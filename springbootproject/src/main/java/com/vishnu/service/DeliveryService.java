package com.vishnu.service;

import com.vishnu.model.Delivery;

import java.util.List;

/**
 * Created by Administrator on 2018/10/24 0024.
 */
public interface DeliveryService {
    boolean addDelivery(Delivery delivery);
    boolean updateDelivery(Delivery delivery);
    boolean deleteDelivery(int dv_id);
    List<Delivery> getAllDelivery();
    Delivery getDeliveryById(int id);
}
