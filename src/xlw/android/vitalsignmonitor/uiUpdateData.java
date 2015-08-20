package xlw.android.vitalsignmonitor;

public class uiUpdateData {
	
	private String mHRString;
	
	private String mSBPString;
	
	private String mDBPString;
	
	private String mMBPString;
	
	private String mRRString;
	
	private String mSpO2String;
	
	private String mAlarmString;
	
	private String mSensitivityString;
	
	private String mSpecificityString;
	
	private String mPPVString;
	
	private String mNPVString; 
	
	private int mRowCount;
	
	uiUpdateData()
	{
		
	}
	
	void setHR(String HRString)
	{
		mHRString = HRString;
	}
	
	void setSBP(String SBPString)
	{
		mSBPString = SBPString;
	}
	
	void setDBP(String DBPString)
	{
		mDBPString = DBPString;
	}
	
	void setMBP(String MBPString)
	{
		mMBPString = MBPString;
	}
	
	void setRR(String RRString)
	{
		mRRString = RRString;
	}
	
	void setSpO2(String SpO2String)
	{
		mSpO2String = SpO2String;
	}
	
	void setAlarm(String AlarmString)
	{
		mAlarmString = AlarmString;
	}
	
	void setRowCount(int RowCount)
	{
		mRowCount = RowCount;
	}
	
	String getHR()
	{
		return mHRString;
	}
	
	String getSBP()
	{
		return mSBPString;
	}
	
	String getDBP()
	{
		return mDBPString;
	}
	
	String getMBP()
	{
		return mMBPString;
	}
	
	String getRR()
	{
		return mRRString;
	}
	
	String getSpO2()
	{
		return mSpO2String;
	}
	
	String getAlarm()
	{
		return mAlarmString;
	}
	
	int getRowCount()
	{
		return mRowCount;
	}
	
	
	
	

}
