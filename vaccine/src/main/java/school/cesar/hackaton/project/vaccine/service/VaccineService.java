package school.cesar.hackaton.project.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import school.cesar.hackaton.project.vaccine.entity.Vaccine;
import school.cesar.hackaton.project.vaccine.exception.business.VaccineEmptyNameException;
import school.cesar.hackaton.project.vaccine.exception.abstracts.AbstractBagException;
import school.cesar.hackaton.project.vaccine.exception.business.VaccineNotFoundException;
import school.cesar.hackaton.project.vaccine.exception.business.VaccineZeroDoseQuantityException;
import school.cesar.hackaton.project.vaccine.exception.status.BadRequestException;
import school.cesar.hackaton.project.vaccine.repository.VaccineRepository;
import java.util.List;

@Service
public class VaccineService {

    private final VaccineRepository vaccineRepository;

    @Autowired
    public VaccineService(final VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }

    @Transactional(readOnly = true)
    public List<Vaccine> list(final String name) {
        if(name!=null && !name.trim().isEmpty()) {
            return this.vaccineRepository.findByNameContainingOrderByNameAsc(name);
        } else {
            return this.vaccineRepository.findAll();
        }
    }

    @Transactional(readOnly = true)
    public Vaccine get(final Long id) {
        return this.vaccineRepository.findById(id)
                .orElseThrow(() -> new VaccineNotFoundException(id));
    }

    @Transactional
    public Vaccine update(final Long id, final Vaccine updatedVaccine) {
        return this.vaccineRepository.findById(id)
                .map(vaccine -> {
                    this.validateVaccine(updatedVaccine);

                    vaccine.setName(updatedVaccine.getName());
                    vaccine.setDoseQuantity(updatedVaccine.getDoseQuantity());

                    return this.vaccineRepository.save(vaccine);
                })
                .orElseThrow(() -> new VaccineNotFoundException(id));
    }

    @Transactional
    public Vaccine updatePartially(final Long id, final Vaccine updatedVaccine) {
        return this.vaccineRepository.findById(id)
                .map(vaccine -> {
                    if(updatedVaccine.getName()!=null && !updatedVaccine.getName().trim().isEmpty()) {
                        vaccine.setName(updatedVaccine.getName());
                    }

                    if(updatedVaccine.getDoseQuantity()!=null && updatedVaccine.getDoseQuantity()!=0) {
                        vaccine.setDoseQuantity(updatedVaccine.getDoseQuantity());
                    }

                    return this.vaccineRepository.save(vaccine);
                })
                .orElseThrow(() -> new VaccineNotFoundException(id));
    }

    @Transactional
    public Vaccine save(final Vaccine vaccine) {
        this.validateVaccine(vaccine);
        return this.vaccineRepository.save(vaccine);
    }

    @Transactional
    public void delete(final Long id) {
        this.vaccineRepository.delete(
                this.vaccineRepository.findById(id)
                        .orElseThrow(() -> new VaccineNotFoundException(id))
        );
    }

    private void validateVaccine(final Vaccine vaccine) {
        final AbstractBagException exception = new BadRequestException();

        if(vaccine.getName()==null || vaccine.getName().trim().isEmpty()) {
            exception.addException(new VaccineEmptyNameException());
        }

        if(vaccine.getDoseQuantity()==null || vaccine.getDoseQuantity()==0) {
            exception.addException(new VaccineZeroDoseQuantityException());
        }

        if(!exception.isEmpty()) {
            throw exception;
        }
    }

}
