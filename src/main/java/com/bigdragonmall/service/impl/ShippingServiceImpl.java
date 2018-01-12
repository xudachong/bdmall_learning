package com.bigdragonmall.service.impl;

import com.bigdragonmall.common.ServerResponse;
import com.bigdragonmall.dao.ShippingMapper;
import com.bigdragonmall.pojo.Shipping;
import com.bigdragonmall.service.IShippingService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: XuJuLong<5 7 4 4 0 8 5 7 8 @ qq.com>
 * @Description:
 * @Date: Created in 0:10 2018/1/10
 * @
 */
@Service("iShippingService")
public class ShippingServiceImpl implements IShippingService {

	@Autowired
	private ShippingMapper shippingMapper;

	@Override
	public ServerResponse add(Integer userId, Shipping shipping){
		shipping.setUserId(userId);
		int rowCount = shippingMapper.insert(shipping);
		if(rowCount > 0){
			Map result = Maps.newHashMap();
			result.put("shippingId",shipping.getId());
			return ServerResponse.createBySuccess("新建地址成功",result);
		}
		return ServerResponse.createByErrorMessage("新建地址失败");
	}

	@Override
	public ServerResponse<String> del(Integer userId, Integer shippingId){
		int resultCount = shippingMapper.deleteByShippingIdUserId(userId,shippingId);
		if(resultCount > 0){
			return ServerResponse.createBySuccess("删除地址成功");
		}
		return ServerResponse.createByErrorMessage("删除地址失败");
	}

	@Override
	public ServerResponse update(Integer userId, Shipping shipping){
		shipping.setUserId(userId);
		int rowCount = shippingMapper.updateByShipping(shipping);
		if(rowCount > 0){
			return ServerResponse.createBySuccess("更新地址成功");
		}
		return ServerResponse.createByErrorMessage("更新地址失败");
	}

	@Override
	public ServerResponse<Shipping> select(Integer userId, Integer shippingId){
		Shipping shipping = shippingMapper.selectByShippingIdUserId(userId,shippingId);
		if(shipping == null){
			return ServerResponse.createByErrorMessage("无法查询到该地址");
		}
		return ServerResponse.createBySuccess("查询地址成功",shipping);
	}

	@Override
	public ServerResponse<PageInfo> list(Integer userId, int pageNum, int pageSize){
		PageHelper.startPage(pageNum,pageSize);
		List<Shipping> shippingList = shippingMapper.selectByUserId(userId);
		PageInfo pageInfo = new PageInfo(shippingList);
		return ServerResponse.createBySuccess(pageInfo);
	}

}