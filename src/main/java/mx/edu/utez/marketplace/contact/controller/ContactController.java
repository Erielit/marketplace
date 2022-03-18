package mx.edu.utez.marketplace.contact.controller;

import mx.edu.utez.marketplace.utils.EmailService;
import mx.edu.utez.marketplace.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = {"*"})
public class ContactController {
    @Autowired
    EmailService emailService;

    @PostMapping("/")
    public ResponseEntity<Message> sendMailContact(@RequestBody EmailDTO email, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(new Message("Verifique los datos", true, null), HttpStatus.BAD_REQUEST);
        }
        if (emailService.sendEmail(email)) {
            return new ResponseEntity<>(new Message("Correo electrónico enviado correctamente", false, email),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Message("Error al envíar el correo electrónico", true, null),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
