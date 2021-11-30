package ac.injecs.java2.entity;

public class ResInfo {
	private int uno;
	private String rinfo;
	private int memcnt;
	private String useday;
	private String usetime;
	private String purpose;
	private boolean accept;

	public ResInfo(int uno,String rinfo, int memcnt, String useday,String usetime,String purpose, boolean accept){
		this.uno=uno;
		this.rinfo=rinfo;
		this.memcnt=memcnt;
		this.useday=useday;
		this.usetime=usetime;
		this.purpose=purpose;
		this.accept = accept;
	}

	public int getuno() {
		return uno;
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

	public boolean getaccept() {
		return accept;
	}

}