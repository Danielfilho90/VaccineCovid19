package school.cesar.hackaton.project.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import school.cesar.hackaton.project.vaccine.entity.Vaccine;
import school.cesar.hackaton.project.vaccine.service.VaccineService;
import java.util.List;

@RestController
@RequestMapping({ "/vaccine" })
public class VaccineController {

    private final VaccineService vaccineService;

    @Autowired
    public VaccineController(final VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @GetMapping({ "", "/" })
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<Vaccine> list(@RequestParam(required = false) final String name) {
        return this.vaccineService.list(name);
    }

    @GetMapping({ "/{id}", "/{id}/"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Vaccine get(@PathVariable(value="id") final Long id) {
        return this.vaccineService.get(id);
    }

    @PutMapping({ "/{id}", "/{id}/"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Vaccine update(@PathVariable(value="id") final Long id, @RequestBody final Vaccine vaccine) {
        return this.vaccineService.update(id, vaccine);
    }

    @PatchMapping({ "/{id}", "/{id}/"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Vaccine updatePartially(@PathVariable(value="id") final Long id, @RequestBody final Vaccine vaccine) {
        return this.vaccineService.updatePartially(id, vaccine);
    }

    @PostMapping({ "", "/" })
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Vaccine save(@RequestBody final Vaccine vaccine) {
        return this.vaccineService.save(vaccine);
    }

    @DeleteMapping({ "/{id}", "/{id}/"})
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable(value="id") final Long id) {
        this.vaccineService.delete(id);
    }

}
