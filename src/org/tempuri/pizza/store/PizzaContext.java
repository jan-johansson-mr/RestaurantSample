package org.tempuri.pizza.store;

import java.util.function.Consumer;
import java.util.function.Function;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PizzaContext {
	
	private static SessionFactory sessionFactory = new Configuration()
			.configure()
			.addAnnotatedClass(RestaurantEntity.class)
			.addAnnotatedClass(PostalEntity.class)
			.addAnnotatedClass(AddressEntity.class)
			.addAnnotatedClass(DishEntity.class)
			.addAnnotatedClass(IngredientEntity.class)
			.buildSessionFactory();

	public static void UnitOfWork(Consumer<Session> action) {
		
		Session p0 = sessionFactory.openSession();
		Transaction t0 = p0.getTransaction();
		
		t0.begin();
		
		try {
			action.accept(p0);
			t0.commit();
		} catch (Exception ex) {
			t0.rollback();
			throw ex;
		} finally {
			p0.clear();
			p0.close();
		}

	}

	public static Object UnitOfWorkWithReturnValue(Function<Session, Object> action) {
		
		Session p0 = sessionFactory.openSession();
		Transaction t0 = p0.getTransaction();
		
		t0.begin();
		
		try {
			Object q0 = action.apply(p0);
			t0.commit();
			return q0;
		} catch (Exception ex) {
			t0.rollback();
			throw ex;
		} finally {
			p0.clear();
			p0.close();
		}

	}
}
