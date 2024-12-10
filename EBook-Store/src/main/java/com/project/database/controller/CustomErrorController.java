package com.project.database.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public ResponseEntity<Object> handleError() {
        // Créez un objet Map pour contenir les détails de l'erreur
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("message", "Ressource non trouvée");
        errorDetails.put("status", HttpStatus.NOT_FOUND.value());
        errorDetails.put("timestamp", System.currentTimeMillis());

        // Vous pouvez ajouter d'autres détails personnalisés selon vos besoins

        // Retournez l'objet Map dans la réponse JSON avec le statut approprié
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
