package regras;

public class Arquivo {
public static String montarCaminho() {
	String dir = System.getProperty("user.dir");
	dir = dir.replace("\\", "\\\\");
	dir=dir+"/src/rsc/";
	
	return dir;
	
}
}
