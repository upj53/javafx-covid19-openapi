package application;

public class CovidData {
	double accDefRate; // 1.5090011279  누적 확진률
	int accExamCnt; // 4269303  누적 검사 수
	int accExamCompCnt; // 4092376 누적 검사 완료 수
	int careCnt; // 17884  치료중 환자 수
	int clearCnt; // 42953 격리해제 수
	String createDt; // 2021-01-01 09:36:53.691  등록일시분초
	int deathCnt; // 917   사망자 수
	int decideCnt; // 61754   확진자 수
	int examCnt; // 176927   검사진행 수
	int resutlNegCnt; // 4030622  결과 음성 수
	int seq; // 372  게시글번호
	String stateDt; // 20210101   기준일
	String stateTime; // 00:00   기준시간
	String updateDt; // 2021-04-20 16:11:34.691   수정일시분초
	int todayDecideCnt; // 오늘 확진자 수
	int todayDeathCnt; // 오늘 사망자 수
	int todayClearCnt; // 오늘 격리해제 수
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
