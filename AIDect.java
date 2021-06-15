package application;

public final class AIDect {
	public final static int SIZE=11;
	public final static int FIVE=5;
	int[][] level=new int[SIZE][SIZE];
	int[][] direction=new int[SIZE][SIZE];
	int[][] rank=new int[SIZE][SIZE];
	int conMax=0;//�s��̤j���l
	public final void setLevel(int[][] computer,int[][] player) {
		for(int i=0;i<SIZE;i++) {//��l�ƥ����x�}
			for(int j=0;j<SIZE;j++) {
				level[i][j]=0;
				direction[i][j]=0;
				rank[i][j]=0;
			}
		}
		conMax=0;
		int[] levelList= {0,1,2,3,4,5,6,7,8};
		//����0:���䳣���l
		//����1:�@�Ӷ¦�(���a)�A�@�䦳
		//����2:�@�Ӷ¦�A���䳣�S��
		//����3:��Ӷ¦�A�@�䦳
		//����4:��Ӷ¦�A���䳣�S��
		//����5:�T�Ӷ¦�A�@�䦳
		//����6:�T�Ӷ¦�A���䳣�S��
		//����7:�|�Ӷ¦�A�@�䦳
		//����8:�|�Ӷ¦�A���䳣�S��
		for(int i=0;i<SIZE;i++) {
			for(int j=0;j<SIZE;j++) {
				int sum=0;
				if(player[i][j]==0)continue;
				////////////////////�P�_����////////////////////
				for(int k=0;k<FIVE;k++) {
					if(i+k>10||player[i+k][j]==0)break;
					sum+=player[i+k][j];
				}
				if(i+sum>10) {
					switch(sum) {
					case 1:
						if(computer[i-1][j]==0&&level[i][j]<levelList[1]) {
							level[i][j]=levelList[1];
							direction[i][j]=82;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 2:
						if(computer[i-1][j]==0&&level[i][j]<levelList[3]) {
							level[i][j]=levelList[3];
							direction[i][j]=82;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 3:
						if(computer[i-1][j]==0&&level[i][j]<levelList[5]) {
							level[i][j]=levelList[5];
							direction[i][j]=82;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 4:
						if(computer[i-1][j]==0&&level[i][j]<levelList[7]) {
							level[i][j]=levelList[7];
							direction[i][j]=82;
							if(sum>conMax)conMax=sum;
						}
						break;
					}
				}
				else if(i-1<0) {
					switch(sum) {
					case 1:
						if(computer[i+sum][j]==0&&level[i][j]<levelList[1]) {
							level[i][j]=levelList[1];
							direction[i][j]=82;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 2:
						if(computer[i+sum][j]==0&&level[i][j]<levelList[3]) {
							level[i][j]=levelList[3];
							direction[i][j]=82;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 3:
						if(computer[i+sum][j]==0&&level[i][j]<levelList[5]) {
							level[i][j]=levelList[5];
							direction[i][j]=82;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 4:
						if(computer[i+sum][j]==0&&level[i][j]<levelList[7]) {
							level[i][j]=levelList[7];
							direction[i][j]=82;
							if(sum>conMax)conMax=sum;
						}
						break;
					}
				}
				else {
					switch(sum) {
					case 1:
						if(computer[i+sum][j]==0&&computer[i-1][j]==0&&level[i][j]<levelList[2]) {
							level[i][j]=levelList[2];
							direction[i][j]=82;
							if(sum>conMax)conMax=sum;
						}
						else if(computer[i+sum][j]==1&&computer[i-1][j]==0&&level[i][j]<levelList[1]) {
							level[i][j]=levelList[1];
							direction[i][j]=82;
							if(sum>conMax)conMax=sum;
						}
						else if(computer[i+sum][j]==0&&computer[i-1][j]==1&&level[i][j]<levelList[1]) {
							level[i][j]=levelList[1];
							direction[i][j]=82;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 2:
						if(computer[i+sum][j]==0&&computer[i-1][j]==0&&level[i][j]<levelList[4]) {
							level[i][j]=levelList[4];
							direction[i][j]=82;
							if(sum>conMax)conMax=sum;
						}
						else if(computer[i+sum][j]==1&&computer[i-1][j]==0&&level[i][j]<levelList[3]) {
							level[i][j]=levelList[3];
							direction[i][j]=82;
							if(sum>conMax)conMax=sum;
						}
						else if(computer[i+sum][j]==0&&computer[i-1][j]==1&&level[i][j]<levelList[3]) {
							level[i][j]=levelList[3];
							direction[i][j]=82;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 3:
						if(computer[i+sum][j]==0&&computer[i-1][j]==0&&level[i][j]<levelList[6]) {
							level[i][j]=levelList[6];
							direction[i][j]=82;
							if(sum>conMax)conMax=sum;
						}
						else if(computer[i+sum][j]==1&&computer[i-1][j]==0&&level[i][j]<levelList[5]) {
							level[i][j]=levelList[5];
							direction[i][j]=82;
							if(sum>conMax)conMax=sum;
						}
						else if(computer[i+sum][j]==0&&computer[i-1][j]==1&&level[i][j]<levelList[5]) {
							level[i][j]=levelList[5];
							direction[i][j]=82;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 4:
						if(computer[i+sum][j]==0&&computer[i-1][j]==0&&level[i][j]<levelList[8]) {
							level[i][j]=levelList[8];
							direction[i][j]=82;
							if(sum>conMax)conMax=sum;
						}
						else if(computer[i+sum][j]==1&&computer[i-1][j]==0&&level[i][j]<levelList[7]) {
							level[i][j]=levelList[7];
							direction[i][j]=82;
							if(sum>conMax)conMax=sum;
						}
						else if(computer[i+sum][j]==0&&computer[i-1][j]==1&&level[i][j]<levelList[7]) {
							level[i][j]=levelList[7];
							direction[i][j]=82;
							if(sum>conMax)conMax=sum;
						}
						break;
					}
				}
				////////////////////�P�_�////////////////////
				sum=0;
				for(int k=0;k<FIVE;k++) {
					if(j+k>10||player[i][j+k]==0)break;
					sum+=player[i][j+k];
				}
				if(j+sum>10) {
					switch(sum) {
					case 1:
						if(computer[i][j-1]==0&&level[i][j]<levelList[1]) {
							level[i][j]=levelList[1];
							direction[i][j]=46;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 2:
						if(computer[i][j-1]==0&&level[i][j]<levelList[3]) {
							level[i][j]=levelList[3];
							direction[i][j]=46;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 3:
						if(computer[i][j-1]==0&&level[i][j]<levelList[5]) {
							level[i][j]=levelList[5];
							direction[i][j]=46;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 4:
						if(computer[i][j-1]==0&&level[i][j]<levelList[7]) {
							level[i][j]=levelList[7];
							direction[i][j]=46;
							if(sum>conMax)conMax=sum;
						}
						break;
					}
				}
				else if(j-1<0) {
					switch(sum) {
					case 1:
						if(computer[i][j+sum]==0&&level[i][j]<levelList[1]) {
							level[i][j]=levelList[1];
							direction[i][j]=46;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 2:
						if(computer[i][j+sum]==0&&level[i][j]<levelList[3]) {
							level[i][j]=levelList[3];
							direction[i][j]=46;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 3:
						if(computer[i][j+sum]==0&&level[i][j]<levelList[5]) {
							level[i][j]=levelList[5];
							direction[i][j]=46;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 4:
						if(computer[i][j+sum]==0&&level[i][j]<levelList[7]) {
							level[i][j]=levelList[7];
							direction[i][j]=46;
							if(sum>conMax)conMax=sum;
						}
						break;
					}
				}
				else {
					switch(sum) {
					case 1:
						if(computer[i][j+sum]==0&&computer[i][j-1]==0&&level[i][j]<levelList[2]) {
							level[i][j]=levelList[2];
							direction[i][j]=46;
							if(sum>conMax)conMax=sum;
						}
						else if(computer[i][j+sum]==1&&computer[i][j-1]==0&&level[i][j]<levelList[1]) {
							level[i][j]=levelList[1];
							direction[i][j]=46;
							if(sum>conMax)conMax=sum;
						}
						else if(computer[i][j+sum]==0&&computer[i][j-1]==1&&level[i][j]<levelList[1]) {
							level[i][j]=levelList[1];
							direction[i][j]=46;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 2:
						if(computer[i][j+sum]==0&&computer[i][j-1]==0&&level[i][j]<levelList[4]) {
							level[i][j]=levelList[4];
							direction[i][j]=46;
							if(sum>conMax)conMax=sum;
						}
						else if(computer[i][j+sum]==1&&computer[i][j-1]==0&&level[i][j]<levelList[3]) {
							level[i][j]=levelList[3];
							direction[i][j]=46;
							if(sum>conMax)conMax=sum;
						}
						else if(computer[i][j+sum]==0&&computer[i][j-1]==1&&level[i][j]<levelList[3]) {
							level[i][j]=levelList[3];
							direction[i][j]=46;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 3:
						if(computer[i][j+sum]==0&&computer[i][j-1]==0&&level[i][j]<levelList[6]) {
							level[i][j]=levelList[6];
							direction[i][j]=46;
							if(sum>conMax)conMax=sum;
						}
						else if(computer[i][j+sum]==1&&computer[i][j-1]==0&&level[i][j]<levelList[5]) {
							level[i][j]=levelList[5];
							direction[i][j]=46;
							if(sum>conMax)conMax=sum;
						}
						else if(computer[i][j+sum]==0&&computer[i][j-1]==1&&level[i][j]<levelList[5]) {
							level[i][j]=levelList[5];
							direction[i][j]=46;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 4:
						if(computer[i][j+sum]==0&&computer[i][j-1]==0&&level[i][j]<levelList[8]) {
							level[i][j]=levelList[8];
							direction[i][j]=46;
							if(sum>conMax)conMax=sum;
						}
						else if(computer[i][j+sum]==1&&computer[i][j-1]==0&&level[i][j]<levelList[7]) {
							level[i][j]=levelList[7];
							direction[i][j]=46;
							if(sum>conMax)conMax=sum;
						}
						else if(computer[i][j+sum]==0&&computer[i][j-1]==1&&level[i][j]<levelList[7]) {
							level[i][j]=levelList[7];
							direction[i][j]=46;
							if(sum>conMax)conMax=sum;
						}
						break;
					}
				}
				////////////////////�P�_���W�k�U////////////////
				sum=0;
				for(int k=0;k<FIVE;k++) {
					if(j+k>10||i+k>10||player[i+k][j+k]==0)break;
					sum+=player[i+k][j+k];
				}
				if(j+sum>10||i+sum>10) {
					switch(sum) {
					case 1:
						if(computer[i-1][j-1]==0&&level[i][j]<levelList[1]) {
							level[i][j]=levelList[1];
							direction[i][j]=73;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 2:
						if(computer[i-1][j-1]==0&&level[i][j]<levelList[3]) {
							level[i][j]=levelList[3];
							direction[i][j]=73;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 3:
						if(computer[i-1][j-1]==0&&level[i][j]<levelList[5]) {
							level[i][j]=levelList[5];
							direction[i][j]=73;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 4:
						if(computer[i-1][j-1]==0&&level[i][j]<levelList[7]) {
							level[i][j]=levelList[7];
							direction[i][j]=73;
							if(sum>conMax)conMax=sum;
						}
						break;
					}
				}
				else if(j-1<0||i-1<0) {
					switch(sum) {
					case 1:
						if(computer[i+sum][j+sum]==0&&level[i][j]<levelList[1]) {
							level[i][j]=levelList[1];
							direction[i][j]=73;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 2:
						if(computer[i+sum][j+sum]==0&&level[i][j]<levelList[3]) {
							level[i][j]=levelList[3];
							direction[i][j]=73;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 3:
						if(computer[i+sum][j+sum]==0&&level[i][j]<levelList[5]) {
							level[i][j]=levelList[5];
							direction[i][j]=73;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 4:
						if(computer[i+sum][j+sum]==0&&level[i][j]<levelList[7]) {
							level[i][j]=levelList[7];
							direction[i][j]=73;
							if(sum>conMax)conMax=sum;
						}
						break;
					}
				}
				else {
					switch(sum) {
					case 1:
						if(computer[i+sum][j+sum]==0&&computer[i-1][j-1]==0&&level[i][j]<levelList[2]) {
							level[i][j]=levelList[2];
							direction[i][j]=73;
							if(sum>conMax)conMax=sum;
						}
						else if(computer[i+sum][j+sum]==1&&computer[i-1][j-1]==0&&level[i][j]<levelList[1]) {
							level[i][j]=levelList[1];
							direction[i][j]=73;
							if(sum>conMax)conMax=sum;
						}
						else if(computer[i+sum][j+sum]==0&&computer[i-1][j-1]==1&&level[i][j]<levelList[1]) {
							level[i][j]=levelList[1];
							direction[i][j]=73;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 2:
						if(computer[i+sum][j+sum]==0&&computer[i-1][j-1]==0&&level[i][j]<levelList[4]) {
							level[i][j]=levelList[4];
							direction[i][j]=73;
							if(sum>conMax)conMax=sum;
						}
						else if(computer[i+sum][j+sum]==1&&computer[i-1][j-1]==0&&level[i][j]<levelList[3]) {
							level[i][j]=levelList[3];
							direction[i][j]=73;
							if(sum>conMax)conMax=sum;
						}
						else if(computer[i+sum][j+sum]==0&&computer[i-1][j-1]==1&&level[i][j]<levelList[3]) {
							level[i][j]=levelList[3];
							direction[i][j]=73;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 3:
						if(computer[i+sum][j+sum]==0&&computer[i-1][j-1]==0&&level[i][j]<levelList[6]) {
							level[i][j]=levelList[6];
							direction[i][j]=73;
							if(sum>conMax)conMax=sum;
						}
						else if(computer[i+sum][j+sum]==1&&computer[i-1][j-1]==0&&level[i][j]<levelList[5]) {
							level[i][j]=levelList[5];
							direction[i][j]=73;
							if(sum>conMax)conMax=sum;
						}
						else if(computer[i+sum][j+sum]==0&&computer[i-1][j-1]==1&&level[i][j]<levelList[5]) {
							level[i][j]=levelList[5];
							direction[i][j]=73;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 4:
						if(computer[i+sum][j+sum]==0&&computer[i-1][j-1]==0&&level[i][j]<levelList[8]) {
							level[i][j]=levelList[8];
							direction[i][j]=73;
							if(sum>conMax)conMax=sum;
						}
						else if(computer[i+sum][j+sum]==1&&computer[i-1][j-1]==0&&level[i][j]<levelList[7]) {
							level[i][j]=levelList[7];
							direction[i][j]=73;
							if(sum>conMax)conMax=sum;
						}
						else if(computer[i+sum][j+sum]==0&&computer[i-1][j-1]==1&&level[i][j]<levelList[7]) {
							level[i][j]=levelList[7];
							direction[i][j]=73;
							if(sum>conMax)conMax=sum;
						}
						break;
					}
				}
				////////////////////�P�_�k�W���U////////////////
				sum=0;
				for(int k=0;k<FIVE;k++) {
					if(j-k<0||i+k>10||player[i+k][j-k]==0)break;
					sum+=player[i+k][j-k];
				}
				if(i+sum>10||j-sum<0) {
					switch(sum) {
					case 1:
						if(computer[i-1][j+1]==0&&level[i][j]<levelList[1]) {
							level[i][j]=levelList[1];
							direction[i][j]=91;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 2:
						if(computer[i-1][j+1]==0&&level[i][j]<levelList[3]) {
							level[i][j]=levelList[3];
							direction[i][j]=91;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 3:
						if(computer[i-1][j+1]==0&&level[i][j]<levelList[5]) {
							level[i][j]=levelList[5];
							direction[i][j]=91;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 4:
						if(computer[i-1][j+1]==0&&level[i][j]<levelList[7]) {
							level[i][j]=levelList[7];
							direction[i][j]=91;
							if(sum>conMax)conMax=sum;
						}
						break;
					}
				}
				else if(j+1<0||i-1<0) {
					switch(sum) {
					case 1:
						if(computer[i+sum][j-sum]==0&&level[i][j]<levelList[1]) {
							level[i][j]=levelList[1];
							direction[i][j]=91;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 2:
						if(computer[i+sum][j-sum]==0&&level[i][j]<levelList[3]) {
							level[i][j]=levelList[3];
							direction[i][j]=91;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 3:
						if(computer[i+sum][j-sum]==0&&level[i][j]<levelList[5]) {
							level[i][j]=levelList[5];
							direction[i][j]=91;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 4:
						if(computer[i+sum][j-sum]==0&&level[i][j]<levelList[7]) {
							level[i][j]=levelList[7];
							direction[i][j]=91;
							if(sum>conMax)conMax=sum;
						}
						break;
					}
				}
				else {
					switch(sum) {
					case 1:
						if(computer[i+sum][j-sum]==0&&computer[i-1][j+1]==0&&level[i][j]<levelList[2]) {
							level[i][j]=levelList[2];
							direction[i][j]=91;
							if(sum>conMax)conMax=sum;
						}
						else if(computer[i+sum][j-sum]==1&&computer[i-1][j+1]==0&&level[i][j]<levelList[1]) {
							level[i][j]=levelList[1];
							direction[i][j]=91;
							if(sum>conMax)conMax=sum;
						}
						else if(computer[i+sum][j-sum]==0&&computer[i-1][j+1]==1&&level[i][j]<levelList[1]) {
							level[i][j]=levelList[1];
							direction[i][j]=91;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 2:
						if(computer[i+sum][j-sum]==0&&computer[i-1][j+1]==0&&level[i][j]<levelList[4]) {
							level[i][j]=levelList[4];
							direction[i][j]=91;
							if(sum>conMax)conMax=sum;
						}
						else if(computer[i+sum][j-sum]==1&&computer[i-1][j+1]==0&&level[i][j]<levelList[3]) {
							level[i][j]=levelList[3];
							direction[i][j]=91;
							if(sum>conMax)conMax=sum;
						}
						else if(computer[i+sum][j-sum]==0&&computer[i-1][j+1]==1&&level[i][j]<levelList[3]) {
							level[i][j]=levelList[3];
							direction[i][j]=91;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 3:
						if(computer[i+sum][j-sum]==0&&computer[i-1][j+1]==0&&level[i][j]<levelList[6]) {
							level[i][j]=levelList[6];
							direction[i][j]=91;
							if(sum>conMax)conMax=sum;
						}
						else if(computer[i+sum][j-sum]==1&&computer[i-1][j+1]==0&&level[i][j]<levelList[5]) {
							level[i][j]=levelList[5];
							direction[i][j]=91;
							if(sum>conMax)conMax=sum;
						}
						else if(computer[i+sum][j-sum]==0&&computer[i-1][j+1]==1&&level[i][j]<levelList[5]) {
							level[i][j]=levelList[5];
							direction[i][j]=91;
							if(sum>conMax)conMax=sum;
						}
						break;
					case 4:
						if(computer[i+sum][j-sum]==0&&computer[i-1][j+1]==0&&level[i][j]<levelList[8]) {
							level[i][j]=levelList[8];
							direction[i][j]=91;
							if(sum>conMax)conMax=sum;
						}
						else if(computer[i+sum][j-sum]==1&&computer[i-1][j+1]==0&&level[i][j]<levelList[7]) {
							level[i][j]=levelList[7];
							direction[i][j]=91;
							if(sum>conMax)conMax=sum;
						}
						else if(computer[i+sum][j-sum]==0&&computer[i-1][j+1]==1&&level[i][j]<levelList[7]) {
							level[i][j]=levelList[7];
							direction[i][j]=91;
							if(sum>conMax)conMax=sum;
						}
						break;
					}
				}
			}
		}
	}
	
	///////////////////////////�ڬO���j�u//////////////////////////////
	//�ˬd����Ѥl
	public final void checkBothSide(int[][] computer,int [][]player) {
		int maxLevel=0;
		//��X�v���̤j����m
		for(int i=0;i<SIZE;i++) {
			for(int j=0;j<SIZE;j++) {
				if(level[i][j]>maxLevel)maxLevel=level[i][j];
			}
		}
		//�P�_�����m���p
		for(int i=0;i<SIZE;i++) {
			for(int j=0;j<SIZE;j++) {
				if(level[i][j]!=maxLevel)continue;
					//�P�_����
					if(direction[i][j]==82) {
						if(i+conMax>10||i-1<0)continue;
						else if(player[i+conMax][j]==1||computer[i+conMax][j]==1) {
							if(player[i-1][j]==1||computer[i-1][j]==1) continue;
							else rank[i-1][j]=1;
						}else {
							if(player[i-1][j]==1||computer[i-1][j]==1)rank[i+conMax][j]=1;
							else {
								rank[i-1][j]=2;
								rank[i+conMax][j]=2;
							}
						}
					}
					//�P�_�
					else if(direction[i][j]==46) {
						if(j+conMax>10||j-1<0)continue;
						else if(player[i][j+conMax]==1||computer[i][j+conMax]==1) {
							if(player[i][j-1]==1||computer[i][j-1]==1) continue;
							else rank[i][j-1]=1;
						}else {
							if(player[i][j-1]==1||computer[i][j-1]==1)rank[i][j+conMax]=1;
							else {
								rank[i][j-1]=2;
								rank[i][j+conMax]=2;
							}
						}
					}
					//�P�_���W�k�U
					else if(direction[i][j]==73) {
						if(j+conMax>10||j-1<0||i+conMax>10||i-1<0)continue;
						else if(player[i+conMax][j+conMax]==1||computer[i+conMax][j+conMax]==1) {
							if(player[i-1][j-1]==1||computer[i-1][j-1]==1) continue;
							else rank[i-1][j-1]=1;
						}else {
							if(player[i-1][j-1]==1||computer[i-1][j-1]==1)rank[i+conMax][j+conMax]=1;
							else{
								rank[i-1][j-1]=2;
								rank[i+conMax][j+conMax]=2;
							}
						}
					}
					//�P�_�k�W���U
					else if(direction[i][j]==91) {
						if(j-conMax<0||j+1>10||i+conMax>10||i-1<0)continue;
						else if(player[i+conMax][j-conMax]==1||computer[i+conMax][j-conMax]==1) {
							if(player[i-1][j+1]==1||computer[i-1][j+1]==1) continue;
							else rank[i-1][j+1]=1;
						}else {
							if(player[i-1][j+1]==1||computer[i-1][j+1]==1)rank[i+conMax][j-conMax]=1;
							else {
								rank[i-1][j+1]=2;
								rank[i+conMax][j-conMax]=2;
							}
						}
					}
			}
		}
	}
	public final void finalPlace() {
		int maxRank=0;
		for(int i=0;i<SIZE;i++) {
			for(int j=0;j<SIZE;j++) {
				if(rank[i][j]>maxRank)maxRank=rank[i][j];
			}
		}
		outer:
		for(int i=0;i<SIZE;i++) {
			for(int j=0;j<SIZE;j++) {
				if(rank[i][j]==maxRank) {
					for(int a=0;a<SIZE;a++) {
						for(int b=0;b<SIZE;b++) {
							rank[a][b]=0;
						}
					}
					rank[i][j]=1;
					break outer;
				}
			}
		}
	}	
}