package xlw.android.vitalsignmonitor;

public class BN {
	
	double alarm;
	
	BN()
	{
		this.alarm=0;
	}
	
	double BN_threshold_compare(double hr, double sbp, double dbp, double mbp,
			      double rr,double spo2)
	{
		double alarm_hr=0;
		double alarm_sbp=0;
		double alarm_dbp=0;
		double alarm_mbp=0;
		double alarm_rr=0;
		double alarm_spo2=0;
		
		if(hr>=50&&hr<=120)
			alarm_hr=0;
		else
			alarm_hr=1;
		
		if(sbp>=100&&sbp<=145)
			alarm_sbp=0;
		else
			alarm_sbp=1;
		
		if(dbp>=75&&dbp<=90)
			alarm_dbp=0;
		else
			alarm_dbp=1;
		
		if(mbp>=88&&mbp<=108)
			alarm_mbp=0;
		else
			alarm_mbp=1;
		
		if(rr>=8&&rr<=35)
			alarm_rr=0;
		else
			alarm_rr=1;
		
		if(spo2>=92)
			alarm_spo2=0;
		else
			alarm_spo2=1;			
			
		if(alarm_hr==1||alarm_sbp==1||alarm_dbp==1||
		    alarm_mbp==1||alarm_rr==1||alarm_spo2==1)
		    this.alarm=1;
		else 
			this.alarm=0;
		
		return this.alarm;
	}

}
