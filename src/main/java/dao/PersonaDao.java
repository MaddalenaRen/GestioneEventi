package dao;

import enteties.Evento;
import enteties.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersonaDao {
    private EntityManager em;

    public PersonaDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
    }

    //dovrà salvare nel database lo studente che gli viene passato
    public void salva(Persona persona){
        em.getTransaction().begin(); //inizio la transazione

        em.persist(persona);//dico al jpa di salvare lo studente sul database

        em.getTransaction().commit();//il salvataggio effettivo avverrà solo al commit
    }


    public Persona getById(int id){
        return em.find(Persona.class,id);
    }

    public void rimuovi(int id){
        Persona persona = getById(id);

        if(persona!=null){
            em.getTransaction().begin();
            em.remove(persona);
            em.getTransaction().commit();
        }
        else{
            System.out.println("Persona con id " + id+ " non trovato");
        }

    }
}
