package tech.chillo.imc;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@AllArgsConstructor
@RestController
@RequestMapping(path = "imc")
public class ImcController {

    private ImcService imcService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public @ResponseBody Map<String, String> caculate(@RequestBody Imc data) {
        return imcService.caculate(data);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Imc> search() {
        return this.imcService.search();

    }
}
