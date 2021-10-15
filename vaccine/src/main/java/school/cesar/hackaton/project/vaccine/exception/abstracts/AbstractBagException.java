package school.cesar.hackaton.project.vaccine.exception.abstracts;

import org.springframework.http.HttpStatus;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class AbstractBagException extends RuntimeException {

    private final HttpStatus httpStatus;

    private final Set<AbstractException> exceptions;

    protected AbstractBagException(final HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.exceptions = new LinkedHashSet<>();
    }

    public void addException(final AbstractException exception) {
        if(!this.httpStatus.equals(exception.getHttpStatus())) {
            throw new IllegalArgumentException();
        }

        this.exceptions.add(exception);
    }

    @Override
    public String getMessage() {
        StringBuilder message = new StringBuilder();

        for(AbstractException exception : this.exceptions) {
            message.append(exception.getMessage());
            message.append("\n");
        }

        return message.toString();
    }

    public boolean isEmpty() {
        return this.exceptions.isEmpty();
    }

}
