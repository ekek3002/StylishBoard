package spms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import spms.vo.Post;
import spms.vo.User;

public class MemberDao {

	DataSource ds = null;

	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}

//	DBConnectionPool connPool;
//
//	public void setDbConnectionPool(DBConnectionPool connPool) {
//		this.connPool = connPool;
//	}

	public List<Post> selectList(Integer pageNo) throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		final String sqlSelect = "SELECT pno,uid,title,content,cre_date" + "\r\n" + "FROM post" + "\r\n"
				+ "ORDER BY pno DESC";

		try {
			connection = ds.getConnection();
			// connection = connPool.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sqlSelect);

			ArrayList<Post> posts = new ArrayList<Post>();

			int count = 1;
			while (rs.next()) {
				if (count > pageNo * 10 - 10 && count <= pageNo * 10)
					posts.add(new Post().setNo(rs.getInt("pno")).setTitle(rs.getString("title"))
							.setContent(rs.getString("content")).setCreatedDate(rs.getDate("cre_date"))
							.setId(rs.getString("uid")));
				count++;
			}

			return posts;

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
			/*
			 * DataSource 객체 내부의 Pool에서 대여한 후 close()시 반납처리 여기서의 close()는 닫는 것이 아니라 반납
			 */
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
//			if (connection != null) {
//				connPool.returnConnection(connection);
//			}
		}
	}

	public int insert(Post post) throws Exception {
		Connection connection = null;
		int result = 0;
		PreparedStatement stmt = null;
		final String sqlInsert = "INSERT INTO post(pno,uid,title,content,cre_date)" + "\r\n"
				+ "VALUES(?, ?, ?,?, NOW())";

		try {
			connection = ds.getConnection();
			// connection = connPool.getConnection();
			stmt = connection.prepareStatement(sqlInsert);
			stmt.setInt(1, post.getNo());
			stmt.setString(2, post.getId());
			stmt.setString(3, post.getTitle());
			stmt.setString(4, post.getContent());
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
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
//			if (connection != null) {
//				connPool.returnConnection(connection);
//			}
		}

		return result;
	}

//
	public int delete(int no) throws Exception {
		Connection connection = null;
		int result = 0;
		Statement stmt = null;
		final String sqlDelete = "DELETE FROM POST WHERE PNO=";

		try {
			connection = ds.getConnection();
			// connection = connPool.getConnection();
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
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
//			if (connection != null) {
//				connPool.returnConnection(connection);
//			}
		}

		return result;
	}

//
//	public Member selectOne(int no) throws Exception {
//		Connection connection = null;
//		Member member = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//
//		final String sqlSelectOne = "SELECT MNO,EMAIL,MNAME,CRE_DATE FROM MEMBERS" + " WHERE MNO=";
//
//		try {
//			connection = ds.getConnection();
//			// connection = connPool.getConnection();
//			stmt = connection.createStatement();
//			rs = stmt.executeQuery(sqlSelectOne + no);
//			if (rs.next()) {
//				member = new Member().setNo(rs.getInt("MNO")).setEmail(rs.getString("EMAIL"))
//						.setName(rs.getString("MNAME")).setCreatedDate(rs.getDate("CRE_DATE"));
//
//			} else {
//				throw new Exception("해당 번호의 회원을 찾을 수 없습니다.");
//			}
//
//		} catch (Exception e) {
//			throw e;
//		} finally {
//			try {
//				if (rs != null)
//					rs.close();
//			} catch (Exception e) {
//			}
//			try {
//				if (stmt != null)
//					stmt.close();
//			} catch (Exception e) {
//			}
//			try {
//				if (connection != null)
//					connection.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
////			if (connection != null) {
////				connPool.returnConnection(connection);
////			}
//		}
//
//		return member;
//	}
//
//	public int update(Member member) throws Exception {
//		Connection connection = null;
//		int result = 0;
//		PreparedStatement stmt = null;
//		final String sqlUpdate = "UPDATE MEMBERS SET EMAIL=?,MNAME=?,MOD_DATE=now()" + " WHERE MNO=?";
//		try {
//			connection = ds.getConnection();
//			// connection = connPool.getConnection();
//			stmt = connection.prepareStatement(sqlUpdate);
//			stmt.setString(1, member.getEmail());
//			stmt.setString(2, member.getName());
//			stmt.setInt(3, member.getNo());
//			result = stmt.executeUpdate();
//
//		} catch (Exception e) {
//			throw e;
//		} finally {
//			try {
//				if (stmt != null)
//					stmt.close();
//			} catch (Exception e) {
//			}
//			try {
//				if (connection != null)
//					connection.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
////			if (connection != null) {
////				connPool.returnConnection(connection);
////			}
//		}
//
//		return result;
//	}
//
//	public Member exist(String email, String password) throws Exception {
//		Connection connection = null;
//		Member member = null;
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		final String sqlExist = "SELECT MNAME,EMAIL FROM MEMBERS" + " WHERE EMAIL=? AND PWD=?";
//
//		try {
//			connection = ds.getConnection();
//			// connection = connPool.getConnection();
//			stmt = connection.prepareStatement(sqlExist);
//			stmt.setString(1, email);
//			stmt.setString(2, password);
//			rs = stmt.executeQuery();
//			if (rs.next()) {
//				member = new Member().setName(rs.getString("MNAME")).setEmail(rs.getString("EMAIL"));
//			} else {
//				return null;
//			}
//		} catch (Exception e) {
//			throw e;
//
//		} finally {
//			try {
//				if (rs != null)
//					rs.close();
//			} catch (Exception e) {
//			}
//			try {
//				if (stmt != null)
//					stmt.close();
//			} catch (Exception e) {
//			}
//			try {
//				if (connection != null)
//					connection.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
////			if (connection != null) {
////				connPool.returnConnection(connection);
////			}
//		}
//
//		return member;
//	}
	public Post viewBoard(int postNo) throws Exception {
		Post post = new Post();
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		final String sqlSelect = "SELECT uid,title,content,cre_date FROM post where pno = " + postNo;

		try {
			connection = ds.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sqlSelect);
			rs.next();
			post.setTitle(rs.getString("title")).setContent(rs.getString("content"))
					.setCreatedDate(rs.getDate("cre_date")).setId(rs.getString("uid"));
			return post;
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
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void update(Post post) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		final String sqlInsert = "UPDATE POST SET TITLE=?,CONTENT=? WHERE PNO=?";

		try {
			connection = ds.getConnection();
			stmt = connection.prepareStatement(sqlInsert);
			stmt.setString(1, post.getTitle());
			stmt.setString(2, post.getContent());
			stmt.setInt(3, post.getNo());
			stmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
		
	}

	public void check(String loginId) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		final String sqlUpdate = "UPDATE users SET upoint=if(adate!=curdate()||adate IS NULL,upoint+100,upoint),"
				+ " adate=if(adate!=curdate()||adate IS NULL,curdate(),adate)"
				+ " WHERE id='" + loginId + "'";
		try {
			connection = ds.getConnection();
			// connection = connPool.getConnection();
			stmt = connection.prepareStatement(sqlUpdate);
			stmt.executeUpdate();

		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
//			if (connection != null) {
//				connPool.returnConnection(connection);
//			}
		}
	}

}
