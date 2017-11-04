package templates;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Assessment;
import com.Question;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.AssessmentDAO;
import util.HibernateSessionFactory;

public class AssessmentFindById {
	
	public static void main(String args[]) {
		Session session = null;
		Transaction tx = null;
		try {
		session = HibernateSessionFactory.getSession();
		tx = session.beginTransaction();
		Integer assid = 8;
        Assessment assessment = new AssessmentDAO().findById(8);
       

		Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        System.out.println(gson.toJson(assessment));
//        System.out.println(assessment.getQuestions().size());
//        	for(Question e : assessment.getQuestions()) {
//        		System.out.println(e.getOptions().size());
//        	}
		tx.commit();
		}
		 catch (Exception ex) {
		ex.printStackTrace();
		tx.rollback();
		} finally {
		session.clear();
		session.close();
		}
	}

}
