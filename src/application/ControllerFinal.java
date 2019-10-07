package application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import regras.Jogo;

public class ControllerFinal {
	@FXML
	private AnchorPane anchorpane;
	@FXML
	private ImageView background;

	@FXML
	private MediaView mv;
	
	public static MediaPlayer mediaplayer;
	@FXML
	void initialize() throws IOException, InterruptedException {
		
		String caminho = regras.Arquivo.montarCaminho();
		caminho = caminho + Jogo.backgroundfinal;
		File file = new File(caminho);
		BufferedImage bufferedImage = ImageIO.read(file);
		Image image = SwingFXUtils.toFXImage(bufferedImage, null);
	
		background.setImage(image);
		String a = regras.Arquivo.montarCaminho();
		a=a+Jogo.videofinal;
		
		String musicFile = a;     
		Media sound = new Media(new File(musicFile).toURI().toString());
		final MediaPlayer mp = new MediaPlayer(sound);
		mediaplayer=mp;
		mediaplayer.setAutoPlay(true);
	mv.setMediaPlayer(mp);
	}
}
