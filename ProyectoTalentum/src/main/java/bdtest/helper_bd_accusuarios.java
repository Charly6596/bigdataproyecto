package bdtest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class helper_bd_accusuarios {
	public static void insert(int uID, int aID) {
        String sql   = "INSERT INTO accusuarios(uID, aID) VALUES (?,?)";
        BaseDatos bd = BaseDatos.createInstanceOfBD();    
        try (Connection conn = bd.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(1, uID);
	            pstmt.setInt(2, aID);
	            pstmt.executeUpdate(); 
	            bd.closeConnection();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	public static int Count(){
		BaseDatos bd = BaseDatos.createInstanceOfBD();
		String sql   = "SELECT count(*) FROM accusuarios";
		ResultSet rs = bd.Query(sql);
		int count = 0;
		try {
				count = rs.getInt(1);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return count;
	}
<<<<<<< HEAD
	public static int CountbyID(int id){
		BaseDatos bd = BaseDatos.createInstanceOfBD();
		String sql   = "SELECT count(*) FROM accusuarios where aID ="+ id;
		ResultSet rs = bd.Query(sql);
		int count = 0;
		try {
				count = rs.getInt(1);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return count;
	}
=======
>>>>>>> d3e04532cc3137ceb069ffd453271a7dd3e02591
	public static int[][] getAcciones(){
		BaseDatos bd = BaseDatos.createInstanceOfBD(); 
		 String sql      = "SELECT * FROM accusuarios";
		 int uID  = 0;
		 int aID  = 0;
		 int auID = 0;
		 int[][] acciones = new int[Count()+1][10]; //TODO: terminar este método
		 
		 try (Connection conn = bd.getConnection();
	             Statement stmt  = conn.createStatement();
				 ResultSet rs = bd.Query(sql);){
	            
	            while (rs.next()) {
	               uID           = rs.getInt("uID");
	               aID           = rs.getInt("aID");
	               auID          = rs.getInt("auID");
	               acciones[auID][aID] = uID;	               
	            }
	            bd.closeConnection();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		 return acciones;
	}
<<<<<<< HEAD
	public static int[] getAccionesbyID(int id){
		BaseDatos bd    = BaseDatos.createInstanceOfBD(); 
		 String sql     = "SELECT * FROM accusuarios WHERE aID ="+ id;
		 int uID        = 0;
		 int cont       = 0;
		 int[] acciones = new int[CountbyID(id)];
		 
		 try (Connection conn = bd.getConnection();
	             Statement stmt  = conn.createStatement();
				 ResultSet rs = bd.Query(sql);){
	            
	            while (rs.next()) {
	               uID            = rs.getInt("uID");
	               acciones[cont] = uID;	
	               cont++;
	            }
	            bd.closeConnection();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		 return acciones;
	}
=======
>>>>>>> d3e04532cc3137ceb069ffd453271a7dd3e02591
}
