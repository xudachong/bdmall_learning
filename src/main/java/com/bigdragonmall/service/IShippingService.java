package com.bigdragonmall.service;

import com.bigdragonmall.common.ServerResponse;
import com.bigdragonmall.pojo.Shipping;
import com.github.pagehelper.PageInfo;

/**
 * @Author: XuJuLong<5 7 4 4 0 8 5 7 8 @ qq.com>
 * @Description:
 * @Date: Created in 0:09 2018/1/10
 * @
 */
public interface IShippingService {

	ServerResponse add(Integer userId, Shipping shipping);

	ServerResponse<String> del(Integer userId, Integer shippingId);

	ServerResponse update(Integer userId, Shipping shipping);

	ServerResponse<Shipping> select(Integer userId, Integer shippingId);

	ServerResponse<PageInfo> list(Integer userId, int pageNum, int pageSize);

}
