package com.example.spring.test.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.stereotype.Component;

@Component
public class userDAO {
	final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
	final String JDBC_URL = "jdbc:mariadb://localhost/testUser";

	private Connection con = null;

	private PreparedStatement pstmt = null;

	ResultSet rs = null;

	public Connection dbConnect() {
		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(JDBC_URL, "root", "Kss01179");
			System.out.println("DB 연결 성공");
		} catch (Exception e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}
		return con;
	}

	public void close() {
		try {
			pstmt.close();
			con.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 회원가입
	public boolean insertUser(userDTO user) {
		boolean success = false;
		dbConnect();
		String sql = "insert into testUser(user_id, user_pw, user_name, user_birth,";
		sql += "user_email, user_class, user_gender)";
		sql += "values(?,?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUser_id());
			pstmt.setString(2, user.getUser_pw());
			pstmt.setString(3, user.getUser_name());
			pstmt.setString(4, user.getUser_birth());
			pstmt.setString(5, user.getUser_email());
			pstmt.setString(6, user.getUser_class());
			pstmt.setString(7, user.getUser_gender());
			pstmt.executeUpdate();
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
			return success;
		}

		return success;
	}

	// 로그인
	public int loginUser(String user_id, String user_pw) {
		dbConnect();
		String sql = "SELECT user_pw FROM testUser WHERE user_id= ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).equals(user_pw))
					return 1;
				else
					return 0;
			}
			return -1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -2;
	}

	// 아이디 조회
	public userDTO getUser(String user_id) {
		dbConnect();
		String SQL = "select * from testUser where user_id = ?";
		userDTO user = new userDTO();

		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, user_id);
			ResultSet rs = pstmt.executeQuery();

			rs.next();
			user.setUser_id(rs.getString("user_id"));
			user.setUser_pw(rs.getString("user_pw"));
			user.setUser_name(rs.getString("user_name"));
			user.setUser_birth(rs.getString("user_birth"));
			user.setUser_email(rs.getString("user_email"));
			user.setUser_class(rs.getString("user_class"));
			user.setUser_gender(rs.getString("user_gender"));
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;

	}

	// 유저목록
	public ArrayList<userDTO> getuserList() {

		dbConnect();
		ArrayList<userDTO> list = new ArrayList<userDTO>();

		String SQL = "select * from testUser";
		try {
			pstmt = con.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				userDTO user = new userDTO();
				user.setUser_id(rs.getString("user_id"));
				user.setUser_pw(rs.getString("user_pw"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_birth(rs.getString("user_birth"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_class(rs.getString("user_class"));
				user.setUser_gender(rs.getString("user_gender"));
				list.add(user);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
	// 회원 정보 수정	
	public boolean updateUser(userDTO user) {
		boolean success = false;
		dbConnect();
		String sql = "update testUser set user_pw = ?,  user_name = ?,  user_birth = ?, user_email = ?, ";
		sql += "user_class = ?, user_gender = ?  where user_id = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUser_pw());
			pstmt.setString(2, user.getUser_name());
			pstmt.setString(3, user.getUser_birth());
			pstmt.setString(4, user.getUser_email());
			pstmt.setString(5, user.getUser_class());
			pstmt.setString(6, user.getUser_gender());
			pstmt.setString(7, user.getUser_id());
			int rowUdt = pstmt.executeUpdate();
			if (rowUdt == 1)
				success = true;
		} catch (SQLException e) {
			e.printStackTrace();
			return success;
		}

		return success;
	}
	
	
	// 회원 탈퇴
		public boolean deleteUser(String user_id) {
			boolean success = false;
			dbConnect();
			String sql ="delete from testUser where user_id=?";
			
			try {
				pstmt = con.prepareStatement(sql);
				// 인자로 받은 주 키인 id 값을 이용해 삭제
				
				pstmt.setString(1, user_id);
				pstmt.executeUpdate();
				success = true;
			}catch(SQLException e) {
				e.printStackTrace();
				return success;
			}
			
			return success;
		
		}

}
