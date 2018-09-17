package common;

public class StudentSqlQuery {
	public static final String GET_EMP_BY_ID="Select * From Student WHERE id=?";
	public static final String GET_ALL_EMP="Select * From Student";
	public static final String INSERT_EMP="INSERT INTO Student  ( nameStudent, age ) VALUES (?,?)";
}
