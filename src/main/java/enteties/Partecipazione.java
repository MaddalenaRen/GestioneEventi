package enteties;

import enumeration.Stato;
import jakarta.persistence.*;

@Entity
@Table(name="partecipazioni")

public class Partecipazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="persona_id")
    private Persona persona;
    @ManyToOne
    @JoinColumn(name="evento_id")
    private Evento evento;
    @Enumerated(EnumType.STRING)
    private Stato stato;

    public Partecipazione(Stato stato) {
        this.stato = stato;
    }

    public Partecipazione() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona +
                ", evento=" + evento +
                ", stato=" + stato +
                '}';
    }
}
