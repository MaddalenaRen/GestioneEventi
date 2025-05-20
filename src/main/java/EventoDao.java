import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EventoDao {

    private EntityManager em;

    public EventoDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
    }
    public void salva(Evento evento){
        em.getTransaction().begin(); //creiamo una transazione
        em.persist(evento); //dico al JPA di salvare lo studente sul DB
        em.getTransaction().commit();//Salvataggio effettivo
    }

    public Evento getById(int Id){
        return em.find(Evento.class,Id);
    }

    public void rimuovi  (int Id){
        Evento s= getById(Id);
        if (s!=null) {
            em.getTransaction().begin();
            em.remove(s);
            em.getTransaction().commit();
        } else  {
            System.out.println("Evento:  " + Id + "non trovato");
        }
    }
    public void clode(){
        em.close();
    }
}
