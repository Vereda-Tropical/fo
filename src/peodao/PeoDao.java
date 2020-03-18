package peodao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import peo.DBUtil;
import peo.Peo;

public class PeoDao {
    private Connection conn;//����
    private PreparedStatement pstmt;//ģ��
    private ResultSet rs;//���
    
  //�鿴ѧ���б�1���У�
    public List<Peo> list() throws SQLException {
           List<Peo> list=new ArrayList<Peo>();//�������б�ArrayList��
       
           String sql="select * from yiqing";
        
        try {
            conn=DBUtil.getConn();
            pstmt=conn.prepareStatement(sql);
    //pstmt.executeUpdate();//������ɾ��
            rs=pstmt.executeQuery();//���ڲ�ѯ
            while (rs.next()) {
                Peo peo=new Peo();
                peo.setId(rs.getString("id"));//ȡ���������ѧ����һ�е�ֵ����
                peo.setName(rs.getString("name"));
                peo.setSex(rs.getString("sex"));
                peo.setCollege(rs.getString("college"));
                peo.setAddress(rs.getString("address"));
                peo.setSuspect(rs.getString("suspect"));
                peo.setConfirm(rs.getString("confirm"));
                peo.setContact(rs.getString("contact"));
                peo.setTime(rs.getString("time"));
                
                list.add(peo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
        	conn.close();
        	pstmt.close();
        	rs.close();
            //DBUtil.close(conn, pstmt, rs);
        }
        return list;
    }
    
  //���ѧ����Ϣ
    public boolean add(Peo peo) {
           String sql="insert into yiqing(id,name,sex,college,address,suspect,confirm,contact,time) values(?,?,?,?,?,?,?,?,?)";
        try {
            conn=DBUtil.getConn();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, peo.getId());
            pstmt.setString(2, peo.getName());
            pstmt.setString(3, peo.getSex());
            pstmt.setString(4, peo.getCollege());
            pstmt.setString(5, peo.getAddress());
            pstmt.setString(6, peo.getSuspect());
            pstmt.setString(7, peo.getConfirm());
            pstmt.setString(8, peo.getContact());
            pstmt.setString(9, peo.getTime());
            pstmt.executeUpdate();
        } catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
        return true;
    }
    //�޸�ѧ����Ϣ
    public boolean update(Peo peo) {
           String sql="update yiqing set id=?,name=? sex=?,college=?,address=?,suspect=?,confirm=?,contact=?,time=?";
        try {
            conn=DBUtil.getConn();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, peo.getId());
            pstmt.setString(2, peo.getName());
            pstmt.setString(3, peo.getSex());
            pstmt.setString(4, peo.getCollege());
            pstmt.setString(5, peo.getAddress());
            pstmt.setString(6, peo.getSuspect());
            pstmt.setString(7, peo.getConfirm());
            pstmt.setString(8, peo.getContact());
            pstmt.setString(9, peo.getTime());
            pstmt.executeUpdate();
        } catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
        return true;
       }
  //ɾ��ѧ����Ϣ
    public boolean del(String id) throws SQLException {
           String sql="delete from yiqing where id=?";
        try {
            conn=DBUtil.getConn();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,id);
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
			e.printStackTrace();
		} 
        pstmt.close();
		conn.close(); 
        return true;
       }
    
	//�鿴�б�   ��ѧ��   1
    public Peo findSomeone(String id) throws SQLException {
           Peo peo=null;
           String sql="select * from yiqing where id=?";
        
        try {
            conn=DBUtil.getConn();
            pstmt=conn.prepareStatement(sql);
//pstmt.executeUpdate();//������ɾ��
            pstmt.setString(1,id);
            rs=pstmt.executeQuery();//���ڲ�ѯ
            while (rs.next()) {
                peo=new Peo();
                peo.setId(rs.getString("id"));//ȡ���������ѧ����һ�е�ֵ����
                peo.setName(rs.getString("name"));
                peo.setSex(rs.getString("sex"));
                peo.setCollege(rs.getString("college"));
                peo.setAddress(rs.getString("address"));
                peo.setSuspect(rs.getString("suspect"));
                peo.setConfirm(rs.getString("confirm"));
                peo.setContact(rs.getString("contact"));
                peo.setTime(rs.getString("time"));
            }
        }  catch (SQLException e) {
			e.printStackTrace();
		} 
        pstmt.close();
		conn.close(); 
        return peo;
    }
    
    
   /* public void findday(){
    	System.out.println("����ʱ�䣺");
    	Scanner s=new Scanner(System.in);
    	String date = s.next();
    	//showMessage(finddate(date));
    	System.out.println("��"+date+"����ͳ�Ƶ�����\n");
    	//showNum(selectDate(date));
    }*/ 
    
  //�ոĵİ�ʱ���ѯ
    public List<Peo> list1(String time) throws SQLException {
           List<Peo> list1=new ArrayList<Peo>();//�������б�ArrayList��
           String sql="select * from yiqing where time=?";
        try {
            conn=DBUtil.getConn();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,time);
            rs=pstmt.executeQuery();//���ڲ�ѯ
            while (rs.next()) {
                Peo peo=new Peo();
                peo.setId(rs.getString("id"));//ȡ���������ѧ����һ�е�ֵ����
                peo.setName(rs.getString("name"));
                peo.setSex(rs.getString("sex"));
                peo.setCollege(rs.getString("college"));
                peo.setAddress(rs.getString("address"));
                peo.setSuspect(rs.getString("suspect"));
                peo.setConfirm(rs.getString("confirm"));
                peo.setContact(rs.getString("contact"));
                peo.setTime(rs.getString("time"));
                Peo Peo = new Peo();
                list1.add(peo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
        	conn.close();
        	pstmt.close();
        	rs.close();
        }
        return list1;
    }
    //��ʱ��
  //�鿴�б�  2
    public Peo finddate(String time) throws SQLException {
           Peo peo=null;
           String sql="select * from yiqing where time=?";
        try {
            conn=DBUtil.getConn();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,time);
            rs=pstmt.executeQuery();//���ڲ�ѯ
            while (rs.next()) {
                peo=new Peo();
                peo.setId(rs.getString("id"));//ȡ���������ѧ����һ�е�ֵ����
                peo.setName(rs.getString("name"));
                peo.setSex(rs.getString("sex"));
                peo.setCollege(rs.getString("college"));
                peo.setAddress(rs.getString("address"));
                peo.setSuspect(rs.getString("suspect"));
                peo.setConfirm(rs.getString("confirm"));
                peo.setContact(rs.getString("contact"));
                peo.setTime(rs.getString("time"));
            }
        } catch (SQLException e) {
			e.printStackTrace();
		} 
        pstmt.close();
		conn.close(); 
        return peo;
    }

  //�鿴�б�   ��ѧԺ  3
    public Peo findcollege(String college) throws SQLException {
           Peo peo=null;
           String sql="select * from yiqing where college=?";
        
        try {
            conn=DBUtil.getConn();
            pstmt=conn.prepareStatement(sql);
//pstmt.executeUpdate();//������ɾ��
            pstmt.setString(1,college);
            rs=pstmt.executeQuery();//���ڲ�ѯ
            while (rs.next()) {
                peo=new Peo();
                peo.setId(rs.getString("id"));//ȡ���������ѧ����һ�е�ֵ����
                peo.setName(rs.getString("name"));
                peo.setSex(rs.getString("sex"));
                peo.setCollege(rs.getString("college"));
                peo.setAddress(rs.getString("address"));
                peo.setSuspect(rs.getString("suspect"));
                peo.setConfirm(rs.getString("confirm"));
                peo.setContact(rs.getString("contact"));
                peo.setTime(rs.getString("time"));
            }
        } catch (SQLException e) {
			e.printStackTrace();
		} 
        pstmt.close();
		conn.close(); 
        return peo;
    }
    
    //�鿴�б�   ������  4
    public Peo findname(String name) throws SQLException {
           Peo peo=null;
           String sql="select * from yiqing where name=?";
        
        try {
            conn=DBUtil.getConn();
            pstmt=conn.prepareStatement(sql);
//pstmt.executeUpdate();//������ɾ��
            pstmt.setString(1,name);
            rs=pstmt.executeQuery();//���ڲ�ѯ
            while (rs.next()) {
                peo=new Peo();
                peo.setId(rs.getString("id"));//ȡ���������ѧ����һ�е�ֵ����
                peo.setName(rs.getString("name"));
                peo.setSex(rs.getString("sex"));
                peo.setCollege(rs.getString("college"));
                peo.setAddress(rs.getString("address"));
                peo.setSuspect(rs.getString("suspect"));
                peo.setConfirm(rs.getString("confirm"));
                peo.setContact(rs.getString("contact"));
                peo.setTime(rs.getString("time"));
            }
        } catch (SQLException e) {
			e.printStackTrace();
		} 
        pstmt.close();
		conn.close(); 
        return peo;
    }
    
    //�鿴�б�   �Ƿ��Ⱦ   5
    public Peo findconfirm(String confirm) throws SQLException {
           Peo peo=null;
           String sql="select * from yiqing where confirm=?";
        
        try {
            conn=DBUtil.getConn();
            pstmt=conn.prepareStatement(sql);
//pstmt.executeUpdate();//������ɾ��
            pstmt.setString(1,confirm);
            rs=pstmt.executeQuery();//���ڲ�ѯ
            while (rs.next()) {
                peo=new Peo();
                peo.setId(rs.getString("id"));//ȡ���������ѧ����һ�е�ֵ����
                peo.setName(rs.getString("name"));
                peo.setSex(rs.getString("sex"));
                peo.setCollege(rs.getString("college"));
                peo.setAddress(rs.getString("address"));
                peo.setSuspect(rs.getString("suspect"));
                peo.setConfirm(rs.getString("confirm"));
                peo.setContact(rs.getString("contact"));
                peo.setTime(rs.getString("time"));
            }
        } catch (SQLException e) {
			e.printStackTrace();
		} 
        pstmt.close();
		conn.close(); 
        return peo;
    }
    
    //�鿴�б�   ����  6
    public Peo findsuspect(String suspect) throws SQLException {
           Peo peo=null;
           String sql="select * from yiqing where suspect=?";
        
        try {
            conn=DBUtil.getConn();
            pstmt=conn.prepareStatement(sql);
//pstmt.executeUpdate();//������ɾ��
            pstmt.setString(1,suspect);
            rs=pstmt.executeQuery();//���ڲ�ѯ
            while (rs.next()) {
                peo=new Peo();
                peo.setId(rs.getString("id"));//ȡ���������ѧ����һ�е�ֵ����
                peo.setName(rs.getString("name"));
                peo.setSex(rs.getString("sex"));
                peo.setCollege(rs.getString("college"));
                peo.setAddress(rs.getString("address"));
                peo.setSuspect(rs.getString("suspect"));
                peo.setConfirm(rs.getString("confirm"));
                peo.setContact(rs.getString("contact"));
                peo.setTime(rs.getString("time"));
            }
        } catch (SQLException e) {
			e.printStackTrace();
		} 
        pstmt.close();
		conn.close(); 
        return peo;
    }
    
    //�鿴�б�   �Ƿ�Ӵ�
    public Peo findcontact(String contact) throws SQLException {
           Peo peo=null;
           String sql="select * from yiqing where contact=?";
        
        try {
            conn=DBUtil.getConn();
            pstmt=conn.prepareStatement(sql);
//pstmt.executeUpdate();//������ɾ��
            pstmt.setString(1,contact);
            rs=pstmt.executeQuery();//���ڲ�ѯ
            while (rs.next()) {
                peo=new Peo();
                peo.setId(rs.getString("id"));//ȡ���������ѧ����һ�е�ֵ����
                peo.setName(rs.getString("name"));
                peo.setSex(rs.getString("sex"));
                peo.setCollege(rs.getString("college"));
                peo.setAddress(rs.getString("address"));
                peo.setSuspect(rs.getString("suspect"));
                peo.setConfirm(rs.getString("confirm"));
                peo.setContact(rs.getString("contact"));
                peo.setTime(rs.getString("time"));
            }
        } catch (SQLException e) {
			e.printStackTrace();
		} 
        pstmt.close();
		conn.close(); 
        return peo;
    }
  //�鿴�б�   ��ѧԺ  3
    public Peo findaddress(String address) throws SQLException {
           Peo peo=null;
           String sql="select * from yiqing where address=?";
        
        try {
            conn=DBUtil.getConn();
            pstmt=conn.prepareStatement(sql);
//pstmt.executeUpdate();//������ɾ��
            pstmt.setString(1,address);
            rs=pstmt.executeQuery();//���ڲ�ѯ
            while (rs.next()) {
                peo=new Peo();
                peo.setId(rs.getString("id"));//ȡ���������ѧ����һ�е�ֵ����
                peo.setName(rs.getString("name"));
                peo.setSex(rs.getString("sex"));
                peo.setCollege(rs.getString("college"));
                peo.setAddress(rs.getString("address"));
                peo.setSuspect(rs.getString("suspect"));
                peo.setConfirm(rs.getString("confirm"));
                peo.setContact(rs.getString("contact"));
                peo.setTime(rs.getString("time"));
            }
        } catch (SQLException e) {
			e.printStackTrace();
		} 
        pstmt.close();
		conn.close(); 
        return peo;
    }
    
}

