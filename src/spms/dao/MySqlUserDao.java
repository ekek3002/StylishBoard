package spms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import spms.annotation.Component;
import spms.vo.User;

@Component("userDao")
public class MySqlUserDao implements UserDao{
	
	DataSource ds = null;
	
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}

	public List<User> selectList() throws Exception {

		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		final String sqlSelect = "SELECT uno,id,pwd,uname,gender,email,upoint" + "\r\n" + "FROM members" + "\r\n"
				+ "ORDER BY uno ASC";

		try {
			connection = ds.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sqlSelect);

			ArrayList<User> users = new ArrayList<User>();

			while (rs.next()) {
				users.add(new User().setNo(rs.getInt("uno")).setId(rs.getString("id"))
						.setName(rs.getString("uname")).setGender(rs.getString("gender"))
						.setEmail(rs.getString("email")).setUpoint(rs.getInt("upoint")));
			}

			return users;

		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			/* DataSource 객체 내부의 Pool에서 대여한 후
			 * close()시 반납처리
			 * 여기서의 close()는 닫는 것이 아니라 반납
			 * */
			try {
				if(connection != null)
					connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public int insert(User user) throws Exception {
		Connection connection = null;
		int result = 0;
		int num=500;
		PreparedStatement stmt = null;
		final String sqlInsert = "INSERT INTO users(id,pwd,uname,gender,email,upoint)" + "\r\n"
				+ "VALUES(?,?, ?, ?, ?, ?)";
		//final String sqlInsert = "INSERT INTO users(id,pwd,uname,email) VALUES('?','?','?','?')";
		
		try {
			connection = ds.getConnection();
			//connection = connPool.getConnection();
			stmt = connection.prepareStatement(sqlInsert);
			stmt.setString(1, user.getId());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getName());
			stmt.setString(4, user.getGender());
			stmt.setString(5, user.getEmail());
			stmt.setInt(6, num);
			
			result = stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(connection != null)
					connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}			
//			if (connection != null) {
//				connPool.returnConnection(connection);
//			}
		}

		return result;
	}

	public int delete(int no) throws Exception {
		Connection connection = null;
		int result = 0;
		Statement stmt = null;
		final String sqlDelete = "DELETE FROM users WHERE uno=";

		try {
			connection = ds.getConnection();
			//connection = connPool.getConnection();
			stmt = connection.createStatement();
			result = stmt.executeUpdate(sqlDelete + no);

		} catch (Exception e) {
			throw e;

		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
			}
			try {
				if(connection != null)
					connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}			
//			if (connection != null) {
//				connPool.returnConnection(connection);
//			}
		}

		return result;
	}

	public User selectOne(String email) throws Exception {
		Connection connection = null;
		User user = null;
		Statement stmt = null;
		ResultSet rs = null;

		final String sqlSelectOne = "SELECT uno,id,pwd,uname,gender,email,upoint FROM users" + " WHERE email=";

		try {
			connection = ds.getConnection();
			//connection = connPool.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sqlSelectOne +"'" +email+"'");
			boolean bool = rs.next();
			if (bool) {
				user = new User().setNo(rs.getInt("uno")).setId(rs.getString("id"))
						.setPassword(rs.getString("pwd")).setName(rs.getString("uname"))
						.setGender(rs.getString("gender")).setEmail(rs.getString("email")).setUpoint(rs.getInt("upoint"));

			} else {
				throw new Exception("해당 번호의 회원을 찾을 수 없습니다.");
			}

		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
			}
			try {
				if(connection != null)
					connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}			
//			if (connection != null) {
//				connPool.returnConnection(connection);
//			}
		}

		return user;
	}
	
	public User selectOne(int no) throws Exception {
		Connection connection = null;
		User user = null;
		Statement stmt = null;
		ResultSet rs = null;

		final String sqlSelectOne = "SELECT uno,id,pwd,uname,gender,email,upoint FROM users" + " WHERE uno=";

		try {
			connection = ds.getConnection();
			//connection = connPool.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sqlSelectOne + no);
			if (rs.next()) {
				user = new User().setNo(rs.getInt("uno")).setId(rs.getString("id"))
						.setPassword(rs.getString("pwd")).setName(rs.getString("uname"))
						.setGender(rs.getString("gender")).setEmail(rs.getString("email")).setUpoint(rs.getInt("upoint"));

			} else {
				throw new Exception("해당 번호의 회원을 찾을 수 없습니다.");
			}

		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
			}
			try {
				if(connection != null)
					connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}			
//			if (connection != null) {
//				connPool.returnConnection(connection);
//			}
		}

		return user;
	}

	public int update(User user) throws Exception {
		Connection connection = null;
		int result = 0;
		PreparedStatement stmt = null;
		final String sqlUpdate = "UPDATE users SET id=?,pwd=?,uname=?,gender=?,email=?" + " WHERE uno=?";
		try {
			connection = ds.getConnection();
			//connection = connPool.getConnection();
			stmt = connection.prepareStatement(sqlUpdate);
			stmt.setString(1, user.getId());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getName());
			stmt.setString(4, user.getGender());
			stmt.setString(5, user.getEmail());
			stmt.setInt(6, user.getNo());
			result = stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
			}
			try {
				if(connection != null)
					connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}			
//			if (connection != null) {
//				connPool.returnConnection(connection);
//			}
		}

		return result;
	}

	public User exist(String id, String password) throws Exception {
		Connection connection = null;
		User user = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		final String sqlExist = "SELECT uno,id,uname,email FROM users" + " WHERE id=? AND pwd=?";

		try {
			connection = ds.getConnection();
			//connection = connPool.getConnection();
			stmt = connection.prepareStatement(sqlExist);
			stmt.setString(1, id);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			if (rs.next()) {
				user = new User().setNo(rs.getInt("uno")).setId(rs.getString("id")).setName(rs.getString("uname")).setEmail(rs.getString("email"));
			} else {
				return null;
			}
		} catch (Exception e) {
			throw e;

		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
			}
			try {
				if(connection != null)
					connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}			
//			if (connection != null) {
//				connPool.returnConnection(connection);
//			}
		}

		return user;
	}
}
