package tech.chillo.imc;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class ImcService {

    ImcRepository imcRepository;
    public Map<String, String> caculate(Imc data) {
        double imc = data.getPoids() / Math.pow(data.getTaille(), 2);
        String advice = this.analyse(imc);
        data.setAdvice(advice);
        data.setValue(imc);
        this.imcRepository.save(data);
        return Map.of(
                "imc", String.valueOf(imc),
                "avis", advice

        );
    }
 public List<Imc> search() {
       return this.imcRepository.findAll();

    }

    private String analyse(double imc) {
        if( imc < 16.5) return "ELEVE";
        if (imc >= 16.5 && imc < 18.5) return "ACCRU";
        if (imc >= 18.5 && imc < 25) return "NORMALE";
        if (imc >= 25 && imc < 30) return "Surpoids";
        if (imc >= 30 && imc < 36) return "Elevé";
        if (imc >= 35 && imc < 40) return "Très élevé";
        if (imc >= 40) return "Obèse";
        return "RAS";
    }
}
