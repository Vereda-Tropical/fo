package peo;

import java.sql.Connection;
import java.sql.SQLException;

//������������
public class Main {
	
    /**
     * @throws SQLException 
     * @throws ClassNotFoundException 
     * @paramargs
     */
	
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    	 Connection con =DBUtil.getConn();
        PeoManage s=new PeoManage();
        s.menu();
        
    }
    
}