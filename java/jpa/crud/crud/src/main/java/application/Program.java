package application;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.entities.Person;

import java.time.Instant;

public class Program {
    public static void main(String[] args) {

        Person person = new Person(null, "Bob Brown",
                "bob@gmail.com", Instant.parse("1990-04-11T00:00:00Z"));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("course-jpa");
        EntityManager em = emf.createEntityManager();

        //Todas as operações, exceto as de leitura, exigem um transaction para garantir a consistência dos dados
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();

        Person person1 = em.find(Person.class, 2);
        System.out.println(person1);

        em.getTransaction().begin();
        Person p = em.find(Person.class, 5);
        em.remove(p); //Com entityManager, só pode ser deletado se o obj estiver sendo monitorado
        em.getTransaction().commit();



        em.close();
        emf.close();
    }
}
