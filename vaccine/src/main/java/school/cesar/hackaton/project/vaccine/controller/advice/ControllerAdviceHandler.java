package school.cesar.hackaton.project.vaccine.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import school.cesar.hackaton.project.vaccine.exception.status.BadRequestException;
import school.cesar.hackaton.project.vaccine.exception.status.NotFoundException;

@ControllerAdvice
public class ControllerAdviceHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public @ResponseBody String notFoundHandler(final NotFoundException exception) {
        return exception.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public @ResponseBody String badRequestHandler(final BadRequestException exception) {
        return exception.getMessage();
    }

}
