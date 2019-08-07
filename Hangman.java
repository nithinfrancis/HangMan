/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadpool;

import java.util.Scanner;
/**
 *
 * @author nithin
 */
public class Hangman 
{
   
    public String n = "" ;
    public int len;
    public static int state=0,hang=0,temp=0,w;
    public int[] ca=new int[26];
    public Hangman(String chars)
    {
        n=chars;
        w=n.length();
        len = n.length();
        for(int i=0;i<w;i++)
        {
            ca[(n.charAt(i)-'a')]++; 
        }
    }
    public void guess(char c)
    {
        
        if(state== 0)
        {
            if(c >= 'a'&& c <= 'z')
            {
                if(ca[c-'a']!=0)
                {
                    ca[c-'a']--;
                    w--;
                }
                else
                {
                    hang++;
                } 
            }
        }
        if(hang>2)
        {
            state=1;
        }
        if(w==0)
        {
            state=2;
        }     
    }
   String getstatus()
   {
       if(state==1)
       {
           return("failed");
       }
       else
       if(state==0)
       {
           return("Running");
       }
       else
       {
           return("Winn");
       }
   }
            
}
class A extends Hangman
{
    
    public A(String chars) {
        super(chars);
    }
 
    public static void main(String args[])
    {
     
             
       System.out.println("enter the string");
       
       Scanner s=new Scanner(System.in);
       String p=s.nextLine();
       
       A a1=new A(p); 
       
       System.out.println("limit");
       int g=s.nextInt();
       
       Scanner r=new Scanner(System.in);
       for(int i=0;i<g;i++)
       {
           if(w!=0 && hang<=2)
           {
           String c= r.next();
           char cc= c.charAt(0);
           a1.guess(cc);
           }
           
       }
       
       
        String c =a1.getstatus();
        System.out.println("\n\n"+c);
    
    }

}
    
