import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Project extends JFrame implements ActionListener
{
	JFrame f;
	static Project f1,f2,f3,f4,f5;
	JLabel head;
	JLabel body;
	JButton write,update,get,delete,exit;
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==write)
		{
			f.add(exit);
		}
		
	}
	Project()
	{
		f=new JFrame("Electronic Diary");
                head=new JLabel("ELECTRONIC DIARY");
                head.setBounds(190,0,800,50);
                body=new JLabel("Welcome to Electronic Diary.Thank you for choosing our Diary");
                body.setBounds(20,50,500,50);
                write=new JButton("Write Notes");
                write.setBounds(47,100,405,40);
                update=new JButton("Update Notes");
                update.setBounds(47,180,405,40);
                get=new JButton("Get Notes");
                get.setBounds(47,260,405,40);
                delete=new JButton("Delete Notes");
                delete.setBounds(47,340,405,40);
                exit=new JButton("Exit");
                exit.setBounds(47,420,405,40);
		f.add(head);
                f.add(body);
                f.add(write);
                f.add(update);
                f.add(get);
                f.add(delete);
		
                f.setSize(500,500);
                f.setLayout(null);
                f.setVisible(true);

	}
	public static void main(String[] args)
	{
		new Project();	
	}
}
