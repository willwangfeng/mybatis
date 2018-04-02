package cn.itcast.mapper;

import java.io.IOException;

import cn.itcast.po.User;

public interface UserMapper {

	public User findUserById(int id) throws IOException;
	public User findUserByIdResultMap(int id) throws IOException;
}
