package dto;

public class MemberDTO {
	
	private int mNum;
	private String mID;
	private String mPW;
	
	public int getmNum() {
		return mNum;
	}
	public void setmNum(int mNum) {
		this.mNum = mNum;
	}
	public String getmID() {
		return mID;
	}
	public void setmID(String mID) {
		this.mID = mID;
	}
	public String getmPW() {
		return mPW;
	}
	public void setmPW(String mPW) {
		this.mPW = mPW;
	}
	@Override
	public String toString() {
		return "MemberDTO [mNum=" + mNum + ", mID=" + mID + ", mPW=" + mPW + "]";
	}
	
	

}
