
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sanket badgujar
 */
//-------------------------------------------------------------------------------------------------------
public class solver {
    public static void main(String args[]){
        Scanner in0=new Scanner(System.in);
        String sub=in0.nextLine();
        //System.out.println(""+sub);
        String[][][] q=new String[10][10][3];   //for storing the sudoku numbers
        String[][][] p=new String[10][10][3];
         //will contain the solved sudoku
        try{
            Scanner in=new Scanner(System.in);
            for(int i=0;i<9;i++){
                
                String a=in.nextLine();
                for(int j=0;j<9;j++){
                    //System.out.println("error "+1);
                    //assigns the value 0 whenever needed
                    if((""+a.charAt(j)).equals(sub)){
                        q[i][j][0]=""+0;
                        //System.out.println("error "+2);
                    }else{
                        q[i][j][0]=""+a.charAt(j);
                        //System.out.println("error "+3);
                    }
                }
            }
            int m=0;
            System.out.println("");
            
            for(;true;){
                //System.out.println("error1");
                p=q;                
                q=assign(q);
                q=checksq(q);
                q=change(q);
                q=checkcol(q);
                q=change(q);
                q=checkrow(q);
                q=change(q);
                int k=complete(q);
                //System.out.println("error2");
                if(k==1)
                    break;
                if(Arrays.equals(p,q)){
                    System.out.println("This is it no more help");
                    for(int i=0;i<9;i++){
                        for(int j=0;j<9;j++){
                            System.out.print(" "+q[i][j][1]);
                        }
                        System.out.println("");
                    }
                    break;
                }
                
            }
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    System.out.print(" "+q[i][j][0]);
                }
                System.out.println("");
            }
            
        }catch(Exception e1){
            JOptionPane.showMessageDialog(null,e1.getMessage());
        }
    }
//-------------------------------------------------------------------------------------------------------    
   public static String[][][] assign(String[][][] prob){
        try{
        //System.out.println("error assign");
        //first priority is to assign value of [x][y][1] ie the possible values
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                //following if else assigns the square number of the particular matrix element
                if(i<3 && j<3)
                    prob[i][j][2]="1";
                else if(j>2 && j<6 && i<3)
                    prob[i][j][2]="2";
                else if(j>5 && j<9 && i<3)
                    prob[i][j][2]="3";
                else if(j<3 && i>2 && i<6)
                    prob[i][j][2]="4";
                else if(j>2 && j<6 && i>2 && i<6)
                    prob[i][j][2]="5";
                else if(j>5 && j<9 && i>2 && i<6)
                    prob[i][j][2]="6";
                else if(j<3 && i>5 && i<9)
                    prob[i][j][2]="7";
                else if(j>2 && j<6 && i>5 && i<9)
                    prob[i][j][2]="8";
                else if(j>5 && j<9 && i>5 && i<9)
                    prob[i][j][2]="9";
                //System.out.println("core");
                //System.out.println("error assign 2");
                 //assigns the value of possible values       
                if(prob[i][j][0].equals("0"))
                    prob[i][j][1]="123456789";
                else
                    prob[i][j][1]=prob[i][j][0];
            }
        }
        
        
     
        
        
         //remember to change the return value
         }catch(Exception e1){
            JOptionPane.showMessageDialog(null,e1.getMessage());
        }
        return prob; 
    }
//-------------------------------------------------------------------------------------------------------  
    public static String[][][] checkrow(String [][][] k){
        //System.out.println("error scheckcol");
        String c="";   
        String d="";//will contain all the values that exist in that column
        for(int a=0;a<9;a++){
            c="";
            for(int i=0;i<9;i++){          //this adds values to Sring c
                if(k[a][i][0].equals("0"))
                    ;
                else
                    c=c+k[a][i][0];
            }
            for(int b=0;b<9;b++){
                if(k[a][b][0].equals("0")){
                    d="";
                    String temp="";
                    temp=k[a][b][1];
                    d=temp;
                    for(int g=0;g<temp.length();g++){
                        for(int h=0;h<c.length();h++){
                            if((int)c.charAt(h)==(int)temp.charAt(g)){
                                for(int q=0;q<d.length();q++){
                                   if((int)d.charAt(q)==(int)c.charAt(h)){
                                        d=(d.substring(0, q)+d.substring(q+1,d.length()));
                                        break;
                                   }
                                   
                                }
                                break;
                        }
                    }
                }
                k[a][b][1]=d;
            }
            
        
            
        }
        
        }
        return k;

    } 
