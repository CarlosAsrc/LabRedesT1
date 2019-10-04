package conexao;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import application.Main;

public class Refresher {
public static void refresh() {
	Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        
        @Override
        public void run() {
        	try {
				Persistencia.readcount();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            try {
            	System.out.println("Persistencia: "+Persistencia.linhafazer());
            	System.out.println("Main: "+Main.linhasfazer);
				if (Persistencia.linhafazer()>Main.linhasfazer) {
					
					}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    };
    long delay = 0; //
    long period = 5000;
    timer.schedule(task, delay, period);
}
}
