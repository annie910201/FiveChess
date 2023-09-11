package application;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public final class AIMotion extends Pane {
	public final static int SIZE=11;
	private Entity entity;
	private AIDect AIdect;
	private Pane pane=new Pane();
	private Image board=new Image("file:///C:\\Users\\Annie\\OneDrive\\圖片\\FiveChessGame\\board.png");
	private ImageView imageView=new ImageView(board);
	public final double h=board.getHeight();
	public final double w=board.getWidth();
	private VBox img1=new VBox();//VBox分隔上下空間，HBox分隔左右空間
	private VBox img2=new VBox();
	File file=new File("C:\\Users\\Annie\\Downloads\\全世界最喜歡.mp3");
	Media media=new Media(file.toURI().toString());
	MediaPlayer mediaPlayer=new MediaPlayer(media);
	public  AIMotion() throws Exception  {
		entity=new Entity();
		AIdect=new AIDect();
		entity.mode=2;
		entity.start(1);
		pane.setLayoutX(0);
		pane.setLayoutY(0);
		imageView.setLayoutX(0);
		imageView.setLayoutY(50);
		img1.setLayoutX(w/2-100);
		img1.setLayoutY(0);
		img2.setLayoutX(0);
		img2.setLayoutY(50);
		setImg1();
		setButton();
		buttonClicked();
		mediaPlayer.setCycleCount(10);
		mediaPlayer.setVolume(30);
		mediaPlayer.play();
		this.getChildren().addAll(pane,imageView,img1,img2);
	}
	public final void setImg1() throws Exception{
		Text setRow1=new Text("player:"+SwitchScene.player+"( BLACK )");
		setRow1.setFont(Font.font("Berlin Sans FB",30));
		img1.getChildren().add(setRow1);
	}
	Button[][] button=new Button[SIZE][SIZE];
	HBox[] row=new HBox[SIZE];
	public final void setButton() {
		for(int i=0;i<SIZE;i++) {
			row[i]=new HBox();	
			for(int j=0;j<SIZE;j++) {
				button[i][j]=new Button();
				button[i][j].setShape(new Circle(1));
				button[i][j].setPrefSize(40, 40);
				button[i][j].setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));//記得改回透明
				row[i].setPadding(new Insets(w/12-20,w/12-20,0,w/12-20));
				row[i].setSpacing(w/12-40);
				row[i].getChildren().add(button[i][j]);
		}
			img2.setSpacing(-20);
			img2.getChildren().add(row[i]);
	}
	}
	///////////按按鈕的部分/////////////////
	public final void buttonClicked() throws IOException {
		for(int i=0;i<SIZE;i++) {
			for(int j=0;j<SIZE;j++) {
				int a=i,b=j;
				button[a][b].setOnMouseClicked((MouseEvent e)->{
					mediaPlayer.setCycleCount(10);
					mediaPlayer.setVolume(30);
					mediaPlayer.play();
					if(entity.dotBlack[a][b]==1||entity.dotWhite[a][b]==1) {
						Alert alert=new Alert(AlertType.INFORMATION);
						alert.setTitle("警告");
						alert.setHeaderText("此處已有落子");
						alert.show();
						}else {
					getMusic();
					entity.setting(a,b,entity.player);	
					button[a][b].setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
					/////////換電腦下棋//////////
					if(!checkWin(a,b)) {
					entity.player=2;
					AIdect.setLevel(entity.dotWhite,entity.dotBlack);
					AIdect.checkBothSide(entity.dotWhite,entity.dotBlack);
					AIdect.finalPlace();
					new Timer().schedule(new TimerTask() {
						@Override
						public void run() {
							getMusic();
							changeColor(AIdect.rank);
							checkWin(a,b);
						}
					}, 1000);
					}
					entity.player=1;
					}
				});
			}
		}
	}
	///////////音樂的部分///////////////
	public final void getMusic() {
		File file=new File("C:\\Users\\Annie\\Music\\small_drum1.mp3");
		Media media=new Media(file.toURI().toString());
		MediaPlayer mediaPlayer=new MediaPlayer(media);
		mediaPlayer.play();
	}
	/////////////////電腦(白方)下棋使button由透明轉白////////////
	public final void changeColor(int[][] draw) {
		outer:for(int i=0;i<SIZE;i++) {
			for(int j=0;j<SIZE;j++) {
				if(draw[i][j]==1) {
				button[i][j].setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
				entity.dotWhite[i][j]=1;
				break outer;
				}
			}
		}
	}
	///////////如果贏的話的操作//////////////
	public final boolean checkWin(int row,int col)  {
		int k=0;//確認遊戲是否暫停
		int sum=0;
		for(int i=0;i<SIZE;i++) {
			for(int j=0;j<SIZE;j++) {
				sum+=entity.dotBlack[i][j];
				sum+=entity.dotWhite[i][j];
			}
		}
		if(sum==121) {
			mediaPlayer.pause();
			final Alert alert1 = new Alert(AlertType.CONFIRMATION); 
			alert1.setHeaderText("遊戲結束");
			alert1.setContentText("平手! 都很厲害呢");
			alertShow(alert1);
		}
		if(entity.check(entity.player)&&entity.player==1) {
			mediaPlayer.pause();
			final Alert alert1 = new Alert(AlertType.CONFIRMATION); 
			alert1.setContentText("恭喜"+SwitchScene.player+"獲勝");
			alert1.setHeaderText("遊戲結束");
			alertShow(alert1);
			k=1;
		}
		else if(entity.check(entity.player)&&entity.player==2) {
			mediaPlayer.pause();
			final Alert alert2 = new Alert(AlertType.CONFIRMATION); 
			alert2.setContentText("失敗也別氣餒，再試一次?");	
			alert2.setHeaderText("遊戲結束");
			alertShow(alert2);
			k=1;
		}
		if(k==1)return true;
		else return false;
	}
	public final void alertShow(Alert alert)  {
		alert.setTitle("Game Over");
		ButtonType buttonExit=new ButtonType("離開遊戲");
		ButtonType buttonRestart=new ButtonType("重新開始");
		alert.getButtonTypes().setAll(buttonRestart,buttonExit);
		final Optional<ButtonType>option=alert.showAndWait();
		if(option.get()==buttonRestart) {
			for(int i = 0; i < 11; i++) {
				for(int j = 0; j < 11; j++) {
					button[i][j].setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));	
				}
			}
			entity.start(2);//因為接下來會跳line107
		}
		else if(option.get()==buttonExit)System.exit(0);
	}
}