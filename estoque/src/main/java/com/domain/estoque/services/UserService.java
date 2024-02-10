package com.domain.estoque.services;

import com.domain.estoque.dto.RegisterUserDTO;
import com.domain.estoque.entities.User;
import com.domain.estoque.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException { //metodo consulta de email
        return repository.findByEmail(email);
    }

    @Transactional
    public RegisterUserDTO insert(RegisterUserDTO dto) {
        User entity = new User();
        CopiarDtoParaEntity(entity,dto);
        entity = repository.save(entity);
        return new RegisterUserDTO(entity);
    }

    public void CopiarDtoParaEntity(User entity, RegisterUserDTO dto) {
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.getPassword());
        entity.setPassword(encryptedPassword);
        entity.setBirthdate(dto.getBirthdate());
        entity.setRole(dto.getRole());
    }
}
