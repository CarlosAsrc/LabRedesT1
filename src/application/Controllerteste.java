package application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

import conexao.Server;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Controllerteste {
	@FXML
	private AnchorPane anchorpane;
	@FXML
	private ImageView background;
	@FXML
	private MediaView mv;
	@FXML
	private Button pular;
	public static MediaPlayer mediaplayer;
	@FXML
	void initialize() throws IOException, InterruptedException {
		
		String caminho = regras.Arquivo.montarCaminho();
		caminho = caminho + "background/login.png";
		File file = new File(caminho);
		BufferedImage bufferedImage = ImageIO.read(file);
		Image image = SwingFXUtils.toFXImage(bufferedImage, null);
		background.setImage(image);
		
		String a = regras.Arquivo.montarCaminho();
		a=a+"teste.mp4";
		
		String musicFile = a;     
		Media sound = new Media(new File(musicFile).toURI().toString());
		 MediaPlayer mp = new MediaPlayer(sound);
		mediaplayer=mp;
		mediaplayer.setAutoPlay(true);
	mv.setMediaPlayer(mp);
	
	
	}
	

	        	
	@FXML
	void onclickpular(ActionEvent event) throws IOException {
		mediaplayer.stop();
		regras.Sons.tocar("got3");
		AnchorPane pane = FXMLLoader.load(getClass().getResource("Login.fxml"));
		anchorpane.getChildren().setAll(pane);
	}
}
