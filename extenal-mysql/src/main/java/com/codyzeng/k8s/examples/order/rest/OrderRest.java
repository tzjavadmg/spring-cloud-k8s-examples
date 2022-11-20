package com.codyzeng.k8s.examples.order.rest;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.druid.support.json.JSONUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.codyzeng.k8s.examples.api.PageRequest;
import com.codyzeng.k8s.examples.api.PageResponse;
import com.codyzeng.k8s.examples.api.ResponseResult;
import com.codyzeng.k8s.examples.order.entity.Order;
import com.codyzeng.k8s.examples.order.service.OrderService;
import com.codyzeng.k8s.examples.vo.OrderVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单表(Order)表控制层
 *
 */
@Slf4j
@RestController
@RequestMapping("order")
public class OrderRest {
    /**
     * 服务对象
     */
    @Resource
    private OrderService orderService;

    /**
     * 分页查询
     *
     * @param pageVO   分页筛选条件
     * @return 查询结果
     */
    @GetMapping("page")
    public ResponseResult<PageResponse<OrderVO>> page(@RequestBody PageRequest<OrderVO> pageVO) {
        Order order = BeanUtil.copyProperties(pageVO.getParam(), Order.class);
        Page<Order> page = new Page<>();
        BeanUtil.copyProperties(pageVO, page);
        IPage<Order> pageResult = orderService.page(page, new QueryWrapper<>(order));

        PageResponse<OrderVO> pageResponse = new PageResponse<>();
        BeanUtil.copyProperties(pageResult, pageResponse);
        List<OrderVO> orderVoList=BeanUtil.copyToList(pageResult.getRecords(),OrderVO.class);
        pageResponse.setRecords(orderVoList);
        return ResponseResult.ok(pageResponse);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("get")
    public ResponseResult<Order> get(Long id) {
        log.info("查询订单明细数据：{}", id);
        return ResponseResult.ok(orderService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param orderVO 实体
     * @return 新增结果
     */
    @PostMapping("create")
    public ResponseResult<Boolean> create(@RequestBody OrderVO orderVO) {
        log.info("创建订单数据：{}", JSONUtils.toJSONString(orderVO));
        Order order= BeanUtil.copyProperties(orderVO,Order.class);
        return ResponseResult.ok(orderService.save(order));
    }

    /**
     * 编辑数据
     *
     * @param orderVO 实体
     * @return 编辑结果
     */
    @PostMapping("update")
    public ResponseResult<Boolean> update(@RequestBody OrderVO orderVO) {
        log.info("更新订单数据：{}", JSONUtils.toJSONString(orderVO));
        Order order= BeanUtil.copyProperties(orderVO,Order.class);
        return ResponseResult.ok(orderService.updateById(order));
    }

    /**
     * 删除数据
     *
     * @param ids 主键集
     * @return 删除是否成功
     */
    @PostMapping("delete")
    public ResponseResult<Boolean> delete(@RequestParam("ids") List<Long> ids) {
        return ResponseResult.ok(orderService.removeByIds(ids));
    }

}

