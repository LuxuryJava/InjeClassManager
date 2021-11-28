package ac.injecs.java2.entity;

public class ResInfo {
	private int sno;
	private String rinfo;
	private int memcnt;
	private String useday;
	private String usetime;
	private String purpose;
	
	public ResInfo(int sno,String rinfo, int memcnt, String useday,String usetime,String purpose){
		this.sno=sno;
		this.rinfo=rinfo;
		this.memcnt=memcnt;
		this.useday=useday;
		this.usetime=usetime;
		this.purpose=purpose;
		
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

}
