package enteties;

import jakarta.persistence.*;

@Entity
@Table(name="locations")

public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String citta;

    @OneToOne //relazione One to One tra studente e diploma unidirezionale
    @JoinColumn(name="evento_id")
    private Evento evento;

    public Location(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;

    }

    public Location() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", citta='" + citta + '\'' +
                ", evento=" + evento +
                '}';
    }
}
