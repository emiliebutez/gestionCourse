apackage com.mycompany.gestioncourses.services;

import com.mycompany.gestioncourses.models.Etape;
import com.mycompany.gestioncourses.models.Etat;
import com.mycompany.gestioncourses.models.EtatEtape;

public class EtapeService {
    private static EtapeService INSTANCE;

    public synchronized static EtapeService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EtapeService();
        }

        return INSTANCE;
    }

    private EtapeService() { 
        
    }
    
    public Etape lancerEtape(Etape etape){
        etape.setEtatEtape(EtatEtape.Lancee);
        etape.save();
        return etape;
    }
        
    public Etape cloturerEtape(Etape etape){
        etape.getPerformances()
                .stream()
                .filter(p -> p.getTemps() == 0)
                .forEach(p -> p.getParticipation().setEtatParticipation(Etat.Eliminee));
        etape.setEtatEtape(EtatEtape.Cloturee);
        etape.save();
        return etape;
    }
}
