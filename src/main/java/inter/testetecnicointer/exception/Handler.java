package inter.testetecnicointer.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
@Slf4j
public class Handler {


    @ExceptionHandler(NumeroInvalidoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String camposAcimaDoPermitido() {

        return "Mana e Heath não pode ser menor que 0 ou maior que 100";
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String CamposInvalidos(MethodArgumentNotValidException e) {

        return Objects.requireNonNull(e.getFieldError()).getDefaultMessage();
    }




    @ExceptionHandler(NumeroPlayersInvalidoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String numeroPlayersInvalido() {

        return "É necessario possuir 5 jogadores";

    }

    @ExceptionHandler(EntityNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound() {

        return "Recurso nao existe";
    }


}
