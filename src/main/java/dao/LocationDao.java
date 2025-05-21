package dao;

import enteties.Evento;
import enteties.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LocationDao {
    private EntityManager em;

    public LocationDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
    }

    //dovrà salvare nel database lo studente che gli viene passato
    public void salva(Location location){
        em.getTransaction().begin(); //inizio la transazione

        em.persist(location);//dico al jpa di salvare lo studente sul database

        em.getTransaction().commit();//il salvataggio effettivo avverrà solo al commit
    }


    public Location getById(int id){
        return em.find(Location.class,id);
    }

    public void rimuovi(int id){
        Location location = getById(id);

        if(location!=null){
            em.getTransaction().begin();
            em.remove(location);
            em.getTransaction().commit();
        }
        else{
            System.out.println("Location con id " + id+ " non trovato");
        }

    }
}
