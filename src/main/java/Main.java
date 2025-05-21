import dao.EventoDao;
import enteties.Evento;
import enumeration.TipoEvento;

import java.time.LocalDate;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        EventoDao dao = new EventoDao();

        // Crea un ID casuale tra 10 e 999
        int idCasuale = new Random().nextInt(10, 1000);

        Evento e1 = new Evento(idCasuale, "EVENTO-BENEFICENZA", LocalDate.of(2025, 6, 10), TipoEvento.PUBBLICO);

        try {
            dao.salva(e1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(dao.getById(e1.getId()));
        //dao.rimuovi(e1.getId());
    }
}
