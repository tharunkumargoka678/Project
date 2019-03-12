import java.io.*;
import java.util.*;
import java.lang.System;
class Notes
{
	FileWriter out=null;
	public void notesWriting()throws Exception
	{
                Runtime r=Runtime.getRuntime();
                Process p=null;
		Scanner sc=new Scanner(System.in);
		String str=new String();
                Thread.sleep(1000);
                System.out.println("\nEnter the name of notes");
                System.out.println("\n*******************************\n");
                str=sc.next();
		String sr="/home/gtk/Java/ProjectNotes/"+str;
		System.out.println("\nDo you want to write notes in Termina(Y/N)\n");
		String s=sc.next();
		String sx;
		if(s.equals("y")||s.equals("Y"))
		{
			String i;
			InputStreamReader in=null;
			in=new InputStreamReader(System.in);
			out=new FileWriter(sr);
			Thread.sleep(1000);
			System.out.println("\n*******************************");
			System.out.println("\nEnter Data......\n\nEnter 'q' to Quit");	
			System.out.println("\n*******************************\n");
			char c=' ';
			while(c!='q')
			{
				c=(char)in.read();
				out.write((int)c);
			}
			System.out.println("\nYour Notes created....\n\nDo you want to see it(Y/N)\n");
			i=sc.next();
			if(i.equals("y")||i.equals("Y"))
			{
				sx="leafpad "+sr;
				p=r.exec(sx);
			}
			else
			{
				return;
			}
		}
		else
		{
			System.out.println("\nOpening..... leafpad\n\nAfter completion of writing please save and close\n");
			sx="leafpad "+sr;
			p=r.exec(sx);
			
		}
		if(out!=null)
			out.close();
		return;
	}
	void notesUpdating() throws Exception
	{
		Runtime r=Runtime.getRuntime();
		Process p=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("Do you want see list of notes...!\n");
		String ch=sc.next();
		if(ch.equals("y")||ch.equals("Y"))
		{
			this.getfiles();
		}
		System.out.println("Enter the name of notes\n"); 
		String st=sc.next();
		String sr="/home/gtk/Java/ProjectNotes/"+st;
		String sx="leafpad "+sr;
		p=r.exec(sx);
	}
	void notesDeleting()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Do you want see list of notes...!\n");
                String ch=sc.next();
                if(ch.equals("y")||ch.equals("Y"))
                {
                        this.getfiles();
                }
                System.out.println("\nEnter the name of notes\n");
                String st=sc.next();
		File f=new File(st);
		f.delete();		
	}
	static void RecursivePrint(File[] arr,int index,int level)
     	{
        	if(index == arr.length)
             		return;
         	for (int i = 0; i < level; i++)
         	    	System.out.print("\t");
          
        	if(arr[index].isFile())
            		System.out.println(arr[index].getName());
        	else if(arr[index].isDirectory())
       		{
            		System.out.println("[" + arr[index].getName() + "]");
             		RecursivePrint(arr[index].listFiles(), 0, level + 1);
        	}
        	RecursivePrint(arr,++index, level);
    	}
	void getfiles()
	{
        	String maindirpath = "/home/gtk/Java/ProjectNotes/";
        	File maindir = new File(maindirpath);
        	if(maindir.exists() && maindir.isDirectory())
        	{
        	    	File arr[] = maindir.listFiles();    
        	    	System.out.println("**********************************************");
        	    	System.out.println("Files from main directory : " + maindir);
        	    	System.out.println("**********************************************");
       		    	RecursivePrint(arr,0,0);
       		}	
	}		
}
public class Project
{
	public static void main(String[] args)throws Exception
	{
		System.out.println("\n*******************************");
                System.out.println("\nWELCOME TO ELECTRONIC DIARY...!");
                System.out.println("\n*******************************");
		Thread.sleep(1000);
		System.out.println("\nHellooo...!");
		Thread.sleep(1200);
		System.out.println("\nI have only 100 Notes for you to write notes....!");
		Thread.sleep(1500);
		System.out.println("\nDo you want to upgrade the no of notes ?(Y/N)\n");
		Scanner sc=new Scanner(System.in);
		String p=sc.next();
		int count;
		if(p.equals("y")||p.equals("Y"))
		{
			System.out.println("\n********************************");
			System.out.println("\nEnter the required no of notes..\n");
			count=sc.nextInt();	
			System.out.println("\nThe main page open in 10 sec Please wait.....!");
		}
		else
		{
			count=100;
			System.out.println("\n********************************");
			System.out.println("\nThank You....\n\nThe main page open in 10 sec Please wait.....!");
		}
		int x,ch;
		Notes n1=new Notes();
		while(true)
		{
			Thread.sleep(1000);
			System.out.println("\n*******************************\n");
			System.out.println("Goo with the following options...!\n");
			System.out.println("1.Write Notes\n");
			Thread.sleep(1000);
			System.out.println("2.Delete Notes\n");
			Thread.sleep(1000);
			System.out.println("3.get files\n");
			Thread.sleep(1000);
			System.out.println("4.updating files\n");
			Thread.sleep(1000);
			System.out.println("5.Exit from Module\n");
			Thread.sleep(1000);
			System.out.println("*******************************\n");
			ch=sc.nextInt();
			Thread.sleep(1000);
			switch(ch)
			{
				case 1:
					count=count-1;
					System.out.println("\n*******************************");
					System.out.println("\nThe Remaining no of Notes:"+count);
					System.out.println("\n*******************************");
					n1.notesWriting();
				break;
				case 2:
					n1.notesDeleting();
					break;				
				case 3:
					n1.getfiles();
					break;
				case 4:
					n1.notesUpdating();
					break;
				case 5:
					System.exit(0);
				default:
					System.out.println("Choose 1/2/3/4.....!");	
			}
		}	
	}
}
