package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.StudentSqlQuery;
import database.ConnectDB;
import entity.Student;

public class StudentDao {
	public Student getEmployeeById(int id) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student student = null;
		try {
			connection = ConnectDB.getConnecṭ();
			ps = connection.prepareStatement(StudentSqlQuery.GET_EMP_BY_ID);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				student = new Student();
				student.setId(rs.getInt("id"));
				student.setNameStudent(rs.getString("nameStudent"));
				student.setAge(rs.getInt("age"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (connection != null) {
					connection.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return student;
	}

	public List<Student> getAllStudent() {
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		List<Student> listStudent = new ArrayList<>();
		Student student = null;
		try {
			connection = ConnectDB.getConnecṭ();
			st = connection.createStatement();
			rs = st.executeQuery(StudentSqlQuery.GET_ALL_EMP);
			while (rs.next()) {
				student = new Student();
				student.setId(rs.getInt("id"));
				student.setNameStudent(rs.getString("nameStudent"));
				student.setAge(rs.getInt("age"));
				listStudent.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (connection != null) {
					connection.close();
				}
				if (st != null) {
					st.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listStudent;
	}

	public boolean insertStudent(Student student) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = ConnectDB.getConnecṭ();
			ps = connection.prepareStatement(StudentSqlQuery.INSERT_EMP);
			ps.setString(1, student.getNameStudent());
			ps.setInt(2, student.getAge());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
