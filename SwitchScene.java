package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;

public class SwitchScene {
	private  Scene scene;
	@FXML
	private ProgressIndicator progress;
	@FXML
	private ProgressBar progressbar;
	@FXML
	private TextField play1;
	@FXML
	private TextField play2;
	@FXML
	private TextField play;
	@FXML
	private  Button start;
	@FXML
	private  Button startMode2;
	public static  String player;
	public static  String player1;
	public static String player2;
	
	public  void switchToView(ActionEvent event) throws IOException {
		player1=play1.getText();
		player2=play2.getText();
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(new PeopleMotion(),767,1263);
		stage.setScene(scene);	
	}
	public  void switchToStart() throws IOException{
		ActionEvent event =new ActionEvent();
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("StartScene.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void SwitchToMode1(ActionEvent event) throws IOException{
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("StartMode1.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void SwitchToMode2(ActionEvent event) throws IOException {
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("StartMode2.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public  void switchToAIMotion(ActionEvent event) throws Exception {
		player=play.getText();
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(new AIMotion(),767,1263);
		stage.setScene(scene);	
	}
}