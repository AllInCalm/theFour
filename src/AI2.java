
public class AI2 {
	protected String[][] set=new String[6][7];
	public AI2(String[][] set){
	}
	protected boolean ROrNot(){
		int y=0;
		int r=0;
		for(int i=0;i<=5;i++){
			for(int j=0;j<=6;j++){
				if(set[i][j]=="R")
					r++;
				if(set[i][j]=="Y")
					y++;
			}
		}
		if(r!=y)
			return false;
		return true;
	}
	

}
