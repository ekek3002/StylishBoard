package spms.dao;

import java.util.List;

import spms.vo.User;

public interface UserDao {

	public List<User> selectList() throws Exception;
	public int insert(User user) throws Exception;
	public int delete(int no) throws Exception;
	public User selectOne(int no) throws Exception;
	public User selectOne(String email) throws Exception;
	public int update(User user) throws Exception;
	public User exist(String id, String password) throws Exception;
}




