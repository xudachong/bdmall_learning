package com.bigdragonmall.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * @Author: XuJuLong<5 7 4 4 0 8 5 7 8 @ qq.com>
 * @Description:
 * @Date: Created in 10:00 2017/12/20
 * @
 */
//如果字段是空，就不需要加到json当中
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T>  implements Serializable{

	private int status;
	private String msg;
	private T data;

	private ServerResponse(int status) {
		this.status = status;
	}

	//注意该构造器与下一个构造器的区别，当第二个参数是非String的时候，则调用这个，当是string时用下面那个，那么当data的泛型是String是呢？
	// 待会会在对外的public方法中规避这个问题
	private ServerResponse(int status, T data) {
		this.status = status;
		this.data = data;
	}

	private ServerResponse(int status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	private ServerResponse(int status, String msg, T data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	//封装一个方法，确认该响应是否正确,这个字段不需要显示在json里，再下面那三个public的get才需要
	@JsonIgnore
	public boolean isSuccess(){
		return this.status == ResponseCode.SUCCESS.getCode();
	}

	public int getStatus() {
		return status;
	}

	public String getMsg() {
		return msg;
	}

	public T getData() {
		return data;
	}

	public static <T> ServerResponse<T> createBySuccess(){
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
	}

	public static <T> ServerResponse<T> createBySuccessMessage(String msg){
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
	}
	//当data是String时，调用该方法或下一个
	public static <T> ServerResponse<T> createBySuccess(T data){
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
	}

	//当data是String时，调用该方法
	public static <T> ServerResponse<T> createBySuccess(String msg, T data){
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
	}

	public static <T> ServerResponse<T> createByError(){
		return new ServerResponse<T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
	}

	public static <T> ServerResponse<T> createByErrorMessage(String errorMessage){
		return new ServerResponse<T>(ResponseCode.ERROR.getCode(),errorMessage);
	}

	public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode, String errorMessage){
		return new ServerResponse<T>(errorCode,errorMessage);
	}

}
