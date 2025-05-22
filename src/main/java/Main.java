import dao.EventoDao;
import dao.LocationDao;
import dao.PartecipazioneDao;
import dao.PersonaDao;
import enteties.Evento;
import enteties.Location;
import enteties.Partecipazione;
import enteties.Persona;
import enumeration.Sesso;
import enumeration.Stato;
import enumeration.TipoEvento;

import java.time.LocalDate;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        LocationDao locatioDao = new LocationDao();
        PersonaDao personaDao = new PersonaDao();
        EventoDao eventodao = new EventoDao();
        PartecipazioneDao partecipazioneDao = new PartecipazioneDao();

        // Crea un ID casuale tra 10 e 999
        //int idCasuale = new Random().nextInt(10, 1000);


        Evento e1 = new Evento("EVENTO-BENEFICENZA", LocalDate.of(2025, 6, 10), TipoEvento.PUBBLICO);
        Evento e2 = new Evento("Concerto", LocalDate.of(2025, 6, 20), TipoEvento.PUBBLICO);
        eventodao.salva(e1);
        eventodao.salva(e2);


        Location location1 = new Location("Villa", "Firenze");
        location1.setEvento(e1);
        Location location2 = new Location("Villa2", "Roma");
        location2.setEvento(e2);


        locatioDao.salva(location1);
        locatioDao.salva(location2);

        Persona p1= new Persona("Anna", "Verdi", "anna@gmail.com",LocalDate.of(2025, 7, 10), Sesso.F);
        Persona p2= new Persona("Mario", "Verdi", "anna@gmail.com",LocalDate.of(2025, 7, 10), Sesso.M);



        personaDao.salva(p1);
        personaDao.salva(p2);

        Partecipazione part1 = new Partecipazione(Stato.CONFERMATA);
        Partecipazione part2 = new Partecipazione(Stato.CONFERMATA);

        partecipazioneDao.salva(part1);
        partecipazioneDao.salva(part2);

        part1.setEvento(e1);
        part2.setEvento(e2);
        part1.setPersona(p1);
        part2.setPersona(p2);

        partecipazioneDao.salva(part1);
        partecipazioneDao.salva(part2);




    }

}
