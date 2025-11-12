import java.util.Scanner;
class User{
	static Scanner sc = new Scanner(System.in);
	private String username;
	private long phoneNumber;
	private String addressDetails;
	private int userId;
	private String password;
	
	User(String username, long phoneNumber, String addressDetails, int userId, String password){
		this.username= username;
		this.phoneNumber=phoneNumber;
		this.addressDetails=addressDetails;
		this. userId=  userId;
		this.password=password;
	}
	String get1(){
		return username;
	}
	String get2(){
		return password;
	}
	
	void set1(String username){
		this.username;	
	}
	void set2(String password){
		this.password;	
	}
	void login(){
		System.out.println("Enter the user
	}

		

	public static void main(String args[]){
		System.out.println("enter user details ( username ,phonenumber, address, userId(4digits), set password)");
		User obj = new User(sc.next(),sc.nextLong(),sc.next(),sc.nextInt(),sc.next());
		
	}
}
