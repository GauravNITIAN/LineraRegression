/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GAURAV KUMAR
 * I have referred this Example from http://stattrek.com/regression/regression-example.aspx?Tutorial=AP
 */
public class LinerRegression {
    
    // Define Y = MX + C (so M and C are Global Varibles)
    double M,C;
    double determinationCoefficent;
  
    public void LinearRegression(double x[],double y[])
    {
        double Xmean;
        double Ymean;
      // Calculate the Total Sum of x feature Vector as Xsum and Y Feature Vector  as Ysum
        double Xsum=0;
        double Ysum=0;
      for(int i=0;i<x.length;i++)
      {
          Xsum+=x[i];
          Ysum+=y[i];
      }
      //Coumpute Xmean and Ymean
      
      Xmean=Xsum/x.length;
      Ymean=Ysum/y.length;
      
      /* Compute (x-Xmean) for all X and (y-Ymean) for all Y 
        (x-Xmean)*(x-Xmean) for all Y and (Y-Ymean)*(y-Ymean) for all Y
         also Compute (x-Xmean)*(y-Ymean) for all x to determine the values of M(Slope) and C(Intercept)
      */
        double XMEAN[]=new double[x.length];
        double YMEAN[]=new double[y.length];
        double XMEANSQUARE[]=new double[x.length];
        double YMEANSQUARE[]=new double[y.length];
        double XYMEAN[]=new double[x.length];
        
        for(int i=0;i<x.length;i++)
        {
          XMEAN[i]=x[i]-Xmean;
          YMEAN[i]=y[i]-Ymean;
          XMEANSQUARE[i]=XMEAN[i]*XMEAN[i];
          YMEANSQUARE[i]=YMEAN[i]*YMEAN[i];
          XYMEAN[i]=XMEAN[i]*YMEAN[i];
            
        }
        //Compute the value M(Slope) And C (Intercept)
        
        Double Y=Sum(XYMEAN);
        Double X=Sum(XMEANSQUARE);
        M=Y/X;     //Slope
        C=Ymean-M*Xmean; //Intercept
      
        //Compute the Coefficent of Determination Mean how well your data fits
        double sigmaX=0;
        double sigmaY=0;
        double sigmaXY=0;
        for(int i=0;i<x.length;i++)
        {
            sigmaX+=XMEANSQUARE[i];
            sigmaY+=YMEANSQUARE[i];
            sigmaXY+=XYMEAN[i];
        }
      
        sigmaX=sigmaX/x.length;
        sigmaY=sigmaY/y.length;
        sigmaXY=sigmaXY/x.length;
        
        sigmaX=Math.sqrt(sigmaX);
        sigmaY=Math.sqrt(sigmaY);
        
        
        determinationCoefficent = sigmaXY / (sigmaX * sigmaY);
        determinationCoefficent=Math.pow(determinationCoefficent, 2);
    }
    double Sum(double ar[])
    {
        double sum=0;
        for(int i=0;i<ar.length;i++)
        {
            sum=sum+ar[i];
        }
        return sum;
        
    }
    public double Predict(double x)
    {
        double y=M*x+C;
        return y;
    }
    
    public String DeterminationCoefficent()
    {
        String percent=Double.toString(determinationCoefficent*100);
     return percent+" %";   
    }
    public static void main(String args[])
    {
        double x[]={95,85,80,70,60};
        double y[]={85,95,70,65,70};
        LinerRegression linear=new LinerRegression();
        linear.LinearRegression(x, y);
        double value=linear.Predict(80);
        System.out.println("Predicted Value is : "+value);
        System.out.println(linear.DeterminationCoefficent());
        
    }
            }
