package application;

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Mode.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("FiveChess");
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		File file=new File("C:\\Users\\Annie\\Downloads\\全世界最喜歡.mp3");
		Media media=new Media(file.toURI().toString());
		MediaPlayer mediaPlayer=new MediaPlayer(media);
		mediaPlayer.setCycleCount(10);
		mediaPlayer.setVolume(30);
		mediaPlayer.play();
		launch(args);
	}
}