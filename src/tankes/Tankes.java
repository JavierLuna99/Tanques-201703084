//Javier Enrique Luna Díaz
package tankes;
import javax.swing.*;
import java.awt.*;

public class Tankes extends JFrame{
    private DibujaTanke panel;    
    private Y yMutex;
    private Y ySemaforo;   
    private ProductorMutex productorMutex;
    private ProductorSemaforo productorSemaforo;
    private ConsumidorMutex consumidorMutex;
    private ConsumidorSemaforo consumidorSemaforo;   
    private Agua aguaM;
    private Agua aguaS;
        
    public Tankes(){
        setSize(400,400);  
        yMutex = new Y();
        ySemaforo = new Y();    
        aguaM = new Agua();
        aguaS = new Agua();      
        panel = new DibujaTanke(aguaM,aguaS);      
        productorMutex = new ProductorMutex(panel,yMutex);
        consumidorMutex = new ConsumidorMutex(panel,yMutex);       
        productorSemaforo = new ProductorSemaforo(panel,ySemaforo);
        consumidorSemaforo = new ConsumidorSemaforo(panel,ySemaforo);
        getContentPane().setLayout(new GridLayout());
        getContentPane().add(panel);
        productorMutex.start();
        consumidorMutex.start();
        productorSemaforo.start();
        consumidorSemaforo.start();
    }
    
    public static void main(String[] args) {
        Tankes fr = new Tankes();
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null);
    }
}
