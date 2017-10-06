package org.tempuri.pizza.ws;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET; 
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.tempuri.pizza.dto.MenuItem;
import org.tempuri.pizza.dto.Restaurant;
import org.tempuri.pizza.store.*;

@Path("/")
public class RestaurantService {
	
	@GET
	@Path("/restaurants")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Restaurant> getRestaurants() {
		
		List<Restaurant> p0 = new ArrayList<Restaurant>();

		PizzaContext.UnitOfWork(session -> {
			
			for (RestaurantEntity u0 : session.createQuery(
					"select e " +
					"from RestaurantEntity e"
					, RestaurantEntity.class
					).getResultList()) {
				
				AddressEntity a0 = u0.getAddresses().get(0);
				PostalEntity b0 = a0.getPostalEntity();
				
				p0.add(new Restaurant(
						u0.getId()
						, u0.getName()
						, a0.getStreetName() + " " + a0.getStreetNumber()
						, b0.getZip() + " " + b0.getProvince()
						, a0.getLongitude()
						, a0.getLatitude()
						));
			}
		});

		return p0;
	}

	@GET
	@Path("/restaurants/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Restaurant getRestaurant(@PathParam("id") int restaurantId) {
		
		return (Restaurant) PizzaContext.UnitOfWorkWithReturnValue(session -> {
			
			RestaurantEntity r0 = getSingleRestaurantEntity(session, restaurantId);
			
			if (r0 == null)
				return null;

			AddressEntity a0 = r0.getAddresses().get(0);
			PostalEntity b0 = a0.getPostalEntity();
			
			return new Restaurant(
					r0.getId()
					, r0.getName()
					, a0.getStreetName() + " " + a0.getStreetNumber()
					, b0.getZip() + " " + b0.getProvince()
					, a0.getLongitude()
					, a0.getLatitude()
					);
			
		});
	}
	
	@SuppressWarnings("unchecked")
	@GET
	@Path("/restaurants/{id}/menu")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MenuItem> getMenu(
			@PathParam("id") int restaurantId
			, @QueryParam("category") String category
			, @QueryParam("orderBy") String orderBy
			) {
		
		return (List<MenuItem>) PizzaContext.UnitOfWorkWithReturnValue(session -> {
			
			RestaurantEntity r0 = getSingleRestaurantEntity(session, restaurantId);
			
			if (r0 == null)
				return null;
			
			List<MenuItem> p0 = new ArrayList<MenuItem>();
			
			for (DishEntity u0 : r0.getDishes()) {
				
				MenuItem q0 = new MenuItem(
						u0.getId()
						, u0.getName()
						, u0.getCategory()
						, u0.getRank()
						, u0.getPrice());
				
				for (IngredientEntity u1 : u0.getIngredients()) {
					q0.getTopping().add(u1.getName());
				}
				
				p0.add(q0);
			}

			return p0;
		});
	}

