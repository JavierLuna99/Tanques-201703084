//Javier Enrique Luna Díaz
package tankes;      
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import static java.lang.Thread.sleep;

public class ConsumidorMutex extends Thread{
    private Y yMutex;
    private DibujaTanke panelMutex;
    private Lock mutex;
    
    public ConsumidorMutex(DibujaTanke panelMutex, Y yMutex){
        this.panelMutex = panelMutex;
        this.yMutex = yMutex;
        mutex = new ReentrantLock();
    }
    
    public void run(){
        while(true){
            if(yMutex.getY() < 250){
                if(mutex.tryLock()){
                    mutex.lock();
                    panelMutex.aguaMutex.getAgua().remove(panelMutex.aguaMutex.getAgua().size() - 1);
                    yMutex.setY(yMutex.getY() + 5);
                    mutex.unlock();
                }
                panelMutex.repaint();
                try{    
                    //sleep((int)(Math.random()*1000));
                    sleep((1000));
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
