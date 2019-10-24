import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentDao {
	private static final String TABLE_NAME = "dep";

	public Department load(int id) {
		Connection con = DBManager.createConnection();
		String sql = "select dep_id,dep_name from " + TABLE_NAME + " where dep_id=" + id;

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				Department department = new Department();
				department.setDepId(rs.getInt("dep_id"));
				department.setDepName(rs.getString("dep_name"));
				return department;
			}
			return null;
		} catch (SQLException e) {
			System.err.println("SQL=" + sql);
			throw new RuntimeException("loadèàóùÇ…é∏îsÇµÇ‹ÇµÇΩÅB", e);
		} finally {
			DBManager.closeConnestion(con);
		}

	}

	public int insert(Department department) {
		Connection con = DBManager.createConnection();

		String sql = "insert into " + TABLE_NAME + " (dep_id,dep_name ) " + "values (?,?);";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, department.getDepId());
			pstmt.setString(2, department.getDepName());

			int affected = pstmt.executeUpdate();

			return affected;

		} catch (SQLException e) {
			System.err.println("SQL=" + sql);
			throw new RuntimeException("insertèàóùÇ…é∏îsÇµÇ‹ÇµÇΩÅB", e);
		} finally {
			DBManager.closeConnestion(con);

		}

	}

	public int update(Department department) {
		Connection con = DBManager.createConnection();

		String sql = "update " + TABLE_NAME + " set dep_id=? , dep_name=? "
				+ " where dep_id=?;";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, department.getDepId());
			pstmt.setString(2, department.getDepName());
			pstmt.setInt(3, department.getDepId());

			int affected = pstmt.executeUpdate();
			return affected;

		} catch (SQLException e) {
			System.err.println("SQL=" + sql);
			throw new RuntimeException("updateèàóùÇ…é∏îsÇµÇ‹ÇµÇΩÅB", e);
		} finally {
			DBManager.closeConnestion(con);
		}

	}
	
	public int deleteById(int dep_id) {
		Connection con =DBManager.createConnection();
		String sql ="delete from "+TABLE_NAME+" where dep_id=?;";
		
		try {
			PreparedStatement pstmt =con.prepareStatement(sql);
			pstmt.setInt(1, dep_id);
			int affected = pstmt.executeUpdate();
			return affected;
			
		} catch (SQLException e) {
			System.err.println("SQL=" + sql);
			throw new RuntimeException("deleteèàóùÇ…é∏îsÇµÇ‹ÇµÇΩÅB", e);
		} finally {
			DBManager.closeConnestion(con);
		}
		
	}

}
