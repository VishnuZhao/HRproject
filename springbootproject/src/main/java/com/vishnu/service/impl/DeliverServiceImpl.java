package com.vishnu.service.impl;

import com.vishnu.dao.DeliveryDao;
import com.vishnu.model.Delivery;
import com.vishnu.service.DeliveryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/10/24 0024.
 */
@Service
public class DeliverServiceImpl implements DeliveryService {
    @Resource
    private DeliveryDao deliveryDao;
    @Override
    public boolean addDelivery(Delivery delivery) {
        if (delivery==null){
            return false;
        }
        deliveryDao.addDelivery(delivery);
        return true;
    }

    @Override
    public boolean updateDelivery(Delivery delivery) {
        if (delivery==null){
            return false;
        }
        deliveryDao.updateDelivery(delivery);
        return true;
    }

    @Override
    public boolean deleteDelivery(int dv_id) {
        if (dv_id<10000){
            return false;
        }
        deliveryDao.deleteDelivery(dv_id);
        return true;
    }

    @Override
    public List<Delivery> getAllDelivery() {
        return deliveryDao.getAllDelivery();
    }

    @Override
    public Delivery getDeliveryById(int id) {
        if (id<10000){
            return null;
        }
        return deliveryDao.getDeliveryById(id);
    }
}
