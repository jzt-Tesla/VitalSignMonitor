package xlw.android.vitalsignmonitor;

public class FUZZYLOGIC {
	
	FUZZYLOGIC()
	{
		
	}
	
	private double HR_MF1_LOW(double x)
	{
		double y=0;
		
		if(x<=40)
		  y=1;
		else if (x>=50)
		  y=0;
		else
		  y=-0.1*x+5;
		
		return y;
	}
	
	private double HR_MF2_NORMAL(double x)
	{
		double y=0;
		
		if(x<=40)
		  y=0;
		else if (x>40&&x<50)
		  y=0.1*x-4;
		else if (x>=50&&x<=140)
		  y=1;
		else if(x>140&&x<=155)
		  y=(155-x)/15;
		else 
		  y=0;
			
		return y;
	}

	private double HR_MF3_HIGH(double x)
	{
		double y=0;
		
		if(x<=140)
		  y=0;
		else if(x>140&&x<=155)
		  y=(x-140)/15;
		else 
		  y=1;
			
		return y;
	}
	
	private double SBP_MF1_LOW(double x)
	{
		double y=0;
		
		if(x<=100)
		  y=1;
		else if (x>=105)
		  y=0;
		else
		  y=-0.2*x+21;
		
		return y;
	}
	
	private double SBP_MF2_NORMAL(double x)
	{
		double y=0;
		
		if(x<=100)
		  y=0;
		else if (x>100&&x<105)
		  y=0.2*x-20;
		else if (x>=105&&x<=140)
		  y=1;
		else if(x>140&&x<=145)
		  y=29-0.2*x;
		else 
		  y=0;
			
		return y;
	}
	
	private double SBP_MF3_HIGH(double x)
	{
		double y=0;
		
		if(x<=140)
		  y=0;
		else if(x>140&&x<=145)
		  y=0.2*x-28;
		else 
		  y=1;
			
		return y;
	}
	
	private double DBP_MF1_LOW(double x)
	{
		double y=0;
		
		if(x<=65)
		  y=1;
		else if (x>=70)
		  y=0;
		else
		  y=-0.2*x+14;
		
		return y;
	}
	
	private double DBP_MF2_NORMAL(double x)
	{
		double y=0;
		
		if(x<=65)
		  y=0;
		else if (x>65&&x<70)
		  y=0.2*x-13;
		else if (x>=70&&x<=90)
		  y=1;
		else if(x>90&&x<=95)
		  y=19-0.2*x;
		else 
		  y=0;
			
		return y;
	}
	
	private double DBP_MF3_HIGH(double x)
	{
		double y=0;
		
		if(x<=90)
		  y=0;
		else if(x>90&&x<=95)
		  y=0.2*x-18;
		else 
		  y=1;
			
		return y;
	}
	
	private double MBP_MF1_LOW(double x)
	{
		double y=0;
		
		if(x<=80)
		  y=1;
		else if (x>=82)
		  y=0;
		else
		  y=-0.5*x+41;
		
		return y;
	}
	
	private double MBP_MF2_NORMAL(double x)
	{
		double y=0;
		
		if(x<=80)
		  y=0;
		else if (x>80&&x<82)
		  y=0.5*x-40;
		else if (x>=82&&x<=107)
		  y=1;
		else if(x>107&&x<=108)
		  y=108-x;
		else 
		  y=0;
			
		return y;
	}
	
	private double MBP_MF3_HIGH(double x)
	{
		double y=0;
		
		if(x<=107)
		  y=0;
		else if(x>107&&x<=108)
		  y=x-107;
		else 
		  y=1;
			
		return y;
	}
	
	private double RR_MF1_LOW(double x)
	{
		double y=0;
		
		if(x<=8)
		  y=1;
		else if (x>=10)
		  y=0;
		else
		  y=-0.5*x+5;
		
		return y;
	}
	
	private double RR_MF2_NORMAL(double x)
	{
		double y=0;
		
		if(x<=8)
		  y=0;
		else if (x>8&&x<10)
		  y=0.5*x-4;
		else if (x>=10&&x<=30)
		  y=1;
		else if(x>30&&x<=35)
		  y=7-0.2*x;
		else 
		  y=0;
			
		return y;
	}
	
	private double RR_MF3_HIGH(double x)
	{
		double y=0;
		
		if(x<=30)
		  y=0;
		else if(x>30&&x<=35)
		  y=0.2*x-6;
		else 
		  y=1;
			
		return y;
	}
	
	private double SPO2_MF1_LOW(double x)
	{
		double y=0;
		
		if(x<=90)
		  y=1;
		else if (x>=92)
		  y=0;
		else
		  y=-0.5*x+46;
		
		return y;
	}
	
	private double SPO2_MF2_NORMAL(double x)
	{
		double y=0;
		
		if(x<=90)
		  y=0;
		else if(x>90&&x<=92)
		  y=0.5*x-45;
		else 
		  y=1;
			
		return y;
	}
	
	private double ALARM_MF1_NORMAL(double x)
	{
		double y=0;
		
		if(x<=0.45)
		  y=1;
		else if (x>=0.55)
		  y=0;
		else
		  y=-10*x+5.5;
		
		return y;
	}
	
	private double REVERSE_ALARM_MF1_NORMAL(double y)
	{
		double x=0;
		x=0.55-0.1*y;
		return x;
	}
	
	private double ALARM_MF2_ALARM(double x)
	{
		double y=0;
		
		if(x<=0.45)
		  y=0;
		else if(x>0.45&&x<=0.55)
		  y=10*x-4.5;
		else 
		  y=1;
			
		return y;
	}
	
