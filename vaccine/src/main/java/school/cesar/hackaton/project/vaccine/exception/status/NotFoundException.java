package school.cesar.hackaton.project.vaccine.exception.status;

import org.springframework.http.HttpStatus;
import school.cesar.hackaton.project.vaccine.exception.abstracts.AbstractBagException;

public class NotFoundException extends AbstractBagException {

    public NotFoundException() {
        super(HttpStatus.NOT_FOUND);
    }

}
