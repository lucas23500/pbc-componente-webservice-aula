package ifam.pbccomponentewebserviceaula.controller;

import br.ifam.edu.pbc.base.Logger;
import br.ifam.edu.pbc.exception.LoggerException;
import br.ifam.edu.pbc.exceptions.ValidationException;
import br.ifam.edu.pbc.validators.NameValidator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/validation")
public class ValidationController {

    @GetMapping(value="/name/{input}")
    public String validateName(@PathVariable("input") String input){


        try {

            NameValidator validator = new NameValidator(
                    "Name",
                    "deve conter apenas letras e espaço",
                    new Logger()
                    );

            validator.check(input);

            return "PASSOU: " + input;

        } catch (LoggerException | ValidationException | IOException e) {
            return "NÂO PASSOU: " + e.getMessage();
        }


    }

}
