package school.cesar.hackaton.project.vaccine.exception.business;

import org.springframework.http.HttpStatus;
import school.cesar.hackaton.project.vaccine.exception.abstracts.AbstractException;

public class VaccineNotFoundException extends AbstractException {

    public VaccineNotFoundException(final Long id) {
        super(String.format("Could not find Vaccine with ID %d!", id), HttpStatus.NOT_FOUND);
    }

}
