package application;

public class CovidTableData {
	int idx;        // ����
	String stateDt; // 20210101   ������
	int decideCnt; // 61754   Ȯ���� ��
	int deathCnt; // 917   ����� ��
	int clearCnt; // 42953 �ݸ����� ��
	int todayDecideCnt; // ���� Ȯ���� ��
	int todayDeathCnt; // ���� ����� ��
	int todayClearCnt; // ���� �ݸ����� ��
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
