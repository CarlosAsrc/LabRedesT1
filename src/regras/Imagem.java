package regras;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

public class Imagem {
public static Image criaimagem(String a) throws IOException {
	String caminho = regras.Arquivo.montarCaminho();
	caminho = caminho + a;
	File file = new File(caminho);
	BufferedImage bufferedImage = ImageIO.read(file);
	Image image = SwingFXUtils.toFXImage(bufferedImage, null);
	return image;
}
}
