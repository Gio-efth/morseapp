package gr.aueb.cf.morseapp.rest;

import gr.aueb.cf.morseapp.authentication.AuthenticationService;
import gr.aueb.cf.morseapp.dto.AuthenticationRequestDTO;
import gr.aueb.cf.morseapp.dto.AuthenticationResponseDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "login", description = "Ενέργειες σύνδεσης χρήστη με JWT")
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDTO> login(@RequestBody @Valid AuthenticationRequestDTO request) {
        AuthenticationResponseDTO response = authenticationService.authenticate(request);
        return ResponseEntity.ok(response);
    }
}
