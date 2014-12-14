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
import Model.Network;

@Path("networks")
public class NetworkResource {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	@GET
	@Path("getAllNetworks")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public GenericEntity<List<Network>> getAllNetworks() throws Exception {
		LogicFactory.Connect();
		List<Network> networks = LogicFactory.getNetworkLogic().getAllNetworks();
		LogicFactory.Disconnect();
		return new GenericEntity<List<Network>>(networks) {};
	}
}
