package school.cesar.hackaton.project.vaccine.exception.business;

import org.springframework.http.HttpStatus;
import school.cesar.hackaton.project.vaccine.exception.abstracts.AbstractException;

public class VaccineZeroDoseQuantityException extends AbstractException {

    public VaccineZeroDoseQuantityException() {
        super("You cannot persist a Vaccine without dose quantity!", HttpStatus.BAD_REQUEST);
    }

}
