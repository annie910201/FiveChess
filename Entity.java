package application;

public class Entity {//判斷是否五個連成一直線
	final static int SIZE=11;
	final static int FIVE=5;
	int[][] dotBlack=new int[SIZE][SIZE];
	int[][] dotWhite=new int[SIZE][SIZE];
	int player=0; 
	int mode =0;
	int maxOf82=0;
	int maxOf46=0;
	int maxOf73=0;
	int maxOf91=0;
	public final void start(int p){
		for(int i=0;i<SIZE;i++) {
			for(int j=0;j<SIZE;j++) {
			dotBlack[i][j]=0;
			dotWhite[i][j]=0;
		}
			
	}
		maxOf82=0;
		maxOf46=0;
		maxOf73=0;
		maxOf91=0;
		player=p;
	}
	public final void setting(int x,int y,int player) {
		if(player==1)dotBlack[x][y]=1;
		else if(player==2)dotWhite[x][y]=1;
	}
	
	public final boolean check(int player) {
		if(player==1) {
			for(int i=0;i<SIZE;i++) {
				for(int j=0;j<SIZE;j++) {
					whetherIsFive(82,i,j,dotBlack);
					whetherIsFive(46,i,j,dotBlack);
					whetherIsFive(73,i,j,dotBlack);
					whetherIsFive(91,i,j,dotBlack);
				}
			}
		}
		else if (player==2) {
			for(int i=0;i<SIZE;i++) {
				for(int j=0;j<SIZE;j++) {
					whetherIsFive(82,i,j,dotWhite);
					whetherIsFive(46,i,j,dotWhite);
					whetherIsFive(73,i,j,dotWhite);
					whetherIsFive(91,i,j,dotWhite);
				}
			}
		}
		if(maxOf82==FIVE||maxOf46==FIVE||maxOf73==FIVE||maxOf91==FIVE)return true;
		else {
			maxOf82=0;
			maxOf46=0;
			maxOf73=0;
			maxOf91=0;
			return false;
		}
		
	}
	public final void whetherIsFive(int direction,int x,int y,int[][] dot) {
		switch(direction) {
			case 82 :
				int sum82=0;
				if(x+FIVE>10)break;
				for(int k=0;k<FIVE;k++) {
					sum82+=dot[x+k][y];
				}
				if(sum82>maxOf82)maxOf82=sum82;
				break;
			case 46 :
				int sum46=0;
				if(y+FIVE>10)break;
				for(int k=0;k<FIVE;k++) {
					sum46+=dot[x][y+k];
				}
				if(sum46>maxOf46)maxOf46=sum46;
				break;
			case 73 :
				int sum73=0;
				if(x+FIVE>10||y+FIVE>10)break;
				for(int k=0;k<FIVE;k++) {
					sum73+=dot[x+k][y+k];
				}
				if(sum73>maxOf73)maxOf73=sum73;
				break;
			case 91 :
				int sum91=0;
				if(x+FIVE>10||y-FIVE<0)break;
				for(int k=0;k<FIVE;k++) {
					sum91+=dot[x+k][y-k];
				}
				if(sum91>maxOf91)maxOf91=sum91;
				break;
		}
	}
}