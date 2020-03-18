package peo;
//ѧ����Ϣ����ϵͳ�Ĳ˵�ѡ��
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.print.DocFlavor.INPUT_STREAM;
import org.omg.CORBA.PUBLIC_MEMBER;
import peodao.PeoDao;

public class PeoManage {
	
	
	
    private static final String String = null;

	public void  menu() throws SQLException {
        //1.��ӡ�˵�
        //2.����˵�
        //3.switch�˵�ѡ��
        int choose;
        do {
            System.out.println("******************************");
            System.out.println("=======��ӭ����������Ϣ����ϵͳ=======");
            System.out.println("1.������Ϣ");
            System.out.println("2.�޸���Ϣ");
            System.out.println("3.ɾ����Ϣ");
            System.out.println("4.��ѯ��Ϣ");
            System.out.println("5.��ʱ���");
            System.out.println("6.����ַ��");
            System.out.println("7.��ȷ��");
            System.out.println("8.������");
            System.out.println("9.�˳���ϵͳ");
            System.out.println("��ѡ��1-9����");
            
            Scanner scanner=new Scanner(System.in);
            choose=scanner.nextInt();
            System.out.println("******************************");
            switch (choose) {
            case 1:
                myAdd(); //�˵�ѡ��1��������ѧ��
                break;
            case 2:
                myUpdate();  //�˵�ѡ��2�����޸�ѧ��
                break;
            case 3:
                myDel();  //�˵�ѡ��3����ɾ��ѧ��
                break;
            case 4:
                myList();  //�˵�ѡ��4���ǲ�ѯѧ��
                break;
                
            case 5:
            	findday();//�˵�ѡ��5����ʱ��
            	break;
            case 6:
            	findaddress();//�˵�ѡ��6������ַ
            	break;
            case 7:
            	findconfirm();//�˵�ѡ��7����ȷ��
            	break;
            case 8:
            	findsuspect();//�˵�ѡ��8��������
            	break;
            case 9:     //�˵�ѡ��9�����˳���ϵͳ
                System.out.println("��ѡ�����˳�ϵͳ��ȷ��Ҫ�˳���(y/n)");
                Scanner scan=new Scanner(System.in);
                String scanExit=scan.next();
                if(scanExit.equals("y")){
                System.exit(-1);
                System.out.println("���ѳɹ��˳�ϵͳ����ӭ���ٴ�ʹ�ã�");
                }
                break;
            default:
                break;
            }
        } while (choose!=5);
    }
    
    //����ѧ����Ϣ
    public void myAdd() {
        
        String continute;
        do {
            Scanner s=new Scanner(System.in);
            String id,name,sex,college,address,suspect,confirm,contact,time;
            System.out.println("====������Ϣ====");
            System.out.println("ѧ�ţ�");
            id=s.next();
            System.out.println("������");
            name=s.next();
            System.out.println("�Ա�");
            sex=s.next();
            System.out.println("ѧԺ��");
            college=s.next();
            System.out.println("��ַ��");
            address=s.next();
            System.out.println("�Ƿ����ƣ�");
            suspect=s.next();
            System.out.println("�Ƿ�ȷ�");
            confirm=s.next();
            System.out.println("�Ƿ��뻼�߽Ӵ���");
            contact=s.next();
            System.out.println("���ڣ�");
            time=s.next();
            
            Peo peo=new Peo(id,name,sex,college,address,suspect,confirm,contact,time);
            PeoDao dao=new PeoDao();
            boolean ok=dao.add(peo);
            if (ok) {
                System.out.println("����ɹ���");
            }else {
                System.out.println("����ʧ�ܣ�");
            }
            System.out.println("�Ƿ�������(y/n)��");
            Scanner scanner2=new Scanner(System.in);
            continute=scanner2.next();
        } while (continute.equals("y"));
    }
    
