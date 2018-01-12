package com.bigdragonmall.service;

import com.bigdragonmall.common.ServerResponse;
import com.bigdragonmall.vo.OrderVo;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * @Author: XuJuLong<5 7 4 4 0 8 5 7 8 @ qq.com>
 * @Description:
 * @Date: Created in 16:13 2018/1/10
 * @
 */
public interface IOrderService {

	ServerResponse pay(Long orderNo, Integer userId, String path);

	ServerResponse aliCallback(Map<String, String> params);

	ServerResponse queryOrderPayStatus(Integer userId, Long orderNo);

	ServerResponse createOrder(Integer userId, Integer shippingId);

	ServerResponse<String> cancel(Integer userId, Long orderNo);

	ServerResponse getOrderCartProduct(Integer userId);

	ServerResponse<OrderVo> getOrderDetail(Integer userId, Long orderNo);

	ServerResponse<PageInfo> getOrderList(Integer userId, int pageNum, int pageSize);



	ServerResponse<PageInfo> manageList(int pageNum, int pageSize);

	ServerResponse<OrderVo> manageDetail(Long orderNo);

	ServerResponse<PageInfo> manageSearch(Long orderNo, int pageNum, int pageSize);

	ServerResponse<String> manageSendGoods(Long orderNo);

}
