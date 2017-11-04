package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.Question;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import services.question.QuestionService;

@Path("/question")
public class RestQuestionApi {
	private Gson gson;

	@GET
	@Path("/all/{assessment_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllGroupDetails(@PathParam("assessment_id") Integer assessmentId) {
		gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		long currentTime = System.currentTimeMillis();
		QuestionService questionservice = new QuestionService();
		String json = "No Questions In This Assessment ";
		System.err.println("-----------------> " + json);
		if (assessmentId != null) {
			List<Question> questions = questionservice.getAllQusetionsDetails(assessmentId);

			json = gson.toJson(questions);

			System.out.println(json);

		}

		System.out.println("time taken " + (System.currentTimeMillis() - currentTime) + " ms ");
		return Response.status(200).entity(json).build();
	}

}
