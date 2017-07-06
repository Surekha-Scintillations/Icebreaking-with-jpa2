package org.scintillations.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaApplication {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("library");
		EntityManager em = factory.createEntityManager();

		Book book = new Book();
		book.setIsbn(1234);
		book.setTitle("JPA 2.0");

		em.getTransaction().begin();
		em.persist(book);
		em.getTransaction().commit();

		Book results = em.find(Book.class, 1234);
		System.out.println("Found: " + results.getTitle());
		em.close();

	}
}
