//Javier Enrique Luna Dïaz
package tankes;
import java.awt.geom.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.Semaphore;
import static java.lang.Thread.sleep;
public class ProductorSemaforo extends Thread{
    private Y ySemaforo;
    private DibujaTanke panelS; 
    private Lock mutex;
    private Semaphore sem;
    
    public ProductorSemaforo(DibujaTanke panelS, Y ySemaforo){
        this.panelS=panelS;
        this.ySemaforo = ySemaforo;
        mutex = new ReentrantLock();
        sem = new Semaphore(1);
        
    }
    public void run(){
        while(true){
            if(ySemaforo.getY() > 50){
                try 
                {
                    sem.acquire();
                    panelS.aguaSemaforo.getAgua().add(new Rectangle2D.Double(200,ySemaforo.getY(), 100, 5));
                    ySemaforo.setY(ySemaforo.getY() - 5);
                    sem.release(); 
                } catch (InterruptedException exc) { 
                    System.out.println(exc); 
                }
                panelS.repaint();
                try{
                    sleep((int)(Math.random()*1000));
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else if(ySemaforo.getY() <= 50){
                try{
                    sleep((int)(Math.random()*1000));
                }catch(Exception e){}
            }
        }
    }
}
