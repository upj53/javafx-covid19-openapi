# JavaFX OpenAPI 공공데이터를 활용한 COVID-19 실시간 뷰어

![](https://upj53.pe.kr/javafx/covid19openapi.png)

+ [준비파일 다운로드](https://drive.google.com/drive/folders/1m65-OF3zZjNk-P19qwJ8mI8BcTQWxsQv?usp=sharing)
+ [성일정보고등학교](http://sungil-i.kr/)
+ [GitHub](https://github.com/upj53/javafx-covid19-openapi)
+ [YouTube 재생목록](https://youtube.com/playlist?list=PLINB01vb6rt4R-rdj4PuQ2MsK3rtJNeqA)

<details><summary>환경설정 모두보기</summary>
<pre>
▶오픈API 상세
XML 공공데이터활용지원센터_보건복지부 코로나19 감염 현황
https://www.data.go.kr/data/15043376/openapi.do
<br>
▶FXML과 Java 연결구성
Covid19Controller.java ↔ covid19-viewer.fxml
<br>
▶GUI FXML 변수명
1.lineChartLabel
2.covidLineChart
3.barChartLabel
4.covidBarChart
5.covidTableView
5-1.tvcIdx
5-2.tvcStateDt 날짜
5-3.tvcDecideCnt 누적 확진자 수
5-4.tvcDeathCnt 누적 사망자 수
5-5.tvcClearCnt 누적 격리해제자 수
5-6.tvcTodayDecideCnt 오늘의 확진자 수
5-7.tvcTodayDeathCnt 오늘의 사망자 수
5-8.tvcTodayClearCnt 오늘의 격리해제자 수

▶OpenAPI 자료구조
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
<br>
▶TableView 자료구조
int idx;        // 순번
String stateDt; // 20210101   기준일
int decideCnt; // 61754   확진자 수
int deathCnt; // 917   사망자 수
int clearCnt; // 42953 격리해제 수
int todayDecideCnt; // 오늘 확진자 수
int todayDeathCnt; // 오늘 사망자 수
int todayClearCnt; // 오늘 격리해제 수
</pre>
</details>

## 1-1.개발 설계하기
[![](http://img.youtube.com/vi/A8QEGHuOBkg/0.jpg)](https://youtu.be/A8QEGHuOBkg)

## 2-1.FXML 폼 디자인
[![](http://img.youtube.com/vi/8n8_b-uYwYo/0.jpg)](https://youtu.be/8n8_b-uYwYo)

## 3.JavaFX 프로그래밍
### 3-1.공공데이터 가져오기
[![](http://img.youtube.com/vi/SfZnU2scOeE/0.jpg)](https://youtu.be/SfZnU2scOeE)

### 3-2.ArrayList로 테이블뷰 읽기 (1)
[![](http://img.youtube.com/vi/DD2S2M2nP5k/0.jpg)](https://youtu.be/DD2S2M2nP5k)

### 3-3.ArrayList로 테이블뷰 읽기 (2)
[![](http://img.youtube.com/vi/FABEV8i8vm8/0.jpg)](https://youtu.be/FABEV8i8vm8)

### 3-4.ArrayList로 테이블뷰 읽기 (3)
[![](http://img.youtube.com/vi/jQ2omJaFQ8k/0.jpg)](https://youtu.be/jQ2omJaFQ8k)

### 3-5.LineChar와 BarChart 그래프 그리기
[![](http://img.youtube.com/vi/SarMsscneVQ/0.jpg)](https://youtu.be/SarMsscneVQ)
