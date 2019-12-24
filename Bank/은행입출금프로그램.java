#Bank.java
public class Bank 
{
	protected String account_Num; 	//계좌번호
	protected int bank_Total_Money;	//은행돈
	protected double interest_Rate;	//이자율
	
	protected Bank(){               //디폴트 생성자  매개변수가 없을 경우 this생성자 로 이동
		this("", 0, 0.0);
		
	}
	
	protected Bank(String account_Num,int bank_Total_Money, double interest_Rate) //생성자 = 필드를 초기화 하기 위해
	{
		this.account_Num = account_Num;
		this.bank_Total_Money = bank_Total_Money;
		this.interest_Rate = interest_Rate;
	}
	
	public String getAccount_Num()  //접근자 생성 : 외부 클래스에서 접근이 불가하기 때문에 메소드 형태로 해당 클래스에 만들어 놓은것

	{
		return account_Num;
	}

	public void setAccount_Num(String account_Num) //설정자 생성 : 외부 클래스에서 설정이 불가하기 때문에 메소드 형태로 해당 클래스에 만들어 놓은것

	{
		this.account_Num = account_Num;
	}

	public int getBank_Total_Money() //접근자메소드
	{
		return bank_Total_Money;
	}

	public void setBank_Total_Money(int bank_Total_Money) //설정자메소드
	{
		this.bank_Total_Money = bank_Total_Money;
	}

	public double getInterest_Rate() //접근자메소드
	{
		return interest_Rate;
	}

	public void setInterest_Rate(double interest_Rate) //설정자 메소드
	{
		this.interest_Rate = interest_Rate;
	}

	void inOut_Func(int money)  // 입출금 메소드
	{
		System.out.println("입출금을 위한 메소드");
	}
	
	void ir_Func()  //이자율 메소드
	{
		System.out.println("이자율 적용 메소드");
	}
}



#Customer.java

public class Customer extends Bank 
{
	private String name;			//이름
	private int cus_Total_Money;	//고객돈
	
	public Customer(String name,int cus_Total_Money,String account_Num, 
			        int bank_Total_Money,double interest_Rate)
	{
		super(account_Num,bank_Total_Money,interest_Rate);//부모클래스 생성자 호출
		this.name = name;
		this.cus_Total_Money = cus_Total_Money;
	}
	
	public String getName() //접근자 메소드 : 외부 클래스에서 접근이 불가하기 때문에 메소드 형태로 해당 클래스에 만들어 놓은것
	{
		return name;
	}

	public void setName(String name)  //설정자 메소드 : 외부 클래스에서 설정이 불가하기 때문에 메소드 형태로 해당 클래스에 만들어 놓은것
	{
		this.name = name;
	}

	public int getCus_Total_Money() //접근자 메소드
	{
		return cus_Total_Money;
	}

	public void setCus_Total_Money(int cus_Total_Money)  //설정자 메소드
	{
		this.cus_Total_Money = cus_Total_Money;
	}

	@Override
	void inOut_Func(int money)
	{//입금의 경우 +, 출금의 경우 -
		if(money > 0)
		{//입금
			if(cus_Total_Money >= money)
			{//소지한 금액이 입금할 금액보다 많을때(입금가능) 
				cus_Total_Money = cus_Total_Money-money;
				bank_Total_Money += money;
			}else
			{
				System.out.println("금액이 부족합니다.");
			}
		}else
		{//출금
			if(bank_Total_Money >= (-money))
			{//은행잔액이 출금할 금액보다 많을때(출금가능)
				bank_Total_Money += money;
				cus_Total_Money -= money;
			}else
			{
				System.out.println("잔액이 부족합니다.");
			}
		}
	}
	
	@Override
	void ir_Func()
	{//이자를 계산하여 고객의돈에 합산
		cus_Total_Money += (int)(bank_Total_Money*interest_Rate);
	}
	
	public String toString()
	{// toString 메소드 호출시 밑에 문자열 출력
		return "이름: "+name+"\n소지한 금액: "+cus_Total_Money+"\n계좌번호: "+account_Num
				+"\n은행 잔액: "+bank_Total_Money;
	}
}


#Account_Test.java


public class Account_Test 
{
	public static void main(String[]args)
	{
		Customer cs1 = new Customer("김기태",100000, "123-456", 0, 0.05);
		System.out.println(cs1);
		System.out.println();
		
		cs1.inOut_Func(50000);//5만원 입금
		System.out.println("소지한 금액: "+cs1.getCus_Total_Money());
		System.out.println("은행 잔액: "+ cs1.getBank_Total_Money());
		System.out.println();
		
		cs1.inOut_Func(-30000);//3만원 출금
		System.out.println("소지한 금액: "+cs1.getCus_Total_Money());
		System.out.println("은행 잔액: "+ cs1.getBank_Total_Money());
		System.out.println();
		
		cs1.inOut_Func(90000);//소지한 금액 이상을 입금
		cs1.inOut_Func(-30000);//은행 잔액 이상을 출금
		System.out.println("소지한 금액: "+cs1.getCus_Total_Money());
		System.out.println("은행 잔액: "+ cs1.getBank_Total_Money());
		System.out.println();
		
		cs1.inOut_Func(80000);
		System.out.println("소지한 금액: "+cs1.getCus_Total_Money());
		System.out.println("은행 잔액: "+ cs1.getBank_Total_Money());
		System.out.println();
		
		cs1.ir_Func();
		System.out.println(cs1);		
	}
}


