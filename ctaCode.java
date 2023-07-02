import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class Calculation {
	double ia1,marks,ia2,ia3,see,cie,cta;
	Calculation(double ia1,double ia2,double ia3,double cta,double see)
	{
		this.see=see;
		this.ia1=ia1;
		this.ia2=ia2;
		this.ia3=ia3;
		this.cta=cta;
	}
	
	public boolean CheckProb(double ia1,double ia2,double ia3,double cta,double see)
	{
		if(ia1>20|ia2>20|ia3>20|cta>10|see>100|ia1<0|ia2<0|ia3<0|cta<0|see<0)
			return false;
		return true;
	}
	
	public double cieCal()
	{
		if(ia1>ia2)
		{
			if(ia1>ia3)
			{
				if(ia2>ia3)
					cie=ia1+ia2+cta;
				else
					cie=ia1+ia3+cta;
			}
			else
			{
				if(ia2>ia1)
					cie=ia3+ia2+cta;
				else
					cie=ia3+ia1+cta;
			}
		}
		else
		{
			if(ia2>ia3)
			{
				if(ia1>ia3)
				    cie=ia2+ia1+cta;
				else
					cie=ia2+ia3+cta;
			}
			else
			{
				if(ia2>ia1)
					cie=ia3+ia2+cta;
				else
					cie=ia3+ia1+cta;
			}
		}
		return(cie);
	}
	
	public boolean detCieCheck()
	{
		if(cie<20)
			return true;
		return false;
	}
	
	public boolean detSeeCheck()
	{
		if(see==38|see==39)
			see=40;
		else if(see<38)
			return true;
		return false;
	}
	
	public double marksCal()
	{
		double seeaprx;
		if(see%1>=0.5)
			seeaprx=Math.ceil(see);
		else
			seeaprx=Math.floor(see);
		marks=cie+seeaprx/2;
		return marks;
	}
	
	public char calcGrade()
	{
		if(marks>=90)
			return 'S';
		else if(marks<=89 & marks>=80)
			return 'A';
		else if(marks<=79 & marks>=70)
			return 'B';
		else if(marks<=69 & marks>=60)
			return 'C';
		else if(marks<=59 & marks>=50)
			return 'D';
		else if(marks<=49 & marks>=40)
			return 'E';
		else 
			return 'F';
	}

}


class  Myframe extends JFrame implements ActionListener{
	private Container c;
	private JLabel label,label1,label2,label3,label4,label5,label6,label7,label8;
	private JLabel lerror,lerror1, ltotal,lgrade,errorlabel;
	private JTextField  name,usn,ia1,ia2,ia3,cta,see,sub;
	private JButton  save, close;
	
	Myframe () {
		setTitle("Student Grading System");
		setSize(700,500);
		setLocation(100,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		c=getContentPane();
		c.setLayout(null);
		
		label1= new JLabel ("Student Grading system ");
		label1.setBounds(100,20,250,20);
		c.add(label1);
		
		
	    label1= new JLabel ("Student Name : ");
		label1.setBounds(20,50,100,20);
		c.add(label1);
		
		name= new JTextField ();
		name.setBounds(120,50,200,20);
		c.add(name);
		
		label2= new JLabel ("usn: ");
		label2.setBounds(60,80,100,20);
		c.add(label2);
		
		usn= new JTextField ();
		usn.setBounds(120,80,100,20);
		c.add(usn);
		
		label3= new JLabel ("IA 1: ");
		label3.setBounds(60,110,100,20);
		c.add(label3);
		
		ia1= new JTextField ();
		ia1.setBounds(120,110,100,20);
		c.add(ia1);
		
		label4= new JLabel ("IA 2: ");
		label4.setBounds(60,140,100,20);
		c.add(label4);
		
		ia2= new JTextField ();
		ia2.setBounds(120,140,100,20);
		c.add(ia2);
		
		label5= new JLabel ("IA 3: ");
		label5.setBounds(60,170,100,20);
		c.add(label5);
		
		ia3= new JTextField ();
		ia3.setBounds(120,170,100,20);
		c.add(ia3);
		
		label6= new JLabel ("see: ");
		label6.setBounds(60,200,100,20);
		c.add(label6);
		
		see= new JTextField ();
	    see.setBounds(120,200,100,20);
		c.add(see);
		
		label7= new JLabel ("cta: ");
		
		cta= new JTextField ();
		cta.setBounds(120,230,100,20);
		c.add(cta);
		
		label7= new JLabel ("Subject: ");
		label7.setBounds(60,260,200,20);
		c.add(label7);
		
		sub= new JTextField ();
		sub.setBounds(120,260,200,20);
		c.add(sub);
		
		save= new JButton("Save");
		save.setBounds (80,290,80,20);
		c.add(save);
		
		close= new JButton("Close");
		close.setBounds (200,290,80,20);
		c.add(close);
		
				
		lerror= new JLabel ("");
		lerror.setBounds(60,350,300,20);
		c.add(lerror);
		
		ltotal= new JLabel ("Total Marks: ");
		ltotal.setBounds(60,320,300,20);
		c.add(ltotal);
		
		lgrade= new JLabel ("Grade: ");
		lgrade.setBounds(300,320,300,20);
		c.add(lgrade);
		
		save.addActionListener(this);
		close.addActionListener(this);
				
		setVisible(true);
	}
		

	
		
	public  void actionPerformed( ActionEvent e){
		System.out.println("Inaction");
	   try  {
		
		if (e.getSource() == save) {	
            String nameRead=name.getText();
			String usnRead=usn.getText();
		    String subRead=sub.getText();
			double ia1Read=Double.parseDouble(ia1.getText());
			double ia2Read=Double.parseDouble(ia2.getText());
			double ia3Read=Double.parseDouble(ia3.getText());
			double ctaRead=Double.parseDouble(cta.getText());
	        double seeRead=Double.parseDouble(see.getText());
			lerror.setText("  ");	
			ltotal.setText("Total Marks:    ");
			lgrade.setText("Grade:   ");
					
			//System.out.println(ia1Read);
			//System.out.println(ia2Read);
			//System.out.println(ia3Read);
			//System.out.println(ctaRead);
			//System.out.println(seeRead);
			
			Calculation  obj=new Calculation (ia1Read,ia2Read,ia3Read,ctaRead,seeRead);
			
			if(obj.CheckProb(ia1Read, ia2Read, ia3Read, ctaRead, seeRead)== false )
			{
					lerror.setText("pls enter marks data within the range ");	
		            return;
			} 
			
			double ciecalc=obj.cieCal();  
			System.out.println(ciecalc);
			if(obj.detCieCheck()==true)
			{
				lerror.setText("Student detained in cie for this subject");	
				return;
			}
			
			if(obj.detSeeCheck()==true)
			{
				lerror.setText("Student detained in see for this subject");	
				return;
			}
		    double marks=obj.marksCal();
			System.out.println("gdhg");
			System.out.println(String.valueOf(marks));
			ltotal.setText("Total Marks:    "+marks);
			
			char grade=obj.calcGrade();
			System.out.println(String.valueOf(grade));
			lgrade.setText("Grade:   "+grade);
			
		  }
		
		} catch (Exception e1) {
         System.out.println("Something went wrong.");
	  }
	  
			if (e.getSource() == close) {
			
			System.out.println("Thanks for usiing!!! ");
			System.exit(0);
			}
					
	}
}


class  StudentData{
	
public static void main(String args[]) {
	
	
	Myframe  frame=new Myframe();
}
}
		label7.setBounds(60,230,100,20);
		c.add(label7);
