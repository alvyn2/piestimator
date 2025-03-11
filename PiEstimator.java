import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/*
 * AUthor:Julius
 * 
 * estimates pi with threads
 * 
*/
public class PiEstimator{
//the following code is just to jog your memory about how labels and buttons work!
//implement your Pi Estimator as described in the project. You may do it all in main below or you 
//may implement additional functions if you feel it necessary.

public static class PIThread extends Thread {
	int pi;
	int n;
	int c=0;
	public PIThread(int n) {
	this.n=n;
	}
	public void run() {
		for(int i=0;i<=n;i++){
		int x=(int)(Math.random());
		int y=(int)(Math.random());
		if(x*x+y*y<=1){
			c++;
		}else{
			//do nothing
		}
		}
		pi=4*c/n;
		System.out.println("PI is estimated as"+pi);
		//send(count);
		
	}


}

public static void main(String[] args) {  
	    JFrame f=new JFrame("Button Example");  
	    JButton b=new JButton("Click Here");  
	    JLabel example = new JLabel(Double.toString(Math.PI));
	    f.add(example);
	    f.add(b);  
	    f.setSize(300,300);  
	    f.setLayout(new GridLayout(4, 1));  
	    f.setVisible(true);      
	}  


    
}
