package Resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import java.util.List;

import Logic.LogicFactory;
import Model.Test;

@Path("test")
public class TestResource {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	@GET
	@Path("getall")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public GenericEntity<List<Test>> getAllTests() throws Exception {
		LogicFactory.Connect();
		List<Test> tests = LogicFactory.getTestLogic().getAllTests();
		LogicFactory.Disconnect();
		return new GenericEntity<List<Test>>(tests) {};
	}
	
	@PUT
	@Path("create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void createTest(Test test) throws Exception {
		LogicFactory.Connect();
		LogicFactory.getTestLogic().createTest(test);
		LogicFactory.Disconnect();
	}

}
