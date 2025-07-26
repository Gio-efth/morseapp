package gr.aueb.cf.morseapp.authentication;

import gr.aueb.cf.morseapp.dto.AuthenticationRequestDTO;
import gr.aueb.cf.morseapp.dto.AuthenticationResponseDTO;
import gr.aueb.cf.morseapp.model.User;
import gr.aueb.cf.morseapp.repository.UserRepository;
import gr.aueb.cf.morseapp.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationResponseDTO authenticate(AuthenticationRequestDTO request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user = userRepository
                .findByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String jwtToken = jwtService.generateToken(
                user.getUsername(),
                user.getRole().name()
        );

        return new AuthenticationResponseDTO(jwtToken, user.getUsername(), user.getRole().name());
    }
}