//-------------------------------------------------------------------------------------------------------
    public static String[][][] checkcol(String [][][] k){
       // System.out.println("checkrow");
        String c="";   
        String d="";//will contain all the values that exist in that column
        for(int a=0;a<9;a++){
            c="";
            for(int i=0;i<9;i++){          //this adds values to Sring c
                if(k[i][a][0].equals("0"))
                    ;
                else
                    c=c+k[i][a][0];
            }
            for(int b=0;b<9;b++){
                if(k[b][a][0].equals("0")){
                    d="";
                    String temp="";
                    temp=k[b][a][1];
                    d=temp;
                    for(int g=0;g<temp.length();g++){
                        for(int h=0;h<c.length();h++){
                            if((int)c.charAt(h)==(int)temp.charAt(g)){
                                for(int q=0;q<d.length();q++){
                                   if((int)d.charAt(q)==(int)c.charAt(h)){
                                        d=(d.substring(0, q)+d.substring(q+1,d.length()));
                                        break;
                                   }
                                   
                                }
                                break;
                        }
                    }
                }
                k[b][a][1]=d;
            }
            
        
            
        }
        
        }
        return k;
    
    }
//-------------------------------------------------------------------------------------------------------    
    public static String[][][] change(String [][][] a){ 
       // System.out.println("change");//this should run all the time see the changes
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(a[i][j][1].length()==1)
                    a[i][j][0]=a[i][j][1];
            }
        }
        
        return a;
    }
//-------------------------------------------------------------------------------------------------------    
    public static int complete(String [][][] a){
       // System.out.println("complete");//this should run all the time see the changes
        int ans=1;
        for(int i=0;i<9;i++){
            int p=0;
            for(int j=0;j<9;j++){
                if(a[i][j][0].equals(""+0)){
                    p=1;
                    break;
                }
            }
            if(p==1){
                ans=0;
                break;
            }
            
               
        }
                            
        return ans;
    }
    
//-------------------------------------------------------------------------------------------------------
    public static String[][][] checksq(String[][][] p){
        //System.out.println("checksqr");
        String c="";
        String d="";
         //System.out.println("error checksq 1");
           //specifies end and start point for j
        for(int k=1;k<=9;k++){
            //System.out.println("checksqr 1");
         String si="";   //specifies end and start point for i
        String sj="";   
            //System.out.println("error checksq2");
        if(k==1){
            si="02";
            sj="02";            
        }else if(k==2){
            si="02";
            sj="35";            
        }else if(k==3){
            si="02";
            sj="68";
        }else if(k==4){
            si="35";
            sj="02";
        }else if(k==5){
            si="35";
            sj="35";
        }else if(k==6){
            si="35";
            sj="68";
        }else if(k==7){
            si="68";
            sj="02";
        }else if(k==8){
            si="68";
            sj="35";
        }else if(k==9){
            si="68";
            sj="68";
        }
            //System.out.println("error checksqr 3");
           // System.out.println("checksqr 2");
           // System.out.println(""+si+" "+sj);
            //System.out.println(""+si.charAt(0)+"  "+sj.charAt(0));
            int in=Integer.parseInt(""+si.charAt(0));
            int in1=Integer.parseInt(""+si.charAt(1));
            int out=Integer.parseInt(""+sj.charAt(0));
            int out1=Integer.parseInt(""+sj.charAt(1));
            //System.out.println(""+in+","+in1+";"+out+","+out1+";");
            for(int i=in;i<=in1;i++){
 //collcetion of possible values those are available in the square box
                for(int j=out;j<=out1;j++){
                    if(p[i][j][0].equals("0"));
        //the above mentioned parameter is very important so as to avoid problems when more than one 0
                    else
                        c=c+p[i][j][0];
                }
                //System.out.println(c);
              //  System.out.println("checksqr 3");
            }
             //dupllication of 'c' in 'd' where all the changes will take place
            
            String temp="";
                    String temp1="";
            //System.out.println("checksqr 4");
            for(int i=in;i<=in1;i++){
                for(int j=out;j<=out1;j++){
                   // System.out.println("checksqr 5");
                    if(p[i][j][0].equals("0")){
                        
                        temp1=p[i][j][1];//all the possinle values
                        d=temp1;
                        for(int a=0;a<temp1.length();a++){
                           // System.out.println("checksqr 6");
                            for(int b=0;b<c.length();b++){
                               // System.out.println("checksqr 7");
                                if((int)temp1.charAt(a)==(int)c.charAt(b)){
                                   // System.out.println("checksqr 8");
                                    for(int q=0;q<d.length();q++){
                                        if((int)c.charAt(b)==((int)d.charAt(q))){
                                          //  System.out.println("checksqr 9");
                                            d=(d.substring(0,q)+d.substring(q+1,d.length()));
                                            //System.out.println(""+d);
                                            break;
                                        }
                                    }
                                break;
                                }
                                //System.out.println("checksqr 10");
                            }
                        }
                    p[i][j][1]=d;
                    }
                d="";
                    
                }   
            }
            c="";
           
        }
            
        //System.out.println("checksqr 5");
        return p;//remember to return a proper String array
    }
//-------------------------------------------------------------------------------------------------------
    public static String[][][] guess(String[][][] m){
        
        
        return m;
    }
//-------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------
    
}