import java.util.Scanner;
public class TheFour {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Human vs Human(0) or Human vs Computer(1)");
		Scanner input=new Scanner(System.in);
		int hvh=2;
		while(hvh!=0&&hvh!=1){
			hvh=input.nextInt();
		}
		String hcolour=" ";
		if(hvh==1){
			System.out.println("Human go First?(1 for Yes/0 for No)");
			int first=2;
			while(first!=0&&first!=1){
				first=input.nextInt();
			}
			
			if(first==1)
				hcolour="R";
			else
				hcolour="Y";
		}//决定先后
		
		String[][] p2=new String[6][7];
		resetAll(p2,6,7);
		int check1=0;
		int check2=0;
		int step=0;
		while(check1==0&check2==0){
			String colour;
			colour="?";
			if((step%2.0)==0)
				colour="R";
			if((step%2.0)!=0)
				colour="Y";
			printAll(p2);
			if(hvh==0|((hvh==1)&&(colour==hcolour))){
				System.out.println("Drop a "+colour+" disk at column(0-6)");
				int a=1;
				
				while(a==1){
					int in=input.nextInt();
					a=putAndCheck(p2,in,colour);
				}
			}
			if(hvh==1&&(colour!=hcolour)){
				int comput=Computer.Comput(p2, colour);
				put(p2,comput,colour);
			}
			step++;
			check1=check(p2);
			if(step==6*7)
				check2=1;
			//check=0 means to go on
			//check1=1 means end with a winner
			//check2=1 means end with Full
		}
		Analyse(check1,check2,step);
		printAll(p2);
		System.out.close();
		

	}
	public static void resetAll(String[][] str,int i,int j){
		for(int m=0;m<i;m++)
			for(int n=0;n<j;n++)
				str[m][n]=" ";
		
	}
	public static void printAll(String[][] p){
		System.out.println(" 0 1 2 3 4 5 6 ");
		/*System.out.println(" _ _ _ _ _ _ _ ");*/
		for(int i=5; i >=0; i--){
			for(int j=0;j<=6;j++){
				System.out.print("|"+p[i][j]);
				if(j==6)
					System.out.println("|");
			}
			if(i==0)
				System.out.println("###############");
		};
	}
	public static int putAndCheck(String[][] p, int a , String colour){
		if(a<0|a>6){
			System.out.println("Invalid Input!");
			return 1;
		}
		int c=put(p,a,colour);
		if(c==1){
			System.out.println("Invalid Input!");
			return 1;
		}
		return 0;
	}
	public static int put(String[][] p,int a,String colour){
		int x=0;
		Boolean correct=false;
		while(correct==false&&x<=5){
			if(p[x][a]==" "){
				correct=true;
			}
			
			x++;
		}
		if(correct==false)
			return 1;
		p[x-1][a]=colour;
		return 0;
		
	}
	public static int check(String[][] check){
		if(c1(check)==1|c2(check)==1|c3(check)==1)
			return 1;
		return 0;//return 1 means Win
		
	}
	public static void Analyse(int a,int b,int step){

		if(a==1){
			System.out.println("Win!");
			return;
		}
		System.out.println("Draw");
	}
	public static int c1(String[][] c){
		for(int p=0;p <= 5; p++){
			for(int q=0;q<=3;q++){
				if((c[p][q]=="R"&c[p][q+1]=="R"&c[p][q+2]=="R"&c[p][q+3]=="R")|(c[p][q]=="Y"&c[p][q+1]=="Y"&c[p][q+2]=="Y"&c[p][q+3]=="Y"))
					return 1;
			}
		}
		return 0;
	}
	public static int c2(String[][] c){
		for(int q=0;q <= 6; q++){
			for(int p=0;p<=2;p++){
				if((c[p+1][q]=="R"&c[p+2][q]=="R"&c[p+3][q]=="R"&c[p][q]=="R")|(c[p][q]=="Y"&c[p+1][q]=="Y"&c[p+2][q]=="Y"&c[p+3][q]=="Y"))
					return 1;
			}
		}
		return 0;
	}
	public static int c3(String[][] c){
		for(int p=3;p <= 5; p++){
			for(int q=0;q<=3;q++){
				if((c[p][q]=="R"&c[p-1][q+1]=="R"&c[p-2][q+2]=="R"&c[p-3][q+3]=="R")|(c[p][q]=="Y"&c[p-1][q+1]=="Y"&c[p-2][q+2]=="Y"&c[p-3][q+3]=="Y"))
					return 1;
			}
		
		}
		for(int p=3;p <= 5; p++){
			for(int q=3;q<=6;q++){
				if((c[p][q]=="R"&c[p-1][q-1]=="R"&c[p-2][q-2]=="R"&c[p-3][q-3]=="R")|(c[p][q]=="Y"&c[p-1][q-1]=="Y"&c[p-2][q-2]=="Y"&c[p-3][q-3]=="Y"))
					return 1;
			}
		}
		return 0;
	}

}
