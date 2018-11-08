package notenverwaltung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.CallableStatement;

public class SqlManager {
	private static Connection ActConnection;
	
	public SqlManager() {
		ActConnection = InitConnection();
	}
	public static Connection InitConnection() {
		Connection conn = null;
		try
		{
		  String url = "jdbc:mysql://localhost:3306/notendb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		  conn = DriverManager.getConnection(url, "root", "");
		}catch(SQLException  e) {
			System.out.println(e.getMessage());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	public static ArrayList<Fach> LoadFaecher() {
		String query = "Select * from fach";
		ResultSet rs;
		ActConnection = InitConnection();
		try
			{
			PreparedStatement ps = ActConnection.prepareStatement(query);
			rs = ps.executeQuery();
			ArrayList<Fach> faecher = new ArrayList<Fach>();
			while(rs.next()) {
				Fach tempfach = new Fach(rs.getInt("Fach_ID"), rs.getString("Fachname"));
				faecher.add(tempfach);
			}
			return faecher;
		}catch(SQLException  e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static ArrayList<Note> LoadNoten() {
		String query = "Select * from note";
		ResultSet rs;
		ActConnection = InitConnection();
		try
			{
			PreparedStatement ps = ActConnection.prepareStatement(query);
			rs = ps.executeQuery();
			ArrayList<Note> noten = new ArrayList<Note>();
			while(rs.next()) {
				Note tempnote = new Note(rs.getInt("Noten_ID"), rs.getInt("Fach_ID"),rs.getInt("Gewichtung"),rs.getFloat("ErhalteneNote"));
				noten.add(tempnote);
			}
			return noten;
		}catch(SQLException  e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	public static void AddFach(String fachname) {
		String query = "{ call AddFach(?,?)}";
		ResultSet rs;
		ActConnection = InitConnection();
		try
			{
			CallableStatement cs = ActConnection.prepareCall(query);
			cs.setInt("Fach_Id", LoadFaecher().size()+1);
			cs.setString("FachName", fachname);
			rs = cs.executeQuery();
		}catch(SQLException  e) {
			System.out.println(e.getMessage());
		}
	}
}
