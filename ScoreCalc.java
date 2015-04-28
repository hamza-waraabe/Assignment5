/** 
 * @author haa2224
 * Name:Hamza Abshir
 * Assignment 5
 * This is a GUI program to find the weighted average of four test scores.
 */

/**
 *  Declaring these Java classes to be used in the code below.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class ScoreCalc implements ActionListener {
	final int size = 4;
/** 
 * private classes.
 */
private JFrame frame;
private JPanel panel, bpanel, rpanel;
private JTextField [] tscore = new JTextField[size];
private JTextField [] wscore = new JTextField[size];
private JLabel [] label = new JLabel[size];
private JLabel fscore;
private JButton calculate;


double [] G = new double [size];
double [] A = new double [size];
double [] Gt = new double [size];
double [] At = new double [size];
/**
 *GUI develop.
 */
         public ScoreCalc() {
	frame = new JFrame();
	frame.setVisible(true);
	frame.setSize(300, 800);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	/** 
	 * Formating & constructing the Calculation frame.
	 */
	panel = new JPanel();
	panel.setBackground(Color.red);
	panel.setLayout(new GridLayout(5,4));
	bpanel = new JPanel();
	bpanel.setBackground(Color.black);
	rpanel = new JPanel();
	rpanel.setBackground(Color.lightGray);
	label[0] = new JLabel("testscore1");
	label[1] = new JLabel("testscore2");
	label[2] = new JLabel("testscore3");
	label[3] = new JLabel("testscore4");
	
	for (int i=0; i<size; i++){
		panel.add(label[i]);
		tscore[i]=new JTextField(10);
		panel.add(tscore[i]);
		wscore[i]=new JTextField(10);
		panel.add(wscore[i]);
	}
	
	fscore = new JLabel();
	fscore.setText(".....");
	rpanel.add(fscore);
	/** 
	 * construct a CALCULATE button for the user to click.
	 */
	calculate = new JButton("Calculate");
	calculate.addActionListener(this);
	bpanel.add(calculate);
	/** 
	 * set the the frames size and latitude.
	 */
	frame.add(panel, BorderLayout.NORTH);
	frame.add(bpanel, BorderLayout.CENTER);
	frame.add(rpanel, BorderLayout.SOUTH);
	
	frame.setVisible(true);
	frame.pack();
	frame.setLocationRelativeTo(null);
}
/**
 * Set the Calculation for
 * the weighted Average.
 * 
 * 
 */
public double calculateAvgScore(double [] s, double [] w){
	double total = 0;
	for (int i=0; i<size; i++){
		total+=(s[i] * w[i]);
	}
	return total;
}
/**
 * Promote the User to Input Date(Scores) and it
 * should display the Average.
 */
public void actionPerformed(ActionEvent e){
	for (int i=0; i<size; i++){
		Gt [i] = Double.parseDouble(tscore[i].getText());
		At [i] = Double.parseDouble(wscore[i].getText());
	}
	double T = calculateAvgScore(Gt,At);

	fscore.setText(String.valueOf(T));
//	
}
}
