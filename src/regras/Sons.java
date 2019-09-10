package regras;

import java.io.File;
import java.util.Random;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;


public class Sons {
	public static MediaPlayer controlador;

	public static void tocar(String nome) {
		String dir = Arquivo.montarCaminho();
		String a= dir+"music/"+nome+".mp3";
		if (!(controlador==null)) {
		controlador.stop();
		}
		String musicFile = a;     
		Media sound = new Media(new File(musicFile).toURI().toString());
		final MediaPlayer mediaPlayer = new MediaPlayer(sound);
		 mediaPlayer.setOnEndOfMedia(new Runnable() {
		     @Override
			 public void run() {
		         mediaPlayer.seek(Duration.ZERO);
		       }
		   });
		 controlador=mediaPlayer;
		 
		 controlador.play();
	}
	public static String sorteia () {
		Random rnd = new Random();
	int i=rnd.nextInt(3);
	i=i+1;
	//System.out.println(i);
		if(i==1) {
			return "";
		}
		else {
			return ""+i;
		}
		
	}
}
