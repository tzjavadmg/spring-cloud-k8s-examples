package com.codyzeng.k8s.examples.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单表(Order)视图类
 *
 * @author codyzeng
 * @since 2022-10-24 15:28:11
 */
@Data
public class OrderVO implements Serializable {
    
    /**
     * 主键ID
     */     
    private Long id;
    /**
     * 订单编号
     */     
    private String orderNo;
    /**
     * 下单时间
     */     
    private LocalDateTime orderTime;
    /**
     * 订单类型(0:普通订单;1:团购订单;2:秒杀订单)
     */     
    private Integer orderType;
    /**
     * 订单来源(0:微信;1:andriod;2:ios)
     */     
    private Integer orderSource;
    /**
     * 订单金额(扣除优惠)
     */     
    private BigDecimal orderAmount;
    /**
     * 商品金额
     */     
    private BigDecimal productAmount;
    /**
     * 运费金额
     */     
    private BigDecimal freightAmount;
    /**
     * 促销优惠金额（促销价、满减、阶梯价）
     */     
    private BigDecimal promotionAmount;
    /**
     * 优惠券抵扣金额
     */     
    private BigDecimal couponAmount;
    /**
     * 积分抵扣金额
     */     
    private BigDecimal pointsAmount;
    /**
     * 用户ID
     */     
    private Long userId;
    /**
     * 用户姓名
     */     
    private String userName;
    /**
     * 用户手机号
     */     
    private String userPhone;
    /**
     * 收货人姓名
     */     
    private String receiverName;
    /**
     * 收货人电话
     */     
    private String receiverPhone;
    /**
     * 收货人省份/直辖市
     */     
    private String receiverProvince;
    /**
     * 收货人城市
     */     
    private String receiverCity;
    /**
     * 收货人区
     */     
    private String receiverRegion;
    /**
     * 收货人详细地址
     */     
    private String receiverAddress;
    /**
     * 支付方式(0:微信;1:支付宝;2:银联)
     */     
    private Integer paymentMode;
    /**
     * 支付时间
     */     
    private LocalDateTime paymentTime;
    /**
     * 支付金额(扣除积分)
     */     
    private BigDecimal paymentAmount;
    /**
     * 订单状态(订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单)
     */     
    private Integer status;
    /**
     * 赚取积分
     */     
    private Integer earnPoints;
    /**
     * 使用积分
     */     
    private Integer usePoints;
    /**
     * 发货时间
     */     
    private LocalDateTime deliveryTime;
    /**
     * 收货时间
     */     
    private LocalDateTime receiveTime;
    /**
     * 订单备注
     */     
    private String remark;


}

