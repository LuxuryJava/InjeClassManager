package ac.injecs.java2.entity;

public class ResInfo {
	private int sno;
	private String rinfo;
	private String useday;
	private int memcnt;
	private String usetime;
	private String purpose;
	private boolean isAccept;
	
	public ResInfo(int sno,String rinfo,String useday,int memcnt ,String usetime,String purpose,boolean isAccept){
		this.sno=sno;
		this.rinfo=rinfo;
		this.memcnt=memcnt;
		this.useday=useday;
		this.usetime=usetime;
		this.purpose=purpose;
		this.isAccept = isAccept;
	}
	
	public int getsno() {
		return sno;
	}
	
	public String getrinfo() {
		return rinfo;
	}
	
	public int getmemcnt() {
		return memcnt;
	}
	
	public String getuseday() {
		return useday;
	}
	
	public String getusetime() {
		return usetime;
	}
	
	public String getpurpose() {
		return purpose;
	}

	public boolean isAccept() {
		return isAccept;
	}
}
