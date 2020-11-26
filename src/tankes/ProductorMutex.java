//Javier Enrique Luna Díaz
package tankes; 
import java.awt.geom.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import static java.lang.Thread.sleep;

public class ProductorMutex extends Thread{
    private Y yMutex;
    private DibujaTanke panelMutex; 
    private Lock mutex;
    
    public ProductorMutex(DibujaTanke panelMutex, Y yMutex){
        this.panelMutex = panelMutex;
        this.yMutex = yMutex;
        mutex = new ReentrantLock();
    }
    public void run(){
        while(true){
            if(yMutex.getY() > 50){
                if(mutex.tryLock()){
                    mutex.lock();
                    panelMutex.aguaMutex.getAgua().add(new Rectangle2D.Double(50,yMutex.getY(), 100, 5));
                    yMutex.setY(yMutex.getY() - 5);
                    mutex.unlock();
                }
                panelMutex.repaint();
                try{
                    sleep((int) (Math.random()*1000));
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else if(yMutex.getY() <= 50){
                try{
                    sleep((int) (Math.random()*1000));
                }catch(Exception e){}
            }
        }
    }
}