	private double REVERSE_ALARM_MF2_ALARM(double y)
	{
		double x=0;
		x=0.45+0.1*y;
		return x;
	}
	
	private double Rectangle_Area(double x1,double x2,double y1,double y2)
	{
		double deltaX=x2-x1;
		double deltaY=y2-y1;
		
		double area=deltaX*deltaY;
		
		return area;
	}
	
	private double Trapezoidal_Area(double x1,double x2,double y1,double y2)
	{
		double h=x2-x1;
		
		double area=(y1+y2)*h/2;
		
		return area;
	}
	
	private double Rectangle_Area1(double x1,double x2,double y1,double y2)
	{
		double deltaX_square=x2*x2-x1*x1;
		
		double area=0.5*y2*deltaX_square;
		
		return area;
	}
	
	private double Trapezoidal_Area1(double x1,double x2,double y1,double y2)
	{
		//(x1,y1) (x2,y2)
		double deltaX=x2-x1;//Make sure x2 > x1
		double deltaY=y2-y1;
		double k=deltaY/deltaX;//Slope
		double deltaX_square=x2*x2-x1*x1;
		double deltaX_cubic=x2*x2*x2-x1*x1*x1;
		
		double sum1=k*deltaX_cubic/3;
		double sum2=(y1-k*x1)*deltaX_square/2;
		
		double area=sum1+sum2;
		
		return area;
	}
	
	private double max(double[] input_array,int num)
	{
		double max_value=0;
		int i=0;
		for(i=0;i<num;i++)
		{
			if(input_array[i]>max_value)
				max_value=input_array[i];
		}
		
		return max_value;
	}
	
	private double min(double[] input_array,int num)
	{
		double min_value=input_array[0];
		int i=0;
		for(i=0;i<num;i++)
		{
			if(input_array[i]<min_value)
				min_value=input_array[i];
		}
		
		return min_value;
	}
	
	double FUZZYLOGIC_RULE1_COMB1(double hr)
	{
		double[] Aalarm_array=new double[2];
		double Aalarm_max=0;
		 double alarm_result=0;
		
		//ruleList1=[1 2 1 1;2 1 1 1;3 2 1 1];
		
		//output:alarm is normal
		
		//when hr is normal,alarm is normal
		
		double out_hr_mf2=HR_MF2_NORMAL(hr);
		
		//output:alarm is alarm
		
		//when hr is low,alarm is alarm
		
		double out_hr_mf1=HR_MF1_LOW(hr);
		
		//when hr is high,alarm is alarm
		
		double out_hr_mf3=HR_MF3_HIGH(hr);
		
		Aalarm_array[0]=out_hr_mf1;
		Aalarm_array[1]=out_hr_mf3;
		Aalarm_max=max(Aalarm_array,2);
		
		//3 cases below,according to out_hr_mf2 ">" "<" "=" Aalarm_max
		
		if(out_hr_mf2<Aalarm_max)
		{
			//We want to get key point of the trapezoidal
			double Xmax=REVERSE_ALARM_MF2_ALARM(Aalarm_max);
		    double Xmin=REVERSE_ALARM_MF2_ALARM(out_hr_mf2);
		    
		    //calculate 3 areas
		    
		    double LeftRectangularArea=Rectangle_Area(0,Xmin,0,out_hr_mf2);
		    double TrapezoidalArea=Trapezoidal_Area(Xmin,Xmax,out_hr_mf2,Aalarm_max);
		    double RightRectangularArea=Rectangle_Area(Xmax,1,0,Aalarm_max);
		    
		    double LeftRectangularArea1=Rectangle_Area1(0,Xmin,0,out_hr_mf2);
		    double TrapezoidalArea1=Trapezoidal_Area1(Xmin,Xmax,out_hr_mf2,Aalarm_max);
		    double RightRectangularArea1=Rectangle_Area1(Xmax,1,0,Aalarm_max);
		    
		    //get centroid value
		    alarm_result=(LeftRectangularArea1+TrapezoidalArea1+RightRectangularArea1)/(LeftRectangularArea+TrapezoidalArea+RightRectangularArea);
		 }
		
		if(out_hr_mf2>Aalarm_max)
		{
			//We want to get key point of the trapezoidal
			double Xmax=REVERSE_ALARM_MF1_NORMAL(Aalarm_max);
		    double Xmin=REVERSE_ALARM_MF1_NORMAL(out_hr_mf2);
		    
		    //calculate 3 areas
		    
		    double LeftRectangularArea=Rectangle_Area(0,Xmin,0,out_hr_mf2);
		    double TrapezoidalArea=Trapezoidal_Area(Xmin,Xmax,out_hr_mf2,Aalarm_max);
		    double RightRectangularArea=Rectangle_Area(Xmax,1,0,Aalarm_max);
		    
		    double LeftRectangularArea1=Rectangle_Area1(0,Xmin,0,out_hr_mf2);
		    double TrapezoidalArea1=Trapezoidal_Area1(Xmin,Xmax,out_hr_mf2,Aalarm_max);
		    double RightRectangularArea1=Rectangle_Area1(Xmax,1,0,Aalarm_max);
		    
		    //get centroid value
		    alarm_result=(LeftRectangularArea1+TrapezoidalArea1+RightRectangularArea1)/(LeftRectangularArea+TrapezoidalArea+RightRectangularArea);
		 }
		
		if(out_hr_mf2==Aalarm_max)//Both of the two value are 50%;The whole shape is a rectangle 
		{
			double RectangularArea=Rectangle_Area(0,1,0,out_hr_mf2);
			double RectangularArea1=Rectangle_Area1(0,1,0,out_hr_mf2);
			alarm_result=RectangularArea1/RectangularArea;
			
		}
		
		return alarm_result;		
		
	}
	
