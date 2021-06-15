package application;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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


public class PeopleMotion extends Pane {
	public final static int SIZE=11;
	private Entity entity;
	private Pane pane=new Pane();
	private Image board=new Image("file:///C:\\Users\\Annie\\OneDrive\\圖片\\FiveChessGame\\board.png");
	private ImageView imageView=new ImageView(board);
	public final double h=board.getHeight();
	public final double w=board.getWidth();
	private VBox img1=new VBox();//VBox分隔上下空間，HBox分隔左右空間
	private VBox img2=new VBox();
	private HBox name1=new HBox();
	private HBox name2=new HBox();
	public PeopleMotion() throws IOException {
		entity=new Entity();
		entity.mode=1;
		entity.start(1);
		pane.setLayoutX(0);
		pane.setLayoutY(0);
		imageView.setLayoutX(0);
		imageView.setLayoutY(50);
		img1.setLayoutX(0);
		img1.setLayoutY(0);
		img2.setLayoutX(0);
		img2.setLayoutY(50);
		name1.setLayoutX(40);
		name1.setLayoutY(0);
		name2.setLayoutX(w/2+40);//長度的一半(記得改)
		name2.setLayoutY(0);
		setButton();
		setName1();
			this.getChildren().addAll(pane,imageView,img1,img2,name1,name2);
	}
	
	public void setName1() throws IOException {
		
		Text setCol1 =new Text("player1:"+SwitchScene.player1+"( BLACK )");
		Text setCol2 =new Text("player2:"+SwitchScene.player2+"( WHITE )");
		setCol1.setFont(Font.font("Berlin Sans FB",30));
		setCol2.setFont(Font.font("Berlin Sans FB",30));
		
		name1.getChildren().add(setCol1);
		name2.getChildren().add(setCol2);
	}
	Button[][] button=new Button[SIZE][SIZE];
	HBox[] row=new HBox[11];
	public void setButton() {
		for(int i=0;i<SIZE;i++) {
			row[i]=new HBox();
			for(int j=0;j<SIZE;j++) {
				int a=i,b=j;
				button[i][j]=new Button();
				button[i][j].setShape(new Circle(1));
				button[i][j].setPrefSize(40, 40);
				button[i][j].setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));;//記得改回透明
				row[i].setPadding(new Insets(w/12-20,w/12-20,0,w/12-20));
				row[i].setSpacing(w/12-40);
				row[i].getChildren().add(button[i][j]);
				button[i][j].setOnMouseClicked((MouseEvent e)->{
					if(entity.dotBlack[a][b]==1||entity.dotWhite[a][b]==1) {
						Alert alert=new Alert(AlertType.INFORMATION);
						alert.setTitle("警告");
						alert.setHeaderText("此處已有落子");
						alert.show();
						}else {
					getMusic();
					entity.setting(a,b,entity.player);	
					changeColor(a,b);	
					try {
						checkWin(a,b);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					if(entity.player==1)entity.player=2;
					else if (entity.player==2)entity.player=1;
						}
				});
			}
			img2.setSpacing(-20);
			img2.getChildren().add(row[i]);
		}
	}
	public void getMusic() {
		File file=new File("C:\\Users\\Annie\\Music\\small_drum1.mp3");
		Media media=new Media(file.toURI().toString());
		MediaPlayer mediaPlayer=new MediaPlayer(media);
		mediaPlayer.play();
		
	}
	public void changeColor(int row,int col) {
		
		if(entity.player==1) {
			button[row][col].setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
			
			}
		else if(entity.player==2) {
			button[row][col].setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
			}
	}
	public void checkWin(int row,int col) throws IOException {
		int sum=0;
		for(int i=0;i<SIZE;i++) {
			for(int j=0;j<SIZE;j++) {
				sum+=entity.dotBlack[i][j];
				sum+=entity.dotWhite[i][j];
			}
		}
		if(sum==121) {
			final Alert alert1 = new Alert(AlertType.CONFIRMATION); 
			alert1.setHeaderText("遊戲結束");
			alert1.setContentText("平手! 都很厲害呢");
			alertShow(alert1);
		}
		if(entity.check(entity.player)&&entity.player==1) {
			final Alert alert1 = new Alert(AlertType.CONFIRMATION); 
			alert1.setHeaderText("遊戲結束");
			alert1.setContentText("恭喜"+SwitchScene.player1+"獲勝");
			alertShow(alert1);
			
		}
		else if(entity.check(entity.player)&&entity.player==2) {
			final Alert alert2 = new Alert(AlertType.CONFIRMATION);
			alert2.setHeaderText("遊戲結束");
			alert2.setContentText("恭喜"+SwitchScene.player2+"獲勝");	
			alertShow(alert2);
			
		}
	}
	public void alertShow(Alert alert) throws IOException {
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
			entity.start(2);//因為接下來會接line94
		}
		if(option.get()==buttonExit)System.exit(0);
	}
}