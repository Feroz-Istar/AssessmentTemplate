package templates;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.Assessment;
import com.Question;
import com.google.gson.Gson;

public class GsonParse {
	public static void main(String args[]) {
		
		try {
			sendGet();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void sendGet() throws Exception {

		String url = "http://localhost:8080/templates/assessmentService?assessment_id=2";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
		
		Gson gson = new Gson();
		Assessment assessment = gson.fromJson(response.toString(),Assessment.class);
		List<Question> stringsList = new ArrayList<>(assessment.getQuestions());

		System.out.println(stringsList.get(0).getAnswers().size());

	}
}
