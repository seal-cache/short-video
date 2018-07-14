package com.imooc.service;

import com.imooc.pojo.Users;

public interface UserService {
	
	/**
	 * 判断用户名是否存在
	 * @param username
	 * @return
	 */
	public boolean queryUsernameIsExist(String username);
	
	/**
	 * 保存用户
	 * @param user
	 */
	public void saveUser( Users user);
}
