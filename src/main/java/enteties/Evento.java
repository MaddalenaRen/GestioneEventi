package enteties;

import enumeration.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.ListResourceBundle;

@Entity
//@Table (name="eventi")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_evento_spec", discriminatorType = DiscriminatorType.STRING)

public class Evento {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int Id;
    @Column(length = 20,nullable = false)
    private String titolo;
    @Column(name="data_evento")
    private LocalDate dataEvento;
    @Enumerated(EnumType.STRING)
    @Column(name="tipo_evento")
    private TipoEvento tipoEvento;

    @OneToMany(mappedBy="evento")
        private List<Partecipazione> partecipazioni;


    public Evento(){};

    public Evento( String titolo, LocalDate dataEvento, TipoEvento tipoEvento) {

        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.tipoEvento = tipoEvento;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public List<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    public void setPartecipazioni(List<Partecipazione> partecipazioni) {
        this.partecipazioni = partecipazioni;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "Id=" + Id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", tipoEvento=" + tipoEvento +
                ", partecipazioni=" + partecipazioni +
                '}';
    }
}
