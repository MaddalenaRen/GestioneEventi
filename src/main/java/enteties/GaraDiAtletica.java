package enteties;


import enumeration.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("ATLETICA")
@NamedQuery(name="getGareDiAtleticaPerVincitore", query = "SELECT g FROM GaraDiAtletica g Where g.vincitore=:vincitore")

public class GaraDiAtletica extends Evento{

    @ManyToMany
    @JoinTable(
            name = "atleti_gara",
            joinColumns = @JoinColumn(name = "gara_id"),
            inverseJoinColumns = @JoinColumn(name = "persona_id")
    )
    private Set<Persona> atleti= new HashSet<>();

    @ManyToOne
    @JoinColumn(name="vincitore_id")
    private Persona vincitore;

    public GaraDiAtletica(){}

    public GaraDiAtletica(String titolo, LocalDate dataEvento, TipoEvento tipoEvento, Set<Persona> atleti, Persona vincitore) {
        super(titolo, dataEvento, tipoEvento);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "atleti=" + atleti +
                ", vincitore='" + vincitore + '\'' +
                '}';
    }
}
