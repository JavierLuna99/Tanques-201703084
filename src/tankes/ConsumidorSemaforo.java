//Javier Enrique Luna Díaz
package tankes;
import java.util.concurrent.Semaphore;
import static java.lang.Thread.sleep;

public class ConsumidorSemaforo extends Thread{
    private Y ySemaforo;
    private DibujaTanke panelSemaforo;
    private Semaphore s;
    
    public ConsumidorSemaforo(DibujaTanke panelSemaforo, Y ySemaforo){
        this.panelSemaforo = panelSemaforo;
        this.ySemaforo = ySemaforo;
        s = new Semaphore(1);
    }
     public void run(){
        while(true){
            if(ySemaforo.getY() < 250){
                try{
                    s.acquire();
                    panelSemaforo.aguaSemaforo.getAgua().remove(panelSemaforo.aguaSemaforo.getAgua().size()-1);
                    ySemaforo.setY(ySemaforo.getY() + 5);
                    s.release();
                } catch (InterruptedException e) { 
                    e.printStackTrace();
                }
                panelSemaforo.repaint();
                try{    
                    //sleep((int)(Math.random()*1000));
                    sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
     }
}
