package com.bigdragonmall.controller.backend;

import com.bigdragonmall.common.Const;
import com.bigdragonmall.common.ServerResponse;
import com.bigdragonmall.pojo.User;
import com.bigdragonmall.service.IUserService;
import com.bigdragonmall.util.CookieUtil;
import com.bigdragonmall.util.JsonUtil;
import com.bigdragonmall.util.RedisShardedPoolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: XuJuLong<5 7 4 4 0 8 5 7 8 @ qq.com>
 * @Description:
 * @Date: Created in 12:58 2017/12/29
 * @
 */
@Controller
@RequestMapping("/manage/user")
public class UserManageController {

	@Autowired
	private IUserService iUserService;

	@RequestMapping(value="login.do",method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse<User> login(String username, String password, HttpSession session, HttpServletResponse httpServletResponse){
		ServerResponse<User> response = iUserService.login(username,password);
		if(response.isSuccess()){
			User user = response.getData();
			if(user.getRole() == Const.Role.ROLE_ADMIN){
				//说明登录的是管理员
//				session.setAttribute(Const.CURRENT_USER,user);
				//新增redis共享cookie，session的方法
				CookieUtil.writeLoginToken(httpServletResponse,session.getId());
				RedisShardedPoolUtil.setEx(session.getId(), JsonUtil.obj2String(response.getData()),Const.RedisCacheExtime.REDIS_SESSION_EXTIME);

				return response;
			}else{
				return ServerResponse.createByErrorMessage("不是管理员,无法登录");
			}
		}
		return response;
	}

}
