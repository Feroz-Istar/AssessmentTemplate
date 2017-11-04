package services;

import java.io.IOException;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.Assessment;
import com.Question;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import util.HibernateSessionFactory;

/**
 * Servlet implementation class AssessmentService
 */
@WebServlet("/assessmentService")
public class AssessmentService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GsonBuilder gsonBuilder = new GsonBuilder();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssessmentService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Assessment assessment = null;
		Session session = null;
		Transaction tx = null;
		try {
		session = HibernateSessionFactory.getSession();
		tx = session.beginTransaction();
		System.out.println(Integer.parseInt(request.getParameter("assessment_id"))+"");
		assessment =  (Assessment) session.get(Assessment.class, 8);
		
		tx.commit();
		}
		 catch (Exception ex) {
		ex.printStackTrace();
		tx.rollback();
		} finally {
		session.clear();
		session.close();
		}
		if(assessment != null) {
			try {
				
				
				Gson gson = new GsonBuilder()
		                .excludeFieldsWithoutExposeAnnotation()
		                .create();

//				GsonBuilder gsonBuilder = new GsonBuilder();
//				new GraphAdapterBuilder()
//				    .addType(Question.class)
//				    .registerOn(gsonBuilder);
				//Gson gson = gsonBuilder.create();
			response.getWriter().print(gson.toJson(assessment).toString());
			}catch(JsonSyntaxException jse) {
				jse.printStackTrace();
			}
		}else {
			response.getWriter().println("No assessment found!");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private static Gson buildGson() {
	    return new GsonBuilder().addSerializationExclusionStrategy( getExclusionStrategy() ).create();  
	}

	private static ExclusionStrategy getExclusionStrategy() {
	    ExclusionStrategy exlStrategy = new ExclusionStrategy() {
	        @Override
	        public boolean shouldSkipField(FieldAttributes fas) {
	            return ( null != fas.getAnnotation(ManyToMany.class) );
	        }
	        @Override
	        public boolean shouldSkipClass(Class<?> classO) {
	            return ( null != classO.getAnnotation(ManyToMany.class) );
	        }
	    };
	    return exlStrategy;
	} 
}
