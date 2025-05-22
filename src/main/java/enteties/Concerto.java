package enteties;


import enumeration.Genere;
import enumeration.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("CONCERTO")

public class Concerto extends Evento{
    @Enumerated(EnumType.STRING)
    private Genere genere;
    @Column(name="in_streaming")
    private Boolean inStreaming;

    public Concerto(){};

    public Concerto(String titolo, LocalDate dataEvento, TipoEvento tipoEvento, Genere genere, Boolean inStreaming) {
        super(titolo, dataEvento, tipoEvento);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public Boolean getInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(Boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genere=" + genere +
                ", inStreaming=" + inStreaming +
                '}';
    }
}
