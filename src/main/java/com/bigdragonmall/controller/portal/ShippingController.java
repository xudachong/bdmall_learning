package com.bigdragonmall.controller.portal;

import com.bigdragonmall.common.Const;
import com.bigdragonmall.common.ResponseCode;
import com.bigdragonmall.common.ServerResponse;
import com.bigdragonmall.pojo.Shipping;
import com.bigdragonmall.pojo.User;
import com.bigdragonmall.service.IShippingService;
import com.bigdragonmall.util.CookieUtil;
import com.bigdragonmall.util.JsonUtil;
import com.bigdragonmall.util.RedisPoolUtil;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: XuJuLong<5 7 4 4 0 8 5 7 8 @ qq.com>
 * @Description:
 * @Date: Created in 0:11 2018/1/10
 * @
 */
@Controller
@RequestMapping("/shipping/")
public class ShippingController {

	@Autowired
	private IShippingService iShippingService;


	@RequestMapping("add.do")
	@ResponseBody
	public ServerResponse add(HttpServletRequest httpServletRequest, Shipping shipping){
		//为了处理横向越权，即某些登陆了的用户，把其它用户的id传过来操作，所以必须是在session中获取userID,以下所有操作都是
		String loginToken = CookieUtil.readLoginToken(httpServletRequest);
		if(StringUtils.isEmpty(loginToken)){
			return ServerResponse.createByErrorMessage("用户未登录,无法获取当前用户的信息");
		}
		String userJsonStr = RedisPoolUtil.get(loginToken);
		User user = JsonUtil.string2Obj(userJsonStr,User.class);
		if(user ==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
		}
		return iShippingService.add(user.getId(),shipping);
	}


	@RequestMapping("del.do")
	@ResponseBody
	public ServerResponse del(HttpServletRequest httpServletRequest,Integer shippingId){
		String loginToken = CookieUtil.readLoginToken(httpServletRequest);
		if(StringUtils.isEmpty(loginToken)){
			return ServerResponse.createByErrorMessage("用户未登录,无法获取当前用户的信息");
		}
		String userJsonStr = RedisPoolUtil.get(loginToken);
		User user = JsonUtil.string2Obj(userJsonStr,User.class);
		if(user ==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
		}
		return iShippingService.del(user.getId(),shippingId);
	}

	@RequestMapping("update.do")
	@ResponseBody
	public ServerResponse update(HttpServletRequest httpServletRequest,Shipping shipping){
		String loginToken = CookieUtil.readLoginToken(httpServletRequest);
		if(StringUtils.isEmpty(loginToken)){
			return ServerResponse.createByErrorMessage("用户未登录,无法获取当前用户的信息");
		}
		String userJsonStr = RedisPoolUtil.get(loginToken);
		User user = JsonUtil.string2Obj(userJsonStr,User.class);
		if(user ==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
		}
		return iShippingService.update(user.getId(),shipping);
	}


	@RequestMapping("select.do")
	@ResponseBody
	public ServerResponse<Shipping> select(HttpServletRequest httpServletRequest, Integer shippingId){
		String loginToken = CookieUtil.readLoginToken(httpServletRequest);
		if(StringUtils.isEmpty(loginToken)){
			return ServerResponse.createByErrorMessage("用户未登录,无法获取当前用户的信息");
		}
		String userJsonStr = RedisPoolUtil.get(loginToken);
		User user = JsonUtil.string2Obj(userJsonStr,User.class);
		if(user ==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
		}
		return iShippingService.select(user.getId(),shippingId);
	}


	@RequestMapping("list.do")
	@ResponseBody
	public ServerResponse<PageInfo> list(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
										 @RequestParam(value = "pageSize",defaultValue = "10")int pageSize,
										 HttpServletRequest httpServletRequest){
		String loginToken = CookieUtil.readLoginToken(httpServletRequest);
		if(StringUtils.isEmpty(loginToken)){
			return ServerResponse.createByErrorMessage("用户未登录,无法获取当前用户的信息");
		}
		String userJsonStr = RedisPoolUtil.get(loginToken);
		User user = JsonUtil.string2Obj(userJsonStr,User.class);
		if(user ==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
		}
		return iShippingService.list(user.getId(),pageNum,pageSize);
	}

}
