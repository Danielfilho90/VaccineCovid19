package school.cesar.hackaton.project.vaccine.exception.status;

import org.springframework.http.HttpStatus;
import school.cesar.hackaton.project.vaccine.exception.abstracts.AbstractBagException;

public class BadRequestException extends AbstractBagException {

    public BadRequestException() {
        super(HttpStatus.BAD_REQUEST);
    }

}
