package dao;

import java.sql.*;
import java.util.ArrayList;

import db.DB;
import dto.UserDto;

public class UserDaoImpl implements UserDao{

	@Override
	public void insert(UserDto dto) {
		// 디비 연결
		// 쿼리 만들고
		// 쿼리 실행

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DB.conn(); 
			String sql = "INSERT INTO user (id, name) VALUES (?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			
			int count = pstmt.executeUpdate();
			if (count == 0) {
				System.out.println("데이터 입력 실패");
			} else {
				System.out.println("데이터 입력 성공");
			}

		} catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if( pstmt != null && !pstmt.isClosed()){
                    pstmt.close();
                }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public UserDto select(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 전달 변수(dto 담을 그릇)
		UserDto dto = null;
		try {
			conn = DB.conn();
//			String sql = "SELECT * FROM user WHERE  id= '" + id + "'";
			String sql = "SELECT * FROM user WHERE  id= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dto = new UserDto();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setJumsu(rs.getInt("jumsu"));
			} else {
				System.out.println("사용자가 없다");
			}

		} catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if( rs != null && !rs.isClosed()){
                    rs.close();
                }
				if( pstmt != null && !pstmt.isClosed()){
                    pstmt.close();
                }
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	@Override
	public ArrayList<UserDto> select() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 전달 변수(dto 담을 그릇)
		ArrayList<UserDto> list = new ArrayList<UserDto>();
		try {
			conn = DB.conn();
			String sql = "SELECT * FROM user";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				UserDto dto = new UserDto();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setJumsu(rs.getInt("jumsu"));
				list.add(dto);
			}

		} catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if( rs != null && !rs.isClosed()){
                    rs.close();
                }
				if( pstmt != null && !pstmt.isClosed()){
                    pstmt.close();
                }
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public void update(UserDto dto) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DB.conn(); 
			String sql = "UPDATE user SET jumsu=? WHERE  id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getJumsu());
			pstmt.setString(2, dto.getId());
			
			int count = pstmt.executeUpdate();
			if (count == 0) {
				System.out.println("데이터 입력 실패");
			} else {
				System.out.println("데이터 입력 성공");
			}

		} catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if( pstmt != null && !pstmt.isClosed()){
                    pstmt.close();
                }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
