package com.bigdragonmall.service;

import com.bigdragonmall.common.ServerResponse;
import com.bigdragonmall.vo.CartVo;

/**
 * @Author: XuJuLong<5 7 4 4 0 8 5 7 8 @ qq.com>
 * @Description:
 * @Date: Created in 20:43 2018/1/9
 * @
 */
public interface ICartService {

	ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count);

	ServerResponse<CartVo> list(Integer userId);

	ServerResponse<CartVo> update(Integer userId, Integer productId, Integer count);

	ServerResponse<CartVo> deleteProduct(Integer userId, String productIds);

	ServerResponse<CartVo> selectOrUnSelect(Integer userId, Integer productId, Integer checked);

	ServerResponse<Integer> getCartProductCount(Integer userId);

}
