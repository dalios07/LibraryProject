package com.example.demo.services;

import com.example.demo.Exceptions.ResourceNotFoundException;
import com.example.demo.dtos.AuthenticationRequest;
import com.example.demo.dtos.AuthenticationResponse;
import com.example.demo.dtos.RegisterDto;
import com.example.demo.entites.User;
import com.example.demo.mappers.RegisterMapper;
import com.example.demo.repositories.UserRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class AuthenticationServiceImp implements AuthenticationService {

    private final RegisterMapper RegisterMapper;
    private final UserRepo UserRepo;
    private final AuthenticationManager authenticationManager;
    private final JwtService  jwtService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User Register(RegisterDto registerDto)
    {
        User user = RegisterMapper.toUser(registerDto);
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        return UserRepo.save(user);

    }
    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        log.debug("Message de débogage avec des informations détaillées");
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getName(),
                            request.getPassword()
                    )
            );
        } catch (Exception e) {
            log.error("Erreur capturée:", e);}

        User user=UserRepo.findByName(request.getName()).orElseThrow(() -> new ResourceNotFoundException("NO user with the name"+request.getName()));
        String jwtToken = jwtService.generateToken(user);

        return new AuthenticationResponse(jwtToken);

    }
    @Override
    public User getUserByToken(String token)
    {
        String userName=jwtService.extractUsername(token);
        return UserRepo.findByName(userName).orElseThrow(() -> new ResourceNotFoundException("NO user with the name"+userName));
    }

}
