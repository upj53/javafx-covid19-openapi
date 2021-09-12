package application;

public class CovidTableData {
	int idx;        // 순번
	String stateDt; // 20210101   기준일
	int decideCnt; // 61754   확진자 수
	int deathCnt; // 917   사망자 수
	int clearCnt; // 42953 격리해제 수
	int todayDecideCnt; // 오늘 확진자 수
	int todayDeathCnt; // 오늘 사망자 수
	int todayClearCnt; // 오늘 격리해제 수
	public CovidTableData(int idx, String stateDt, int decideCnt, int deathCnt, int clearCnt, int todayDecideCnt,
			int todayDeathCnt, int todayClearCnt) {
		super();
		this.idx = idx;
		this.stateDt = stateDt;
		this.decideCnt = decideCnt;
		this.deathCnt = deathCnt;
		this.clearCnt = clearCnt;
		this.todayDecideCnt = todayDecideCnt;
		this.todayDeathCnt = todayDeathCnt;
		this.todayClearCnt = todayClearCnt;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getStateDt() {
		return stateDt;
	}
	public void setStateDt(String stateDt) {
		this.stateDt = stateDt;
	}
	public int getDecideCnt() {
		return decideCnt;
	}
	public void setDecideCnt(int decideCnt) {
		this.decideCnt = decideCnt;
	}
	public int getDeathCnt() {
		return deathCnt;
	}
	public void setDeathCnt(int deathCnt) {
		this.deathCnt = deathCnt;
	}
	public int getClearCnt() {
		return clearCnt;
	}
	public void setClearCnt(int clearCnt) {
		this.clearCnt = clearCnt;
	}
	public int getTodayDecideCnt() {
		return todayDecideCnt;
	}
	public void setTodayDecideCnt(int todayDecideCnt) {
		this.todayDecideCnt = todayDecideCnt;
	}
	public int getTodayDeathCnt() {
		return todayDeathCnt;
	}
	public void setTodayDeathCnt(int todayDeathCnt) {
		this.todayDeathCnt = todayDeathCnt;
	}
	public int getTodayClearCnt() {
		return todayClearCnt;
	}
	public void setTodayClearCnt(int todayClearCnt) {
		this.todayClearCnt = todayClearCnt;
	}
}