	private RestaurantEntity getSingleRestaurantEntity(Session session, int restaurantId) {

		List<RestaurantEntity> l0 = session.createQuery(
				"select e " +
				"from RestaurantEntity e " +
				"where e.id = :id"
				, RestaurantEntity.class
				)
				.setParameter("id", restaurantId)
				.getResultList();

		return l0.isEmpty()
				? null
				: l0.get(0);
	}

	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public void testing() {
		
		PostalEntity p1 = new PostalEntity();

		PizzaContext.UnitOfWork(session -> {
			
			p1.setProvince("Stockholm");
			p1.setZip("111 43");
			
			session.persist(p1);
			
			int _t = p1.getId();
			System.out.println(_t);
			
		});
		
		AddressEntity p2 = new AddressEntity();
		
		PizzaContext.UnitOfWork(session -> {

			p2.setLatitude(59.336078);
			p2.setLongitude(18.071807);
			p2.setStreetName("Kungsgatan");
			p2.setStreetNumber(1);
			
			p1.addAddress(p2);
			p2.setPostalEntity(p1);
			
			session.persist(p2);
			
			int _t = p1.getId();
			int _u = p2.getId();
			System.out.println(_t);
			System.out.println(_u);

		});
		
		RestaurantEntity p3 = new RestaurantEntity();
		
		PizzaContext.UnitOfWork(session -> {
			
			p3.setName("Pizza Heaven");
			p2.setRestaurantEntity(p3);
			p3.addAddress(p2);
			
			session.update(p2);
			session.persist(p3);
			
			int _t = p1.getId();
			int _u = p2.getId();
			int _v = p3.getId();
			System.out.println(_t);
			System.out.println(_u);
			System.out.println(_v);

		});
		
		PostalEntity p4 = new PostalEntity();

		PizzaContext.UnitOfWork(session -> {
			
			p4.setProvince("Stockholm");
			p4.setZip("117 43");
			
			session.persist(p4);
			
			int _t = p4.getId();
			System.out.println(_t);
			
		});
		
		AddressEntity p5 = new AddressEntity();
		
		PizzaContext.UnitOfWork(session -> {

			p5.setLatitude(59.315709);
			p5.setLongitude(18.033507);
			p5.setStreetName("Långholmsgatan");
			p5.setStreetNumber(34);
			
			p4.addAddress(p5);
			p5.setPostalEntity(p1);
			
			session.persist(p5);
			
			int _t = p4.getId();
			int _u = p5.getId();
			System.out.println(_t);
			System.out.println(_u);

		});
		
		RestaurantEntity p6 = new RestaurantEntity();
		
		PizzaContext.UnitOfWork(session -> {
			
			p6.setName("Pizzerian Apan");
			p5.setRestaurantEntity(p6);
			p6.addAddress(p5);
			
			session.update(p5);
			session.persist(p6);
			
			int _t = p4.getId();
			int _u = p5.getId();
			int _v = p6.getId();
			System.out.println(_t);
			System.out.println(_u);
			System.out.println(_v);

		});
		
		IngredientEntity i0 = new IngredientEntity();
		
		PizzaContext.UnitOfWork(session -> {
			
			i0.setName("Tomat");
			session.persist(i0);
			
		});
		
		IngredientEntity i1 = new IngredientEntity();
		
		PizzaContext.UnitOfWork(session -> {
			
			i1.setName("Ost");
			session.persist(i1);
			
		});
		
		IngredientEntity i2 = new IngredientEntity();
		
		PizzaContext.UnitOfWork(session -> {
			
			i2.setName("Skinka");
			session.persist(i2);
			
		});
		
		IngredientEntity i3 = new IngredientEntity();
		
		PizzaContext.UnitOfWork(session -> {
			
			i3.setName("Ananas");
			session.persist(i3);
			
		});
		
		IngredientEntity i4 = new IngredientEntity();
		
		PizzaContext.UnitOfWork(session -> {
			
			i4.setName("Parmaskinka");
			session.persist(i4);
			
		});
		
		IngredientEntity i5 = new IngredientEntity();
		
		PizzaContext.UnitOfWork(session -> {
			
			i5.setName("Oliver");
			session.persist(i5);
			
		});
		
		IngredientEntity i6 = new IngredientEntity();
		
		PizzaContext.UnitOfWork(session -> {
			
			i6.setName("Färsk basilika");
			session.persist(i6);
			
		});
		
		DishEntity d0 = new DishEntity();
		
		PizzaContext.UnitOfWork(session -> {
			
			d0.addDish(i0);
			d0.addDish(i1);
			d0.addDish(i2);
			d0.setCategory("Pizza");
			d0.setName("Vesuvius");
			d0.setPrice(79);
			d0.setRank(3);
			
			session.update(i0);
			session.update(i1);
			session.update(i2);
			session.persist(d0);
			
		});
		
		DishEntity d1 = new DishEntity();
		
		PizzaContext.UnitOfWork(session -> {
			
			d1.addDish(i0);
			d1.addDish(i1);
			d1.addDish(i2);
			d1.addDish(i3);
			d1.setCategory("Pizza");
			d1.setName("Hawaii");
			d1.setPrice(79);
			d1.setRank(1);
			
			session.update(i0);
			session.update(i1);
			session.update(i2);
			session.update(i3);
			session.persist(d1);
			
		});
		
		PizzaContext.UnitOfWork(session -> {
			
			p3.addDish(d0);
			p3.addDish(d1);
			d0.addRestaurant(p3);
			d1.addRestaurant(p3);

			session.update(p3);
			session.update(d0);
			
		});
		
		PizzaContext.UnitOfWork(session -> {
			
			p6.addDish(d0);
			d0.addRestaurant(p6);

			session.update(p6);
			session.update(d0);
			
		});
		
	}
}
