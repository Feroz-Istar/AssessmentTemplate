package services.question;

import java.util.ArrayList;
import java.util.List;

import com.Assessment;
import com.Question;

import dao.AssessmentDAO;

public class QuestionService {

	public List<Question> getAllQusetionsDetails(Integer assessmentId) {

		List<Question> questions = new ArrayList<Question>();

		if (assessmentId != null) {
			Assessment assessment = new AssessmentDAO().findById(assessmentId);

			if (assessment != null) {

				if (assessment.getQuestions() != null && assessment.getQuestions().size() != 0) {

					for (Question question : assessment.getQuestions()) {

						questions.add(question);
					}

				}

			}

		}

		return questions;

	}

}
