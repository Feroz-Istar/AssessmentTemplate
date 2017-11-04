package templates;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Answer;
import com.Assessment;
import com.Option;
import com.Question;
import com.github.mirreck.FakeFactory;

import util.HibernateSessionFactory;
import util.HibernateUtils;

public class AssessmentTest {



	public static void main(String args[]) {
		  ArrayList<String> image_url = new ArrayList<>();
		  ArrayList<Integer> order_id = new ArrayList<>();
		  ArrayList<String> type = new ArrayList<>();

		image_url.add("http://images.newindianexpress.com/uploads/user/imagelibrary/2017/8/31/original/High_tax.jpg");
		image_url.add("http://new.uptecnet.com/Courses/images/Tally.jpg");
		image_url.add("http://vcaglobal.com/wp-content/uploads/2015/10/cld-app-dev-gp1554.png");
		image_url.add("http://www.ejobsnepal.com/wp-content/uploads/2016/03/Untitled-1-19.png");
		image_url.add("http://www.thinkaxiom.com/wp-content/uploads/2015/10/Cloud-Storage.jpg");
		image_url.add("http://www.neonettech.com/sites/all/themes/corporateclean/images/convergence_network.png");
		image_url.add("http://skyseoservice.com/images/web2_ser_img.png");
		order_id.add(0);
		order_id.add(1);
		order_id.add(2);
		order_id.add(3);
		order_id.add(4);
		type.add("DRAGNDROP");
		type.add("LISTENNWRITE");
		type.add("FOUROPTION");

		System.out.println("Hello --- > ");
		FakeFactory factory = new FakeFactory();
		
		Session session = null;
		Transaction tx = null;
		try {
		session = HibernateSessionFactory.getSession();
		for(int p=0; p<10;p++) {
			tx = session.beginTransaction();

		Assessment assessment = new Assessment(getRandomType(type),getRandomChestItem(image_url));
		 Set<Question> questions = new HashSet<Question>(0);

		for(int i=0; i <10; i++) {
			Question que = new Question(factory.paragraph(),factory.sentence());
			 Set<Option> options = new HashSet<Option>(
						0);
			 Set<Answer> answers = new HashSet<Answer>(
						0);
			for(int k=0;k<5;k++) {
				Option option = new Option(getRandomOrderId(order_id),factory.streetName(),que);
				options.add(option);
				Answer answer = new Answer(getRandomOrderId(order_id),factory.streetName(),que);
				answers.add(answer);
				
			}
			
			que.setOptions(options);
			que.setAnswers(answers);
			questions.add(que);
			
		}
		assessment.setQuestions(questions);
		session.save(assessment);
		tx.commit();
		}
		} catch (Exception ex) {
		ex.printStackTrace();
		tx.rollback();
		} finally {
		session.clear();
		session.close();
		}
		System.out.println("Hello --- > emnd");

	}
	
	public static String getRandomChestItem(ArrayList<String> image_url) {
	    try {
	        return image_url.get((new Random()).nextInt(image_url.size()));
	    }
	    catch (Throwable e){
	        return null;
	    }
	}
	public static String getRandomType(ArrayList<String> image_url) {
	    try {
	        return image_url.get((new Random()).nextInt(image_url.size()));
	    }
	    catch (Throwable e){
	        return null;
	    }
	}
	public static Integer getRandomOrderId(ArrayList<Integer> order_id) {
	    try {
	        return order_id.get((new Random()).nextInt(order_id.size()));
	    }
	    catch (Throwable e){
	        return null;
	    }
	}
}
