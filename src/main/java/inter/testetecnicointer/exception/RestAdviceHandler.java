package inter.testetecnicointer.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class RestAdviceHandler {


    @ExceptionHandler(NumeroInvalidoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String camposAcimaDoPermitido() {

        return "Mana e Heath não pode ser menor que 0 ou maior que 100";
    }


    @ExceptionHandler(AtributosZeradosExcetion.class)
    @ResponseStatus(HttpStatus.GONE)
    public String manaOuHealthZero() {

        return "o herói não está em condições de combater no momento";
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageGlobalException CamposInvalidos(MethodArgumentNotValidException exception) {
        var erros = exception.getFieldErrors();

        List<ErrorValidation> errorValidations = erros.stream().map(ErrorValidation::new).toList();

        return new MessageGlobalException(LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(), "error fields", errorValidations);
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String CamposInvalidos() {

        return "só é permitido os tipos 'melee', 'spell', 'win' e 'lose' ";
    }


    @ExceptionHandler(NumeroPlayersInvalidoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String numeroPlayersInvalido() {

        return "É necessario possuir 5 jogadores";

    }

    @ExceptionHandler(HeroNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String heroNotFound() {

        return "heroi não existe";
    }

    @ExceptionHandler(PartyNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String PartyNotFound() {

        return "Partida não existe";
    }



}