    //ɾ��ѧ����Ϣ
    public void myDel() throws SQLException{
        Scanner s=new Scanner(System.in);
        String id;
        System.out.println("====ɾ����Ϣ====");
        System.out.println("������Ҫɾ����ѧ��ѧ�ţ�");
        id=s.next();
        System.out.println("��ѧ������Ϣ���£�");
        
        PeoDao peoDao=new PeoDao();
        System.out.println("ѧ��ѧ�ţ�"+peoDao.findSomeone(id).getId());
        System.out.println("ѧ��������"+peoDao.findSomeone(id).getName());
        System.out.println("ѧ���Ա�"+peoDao.findSomeone(id).getSex());
        System.out.println("����ѧԺ��"+peoDao.findSomeone(id).getCollege());
        System.out.println("��ס�أ�"+peoDao.findSomeone(id).getAddress());
        System.out.println("�Ƿ����ƣ�"+peoDao.findSomeone(id).getSuspect());
        System.out.println("�Ƿ�ȷ�"+peoDao.findSomeone(id).getConfirm());
        System.out.println("�Ƿ��뻼�߽Ӵ���"+peoDao.findSomeone(id).getContact());
        System.out.println("���ڣ�"+peoDao.findSomeone(id).getTime());
        
        System.out.println("�Ƿ����ɾ��(y/n)��");
        Scanner scanner3=new Scanner(System.in);
        String x=scanner3.next();
        if (x.equals("y")) {
        	Peo peo=new Peo(id,null,null,null,null,null,null,null,null);
            PeoDao dao=new PeoDao();
            boolean ok=dao.del(id);
            if (ok) {
                System.out.println("ɾ���ɹ���");
            }else {
                System.out.println("ɾ��ʧ�ܣ�");
            }
        }
    }
    //�޸�ѧ����Ϣ
    public void myUpdate() throws SQLException{
        Scanner s=new Scanner(System.in);
        String id;
        System.out.println("====�޸���Ϣ====");
        System.out.println("������Ҫ�޸ĵ�ѧ��ѧ�ţ�");
        id=s.next();
        System.out.println("��ѧ������Ϣ���£�");
        
        PeoDao peoDao=new PeoDao();
        System.out.println("ѧ��ѧ�ţ�"+peoDao.findSomeone(id).getId());
        System.out.println("ѧ��������"+peoDao.findSomeone(id).getName());
        System.out.println("ѧ���Ա�"+peoDao.findSomeone(id).getSex());
        System.out.println("����ѧԺ��"+peoDao.findSomeone(id).getCollege());
        System.out.println("��ס�أ�"+peoDao.findSomeone(id).getAddress());
        System.out.println("�Ƿ����ƣ�"+peoDao.findSomeone(id).getSuspect());
        System.out.println("�Ƿ�ȷ�"+peoDao.findSomeone(id).getConfirm());
        System.out.println("�Ƿ��뻼�߽Ӵ���"+peoDao.findSomeone(id).getContact());
        System.out.println("���ڣ�"+peoDao.findSomeone(id).getTime());
        
        System.out.println("�������µ�ѧ����Ϣ��");
        
        Scanner peoUp=new Scanner(System.in);
        
        String name,sex,college,address,suspect,confirm,contact,time;
        System.out.println("ѧ�ţ�");
        id=s.next();
        System.out.println("������");
        name=s.next();
        System.out.println("�Ա�");
        sex=s.next();
        System.out.println("ѧԺ��");
        college=s.next();
        System.out.println("��ַ��");
        address=s.next();
        System.out.println("�Ƿ����ƣ�");
        suspect=s.next();
        System.out.println("�Ƿ�ȷ�");
        confirm=s.next();
        System.out.println("�Ƿ��뻼�߽Ӵ���");
        contact=s.next();
        System.out.println("���ڣ�");
        time=s.next();
        
        Peo peo=new Peo(id,name,sex,college,address,suspect,confirm,contact,time);
        
        PeoDao dao=new PeoDao();
        boolean ok=dao.update(peo);
        if (ok) {
            System.out.println("����ɹ���");
        }else {
            System.out.println("����ʧ�ܣ�");
        }
    }
    //��ѯѧ����Ϣ
    public void myList() throws SQLException{
    	Connection conn =DBUtil.getConn();
        System.out.println("************************");
        System.out.println("====��ѯѧ��====");
        System.out.println("��ѧ������Ϣ���£�");
        System.out.println("ѧ��\t����\t�Ա�\tѧԺ\t��ַ\t�Ƿ�����\t�Ƿ�ȷ��\t�Ƿ��뻼�߽Ӵ�\t����");
        PeoDao peoDao=new PeoDao();
        List<Peo> list=peoDao.list();
        for (Peo peoList:list) { //ѭ����ӡ����ѯ���
            System.out.println(peoList.getId()+"\t"+peoList.getName()+"\t"+peoList.getSex()+"\t"
            		+peoList.getCollege()+"\t"+peoList.getAddress()+"\t"+peoList.getSuspect()+"\t"
             		+peoList.getConfirm()+"\t"+peoList.getContact()+"\t\t"+peoList.getTime());
        }
        
        System.out.println("************************");
    }
    
    
    
    
  //��ʱ��
	public void findday() throws SQLException{
		Connection conn =DBUtil.getConn();
		System.out.println("************************");
		Scanner s=new Scanner(System.in);
        String time;
        System.out.println("====�����ڲ�ѯ====");
        System.out.println("������Ҫ��ѯ�����ڣ�");
        time=s.next();
        System.out.println("����������£�");
        
        PeoDao peoDao=new PeoDao();
        System.out.println("ѧ��ѧ�ţ�"+peoDao.finddate(time).getId());
        System.out.println("ѧ��������"+peoDao.finddate(time).getName());
        System.out.println("ѧ���Ա�"+peoDao.finddate(time).getSex());
        System.out.println("����ѧԺ��"+peoDao.finddate(time).getCollege());
        System.out.println("��ס�أ�"+peoDao.finddate(time).getAddress());
        System.out.println("�Ƿ����ƣ�"+peoDao.finddate(time).getSuspect());
        System.out.println("�Ƿ�ȷ�"+peoDao.finddate(time).getConfirm());
        System.out.println("�Ƿ��뻼�߽Ӵ���"+peoDao.finddate(time).getContact());
        System.out.println("���ڣ�"+peoDao.finddate(time).getTime());
	}
        /*List<Peo> list=peoDao.list1(toString(time));
        for (Peo peoList:list) { //ѭ����ӡ����ѯ���
            System.out.println(peoList.getId()+"\t"+peoList.getName()+"\t"+peoList.getSex()+"\t"
            		+peoList.getCollege()+"\t"+peoList.getAddress()+"\t"+peoList.getSuspect()+"\t"
             		+peoList.getConfirm()+"\t"+peoList.getContact()+"\t\t"+peoList.getTime());*/
	//����ַ
	public void findaddress() throws SQLException{
		Connection conn =DBUtil.getConn();
		System.out.println("************************");
		Scanner s=new Scanner(System.in);
        String address;
        System.out.println("====����ַ��ѯ====");
        System.out.println("������Ҫ��ѯ�ĵ�ַ��");
        address=s.next();
        System.out.println("�õ�ַ������£�");
        
        PeoDao peoDao=new PeoDao();
        System.out.println("ѧ��ѧ�ţ�"+peoDao.findaddress(address).getId());
        System.out.println("ѧ��������"+peoDao.findaddress(address).getName());
        System.out.println("ѧ���Ա�"+peoDao.findaddress(address).getSex());
        System.out.println("����ѧԺ��"+peoDao.findaddress(address).getCollege());
        System.out.println("��ס�أ�"+peoDao.findaddress(address).getAddress());
        System.out.println("�Ƿ����ƣ�"+peoDao.findaddress(address).getSuspect());
        System.out.println("�Ƿ�ȷ�"+peoDao.findaddress(address).getConfirm());
        System.out.println("�Ƿ��뻼�߽Ӵ���"+peoDao.findaddress(address).getContact());
        System.out.println("���ڣ�"+peoDao.findaddress(address).getTime());
	}
        
  
	
	
	private String toString(String time) {
	// TODO Auto-generated method stub
	return null;
}

