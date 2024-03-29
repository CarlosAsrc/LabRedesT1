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
            	Persistencia.readfazer();
				if (Persistencia.linhafazer()>0) {
					Acoes.lerAcao(GerenciadorTarefa.fazer.get(0));
					GerenciadorTarefa.fazer.remove(0);
					Persistencia.save("fazer");
					}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    };
    long delay = 0; //
    long period = 1000;
    timer.schedule(task, delay, period);
}

}
