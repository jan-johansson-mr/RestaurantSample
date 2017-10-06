package org.tempuri.pizza.ws;

import java.util.ArrayList;
import java.util.List; 
import javax.ws.rs.GET; 
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;

import org.tempuri.pizza.dto.Restaurant;  

@Path("/")
public class OrderService {
	
	private static final String SUCCESS_RESULT="<result>success</result>";
	private static final String FAILURE_RESULT="<result>failure</result>";	

	@GET
	@Path("/orders")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Restaurant> getOrders() {
		List<Restaurant> p0 = new ArrayList<Restaurant>();
		p0.add(new Restaurant(1, "Pizza Heaven", "Kungsgatan 1", "111 43 Stockholm", 59.336078, 18.071807));
		p0.add(new Restaurant(2, "Pizzeria Apan", "Långholmsgatan 34", "117 33 Stockholm", 59.315709, 18.033507));
		return p0;
	}

}
