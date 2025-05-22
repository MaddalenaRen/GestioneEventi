package enteties;
import enumeration.TipoEvento;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import org.hibernate.annotations.NamedQueries;

import java.time.LocalDate;

@Entity
@NamedQuery(name="getPartiteVinceInCasa", query = "SELECT p FROM PartitaDiCalcio p WHERE p.numeroGolSquadraDiCasa > p.numeroGolSquadraOspite")
@NamedQuery(name="getPartiteVinteInTrasferta", query = "SELECT p FROM PartitaDiCalcio p WHERE p.numeroGolSquadraDiCasa < p.numeroGolSquadraOspite")
@NamedQuery(name="getPartitePareggiate", query = "SELECT p FROM PartitaDiCalcio p WHERE p.numeroGolSquadraDiCasa = p.numeroGolSquadraOspite")
@DiscriminatorValue("CALCIO")

public class PartitaDiCalcio extends Evento{
    @Column(name="squadra_di_casa")
    private String squadraDiCasa;
    @Column(name="squadra_ospite")
    private String ospite;
    @Column(name="squadra_vincente")
    private String vincente;
    @Column(name="gol_casa")
    private int numeroGolSquadraDiCasa;
    @Column(name="gol_ospite")
    private int numeroGolSquadraOspite;

    public PartitaDiCalcio() {}

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, TipoEvento tipoEvento, String squadraDiCasa, String ospite, String vincente, int numeroGolSquadraDiCasa, int numeroGolSquadraOspite) {
        super(titolo, dataEvento, tipoEvento);
        this.squadraDiCasa = squadraDiCasa;
        this.ospite = ospite;
        this.vincente = vincente;
        this.numeroGolSquadraDiCasa = numeroGolSquadraDiCasa;
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;
    }

    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public String getOspite() {
        return ospite;
    }

    public void setOspite(String ospite) {
        this.ospite = ospite;
    }

    public String getVincente() {
        return vincente;
    }

    public void setVincente(String vincente) {
        this.vincente = vincente;
    }

    public int getNumeroGolSquadraDiCasa() {
        return numeroGolSquadraDiCasa;
    }

    public void setNumeroGolSquadraDiCasa(int numeroGolSquadraDiCasa) {
        this.numeroGolSquadraDiCasa = numeroGolSquadraDiCasa;
    }

    public int getNumeroGolSquadraOspite() {
        return numeroGolSquadraOspite;
    }

    public void setNumeroGolSquadraOspite(int numeroGolSquadraOspite) {
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadraDiCasa='" + squadraDiCasa + '\'' +
                ", ospite='" + ospite + '\'' +
                ", vincente='" + vincente + '\'' +
                ", numeroGolSquadraDiCasa=" + numeroGolSquadraDiCasa +
                ", numeroGolSquadraOspite=" + numeroGolSquadraOspite +
                '}';
    }
}
