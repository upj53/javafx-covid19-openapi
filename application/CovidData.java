package application;

public class CovidData {
	double accDefRate; // 1.5090011279  ���� Ȯ����
	int accExamCnt; // 4269303  ���� �˻� ��
	int accExamCompCnt; // 4092376 ���� �˻� �Ϸ� ��
	int careCnt; // 17884  ġ���� ȯ�� ��
	int clearCnt; // 42953 �ݸ����� ��
	String createDt; // 2021-01-01 09:36:53.691  ����Ͻú���
	int deathCnt; // 917   ����� ��
	int decideCnt; // 61754   Ȯ���� ��
	int examCnt; // 176927   �˻����� ��
	int resutlNegCnt; // 4030622  ��� ���� ��
	int seq; // 372  �Խñ۹�ȣ
	String stateDt; // 20210101   ������
	String stateTime; // 00:00   ���ؽð�
	String updateDt; // 2021-04-20 16:11:34.691   �����Ͻú���
	int todayDecideCnt; // ���� Ȯ���� ��
	int todayDeathCnt; // ���� ����� ��
	int todayClearCnt; // ���� �ݸ����� ��
	public CovidData(double accDefRate, int accExamCnt, int accExamCompCnt, int careCnt, int clearCnt, String createDt, int deathCnt, int decideCnt, int examCnt, int resutlNegCnt, int seq, String stateDt, String stateTime, String updateDt) {
		this.accDefRate = accDefRate;
		this.accExamCnt = accExamCnt;
		this.accExamCompCnt = accExamCompCnt;
		this.careCnt = careCnt;
		this.clearCnt = clearCnt;
		this.createDt = createDt;
		this.deathCnt = deathCnt;
		this.decideCnt = decideCnt;
		this.examCnt = examCnt;
		this.resutlNegCnt = resutlNegCnt;
		this.seq = seq;
		this.stateDt = stateDt;
		this.stateTime = stateTime;
		this.updateDt = updateDt;
		this.todayDecideCnt = 0;
		this.todayDeathCnt = 0;
		this.todayClearCnt = 0;
	}
	
	public double getAccDefRate() {
		return accDefRate;
	}
	public void setAccDefRate(double accDefRate) {
		this.accDefRate = accDefRate;
	}
	public int getAccExamCnt() {
		return accExamCnt;
	}
	public void setAccExamCnt(int accExamCnt) {
		this.accExamCnt = accExamCnt;
	}
	public int getAccExamCompCnt() {
		return accExamCompCnt;
	}
	public void setAccExamCompCnt(int accExamCompCnt) {
		this.accExamCompCnt = accExamCompCnt;
	}
	public int getCareCnt() {
		return careCnt;
	}
	public void setCareCnt(int careCnt) {
		this.careCnt = careCnt;
	}
	public int getClearCnt() {
		return clearCnt;
	}
	public void setClearCnt(int clearCnt) {
		this.clearCnt = clearCnt;
	}
	public String getCreateDt() {
		return createDt;
	}
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	public int getDeathCnt() {
		return deathCnt;
	}
	public void setDeathCnt(int deathCnt) {
		this.deathCnt = deathCnt;
	}
	public int getDecideCnt() {
		return decideCnt;
	}
	public void setDecideCnt(int decideCnt) {
		this.decideCnt = decideCnt;
	}
	public int getExamCnt() {
		return examCnt;
	}
	public void setExamCnt(int examCnt) {
		this.examCnt = examCnt;
	}
	public int getResutlNegCnt() {
		return resutlNegCnt;
	}
	public void setResutlNegCnt(int resutlNegCnt) {
		this.resutlNegCnt = resutlNegCnt;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getStateDt() {
		return stateDt;
	}
	public void setStateDt(String stateDt) {
		this.stateDt = stateDt;
	}
	public String getStateTime() {
		return stateTime;
	}
	public void setStateTime(String stateTime) {
		this.stateTime = stateTime;
	}
	public String getUpdateDt() {
		return updateDt;
	}
	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
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