	//�Ƿ�ȷ��
	public void findconfirm() throws SQLException{
		Connection conn =DBUtil.getConn();
		System.out.println("************************");
		Scanner s=new Scanner(System.in);
        String confirm;
        System.out.println("====��ȷ���ѯ====");
        System.out.println("������Ҫ��ѯ�������");
        confirm=s.next();
        System.out.println("��������£�");
        
        PeoDao peoDao=new PeoDao();
        
        System.out.println("ѧ��ѧ�ţ�"+peoDao.findconfirm(confirm).getId());
        System.out.println("ѧ��������"+peoDao.findconfirm(confirm).getName());
        System.out.println("ѧ���Ա�"+peoDao.findconfirm(confirm).getSex());
        System.out.println("����ѧԺ��"+peoDao.findconfirm(confirm).getCollege());
        System.out.println("��ס�أ�"+peoDao.findconfirm(confirm).getAddress());
        System.out.println("�Ƿ����ƣ�"+peoDao.findconfirm(confirm).getSuspect());
        System.out.println("�Ƿ�ȷ�"+peoDao.findconfirm(confirm).getConfirm());
        System.out.println("�Ƿ��뻼�߽Ӵ���"+peoDao.findconfirm(confirm).getContact());
        System.out.println("���ڣ�"+peoDao.findconfirm(confirm).getTime());
  
	}
	
	//�Ƿ�����
	public void findsuspect() throws SQLException{
		Connection conn =DBUtil.getConn();
		System.out.println("************************");
		Scanner s=new Scanner(System.in);
        String suspect;
        System.out.println("====�����Ʋ�ѯ====");
        System.out.println("������Ҫ��ѯ�������");
        suspect=s.next();
        System.out.println("��������£�");
        
        PeoDao peoDao=new PeoDao();
        
        System.out.println("ѧ��ѧ�ţ�"+peoDao.findsuspect(suspect).getId());
        System.out.println("ѧ��������"+peoDao.findsuspect(suspect).getName());
        System.out.println("ѧ���Ա�"+peoDao.findsuspect(suspect).getSex());
        System.out.println("����ѧԺ��"+peoDao.findsuspect(suspect).getCollege());
        System.out.println("��ס�أ�"+peoDao.findsuspect(suspect).getAddress());
        System.out.println("�Ƿ����ƣ�"+peoDao.findsuspect(suspect).getSuspect());
        System.out.println("�Ƿ�ȷ�"+peoDao.findsuspect(suspect).getConfirm());
        System.out.println("�Ƿ��뻼�߽Ӵ���"+peoDao.findsuspect(suspect).getContact());
        System.out.println("���ڣ�"+peoDao.findsuspect(suspect).getTime());
  
	}
}