package com.evizi.commerce.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.evizi.commerce.models.Role;
import com.evizi.commerce.models.RoleType;
import com.evizi.commerce.repositories.RoleRepository;

import jakarta.annotation.PostConstruct;

@Component
@Transactional
public class DataInitializer {
    @Autowired
    private RoleRepository roleRepository;

    @PostConstruct
    public void setup() {

        // Set a dummy admin account that will create the actual admin
        /* Authentication authRequest = new UsernamePasswordAuthenticationToken("ignored", "ignored",
                AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
        SecurityContextHolder.getContext().setAuthentication(authRequest); */

        if (!roleRepository.existsByName(RoleType.CUSTOMER)) {
            roleRepository.save(new Role(RoleType.CUSTOMER));
        }

        if (!roleRepository.existsByName(RoleType.ADMIN)) {
            roleRepository.save(new Role(RoleType.ADMIN));
        }

        if (!roleRepository.existsByName(RoleType.SUPERUSER)) {
            roleRepository.save(new Role(RoleType.SUPERUSER));
        }

    }
}
