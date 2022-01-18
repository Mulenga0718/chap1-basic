package practice01;
import java.sql.Date;
public class MemberVO {

	private String name;
	private String type;
	private String menu;
	private String address;
	private String ph;
	// 이름, 분류, 메뉴, 주소, 전화번호, 
	 public MemberVO() {
		System.out.println("launch 생성자 호출");
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String gettype() {
		return type;
	}
	public void settype(String type) {
		this.type = type;
	}
	public String getmenu() {
		return menu;
	}
	public void setmenu(String menu) {
 		this.menu = menu;
	}
	public String getaddress() {
		return address;
	}
	public void setaddress(String address) {
		this.address = address;
	}
	public String getph() {
		return ph;
	}
	public void setph(String ph) {
		this.ph = ph;
	
}
}