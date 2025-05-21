package enteties;

import enumeration.Sesso;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="persone")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String cognome;
    private String email;
    @Column(name = "data_di_nascita")
    private LocalDate dataNascita;
    @Enumerated(EnumType.STRING)
    private Sesso sesso;

    @OneToMany (mappedBy = "persona")
    private List<Partecipazione> partecipazioni;


    public Persona(String nome, String cognome, String email, LocalDate dataNascita, Sesso sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataNascita = dataNascita;
        this.sesso = sesso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }

    public List<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    public void setPartecipazioni(List<Partecipazione> partecipazioni) {
        this.partecipazioni = partecipazioni;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", dataNascita=" + dataNascita +
                ", sesso=" + sesso +
                ", partecipazioni=" + partecipazioni +
                '}';
    }
}
