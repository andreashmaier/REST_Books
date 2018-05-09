package de.gbsschulen.rest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CityService {

    private EntityManagerFactory emf;
    private EntityManager em;

    public CityService() {
        emf = Persistence.createEntityManagerFactory("cities");
        em = emf.createEntityManager();
    }

    public void close() {
        if (em != null) {
            em.close();
        }

        if (emf != null) {
            emf.close();
        }
    }

    public City getCity(int id) {
        return em.find(City.class, id);
    }

    public List<City> getAllCities() {
        TypedQuery<City> typedQuery = em.createQuery("SELECT c from City c", City.class);
        return typedQuery.getResultList();
    }
}
