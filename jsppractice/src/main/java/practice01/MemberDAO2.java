package practice01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.sql.*;

public class MemberDAO2 {

	private PreparedStatement pstmt;
	private Connection con;
	private DataSource dataFactory;
	
		public MemberDAO2()
		{
			try
			{
				Context ctx = new InitialContext();
				Context envContext = (Context) ctx.lookup("java:/comp/env");
				dataFactory = (DataSource) envContext.lookup("jdbc/oracle");	 		
				}catch(Exception e) {
	e.printStackTrace();
}
		}
	
	public List<MemberVO> listMembers(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			con = dataFactory.getConnection();
			String query = "select*from t_launch";
			System.out.println("preparedStatement: "+query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				String name = rs.getString("name");
				String type = rs.getString("type");
				String menu = rs.getString("menu");
				String address = rs.getString("address");
				String ph = rs.getString("ph");
				MemberVO vo = new MemberVO();
				vo.setname(name);
				vo.settype(type);
				vo.setmenu(menu);
				vo.setaddress(address);
				vo.setph(ph);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	 	return list;
	}	
	public void addMember(MemberVO memberVO) {
		try
		{
			con=  dataFactory.getConnection();
			String name = memberVO.getname();
			String type = memberVO.gettype();
			String menu = memberVO.getmenu();
			String address = memberVO.getaddress();
			String ph = memberVO.getph();
			
			String query = "insert into t_launch";
			query += "(name,type,menu,address,ph)";
			query += "values(?,?,?,?,?)";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, type);
			pstmt.setString(3, menu);
			pstmt.setString(4, address);
			pstmt.setString(5, ph);
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
		public void delMember(String name)
		{
			try
			{
				con=dataFactory.getConnection();
				
				String query = "delete from t_lauch" + "where name=?";
				System.out.println("preapareStatement: "+ query);
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, name);
				pstmt.executeUpdate();
				pstmt.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
