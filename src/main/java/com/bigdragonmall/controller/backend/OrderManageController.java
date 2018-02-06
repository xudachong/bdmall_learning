package com.bigdragonmall.controller.backend;

import com.bigdragonmall.common.ResponseCode;
import com.bigdragonmall.common.ServerResponse;
import com.bigdragonmall.pojo.User;
import com.bigdragonmall.service.IOrderService;
import com.bigdragonmall.service.IUserService;
import com.bigdragonmall.util.CookieUtil;
import com.bigdragonmall.util.JsonUtil;
import com.bigdragonmall.util.RedisShardedPoolUtil;
import com.bigdragonmall.vo.OrderVo;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: XuJuLong<5 7 4 4 0 8 5 7 8 @ qq.com>
 * @Description:
 * @Date: Created in 23:15 2018/1/10
 * @
 */
@Controller
@RequestMapping("/manage/order")
public class OrderManageController {

	@Autowired
	private IUserService iUserService;
	@Autowired
	private IOrderService iOrderService;

	@RequestMapping("list.do")
	@ResponseBody
	public ServerResponse<PageInfo> orderList(HttpServletRequest httpServletRequest, @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
											  @RequestParam(value = "pageSize",defaultValue = "10")int pageSize){

//        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
//        if(StringUtils.isEmpty(loginToken)){
//            return ServerResponse.createByErrorMessage("用户未登录,无法获取当前用户的信息");
//        }
//        String userJsonStr = RedisShardedPoolUtil.get(loginToken);
//        User user = JsonUtil.string2Obj(userJsonStr,User.class);
//
//        if(user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录管理员");
//
//        }
//        if(iUserService.checkAdminRole(user).isSuccess()){
//            //填充我们增加产品的业务逻辑
//            return iOrderService.manageList(pageNum,pageSize);
//        }else{
//            return ServerResponse.createByErrorMessage("无权限操作");
//        }
		//全部通过拦截器验证是否登录以及权限
		return iOrderService.manageList(pageNum,pageSize);
	}

	@RequestMapping("detail.do")
	@ResponseBody
	public ServerResponse<OrderVo> orderDetail(HttpServletRequest httpServletRequest, Long orderNo){

//        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
//        if(StringUtils.isEmpty(loginToken)){
//            return ServerResponse.createByErrorMessage("用户未登录,无法获取当前用户的信息");
//        }
//        String userJsonStr = RedisShardedPoolUtil.get(loginToken);
//        User user = JsonUtil.string2Obj(userJsonStr,User.class);
//
//        if(user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录管理员");
//
//        }
//        if(iUserService.checkAdminRole(user).isSuccess()){
//            //填充我们增加产品的业务逻辑
//
//            return iOrderService.manageDetail(orderNo);
//        }else{
//            return ServerResponse.createByErrorMessage("无权限操作");
//        }
		//全部通过拦截器验证是否登录以及权限
		return iOrderService.manageDetail(orderNo);
	}



	@RequestMapping("search.do")
	@ResponseBody
	public ServerResponse<PageInfo> orderSearch(HttpServletRequest httpServletRequest, Long orderNo,@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
												@RequestParam(value = "pageSize",defaultValue = "10")int pageSize){
//        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
//        if(StringUtils.isEmpty(loginToken)){
//            return ServerResponse.createByErrorMessage("用户未登录,无法获取当前用户的信息");
//        }
//        String userJsonStr = RedisShardedPoolUtil.get(loginToken);
//        User user = JsonUtil.string2Obj(userJsonStr,User.class);
//        if(user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录管理员");
//
//        }
//        if(iUserService.checkAdminRole(user).isSuccess()){
//            //填充我们增加产品的业务逻辑
//            return iOrderService.manageSearch(orderNo,pageNum,pageSize);
//        }else{
//            return ServerResponse.createByErrorMessage("无权限操作");
//        }
		//全部通过拦截器验证是否登录以及权限
		return iOrderService.manageSearch(orderNo,pageNum,pageSize);
	}



	@RequestMapping("send_goods.do")
	@ResponseBody
	public ServerResponse<String> orderSendGoods(HttpServletRequest httpServletRequest, Long orderNo){

//        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
//        if(StringUtils.isEmpty(loginToken)){
//            return ServerResponse.createByErrorMessage("用户未登录,无法获取当前用户的信息");
//        }
//        String userJsonStr = RedisShardedPoolUtil.get(loginToken);
//        User user = JsonUtil.string2Obj(userJsonStr,User.class);
//
//        if(user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录管理员");
//
//        }
//        if(iUserService.checkAdminRole(user).isSuccess()){
//            //填充我们增加产品的业务逻辑
//            return iOrderService.manageSendGoods(orderNo);
//        }else{
//            return ServerResponse.createByErrorMessage("无权限操作");
//        }
		//全部通过拦截器验证是否登录以及权限
		return iOrderService.manageSendGoods(orderNo);
	}

}
