package school.cesar.hackaton.project.vaccine.exception.business;

import org.springframework.http.HttpStatus;
import school.cesar.hackaton.project.vaccine.exception.abstracts.AbstractException;

public class VaccineEmptyNameException extends AbstractException {

    public VaccineEmptyNameException() {
        super("You cannot persist a Vaccine without name!", HttpStatus.BAD_REQUEST);
    }

}
