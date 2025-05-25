package dao;

import enteties.*;
import enumeration.Genere;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EventoDao {

    private EntityManager em;

    public EventoDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
    }

    //dovrà salvare nel database lo studente che gli viene passato
    public void salva(Evento evento) {
        em.getTransaction().begin(); //inizio la transazione

        em.persist(evento);//dico al jpa di salvare lo studente sul database

        em.getTransaction().commit();//il salvataggio effettivo avverrà solo al commit
    }


    public Evento getById(int id) {
        return em.find(Evento.class, id);
    }

    public void rimuovi(int id) {
        Evento evento = getById(id);

        if (evento != null) {
            em.getTransaction().begin();
            em.remove(evento);
            em.getTransaction().commit();
        } else {
            System.out.println("Evento con id " + id + " non trovato");
        }


    }

    public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
        TypedQuery<Concerto> query = em.createQuery("select c from Concerto c where c.inStreaming=:streaming", Concerto.class);
        query.setParameter("streaming", inStreaming);
        return query.getResultList();

    }

    public List<Concerto> getConcertiPerGenere(Genere genere) {
        TypedQuery<Concerto> query = em.createQuery("SELECT c FROM Concerto c WHERE c.genere=:genere", Concerto.class);
        query.setParameter("genere", genere);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinceInCasa() {
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("getPartiteVinceInCasa", PartitaDiCalcio.class);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {
        TypedQuery<PartitaDiCalcio> query = em.createQuery("SELECT p FROM PartitaDiCalcio p WHERE p.numeroGolSquadraDiCasa < p.numeroGolSquadraOspite", PartitaDiCalcio.class);
        return query.getResultList();
    }

    public List<PartitaDiCalcio>getPartitePareggiate(){
        TypedQuery<PartitaDiCalcio> query = em.createQuery("SELECT p FROM PartitaDiCalcio p WHERE p.numeroGolSquadraDiCasa = p.numeroGolSquadraOspite", PartitaDiCalcio.class);
        return query.getResultList();
    }

    public List<GaraDiAtletica>  getGareDiAtleticaPerVincitore(Persona vincitore){
        TypedQuery<GaraDiAtletica> query = em.createQuery("SELECT g FROM GaraDiAtletica g Where g.vincitore=:vincitore", GaraDiAtletica.class);
        query.setParameter("vincitore", vincitore);
        return  query.getResultList();
    }

    public List<GaraDiAtletica> getGareDiAtleticaPerPartecipante(Persona partecipante){
        TypedQuery<GaraDiAtletica> query= em.createQuery("SELECT g FROM GaraDiAtletica g WHERE g.partecipante MEMBER OF g.atleti", GaraDiAtletica.class);
        query.setParameter("partecipante", partecipante);
        return query.getResultList();

    }




}
