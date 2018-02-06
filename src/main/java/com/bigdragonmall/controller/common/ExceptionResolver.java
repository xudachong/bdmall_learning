package com.bigdragonmall.controller.common;

import com.bigdragonmall.common.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: XuJuLong<5 7 4 4 0 8 5 7 8 @ qq.com>
 * @Description:
 * @Date: Created in 12:25 2018/2/6
 * @
 */
@Slf4j
@Component
public class ExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
		log.error("{} Exception",httpServletRequest.getRequestURI(),e);
		//当使用时jackson2.x的时候使用MappingJackson2JsonView，课程中使用的是1.9
		ModelAndView modelAndView = new ModelAndView(new MappingJacksonJsonView());
		modelAndView.addObject("status", ResponseCode.ERROR.getCode());
		modelAndView.addObject("msg","接口异常，详情请查看服务端控制台");
		modelAndView.addObject("data",e.toString());

		return modelAndView;
	}
}
