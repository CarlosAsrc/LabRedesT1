package regras;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class codigo {
public static void criaimageview() {
	
	for (int i=0;i<8;i++ ) {
		
		System.out.println("coluna"+i+".add(q_"+i+"x0);\r\n" + 
				"		coluna"+i+".add(q_"+i+"x1);\r\n" + 
				"		coluna"+i+".add(q_"+i+"x2);\r\n" + 
				"		coluna"+i+".add(q_"+i+"x3);\r\n" + 
				"		coluna"+i+".add(q_"+i+"x4);\r\n" + 
				"		coluna"+i+".add(q_"+i+"x5);\r\n" + 
				"		coluna"+i+".add(q_"+i+"x6);\r\n" + 
				"		coluna"+i+".add(q_"+i+"x7);");
		
	}
}
}
