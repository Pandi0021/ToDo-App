package todoMethods;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import tododataList.TodoDtls;

public class TodoDAO {
	private Connection conn;

	public TodoDAO(Connection con) {
		super();
		this.conn = con;
	}

	public boolean addTodo(String name, String todo, String status) {
		boolean f = false;
		try {
			PreparedStatement preparedStatement = conn
					.prepareStatement("INSERT INTO todo(name, todo, status) VALUES (?, ?, ?)");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, todo);
			preparedStatement.setString(3, status);

			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle exceptions
		}
		return f;
	}

	public List<TodoDtls> getTodo() {
		List<TodoDtls> list = new ArrayList<TodoDtls>();
		TodoDtls t = null;
		try {
			String sql = "select * from todo";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				t = new TodoDtls();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setTodo(rs.getString(3));
				t.setStatus(rs.getString(4));
				list.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public TodoDtls getTodoById(int id) {
		TodoDtls t = null;
		try {
			String sql1 = "select * from todo where id=?";
			PreparedStatement ps1;

			ps1 = conn.prepareStatement(sql1);

			ps1.setInt(1, id);
			ResultSet rs = ps1.executeQuery();
			while (rs.next()) {
				t = new TodoDtls();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setTodo(rs.getString(3));
				t.setStatus(rs.getString(4));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	public boolean updateTodo(TodoDtls t) {
		boolean f = false;
		try {
			PreparedStatement preparedStatement = conn
					.prepareStatement("update todo set name=?,todo=?,status=? where id=?");
			preparedStatement.setString(1, t.getName());
			preparedStatement.setString(2, t.getTodo());
			preparedStatement.setString(3, t.getStatus());
			preparedStatement.setInt(4, t.getId());
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle exceptions
		}
		return f;
	}

	public boolean deleteTodo(TodoDtls t) {
		boolean f = false;
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("delete from todo where id=?");

			preparedStatement.setInt(1, t.getId());
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle exceptions
		}
		return f;
	}
}
