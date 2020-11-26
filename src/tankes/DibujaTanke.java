//Javier Enrique Luna Díaz
package tankes;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class DibujaTanke extends JPanel{
    public Agua aguaMutex; 
    public Agua aguaSemaforo; 
    
    public DibujaTanke(Agua aguaMutex, Agua aguaSemaforo){
        this.aguaMutex = aguaMutex;
        this.aguaSemaforo = aguaSemaforo;
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D gMutex = (Graphics2D)g;
        Graphics2D gSemaforo = (Graphics2D)g;    
        gMutex.setColor(Color.BLACK);
        gMutex.draw(new Rectangle2D.Double(49,53,100,200));
        gMutex.setColor(Color.BLUE);
        for(int i = 0;i < aguaMutex.getAgua().size(); i++){
            gMutex.fill((Rectangle2D)aguaMutex.getAgua().get(i));
        }
        gSemaforo.setColor(Color.BLACK);
        gSemaforo.draw(new Rectangle2D.Double(199,53,100,200));
        gSemaforo.setColor(Color.BLUE);
        for(int j = 0; j < aguaSemaforo.getAgua().size(); j++){
            gSemaforo.fill((Rectangle2D)aguaSemaforo.getAgua().get(j));
        }
    }
}
