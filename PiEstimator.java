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
static Double pi=0.0;
public static class PIThread extends Thread {
	Double pi=0.0;
	int n;
	double c=0.0;// c for count double so pi is a double not an int when it is calculated
	public PIThread(int n) {
	this.n=n;
	}
	public void run() {
		for(int i=0;i<=n;i++){
		double x=(Math.random());
		double y=(Math.random());
		System.out.println("x"+x);
		System.out.println("y"+y);
		double r=x*x+y*y;
		System.out.println("r"+r);
		if((r)<=1){
			c++;
		}else{
			r=0.0;
			//do nothing
		}
		}
		pi=(4*c)/n;
		System.out.println("PI is estimated as"+pi);
		send(pi);
		
	}


}


public static synchronized void send(Double piestimate){
	if(pi==0){
		pi=piestimate;
	}else{
		pi=(pi+piestimate)/2;
	}
}

public static void main(String[] args) {  
	    JFrame f=new JFrame("Button Example");  
	    JButton b=new JButton("Click Here");  
	    JLabel example = new JLabel("actual Pi"+Double.toString(Math.PI));// actual pi
		JLabel estimate = new JLabel("pi estimate:");
	    f.add(example);
		f.add(estimate);
	    f.add(b);  
	    f.setSize(300,300);  
	    f.setLayout(new GridLayout(4, 1));  
	    f.setVisible(true);
		PIThread pthread=new PIThread(200000);
		pthread.start();
		try {
			pthread.join();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getStackTrace());
		}
		estimate.setText("pi estimate:"+ pi.toString());


		System.out.println("pi: "+pi);
		
	}  


    
}
