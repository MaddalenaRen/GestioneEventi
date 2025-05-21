package dao;

import enteties.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EventoDao {

    private EntityManager em;

    public EventoDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
    }

    //dovrà salvare nel database lo studente che gli viene passato
    public void salva(Evento evento){
        em.getTransaction().begin(); //inizio la transazione

        em.persist(evento);//dico al jpa di salvare lo studente sul database

        em.getTransaction().commit();//il salvataggio effettivo avverrà solo al commit
    }


    public Evento getById(int id){
        return em.find(Evento.class,id);
    }

    public void rimuovi(int id){
        Evento evento = getById(id);

        if(evento!=null){
            em.getTransaction().begin();
            em.remove(evento);
            em.getTransaction().commit();
        }
        else{
            System.out.println("Evento con id " + id+ " non trovato");
        }

    }
}
