package com.bigdragonmall.controller.common;

import com.bigdragonmall.common.Const;
import com.bigdragonmall.pojo.User;
import com.bigdragonmall.util.CookieUtil;
import com.bigdragonmall.util.JsonUtil;
import com.bigdragonmall.util.RedisShardedPoolUtil;
import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author: XuJuLong<5 7 4 4 0 8 5 7 8 @ qq.com>
 * @Description:
 * @Date: Created in 22:44 2018/2/5
 * @
 */
public class SessionExpireFilter implements Filter{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;

		String loginToken = CookieUtil.readLoginToken(httpServletRequest);

		if(StringUtils.isNotEmpty(loginToken)){
			//判断logintoken是否为空或者""；
			//如果不为空的话，符合条件，继续拿user信息

			String userJsonStr = RedisShardedPoolUtil.get(loginToken);
			User user = JsonUtil.string2Obj(userJsonStr,User.class);
			if(user != null){
				//如果user不为空，则重置session的时间，即调用expire命令
				RedisShardedPoolUtil.expire(loginToken, Const.RedisCacheExtime.REDIS_SESSION_EXTIME);
			}
		}
		filterChain.doFilter(servletRequest,servletResponse);
	}

	@Override
	public void destroy() {

	}
}
