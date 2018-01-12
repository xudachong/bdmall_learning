package com.bigdragonmall.service;

import com.bigdragonmall.common.ServerResponse;
import com.bigdragonmall.pojo.User;

/**
 * @Author: XuJuLong<5 7 4 4 0 8 5 7 8 @ qq.com>
 * @Description:
 * @Date: Created in 9:56 2017/12/20
 * @
 */
public interface IUserService {

	ServerResponse<User> login(String userName, String password);
	ServerResponse<String> register(User user);
	ServerResponse<String> checkValid(String str, String type);
	ServerResponse selectQuestion(String username);
	ServerResponse<String> checkAnswer(String username, String question, String answer);
	ServerResponse<String> forgetResetPassword(String username, String passwordNew, String forgetToken);
	ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user);
	ServerResponse<User> updateInformation(User user);
	ServerResponse<User> getInformation(Integer userId);
	ServerResponse checkAdminRole(User user);

}
