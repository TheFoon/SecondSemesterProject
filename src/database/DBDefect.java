package database;

import java.sql.*;

import model.Defect;

public class DBDefect implements IDBDefect {
	private PreparedStatement p_stmt;
	private DBConnection db_connection;

	public DBDefect() throws DataAccessException {
		db_connection = DBConnection.getInstance();
	}

	@Override
	public Defect findById(int id) throws DataAccessException {
		Defect defect = null;
		String query = "select * from Defect where id = ?";

		db_connection = DBConnection.getInstance();

		try {
			p_stmt = db_connection.getConnection().prepareStatement(query);
			p_stmt.setInt(1, id);

			ResultSet rs = p_stmt.executeQuery();
			if (rs.next()) {
				defect = buildObject(rs);
			}
		} catch (SQLException e) {
			throw new DataAccessException();
		}
		
		return defect;
	}

	private Defect buildObject(ResultSet result_set) throws SQLException {
		return new Defect(result_set.getString(1), result_set.getString(2), result_set.getString(3));
	}

	@Override
	public void insertDefect(Defect defect, int cleaner_id, int housing_unit_id) throws DataAccessException {
		String insert_query = "insert into Defect values (?, ?, ?, ?, ?)";
		Connection con = db_connection.getConnection();
		try {
			con.setAutoCommit(false);
			PreparedStatement p_stmt = con.prepareStatement(insert_query,
					Statement.RETURN_GENERATED_KEYS);

			p_stmt.setString(1, defect.getType());
			p_stmt.setString(2, defect.getDescription());
			p_stmt.setString(3, defect.getRoomName());
			p_stmt.setInt(4, cleaner_id);
			p_stmt.setInt(5, housing_unit_id);

			int affected_rows = p_stmt.executeUpdate();

			if (affected_rows == 0) {
				throw new SQLException("Creating defect failed, no rows affected.");
			}

			ResultSet generatedKeys = p_stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				defect.setId(generatedKeys.getInt(1));
			} else {
				throw new SQLException("Creating defect failed, no ID obtained.");
			}

			con.commit();
		} catch (SQLException e) {
			try
			{
				con.rollback();
			}
			catch (SQLException ekszepcio)
			{}
			
			throw new DataAccessException();
		}
		finally
		{
			try
			{
				con.setAutoCommit(true);
				}
			catch (SQLException e)
			{
				throw new DataAccessException();
			}
		}

	}
}