	double FUZZYLOGIC_RULE2_COMB2(double hr,double sbp)
	{
		
		//  ruleList2=[1 1 2 1 1;
		//             2 1 1 1 1;
		//             3 1 2 1 1;
		//             1 2 1 1 1;
		//             2 2 1 1 1;
		//             3 2 1 1 1;
		//             1 3 2 1 1;
		//             2 3 1 1 1;
		//             3 3 2 1 1];
		double[] AInput_array=new double[2];
		double[] Anormal_array=new double[5];
		double[] Aalarm_array=new double[4];
		double alarm_result=0;
		
		
		double out_hr_mf1=HR_MF1_LOW(hr);
		double out_hr_mf2=HR_MF2_NORMAL(hr);
		double out_hr_mf3=HR_MF3_HIGH(hr);
		double out_sbp_mf1=SBP_MF1_LOW(sbp);
		double out_sbp_mf2=SBP_MF2_NORMAL(sbp);
		double out_sbp_mf3=SBP_MF3_HIGH(sbp);
		//For alarm_normal set
		
		//1: 2 1 1
		AInput_array[0]=out_hr_mf2;
		AInput_array[1]=out_sbp_mf1;
		double alarmNormalValue1=min(AInput_array,2);
		Anormal_array[0]=alarmNormalValue1;
		
		//2:1 2 1
		AInput_array[0]=out_hr_mf1;
		AInput_array[1]=out_sbp_mf2;
		double alarmNormalValue2=min(AInput_array,2);
		Anormal_array[1]=alarmNormalValue2;
		
		//3:2 2 1
		AInput_array[0]=out_hr_mf2;
		AInput_array[1]=out_sbp_mf2;
		double alarmNormalValue3=min(AInput_array,2);
		Anormal_array[2]=alarmNormalValue3;
		
		//4:3 2 1
		AInput_array[0]=out_hr_mf3;
		AInput_array[1]=out_sbp_mf2;
		double alarmNormalValue4=min(AInput_array,2);
		Anormal_array[3]=alarmNormalValue4;
		
		//5:2 3 1
		AInput_array[0]=out_hr_mf2;
		AInput_array[1]=out_sbp_mf3;
		double alarmNormalValue5=min(AInput_array,2);
		Anormal_array[4]=alarmNormalValue5;
		
		//For alarm_alarm set
		
		//1: 1 1 2
		AInput_array[0]=out_hr_mf1;
		AInput_array[1]=out_sbp_mf1;
		double alarmAlarmValue1=min(AInput_array,2);
		Aalarm_array[0]=alarmAlarmValue1;
				
		//2:3 1 2
		AInput_array[0]=out_hr_mf3;
		AInput_array[1]=out_sbp_mf1;
		double alarmAlarmValue2=min(AInput_array,2);
		Aalarm_array[1]=alarmAlarmValue2;
				
		//2:1 3 2
		AInput_array[0]=out_hr_mf1;
		AInput_array[1]=out_sbp_mf3;
		double alarmAlarmValue3=min(AInput_array,2);
		Aalarm_array[2]=alarmAlarmValue3;
				
		//2:3 3 2
		AInput_array[0]=out_hr_mf3;
		AInput_array[1]=out_sbp_mf3;
		double alarmAlarmValue4=min(AInput_array,2);
		Aalarm_array[3]=alarmAlarmValue4;	
		
		double Anormal_max=max(Anormal_array,5);
		double Aalarm_max=max(Aalarm_array,4);
		
		//3 cases below,according to out_hr_mf2 ">" "<" "=" Aalarm_max
		
		if(Anormal_max<Aalarm_max)
		{
			//We want to get key point of the trapezoidal
			double Xmax=REVERSE_ALARM_MF2_ALARM(Aalarm_max);
		    double Xmin=REVERSE_ALARM_MF2_ALARM(Anormal_max);
				    
		   //calculate 3 areas
				    
		   double LeftRectangularArea=Rectangle_Area(0,Xmin,0,Anormal_max);
		   double TrapezoidalArea=Trapezoidal_Area(Xmin,Xmax,Anormal_max,Aalarm_max);
		   double RightRectangularArea=Rectangle_Area(Xmax,1,0,Aalarm_max);
				    
		   double LeftRectangularArea1=Rectangle_Area1(0,Xmin,0,Anormal_max);
		   double TrapezoidalArea1=Trapezoidal_Area1(Xmin,Xmax,Anormal_max,Aalarm_max);
		   double RightRectangularArea1=Rectangle_Area1(Xmax,1,0,Aalarm_max);
				    
		   //get centroid value
		   alarm_result=(LeftRectangularArea1+TrapezoidalArea1+RightRectangularArea1)/(LeftRectangularArea+TrapezoidalArea+RightRectangularArea);
		}
				
		if(Anormal_max>Aalarm_max)
		{
			//We want to get key point of the trapezoidal
			double Xmax=REVERSE_ALARM_MF1_NORMAL(Aalarm_max);
		    double Xmin=REVERSE_ALARM_MF1_NORMAL(Anormal_max);
				    
		   //calculate 3 areas
				    
		   double LeftRectangularArea=Rectangle_Area(0,Xmin,0,Anormal_max);
		   double TrapezoidalArea=Trapezoidal_Area(Xmin,Xmax,Anormal_max,Aalarm_max);
		   double RightRectangularArea=Rectangle_Area(Xmax,1,0,Aalarm_max);
				    
		   double LeftRectangularArea1=Rectangle_Area1(0,Xmin,0,Anormal_max);
		   double TrapezoidalArea1=Trapezoidal_Area1(Xmin,Xmax,Anormal_max,Aalarm_max);
		   double RightRectangularArea1=Rectangle_Area1(Xmax,1,0,Aalarm_max);
				    
			//get centroid value
		   alarm_result=(LeftRectangularArea1+TrapezoidalArea1+RightRectangularArea1)/(LeftRectangularArea+TrapezoidalArea+RightRectangularArea);
		}
				
		if(Anormal_max==Aalarm_max)//Both of the two value are 50%;The whole shape is a rectangle 
		{
			double RectangularArea=Rectangle_Area(0,1,0,Anormal_max);
			double RectangularArea1=Rectangle_Area1(0,1,0,Anormal_max);
			alarm_result=RectangularArea1/RectangularArea;
					
		}
				
			return alarm_result;	
	
	
	}
	
	
	double FUZZYLOGIC_RULE6_COMB9(double hr,double mbp,double rr,double spo2)
	{
		//ruleList6=  [1 1 1 1 2 1 1;   1
		      //       2 1 1 1 1 1 1; 1
		      //       3 1 1 1 2 1 1;   2
		      //       1 2 1 1 2 1 1;   3
		      //       2 2 1 1 1 1 1; 2
              //       3 2 1 1 2 1 1;   4
              //       1 3 1 1 2 1 1;   5
              //       2 3 1 1 1 1 1; 3
              //       3 3 1 1 2 1 1;   6
              //       1 1 2 1 2 1 1;   7
              //       2 1 2 1 1 1 1; 4
              //       3 1 2 1 2 1 1;   8
              //       1 2 2 1 1 1 1; 5
              //       2 2 2 1 1 1 1; 6
              //       3 2 2 1 1 1 1; 7
              //       1 3 2 1 2 1 1;   9
              //       2 3 2 1 1 1 1; 8
              //       3 3 2 1 2 1 1;   10
              //       1 1 3 1 2 1 1;   11
              //       2 1 3 1 1 1 1; 9
              //       3 1 3 1 2 1 1;   12
              //       1 2 3 1 2 1 1;   13
              //       2 2 3 1 1 1 1; 10
              //       3 2 3 1 2 1 1;   14
              //       1 3 3 1 2 1 1;   15
              //       2 3 3 1 1 1 1; 11
              //       3 3 3 1 2 1 1;   16
              //       1 1 1 2 2 1 1;   17
              //       2 1 1 2 1 1 1; 12
              //       3 1 1 2 2 1 1;   18
              //       1 2 1 2 1 1 1; 13
              //       2 2 1 2 1 1 1; 14
              //       3 2 1 2 1 1 1; 15
              //       1 3 1 2 2 1 1;   19
              //       2 3 1 2 1 1 1; 16
              //       3 3 1 2 2 1 1;   20
              //       1 1 2 2 1 1 1; 17
              //       2 1 2 2 1 1 1; 18
              //       3 1 2 2 1 1 1; 19
              //       1 2 2 2 1 1 1; 20
              //       2 2 2 2 1 1 1; 21
              //       3 2 2 2 1 1 1; 22
              //       1 3 2 2 1 1 1; 23
              //       2 3 2 2 1 1 1; 24
              //       3 3 2 2 1 1 1; 25
              //       1 1 3 2 2 1 1;   21
              //       2 1 3 2 1 1 1; 26
              //       3 1 3 2 2 1 1;   22
              //       1 2 3 2 1 1 1; 27
              //       2 2 3 2 1 1 1; 28
              //       3 2 3 2 1 1 1; 29
              //       1 3 3 2 2 1 1;   23
              //       2 3 3 2 1 1 1; 30
              //       3 3 3 2 2 1 1];  24 
		
		double[] AInput_array=new double[4];
		double[] Anormal_array=new double[30];
		double[] Aalarm_array=new double[24];
		double alarm_result=0;
		
		
		double out_hr_mf1=HR_MF1_LOW(hr);
		double out_hr_mf2=HR_MF2_NORMAL(hr);
		double out_hr_mf3=HR_MF3_HIGH(hr);
		
		double out_mbp_mf1=MBP_MF1_LOW(mbp);
		double out_mbp_mf2=MBP_MF2_NORMAL(mbp);
		double out_mbp_mf3=MBP_MF3_HIGH(mbp);
		
		double out_rr_mf1=RR_MF1_LOW(rr);
		double out_rr_mf2=RR_MF2_NORMAL(rr);
		double out_rr_mf3=RR_MF3_HIGH(rr);
		
		double out_spo2_mf1=SPO2_MF1_LOW(spo2);
		double out_spo2_mf2=SPO2_MF2_NORMAL(spo2);
		
		//for Alarm normal set
		
		//1. 2 1 1 1 1
		AInput_array[0]=out_hr_mf2;
		AInput_array[1]=out_mbp_mf1;
		AInput_array[2]=out_rr_mf1;
		AInput_array[3]=out_spo2_mf1;
		double alarmNormalValue1=min(AInput_array,4);
		Anormal_array[0]=alarmNormalValue1;
		
		//2. 2 2 1 1 1
		AInput_array[0]=out_hr_mf2;
		AInput_array[1]=out_mbp_mf2;
		AInput_array[2]=out_rr_mf1;
		AInput_array[3]=out_spo2_mf1;
		double alarmNormalValue2=min(AInput_array,4);
		Anormal_array[1]=alarmNormalValue2;
		
		//3. 2 3 1 1 1		
		AInput_array[0]=out_hr_mf2;
		AInput_array[1]=out_mbp_mf3;
		AInput_array[2]=out_rr_mf1;
		AInput_array[3]=out_spo2_mf1;
		double alarmNormalValue3=min(AInput_array,4);
		Anormal_array[2]=alarmNormalValue3;

		//4. 2 1 2 1 1
		AInput_array[0]=out_hr_mf2;
		AInput_array[1]=out_mbp_mf1;
		AInput_array[2]=out_rr_mf2;
		AInput_array[3]=out_spo2_mf1;
		double alarmNormalValue4=min(AInput_array,4);
		Anormal_array[3]=alarmNormalValue4;
		
		//5. 1 2 2 1 1
		AInput_array[0]=out_hr_mf1;
		AInput_array[1]=out_mbp_mf2;
		AInput_array[2]=out_rr_mf2;
		AInput_array[3]=out_spo2_mf1;
		double alarmNormalValue5=min(AInput_array,4);
		Anormal_array[4]=alarmNormalValue5;
		
		//6. 2 2 2 1 1
		AInput_array[0]=out_hr_mf2;
		AInput_array[1]=out_mbp_mf2;
		AInput_array[2]=out_rr_mf2;
		AInput_array[3]=out_spo2_mf1;
		double alarmNormalValue6=min(AInput_array,4);
		Anormal_array[5]=alarmNormalValue6;
		
		//7. 3 2 2 1 1
		AInput_array[0]=out_hr_mf3;
		AInput_array[1]=out_mbp_mf2;
		AInput_array[2]=out_rr_mf2;
		AInput_array[3]=out_spo2_mf1;
		double alarmNormalValue7=min(AInput_array,4);
		Anormal_array[6]=alarmNormalValue7;
		
		//8. 2 3 2 1 1
		AInput_array[0]=out_hr_mf2;
		AInput_array[1]=out_mbp_mf3;
		AInput_array[2]=out_rr_mf2;
		AInput_array[3]=out_spo2_mf1;
		double alarmNormalValue8=min(AInput_array,4);
		Anormal_array[7]=alarmNormalValue8;
		
		//9. 2 1 3 1 1
		AInput_array[0]=out_hr_mf2;
		AInput_array[1]=out_mbp_mf1;
		AInput_array[2]=out_rr_mf3;
		AInput_array[3]=out_spo2_mf1;
		double alarmNormalValue9=min(AInput_array,4);
		Anormal_array[8]=alarmNormalValue9;
		
		//10. 2 2 3 1 1
		AInput_array[0]=out_hr_mf2;
		AInput_array[1]=out_mbp_mf2;
		AInput_array[2]=out_rr_mf3;
		AInput_array[3]=out_spo2_mf1;
		double alarmNormalValue10=min(AInput_array,4);
		Anormal_array[9]=alarmNormalValue10;
		
		//11. 2 3 3 1 1
		AInput_array[0]=out_hr_mf2;
		AInput_array[1]=out_mbp_mf3;
		AInput_array[2]=out_rr_mf3;
		AInput_array[3]=out_spo2_mf1;
		double alarmNormalValue11=min(AInput_array,4);
		Anormal_array[10]=alarmNormalValue11;
		
		//12. 2 1 1 2 1
		AInput_array[0]=out_hr_mf2;
		AInput_array[1]=out_mbp_mf1;
		AInput_array[2]=out_rr_mf1;
		AInput_array[3]=out_spo2_mf2;
		double alarmNormalValue12=min(AInput_array,4);
		Anormal_array[11]=alarmNormalValue12;
		
		//13. 1 2 1 2 1
		AInput_array[0]=out_hr_mf1;
		AInput_array[1]=out_mbp_mf2;
		AInput_array[2]=out_rr_mf1;
		AInput_array[3]=out_spo2_mf2;
		double alarmNormalValue13=min(AInput_array,4);
		Anormal_array[12]=alarmNormalValue13;
		
		//14. 2 2 1 2 1
		AInput_array[0]=out_hr_mf2;
		AInput_array[1]=out_mbp_mf2;
		AInput_array[2]=out_rr_mf1;
		AInput_array[3]=out_spo2_mf2;
		double alarmNormalValue14=min(AInput_array,4);
		Anormal_array[13]=alarmNormalValue14;
		
		//15. 3 2 1 2 1
		AInput_array[0]=out_hr_mf3;
		AInput_array[1]=out_mbp_mf2;
		AInput_array[2]=out_rr_mf1;
		AInput_array[3]=out_spo2_mf2;
		double alarmNormalValue15=min(AInput_array,4);
		Anormal_array[14]=alarmNormalValue15;
		
		//16. 2 3 1 2 1
		AInput_array[0]=out_hr_mf2;
		AInput_array[1]=out_mbp_mf3;
		AInput_array[2]=out_rr_mf1;
		AInput_array[3]=out_spo2_mf2;
		double alarmNormalValue16=min(AInput_array,4);
		Anormal_array[15]=alarmNormalValue16;
		
		//17. 1 1 2 2 1
		AInput_array[0]=out_hr_mf1;
		AInput_array[1]=out_mbp_mf1;
		AInput_array[2]=out_rr_mf2;
		AInput_array[3]=out_spo2_mf2;
		double alarmNormalValue17=min(AInput_array,4);
		Anormal_array[16]=alarmNormalValue17;
		
		//18. 2 1 2 2 1
		AInput_array[0]=out_hr_mf2;
		AInput_array[1]=out_mbp_mf1;
		AInput_array[2]=out_rr_mf2;
		AInput_array[3]=out_spo2_mf2;
		double alarmNormalValue18=min(AInput_array,4);
		Anormal_array[17]=alarmNormalValue18;
		
		//19. 3 1 2 2 1
		AInput_array[0]=out_hr_mf3;
		AInput_array[1]=out_mbp_mf1;
		AInput_array[2]=out_rr_mf2;
		AInput_array[3]=out_spo2_mf2;
		double alarmNormalValue19=min(AInput_array,4);
		Anormal_array[18]=alarmNormalValue19;
		
		//20.1 2 2 2 1
		AInput_array[0]=out_hr_mf1;
		AInput_array[1]=out_mbp_mf2;
		AInput_array[2]=out_rr_mf2;
		AInput_array[3]=out_spo2_mf2;
		double alarmNormalValue20=min(AInput_array,4);
		Anormal_array[19]=alarmNormalValue20;
		
		//21. 2 2 2 2 1
		AInput_array[0]=out_hr_mf2;
		AInput_array[1]=out_mbp_mf2;
		AInput_array[2]=out_rr_mf2;
		AInput_array[3]=out_spo2_mf2;
		double alarmNormalValue21=min(AInput_array,4);
		Anormal_array[20]=alarmNormalValue21;
		
		//22. 3 2 2 2 1
		AInput_array[0]=out_hr_mf3;
		AInput_array[1]=out_mbp_mf2;
		AInput_array[2]=out_rr_mf2;
		AInput_array[3]=out_spo2_mf2;
		double alarmNormalValue22=min(AInput_array,4);
		Anormal_array[21]=alarmNormalValue22;
		
		//23. 1 3 2 2 1
		AInput_array[0]=out_hr_mf1;
		AInput_array[1]=out_mbp_mf3;
		AInput_array[2]=out_rr_mf2;
		AInput_array[3]=out_spo2_mf2;
		double alarmNormalValue23=min(AInput_array,4);
		Anormal_array[22]=alarmNormalValue23;
		
		//24. 2 3 2 2 1
		AInput_array[0]=out_hr_mf2;
		AInput_array[1]=out_mbp_mf3;
		AInput_array[2]=out_rr_mf2;
		AInput_array[3]=out_spo2_mf2;
		double alarmNormalValue24=min(AInput_array,4);
		Anormal_array[23]=alarmNormalValue24;
		
		//25. 3 3 2 2 1
		AInput_array[0]=out_hr_mf3;
		AInput_array[1]=out_mbp_mf3;
		AInput_array[2]=out_rr_mf2;
		AInput_array[3]=out_spo2_mf2;
		double alarmNormalValue25=min(AInput_array,4);
		Anormal_array[24]=alarmNormalValue25;
		
		//26. 2 1 3 2 1
		AInput_array[0]=out_hr_mf2;
		AInput_array[1]=out_mbp_mf1;
		AInput_array[2]=out_rr_mf3;
		AInput_array[3]=out_spo2_mf2;
		double alarmNormalValue26=min(AInput_array,4);
		Anormal_array[25]=alarmNormalValue26;
		
		//27. 1 2 3 2 1
		AInput_array[0]=out_hr_mf1;
		AInput_array[1]=out_mbp_mf2;
		AInput_array[2]=out_rr_mf3;
		AInput_array[3]=out_spo2_mf2;
		double alarmNormalValue27=min(AInput_array,4);
		Anormal_array[26]=alarmNormalValue27;
		
		//28. 2 2 3 2 1
		AInput_array[0]=out_hr_mf2;
		AInput_array[1]=out_mbp_mf2;
		AInput_array[2]=out_rr_mf3;
		AInput_array[3]=out_spo2_mf2;
		double alarmNormalValue28=min(AInput_array,4);
		Anormal_array[27]=alarmNormalValue28;
		
		//29. 3 2 3 2 1
		AInput_array[0]=out_hr_mf3;
		AInput_array[1]=out_mbp_mf2;
		AInput_array[2]=out_rr_mf3;
		AInput_array[3]=out_spo2_mf2;
		double alarmNormalValue29=min(AInput_array,4);
		Anormal_array[28]=alarmNormalValue29;
		
		//30. 2 3 3 2 1
		AInput_array[0]=out_hr_mf2;
		AInput_array[1]=out_mbp_mf3;
		AInput_array[2]=out_rr_mf3;
		AInput_array[3]=out_spo2_mf2;
		double alarmNormalValue30=min(AInput_array,4);
		Anormal_array[29]=alarmNormalValue30;
		
		//for alarm alarm set:
		//1. 1 1 1 1 2
		AInput_array[0]=out_hr_mf1;
		AInput_array[1]=out_mbp_mf1;
		AInput_array[2]=out_rr_mf1;
		AInput_array[3]=out_spo2_mf1;
		double alarmAlarmValue1=min(AInput_array,4);
		Aalarm_array[0]=alarmAlarmValue1;
		
		//2. 3 1 1 1 2
		AInput_array[0]=out_hr_mf3;
		AInput_array[1]=out_mbp_mf1;
		AInput_array[2]=out_rr_mf1;
		AInput_array[3]=out_spo2_mf1;
		double alarmAlarmValue2=min(AInput_array,4);
		Aalarm_array[1]=alarmAlarmValue2;
		
		//3. 1 2 1 1 2
		AInput_array[0]=out_hr_mf1;
		AInput_array[1]=out_mbp_mf2;
		AInput_array[2]=out_rr_mf1;
		AInput_array[3]=out_spo2_mf1;
		double alarmAlarmValue3=min(AInput_array,4);
		Aalarm_array[2]=alarmAlarmValue3;
		
		//4. 3 2 1 1 2
		AInput_array[0]=out_hr_mf3;
		AInput_array[1]=out_mbp_mf2;
		AInput_array[2]=out_rr_mf1;
		AInput_array[3]=out_spo2_mf1;
		double alarmAlarmValue4=min(AInput_array,4);
		Aalarm_array[3]=alarmAlarmValue4;
		
		//5. 1 3 1 1 2
		AInput_array[0]=out_hr_mf1;
		AInput_array[1]=out_mbp_mf3;
		AInput_array[2]=out_rr_mf1;
		AInput_array[3]=out_spo2_mf1;
		double alarmAlarmValue5=min(AInput_array,4);
		Aalarm_array[4]=alarmAlarmValue5;
		
		//6. 3 3 1 1 2
		AInput_array[0]=out_hr_mf3;
		AInput_array[1]=out_mbp_mf3;
		AInput_array[2]=out_rr_mf1;
		AInput_array[3]=out_spo2_mf1;
		double alarmAlarmValue6=min(AInput_array,4);
		Aalarm_array[5]=alarmAlarmValue6;
		
		//7. 1 1 2 1 2
		AInput_array[0]=out_hr_mf1;
		AInput_array[1]=out_mbp_mf1;
		AInput_array[2]=out_rr_mf2;
		AInput_array[3]=out_spo2_mf1;
		double alarmAlarmValue7=min(AInput_array,4);
		Aalarm_array[6]=alarmAlarmValue7;
		
		//8. 3 1 2 1 2
		AInput_array[0]=out_hr_mf3;
		AInput_array[1]=out_mbp_mf1;
		AInput_array[2]=out_rr_mf2;
		AInput_array[3]=out_spo2_mf1;
		double alarmAlarmValue8=min(AInput_array,4);
		Aalarm_array[7]=alarmAlarmValue8;
		
		//9. 1 3 2 1 2
		AInput_array[0]=out_hr_mf1;
		AInput_array[1]=out_mbp_mf3;
		AInput_array[2]=out_rr_mf2;
		AInput_array[3]=out_spo2_mf1;
		double alarmAlarmValue9=min(AInput_array,4);
		Aalarm_array[8]=alarmAlarmValue9;
		
		//10. 3 3 2 1 2
		AInput_array[0]=out_hr_mf3;
		AInput_array[1]=out_mbp_mf3;
		AInput_array[2]=out_rr_mf2;
		AInput_array[3]=out_spo2_mf1;
		double alarmAlarmValue10=min(AInput_array,4);
		Aalarm_array[9]=alarmAlarmValue10;
		
		//11. 1 1 3 1 2
		AInput_array[0]=out_hr_mf1;
		AInput_array[1]=out_mbp_mf1;
		AInput_array[2]=out_rr_mf3;
		AInput_array[3]=out_spo2_mf1;
		double alarmAlarmValue11=min(AInput_array,4);
		Aalarm_array[10]=alarmAlarmValue11;
		
		//12. 3 1 3 1 2
		AInput_array[0]=out_hr_mf3;
		AInput_array[1]=out_mbp_mf1;
		AInput_array[2]=out_rr_mf3;
		AInput_array[3]=out_spo2_mf1;
		double alarmAlarmValue12=min(AInput_array,4);
		Aalarm_array[11]=alarmAlarmValue12;
		
		//13. 1 2 3 1 2
		AInput_array[0]=out_hr_mf1;
		AInput_array[1]=out_mbp_mf2;
		AInput_array[2]=out_rr_mf3;
		AInput_array[3]=out_spo2_mf1;
		double alarmAlarmValue13=min(AInput_array,4);
		Aalarm_array[12]=alarmAlarmValue13;
		
		//14. 3 2 3 1 2
		AInput_array[0]=out_hr_mf3;
		AInput_array[1]=out_mbp_mf2;
		AInput_array[2]=out_rr_mf3;
		AInput_array[3]=out_spo2_mf1;
		double alarmAlarmValue14=min(AInput_array,4);
		Aalarm_array[13]=alarmAlarmValue14;
		
		//15. 1 3 3 1 2
		AInput_array[0]=out_hr_mf1;
		AInput_array[1]=out_mbp_mf3;
		AInput_array[2]=out_rr_mf3;
		AInput_array[3]=out_spo2_mf1;
		double alarmAlarmValue15=min(AInput_array,4);
		Aalarm_array[14]=alarmAlarmValue15;
		
		//16. 3 3 3 1 2
		AInput_array[0]=out_hr_mf3;
		AInput_array[1]=out_mbp_mf3;
		AInput_array[2]=out_rr_mf3;
		AInput_array[3]=out_spo2_mf1;
		double alarmAlarmValue16=min(AInput_array,4);
		Aalarm_array[15]=alarmAlarmValue16;
		
		//17. 1 1 1 2 2
		AInput_array[0]=out_hr_mf1;
		AInput_array[1]=out_mbp_mf1;
		AInput_array[2]=out_rr_mf1;
		AInput_array[3]=out_spo2_mf2;
		double alarmAlarmValue17=min(AInput_array,4);
		Aalarm_array[16]=alarmAlarmValue17;
		
		//18. 3 1 1 2 2
		AInput_array[0]=out_hr_mf3;
		AInput_array[1]=out_mbp_mf1;
		AInput_array[2]=out_rr_mf1;
		AInput_array[3]=out_spo2_mf2;
		double alarmAlarmValue18=min(AInput_array,4);
		Aalarm_array[17]=alarmAlarmValue18;
		
		//19. 1 3 1 2 2
		AInput_array[0]=out_hr_mf1;
		AInput_array[1]=out_mbp_mf3;
		AInput_array[2]=out_rr_mf1;
		AInput_array[3]=out_spo2_mf2;
		double alarmAlarmValue19=min(AInput_array,4);
		Aalarm_array[18]=alarmAlarmValue19;
		
		//20. 3 3 1 2 2
		AInput_array[0]=out_hr_mf3;
		AInput_array[1]=out_mbp_mf3;
		AInput_array[2]=out_rr_mf1;
		AInput_array[3]=out_spo2_mf2;
		double alarmAlarmValue20=min(AInput_array,4);
		Aalarm_array[19]=alarmAlarmValue20;
		
		//21. 1 1 3 2 2
		AInput_array[0]=out_hr_mf1;
		AInput_array[1]=out_mbp_mf1;
		AInput_array[2]=out_rr_mf3;
		AInput_array[3]=out_spo2_mf2;
		double alarmAlarmValue21=min(AInput_array,4);
		Aalarm_array[20]=alarmAlarmValue21;
		
		//22. 3 1 3 2 2
		AInput_array[0]=out_hr_mf3;
		AInput_array[1]=out_mbp_mf1;
		AInput_array[2]=out_rr_mf3;
		AInput_array[3]=out_spo2_mf2;
		double alarmAlarmValue22=min(AInput_array,4);
		Aalarm_array[21]=alarmAlarmValue22;
		
		//23. 1 3 3 2 2
		AInput_array[0]=out_hr_mf1;
		AInput_array[1]=out_mbp_mf3;
		AInput_array[2]=out_rr_mf3;
		AInput_array[3]=out_spo2_mf2;
		double alarmAlarmValue23=min(AInput_array,4);
		Aalarm_array[22]=alarmAlarmValue23;
		
		//24. 3 3 3 2 2
		AInput_array[0]=out_hr_mf3;
		AInput_array[1]=out_mbp_mf3;
		AInput_array[2]=out_rr_mf3;
		AInput_array[3]=out_spo2_mf2;
		double alarmAlarmValue24=min(AInput_array,4);
		Aalarm_array[23]=alarmAlarmValue24;
		
		double Anormal_max=max(Anormal_array,30);
		double Aalarm_max=max(Aalarm_array,24);
		
		System.out.println( "Anormal_max:"+Anormal_max+" Aalarm_max:"+Aalarm_max);
		
		//3 cases below,according to Anormal_max ">" "<" "=" Aalarm_max
		
		if(Anormal_max<Aalarm_max)
		{
			//We want to get key point of the trapezoidal
			double Xmax=REVERSE_ALARM_MF2_ALARM(Aalarm_max);
		    double Xmin=REVERSE_ALARM_MF2_ALARM(Anormal_max);
				    
		   //calculate 3 areas
				    
		   double LeftRectangularArea=Rectangle_Area(0,Xmin,0,Anormal_max);
		   double TrapezoidalArea=Trapezoidal_Area(Xmin,Xmax,Anormal_max,Aalarm_max);
		   double RightRectangularArea=Rectangle_Area(Xmax,1,0,Aalarm_max);
				    
		   double LeftRectangularArea1=Rectangle_Area1(0,Xmin,0,Anormal_max);
		   double TrapezoidalArea1=Trapezoidal_Area1(Xmin,Xmax,Anormal_max,Aalarm_max);
		   double RightRectangularArea1=Rectangle_Area1(Xmax,1,0,Aalarm_max);
				    
		   //get centroid value
		   alarm_result=(LeftRectangularArea1+TrapezoidalArea1+RightRectangularArea1)/(LeftRectangularArea+TrapezoidalArea+RightRectangularArea);
		}
				
		if(Anormal_max>Aalarm_max)
		{
			//We want to get key point of the trapezoidal
			double Xmax=REVERSE_ALARM_MF1_NORMAL(Aalarm_max);
		    double Xmin=REVERSE_ALARM_MF1_NORMAL(Anormal_max);
				    
		   //calculate 3 areas
				    
		   double LeftRectangularArea=Rectangle_Area(0,Xmin,0,Anormal_max);
		   double TrapezoidalArea=Trapezoidal_Area(Xmin,Xmax,Anormal_max,Aalarm_max);
		   double RightRectangularArea=Rectangle_Area(Xmax,1,0,Aalarm_max);
				    
		   double LeftRectangularArea1=Rectangle_Area1(0,Xmin,0,Anormal_max);
		   double TrapezoidalArea1=Trapezoidal_Area1(Xmin,Xmax,Anormal_max,Aalarm_max);
		   double RightRectangularArea1=Rectangle_Area1(Xmax,1,0,Aalarm_max);
				    
			//get centroid value
		   alarm_result=(LeftRectangularArea1+TrapezoidalArea1+RightRectangularArea1)/(LeftRectangularArea+TrapezoidalArea+RightRectangularArea);
		}
				
		if(Anormal_max==Aalarm_max)//Both of the two value are 50%;The whole shape is a rectangle 
		{
			double RectangularArea=Rectangle_Area(0,1,0,Anormal_max);
			double RectangularArea1=Rectangle_Area1(0,1,0,Anormal_max);
			alarm_result=RectangularArea1/RectangularArea;
					
		}
				
			return alarm_result;
		
		
}

	
}
