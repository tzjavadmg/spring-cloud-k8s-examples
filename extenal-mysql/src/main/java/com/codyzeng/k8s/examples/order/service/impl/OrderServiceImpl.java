package com.codyzeng.k8s.examples.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.codyzeng.k8s.examples.order.dao.OrderDao;
import com.codyzeng.k8s.examples.order.entity.Order;
import com.codyzeng.k8s.examples.order.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * 订单表(Order)表服务实现类
 *
 */
@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {

}

