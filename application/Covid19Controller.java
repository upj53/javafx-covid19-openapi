package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.io.IOException;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Covid19Controller implements Initializable {
	@FXML
	private LineChart<?,?>	covidLineChart;
	@FXML
	private BarChart<?,?> covidBarChart;
	
	@FXML
	private TableView<CovidTableData> covidTableView;
	@FXML
	private TableColumn<CovidTableData, Integer> tvcIdx;
	@FXML
	private TableColumn<CovidTableData, Integer> tvcStateDt; // 날짜
	@FXML
	private TableColumn<CovidTableData, Integer> tvcDecideCnt; // 누적 확진자 수
	@FXML
	private TableColumn<CovidTableData, Integer> tvcDeathCnt; // 누적 사망자 수
	@FXML
	private TableColumn<CovidTableData, Integer> tvcClearCnt; // 누적 격리해제자 수
	@FXML
	private TableColumn<CovidTableData, Integer> tvcTodayDecideCnt; // 오늘의 확진자 수
	@FXML
	private TableColumn<CovidTableData, Integer> tvcTodayDeathCnt; // 오늘의 사망자 수
	@FXML
	private TableColumn<CovidTableData, Integer> tvcTodayClearCnt; // 오늘의 격리해제자 수	
	
	@FXML
	private Label lineChartLabel;
	@FXML
	private Label barChartLabel;
	
	// OpenAPI 원본 자료구조(제네릭 형식의 ArrayList)
	ArrayList<CovidData> m_covidDataList = new ArrayList<>();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 테이블뷰 초기화
		tvcIdx.setCellValueFactory(new PropertyValueFactory<>("idx"));
		tvcStateDt.setCellValueFactory(new PropertyValueFactory<>("stateDt"));
		tvcDecideCnt.setCellValueFactory(new PropertyValueFactory<>("decideCnt"));
		tvcDeathCnt.setCellValueFactory(new PropertyValueFactory<>("deathCnt"));
		tvcClearCnt.setCellValueFactory(new PropertyValueFactory<>("clearCnt"));
		tvcTodayDecideCnt.setCellValueFactory(new PropertyValueFactory<>("todayDecideCnt"));
		tvcTodayDeathCnt.setCellValueFactory(new PropertyValueFactory<>("todayDeathCnt"));
		tvcTodayClearCnt.setCellValueFactory(new PropertyValueFactory<>("todayClearCnt"));
		
		try {
			//readOpenAPIData();
			String fromDate = "20200310";
			String toDate = null;
			Date yDate = new Date();
			yDate = new Date(yDate.getTime() - (1000*60*60*24));
			SimpleDateFormat ySdf = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
			toDate = ySdf.format(yDate);
			
			lineChartLabel.setText("기간 : "+fromDate+" ~ "+toDate);
			barChartLabel.setText("기간 : "+toDate+"로부터 10일 전");
			m_covidDataList = getOpenAPIData(fromDate, toDate);
			if(m_covidDataList != null) {
				// 자료가 있는 경우 결과를 보여줍니다
				showTableView();
				showLineChart();
				showBarChart();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<CovidData> getOpenAPIData(String fromDate, String toDate) throws IOException {
		ArrayList<CovidData> result = new ArrayList<>();
		
		// OpenAPI에서 자료 가져오기
		// https://www.data.go.kr/data/15043376/openapi.do
		StringBuilder urlBuilder = new StringBuilder("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=RfKWB2J/3B18gJR4RmXMbUI8tUOqspBVTL6Ecm/JCUP8ySOcMFHbxfUrXxrCvOEpx0yFCTyZbThZDOw4y4kGKg=="); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("startCreateDt","UTF-8") + "=" + URLEncoder.encode(fromDate, "UTF-8")); /*검색할 생성일 범위의 시작*/
        urlBuilder.append("&" + URLEncoder.encode("endCreateDt","UTF-8") + "=" + URLEncoder.encode(toDate, "UTF-8")); /*검색할 생성일 범위의 종료*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        //System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        
        // XML 형식의 데이터를 자바에 맞는 자료구조로 파싱(parsing) 하기
        try {
        	if(sb.toString().isEmpty() == true || sb.toString().length() == 0) {
        		// OpenAPI에서 가져온 데이터가 없을 경우 null 을 돌려준다
        		result = null;
        	} else {
        		// OpenAPI에서 가져온 데이터가 있을 경우 파싱한다
        		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        		DocumentBuilder builder = factory.newDocumentBuilder();
        		Document document = builder.parse(new InputSource(new StringReader(sb.toString())));
        		Node root = document.getFirstChild();
        		NodeList itemList = root.getChildNodes().item(1).getFirstChild().getChildNodes();
        		// for(int i=0; i<itemList.getLength(); i++) { // 순서대로 데이터 가져오기
        		for(int i=itemList.getLength() - 1; i>=0; i--) { // 역순으로 가져오기
        			double accDefRate = -1.0; // 1.5090011279  누적 확진률
    				int accExamCnt = -1; // 4269303  누적 검사 수
    				int accExamCompCnt = -1; // 4092376 누적 검사 완료 수
    				int careCnt = -1; // 17884  치료중 환자 수
    				int clearCnt = -1; // 42953 격리해제 수
    				String createDt = null; // 2021-01-01 09:36:53.691  등록일시분초
    				int deathCnt = -1; // 917   사망자 수
    				int decideCnt = -1; // 61754   확진자 수
    				int examCnt = -1; // 176927   검사진행 수
    				int resutlNegCnt = -1; // 4030622  결과 음성 수
    				int seq = -1; // 372  게시글번호
    				String stateDt = null; // 20210101   기준일
    				String stateTime = null; // 00:00   기준시간
    				String updateDt = null; // 2021-04-20 16:11:34.691   수정일시분초
        			Node item = itemList.item(i);
        			NodeList tagList = item.getChildNodes();
        			for(int j=0; j<tagList.getLength(); j++) {
        				Node tag = tagList.item(j);
        				//System.out.println(tag.getNodeName() + " : " + tag.getTextContent());
        				switch(tag.getNodeName()) {
        				case "accDefRate":
							accDefRate = Double.parseDouble(tag.getTextContent());
							break;
						case "accExamCnt":
							accExamCnt = Integer.parseInt(tag.getTextContent());
							break;
						case "accExamCompCnt":
							accExamCompCnt = Integer.parseInt(tag.getTextContent());
							break;
						case "careCnt":
							careCnt =Integer.parseInt(tag.getTextContent());
							break;
						case "clearCnt":
							clearCnt = Integer.parseInt(tag.getTextContent());
							break;
						case "createDt":
							createDt = tag.getTextContent();
							break;
						case "deathCnt":
							deathCnt = Integer.parseInt(tag.getTextContent());
							break;
						case "decideCnt":
							decideCnt = Integer.parseInt(tag.getTextContent());
							break;
						case "examCnt":
							examCnt = Integer.parseInt(tag.getTextContent());
							break;
						case "resutlNegCnt":
							resutlNegCnt = Integer.parseInt(tag.getTextContent());
							break;
						case "seq":
							seq = Integer.parseInt(tag.getTextContent());
							break;
						case "stateDt":
							stateDt = tag.getTextContent();
							break;
						case "stateTime":
							stateTime = tag.getTextContent();
							break;
						case "updateDt":
							updateDt = tag.getTextContent();
							break;
						default:
							break;
        				}
        			}
        			result.add(
        					new CovidData(
        							accDefRate, accExamCnt, accExamCompCnt, careCnt, clearCnt, createDt,
    								deathCnt, decideCnt, examCnt, resutlNegCnt, seq,
    								stateDt, stateTime, updateDt
        					)
        			);
        		}
        	}
        	
        	// CovidData 데이터에서 날짜(stateDt) 순서로 다시 정렬합니다
        	// 왜냐하면 날짜가 뒤섞인 데이터가 있기 때문입니다
        	CovidDataSortByDate sortByDate = new CovidDataSortByDate();
        	Collections.sort(result, sortByDate);
        	
        	// result 의 누적 데이터에서 오늘의 데이터 산출하기
        	for(int i=1; i<result.size(); i++) {
        		result.get(i).setTodayDecideCnt(result.get(i).decideCnt - result.get(i-1).decideCnt);
        		result.get(i).setTodayDeathCnt(result.get(i).deathCnt - result.get(i-1).deathCnt);
        		result.get(i).setTodayClearCnt(result.get(i).clearCnt - result.get(i-1).clearCnt);
        	}
        	
        } catch(Exception e) {}
		
		return result;
	}

	public void readOpenAPIData() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=RfKWB2J/3B18gJR4RmXMbUI8tUOqspBVTL6Ecm/JCUP8ySOcMFHbxfUrXxrCvOEpx0yFCTyZbThZDOw4y4kGKg=="); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("startCreateDt","UTF-8") + "=" + URLEncoder.encode("20200310", "UTF-8")); /*검색할 생성일 범위의 시작*/
        urlBuilder.append("&" + URLEncoder.encode("endCreateDt","UTF-8") + "=" + URLEncoder.encode("20200317", "UTF-8")); /*검색할 생성일 범위의 종료*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        //System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
	}
	
	void showTableView() {
		ObservableList<CovidTableData> tvcData = FXCollections.observableArrayList();
		int idx = 1;
		for(CovidData data : m_covidDataList) {
			tvcData.add(
					new CovidTableData(
							idx++,
							data.stateDt,
							data.decideCnt,
							data.deathCnt,
							data.clearCnt,
							data.todayDecideCnt,
							data.todayDeathCnt,
							data.todayClearCnt
					)
			);
		}
		covidTableView.setItems(tvcData);
	}
	
	void showLineChart() {
		XYChart.Series dataSeries1 = new XYChart.Series<>();
		XYChart.Series dataSeries2 = new XYChart.Series<>();
		XYChart.Series dataSeries3 = new XYChart.Series<>();
		
		dataSeries1.setName("누적 확진자(명)");
		dataSeries2.setName("누적 사망자(명)");
		dataSeries3.setName("누적 격리해제자(명)");
		
		for(CovidData data : m_covidDataList) {
			dataSeries1.getData().add(new XYChart.Data(data.getStateDt(), data.getDecideCnt()));
			dataSeries2.getData().add(new XYChart.Data(data.getStateDt(), data.getDeathCnt()));
			dataSeries3.getData().add(new XYChart.Data(data.getStateDt(), data.getClearCnt()));
		}
		
		covidLineChart.getData().addAll(
				dataSeries1,
				dataSeries2,
				dataSeries3
		);
	}
	
	void showBarChart() {
		XYChart.Series dataSeries1 = new XYChart.Series<>();
		XYChart.Series dataSeries2 = new XYChart.Series<>();
		XYChart.Series dataSeries3 = new XYChart.Series<>();
		
		dataSeries1.setName("오늘의 확진자(명)");
		dataSeries2.setName("오늘의 사망자(명)");
		dataSeries3.setName("오늘의 격리해제자(명)");
		
		for(int i=m_covidDataList.size()-10; i<m_covidDataList.size(); i++) {
			CovidData data = m_covidDataList.get(i);
			dataSeries1.getData().add(new XYChart.Data(data.getStateDt(), data.getTodayDecideCnt()));
			dataSeries2.getData().add(new XYChart.Data(data.getStateDt(), data.getTodayDeathCnt()));
			dataSeries3.getData().add(new XYChart.Data(data.getStateDt(), data.getTodayClearCnt()));
		}
		
		covidBarChart.getData().addAll(
				dataSeries1,
				dataSeries2,
				dataSeries3
		);
	}
}













