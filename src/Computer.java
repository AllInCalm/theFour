import java.util.Arrays;

public class Computer{
	public static int Comput(String[][] old,String colour){
		String[][] present=new String[6][7];
		for(int i=0;i<=5;i++){
			for(int j=0;j<=6;j++){
				present[i][j]=old[i][j];
			}
		}
		if(toWin(present,colour)!=7)
			return toWin(present,colour);
		if(makeUp(present,colour)!=7)
			return makeUp(present,colour);
		if(make3(present,colour)!=7)
			return make3(present,colour);
		return(noRestrictPut(present));
	}
	public static int toWin(String[][] present,String colour){
		int i;
		int checkWin=7;
		for(i=0;i<=6;i++){
			String[][] temp=new String[6][7];
			for(int i2=0;i2<=5;i2++){
				for(int j=0;j<=6;j++){
					temp[i2][j]=present[i2][j];
				}
			}
			int s=TheFour.put(temp, i, colour);
			if(s==0){
				checkWin=TheFour.check(temp);
				if (checkWin==1)
					break;
				
			}
		}
		if(checkWin==1)
			return i;
		else
			return 7;
	}
	public static int makeUp(String[][] present,String colour){
		String nextColour=swapColour(colour);
		String[][] temp=new String[6][7];
		for(int i2=0;i2<=5;i2++){
			for(int j=0;j<=6;j++){
				temp[i2][j]=present[i2][j];
			}
		}
		if(toWin(temp,nextColour)!=7){
			return toWin(temp,nextColour);
		}
		return (make3(present,nextColour));
	}
	public static String swapColour(String presentColour){
		switch(presentColour){
		case "R":return "Y";
		case "Y":return "R";
		default : return " ";
		}
		
	}
	public static int make3(String[][] present,String colour){
		int i;
		int checkWin=7;
		for(i=0;i<=6;i++){
			String[][] temp=new String[6][7];
			for(int i2=0;i2<=5;i2++){
				for(int j=0;j<=6;j++){
					temp[i2][j]=present[i2][j];
				}
			}
			int s=TheFour.put(temp, i, colour);
			if(s==0){
				checkWin=check3(temp);
				if ((checkWin==1)&&(toWin(temp,swapColour(colour)))==7)
					break;
				
			}
		}
		
		if(checkWin==1)
			return i;
		else
			return 7;
	}
	public static int check3(String[][] check){
		if(c31(check)==1|c32(check)==1|c33(check)==1)
			return 1;
		return 0;//return 1 means Win
	}
	public static int c31(String[][] c){
		for(int p=0;p <= 5; p++){
			for(int q=0;q<=4;q++){
				if((c[p][q]=="R"&c[p][q+1]=="R"&c[p][q+2]=="R")|(c[p][q]=="Y"&c[p][q+1]=="Y"&c[p][q+2]=="Y"))
					return 1;
			}
		}
		return 0;
	}
	public static int c32(String[][] c){
		for(int q=0;q <= 6; q++){
			for(int p=0;p<=3;p++){
				if((c[p+1][q]=="R"&c[p+2][q]=="R"&c[p][q]=="R")|(c[p][q]=="Y"&c[p+1][q]=="Y"&c[p+2][q]=="Y"))
					return 1;
			}
		}
		return 0;
	}
	public static int c33(String[][] c){
		for(int p=2;p <= 5; p++){
			for(int q=0;q<=4;q++){
				if((c[p][q]=="R"&c[p-1][q+1]=="R"&c[p-2][q+2]=="R")|(c[p][q]=="Y"&c[p-1][q+1]=="Y"&c[p-2][q+2]=="Y"))
					return 1;
			}
		
		}
		for(int p=2;p <= 5; p++){
			for(int q=2;q<=6;q++){
				if((c[p][q]=="R"&c[p-1][q-1]=="R"&c[p-2][q-2]=="R")|(c[p][q]=="Y"&c[p-1][q-1]=="Y"&c[p-2][q-2]=="Y"))
					return 1;
			}
		}
		return 0;
	}
	public static int noRestrictPut(String[][] present){
		int[] bestA={3,2,4,1,5,0,6} ;
		for(int i=0 ;i<=6;i++){
			String[][] temp=new String[6][7];
			for(int i2=0;i2<=5;i2++){
				for(int j=0;j<=6;j++){
					temp[i2][j]=present[i2][j];
				}
			}
			
			if((TheFour.put(temp, bestA[i], "R"))==0){
				
				return bestA[i];
			}
		}
		
		return 3;
	}
}
