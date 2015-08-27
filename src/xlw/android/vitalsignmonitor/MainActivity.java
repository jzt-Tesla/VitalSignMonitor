package xlw.android.vitalsignmonitor;




import android.util.Log;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.lang.Double;

import android.os.AsyncTask;
import 	android.os.Environment;
import android.os.PowerManager;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	// GUI controls
	Button btnStart;	
	
	private static final String TAG = "MyActivity";
	private static final String DATA_FILE_NAME = "data.txt";
	private ProgressBar mProgressBar;
	private TextView mHRValue;
	private TextView mSBPValue;
	private TextView mDBPValue;
	private TextView mMBPValue;
	private TextView mRRValue;
	private TextView mSpO2Value;
	private TextView mAlarmValue;
	private uiUpdateData mUIupdateData;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
	mHRValue = (TextView) findViewById(R.id.HR_Value);
	mSBPValue = (TextView) findViewById(R.id.SBP_Value);
	mDBPValue = (TextView) findViewById(R.id.DBP_Value);
	mMBPValue = (TextView) findViewById(R.id.MBP_Value);
	mRRValue  = (TextView) findViewById(R.id.RR_Value);
	mSpO2Value = (TextView) findViewById(R.id.SpO2_Value);
	mAlarmValue = (TextView) findViewById(R.id.Alarm_Value);
	mUIupdateData = new uiUpdateData();
	btnStart = (Button) findViewById(R.id.start);
	btnStart.setOnClickListener(new OnClickListener() {

		public void onClick(View v) {
			
			new VitalSignMonitorTask().execute();
			
		}// onClick
		}); // btnReadSDFile

	}// onCreate
	
	class VitalSignMonitorTask extends AsyncTask<Void, uiUpdateData, String> {


		@Override
		protected void onPreExecute() {
			mProgressBar.setVisibility(ProgressBar.VISIBLE);
		}

		@Override
		protected String doInBackground(Void... params) {


			// write on SD card file data in the text box
		try {
			Log.v(TAG, "onclick");
			File dir = Environment.getExternalStorageDirectory();
			File inFile = new File(dir, "Data/data1.txt");
			//File outFile= new File(dir, "Data/result.txt");
			//BN BN_Object = new BN();
			FUZZYLOGIC FL_Object= new FUZZYLOGIC();
			int ascii_code=0;
			char[] charArray = new char[10];
			double alM=0;
			int k=1;
			int row_count = 0;
			double hr;
			double sbp; 
			double dbp; 
			double mbp;
		    double rr;
		    double spo2;
		    double alarm;
		    String parameter_string = "";
		    String HR_string = "";
		    String SBP_string = "";
		    String DBP_string = "";
		    String MBP_string = "";
		    String RR_string = "";
		    String SpO2_string = "";
		    String alarm_string = "";
		    String sensitivity_string = "";
		    String specificity_string = "";
		    String PPV_string = "";
		    String NPV_string = "";
		    
		    PowerManager pm;
		    PowerManager.WakeLock wl;

		    pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
		    wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "MainActivity");
		    //accuracy = (TP+TN)/(TP+TN+FP+FN);
		    //error = (FP+FN)/(TP+TN+FP+FN);
		    //sensitivity = TP/(TP+FN);
		    //specificity = TN/(TN+FP);
		    //PPV = TP/(TP+FP);
		    //NPV = TN/(TN+FN);
		    
		    double TP=0;
		    double TN=0;
		    double FP=0;
		    double FN=0;
		    
		    double TotalCnt=0;
		    double CorrectCnt=0;
		    
		    try{
				/*		          
				File dir_ext = Environment.getExternalStorageDirectory();
				File trace_file= new File(dir_ext, "Data/tracefile_no_HS.txt");
				PrintStream out = new PrintStream(new FileOutputStream(trace_file));
				System.setOut(out);
				*/
				}catch(Exception e)
				{
					Log.v(TAG, "output trace file fail.");
				}
			
			//String filePath = getFilesDir().getPath().toString() + "/mysdfile.txt";
			Log.v(TAG, "onclick:"+dir+"\n");
			//File myFile = new File(filePath);
			//myFile.createNewFile();
			
			//DataOutputStream localDataOutputStream = new DataOutputStream(new FileOutputStream(outFile));
			//OutputStreamWriter myOutWriter = new OutputStreamWriter(localDataOutputStream);
			//wl.acquire();
			System.out.println( "Success? "+wl.isHeld() );
			
			mUIupdateData.setRowCount(0);
			mUIupdateData.setHR("");
			mUIupdateData.setSBP("");
			mUIupdateData.setDBP("");
			mUIupdateData.setMBP("");
			mUIupdateData.setRR("");
			mUIupdateData.setSpO2("");
			mUIupdateData.setAlarm("");
			
			publishProgress(mUIupdateData);
			
			for(int loop_num=0;loop_num<1;loop_num++)
			{
				InputStreamReader reader = null;
				System.out.println( "Begin to process file..."+loop_num);
				reader = new InputStreamReader(getAssets().open(DATA_FILE_NAME));
	          	BufferedReader myReader = new BufferedReader(reader);
			myReader.readLine();
			
			while((ascii_code=myReader.read())!=-1)
			{
				long start_time1=System.currentTimeMillis();
				Thread.sleep(2000);
				long end_time1=System.currentTimeMillis();
				long sleep_time=end_time1-start_time1;
				Log.v(TAG, "sleep time:"+sleep_time+"\n");
				
				Log.v(TAG, "before Write First of Record:"+ascii_code+"\n");
				//myOutWriter.write(ascii_code);//Write First Character of "Record#"
				
				while((ascii_code=myReader.read())!=9)
				{
					Log.v(TAG, "before Write Rest of Record:"+ascii_code+"\n");
					//myOutWriter.write(ascii_code);//Write Rest Characters of "Record#"
				}
				
				//myOutWriter.write(9);//Insert a space
				
				while((ascii_code=myReader.read())==9)
				{
					Log.v(TAG, "Read Space after Record"+ascii_code+"\n");
				}//Skip spaces
				
				Log.v(TAG, "before Write First of Date:"+ascii_code+"\n");
				//myOutWriter.write(ascii_code);//Write First Character of "Date"
				
				while((ascii_code=myReader.read())!=9)
				{
					Log.v(TAG, "before Write Rest of Date:"+ascii_code+"\n");
					//myOutWriter.write(ascii_code);//Write Rest Characters of "Date"
				}
				
				//myOutWriter.write(9);//Insert a space
				
				while((ascii_code=myReader.read())==9)
				{
					Log.v(TAG, "Read Space after Date"+ascii_code+"\n");	
				}//Skip spaces
				
				Log.v(TAG, "before Write First of Time:"+ascii_code+"\n");
				//myOutWriter.write(ascii_code);//Write First Character of "Time"
				
				while((ascii_code=myReader.read())!=9)
				{
					Log.v(TAG, "before Write Rest of Time:"+ascii_code+"\n");
					//myOutWriter.write(ascii_code);//Write Rest Characters of "Time"
				}
				
				//myOutWriter.write(9);//Insert a Horizontal tab
				
				while((ascii_code=myReader.read())==9)
				{
					Log.v(TAG, "Read Space after Time"+ascii_code+"\n");	
				}//Skip spaces
				
				Log.v(TAG, "before Write First of HR:"+ascii_code+"\n");
				charArray[0]=(char)ascii_code;
				
				while((ascii_code=myReader.read())!=9)//read "HR"
				{
					Log.v(TAG, "before Get Rest of HR:"+ascii_code+"\n");
					charArray[k++]=(char)ascii_code;
				}
				
				HR_string=String.valueOf(charArray);
				
				Log.v(TAG, "get hr:"+HR_string+"\n");
				
				hr = Double.parseDouble(HR_string);
				
				Log.v(TAG, "get hr value:"+hr+"\n");
				
				for(k=0;k<10;k++)
				{
					charArray[k]=0;
				}
				
				k=1;
				
                while((ascii_code=myReader.read())==9)
                {
                	Log.v(TAG, "Read Space after HR"+ascii_code+"\n");	
                }//Skip spaces
				
                Log.v(TAG, "before Write First of SBP:"+ascii_code+"\n");
				charArray[0]=(char)ascii_code;
				
				while((ascii_code=myReader.read())!=9)//read "SBP"
				{
					Log.v(TAG, "before Get Rest of SBP:"+ascii_code+"\n");
					charArray[k++]=(char)ascii_code;
				}
				
                SBP_string=String.valueOf(charArray);
                Log.v(TAG, "get sbp:"+SBP_string+"\n");
				sbp = Double.parseDouble(SBP_string);
				Log.v(TAG, "get sbp value:"+sbp+"\n");
				for(k=0;k<10;k++)
				{
					charArray[k]=0;
				}
				
				k=1;
				
                while((ascii_code=myReader.read())==9)
                {
                	Log.v(TAG, "Read Space after SBP"+ascii_code+"\n");
                }//Skip spaces
                Log.v(TAG, "before Write First of DBP:"+ascii_code+"\n");
				charArray[0]=(char)ascii_code;
				
				while((ascii_code=myReader.read())!=9)//read "DBP"
				{
					Log.v(TAG, "before Get Rest of DBP:"+ascii_code+"\n");
					charArray[k++]=(char)ascii_code;
				}
				
                DBP_string=String.valueOf(charArray);
                Log.v(TAG, "get dbp:"+DBP_string+"\n");
				dbp = Double.parseDouble(DBP_string);
				Log.v(TAG, "get dbp value:"+dbp+"\n");
				for(k=0;k<10;k++)
				{
					charArray[k]=0;
				}
				
				k=1;
				
                while((ascii_code=myReader.read())==9)
                {
                	Log.v(TAG, "Read Space after DBP"+ascii_code+"\n");
                }//Skip spaces
                Log.v(TAG, "before Write First of MBP:"+ascii_code+"\n");
				charArray[0]=(char)ascii_code;
				
				while((ascii_code=myReader.read())!=9)//read "MBP"
				{
					Log.v(TAG, "before Get Rest of MBP:"+ascii_code+"\n");
					charArray[k++]=(char)ascii_code;
				}
				
                MBP_string=String.valueOf(charArray);
                Log.v(TAG, "get mbp:"+MBP_string+"\n");
				mbp = Double.parseDouble(MBP_string);
				Log.v(TAG, "get mbp value:"+mbp+"\n");
				for(k=0;k<10;k++)
				{
					charArray[k]=0;
				}
				
				k=1;
				
                while((ascii_code=myReader.read())==9)
                {
                	Log.v(TAG, "Read Space after MBP"+ascii_code+"\n");
                }//Skip spaces
				
                Log.v(TAG, "before Write First of RR:"+ascii_code+"\n");
				charArray[0]=(char)ascii_code;
				
				while((ascii_code=myReader.read())!=9)//read "RR"
				{
					Log.v(TAG, "before Get Rest of RR:"+ascii_code+"\n");
					charArray[k++]=(char)ascii_code;
				}
				
                RR_string=String.valueOf(charArray);
                Log.v(TAG, "get rr:"+RR_string+"\n");
				rr = Double.parseDouble(RR_string);
				Log.v(TAG, "get rr value:"+rr+"\n");
				for(k=0;k<10;k++)
				{
					charArray[k]=0;
				}
				
				k=1;
				
                while((ascii_code=myReader.read())==9)
                {
                	Log.v(TAG, "Read Space after RR"+ascii_code+"\n");
                }//Skip spaces
                
                Log.v(TAG, "before Write First of SpO2:"+ascii_code+"\n");
				charArray[0]=(char)ascii_code;
				
				while((ascii_code=myReader.read())!=9)//read "SpO2"
				{
					Log.v(TAG, "before Get Rest of SpO2:"+ascii_code+"\n");
					charArray[k++]=(char)ascii_code;
				}
				
                SpO2_string=String.valueOf(charArray);
                Log.v(TAG, "get spo2:"+SpO2_string+"\n");
				spo2 = Double.parseDouble(SpO2_string);
				Log.v(TAG, "get spo2 value:"+spo2+"\n");
				for(k=0;k<10;k++)
				{
					charArray[k]=0;
				}
				
				k=1;
				
				while((ascii_code=myReader.read())==9)
                {
                	Log.v(TAG, "Read Space after SpO2"+ascii_code+"\n");
                }//Skip spaces
				
				Log.v(TAG, "before Write First of alM:"+ascii_code+"\n");
				charArray[0]=(char)ascii_code;
				
				while((ascii_code=myReader.read())!=13)//read "alM"
				{
					Log.v(TAG, "before Get Rest of alM:"+ascii_code+"\n");
					charArray[k++]=(char)ascii_code;
				}
				
				parameter_string=String.valueOf(charArray);
                Log.v(TAG, "get alM:"+parameter_string+"\n");
				alM = Double.parseDouble(parameter_string);
				Log.v(TAG, "get alM value:"+alM+"\n");
				for(k=0;k<10;k++)
				{
					charArray[k]=0;
				}
				
				k=1;
				
				if((ascii_code=myReader.read())==10)
				{
					//System.out.println( "Begin next line!!!" );
				}
				
				long StartTime=System.nanoTime ();
				//alarm=BN_Object.BN_threshold_compare(hr,sbp,dbp,mbp,rr,spo2);//Classify algorithm executed
				//alarm=FL_Object.FUZZYLOGIC_RULE1_COMB1(hr);
				//alarm=FL_Object.FUZZYLOGIC_RULE2_COMB2(hr,sbp);
				alarm=FL_Object.FUZZYLOGIC_RULE6_COMB9(hr,mbp,rr,spo2);
				long EndTime=System.nanoTime ();
				long ProcessTime=EndTime-StartTime;
				Log.v(TAG, "get alarm value:"+alarm+"---process time:"+ProcessTime+"ns"+"\n");
				parameter_string=Double.toString(alarm);
				Log.v(TAG, "get alarm:"+parameter_string+"\n");
				//myOutWriter.write(parameter_string);//Write the value of "alarm"
				//myOutWriter.write(9);//Insert a space
				TotalCnt=TotalCnt+1;
				if(alarm<=0.5)
				{	
					alarm=0;
					alarm_string = "Negative";
				}
				else
				{
					alarm=1;
					alarm_string = "Positive";
					
				}
				
				parameter_string=Double.toString(alarm);
				//myOutWriter.write(parameter_string);//Write the value of "alarm"
				
				if(Double.compare(1,alM)==0&&Double.compare(1,alarm)==0)
				{
					TP=TP+1;
				}
				
				if(Double.compare(0,alM)==0&&Double.compare(0,alarm)==0)
				{
					TN=TN+1;
				}
				
				if(Double.compare(1,alM)==0&&Double.compare(0,alarm)==0)
				{
					FN=FN+1;
				}
				
				if(Double.compare(0,alM)==0&&Double.compare(1,alarm)==0)
				{
					FP=FP+1;
				}
									
				if(Double.compare(alarm,alM)==0)
				{
					CorrectCnt=CorrectCnt+1;
				}
					
				double CorrectPercentage=CorrectCnt/TotalCnt;	
				Log.v(TAG, "TotalCnt:"+TotalCnt+"-----CorrectCnt:"+CorrectCnt+"\n");
				Log.v(TAG, "TP:"+TP+"TN:"+TN+"\n");
				Log.v(TAG, "FP:"+FP+"FN:"+FN+"\n");
				
				double sensitivity = TP/(TP+FN);
				double specificity = TN/(TN+FP);
				double PPV = TP/(TP+FP);
				double NPV = TN/(TN+FN);
				
				//myOutWriter.write(9);//Insert a tab
				
				parameter_string=Long.toString(ProcessTime);
				//myOutWriter.write(parameter_string);//Write the value of "Process Time"
				
				//myOutWriter.write(9);//Insert a tab
				
				parameter_string=Double.toString(CorrectPercentage);
				//myOutWriter.write(parameter_string);//Write the value of "CorrectPercentage"
				
                //myOutWriter.write(9);//Insert a tab
				
                sensitivity_string=Double.toString(sensitivity);
				//myOutWriter.write(sensitivity_string);//Write the value of "sensitivity"
				
                //myOutWriter.write(9);//Insert a tab
				
                specificity_string=Double.toString(specificity);
				//myOutWriter.write(specificity_string);//Write the value of "specificity"
				
                //myOutWriter.write(9);//Insert a tab
				
                PPV_string=Double.toString(PPV);
				//myOutWriter.write(PPV_string);//Write the value of "PPV"
				
                //myOutWriter.write(9);//Insert a tab
				
                NPV_string=Double.toString(NPV);
				//myOutWriter.write(NPV_string);//Write the value of "NPV"
								
				//myOutWriter.write(13);//Insert a "Enter"
				
				row_count++;
				
				mUIupdateData.setRowCount(row_count);
				mUIupdateData.setHR(HR_string);
				mUIupdateData.setSBP(SBP_string);
				mUIupdateData.setDBP(DBP_string);
				mUIupdateData.setMBP(MBP_string);
				mUIupdateData.setRR(RR_string);
				mUIupdateData.setSpO2(SpO2_string);
				mUIupdateData.setAlarm(alarm_string);
				
				publishProgress(mUIupdateData);
										
			}//whole file loop:line by line
			
			myReader.close();
			
			if (reader != null) {
	                try {
	                    reader.close();
	                } catch(IOException e) {

	                }
	            }
	        
			}//loop_num
			
			//wl.release();
			
			//myOutWriter.close();
			//localDataOutputStream.close();
			
			

		} catch (Exception e) {
			System.out.println( "Exception reported in background thread: " +e.getMessage() );
		}
		return "Vital Sign Monitoring Finished.";
		
			
		}

		@Override
		protected void onProgressUpdate(uiUpdateData... values) {
			Log.v(TAG, "AsyncTask onProgressUpdate\n");
			mProgressBar.setProgress(values[0].getRowCount()*10);
			mHRValue.setText(values[0].getHR());
			mSBPValue.setText(values[0].getSBP());
			mDBPValue.setText(values[0].getDBP());
			mMBPValue.setText(values[0].getMBP());
			mRRValue.setText(values[0].getRR());
			mSpO2Value.setText(values[0].getSpO2());
			mAlarmValue.setText(values[0].getAlarm());
			
			
		}

		@Override
		protected void onPostExecute(String message) {
			Log.v(TAG, "AsyncTask onPostExecute\n");
			mProgressBar.setVisibility(ProgressBar.INVISIBLE);
			Toast.makeText(getBaseContext(),
					message,
					Toast.LENGTH_SHORT).show();
		}

		
	}

}//MainActivity
