package com.gg.tgather.commonservice.infra.security;

import com.gg.tgather.commonservice.enums.AccountRole;
import com.gg.tgather.commonservice.security.JwtAuthentication;
import com.gg.tgather.commonservice.security.JwtAuthenticationToken;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

@RequiredArgsConstructor
public class WithMockJwtAuthenticationSecurityContextFactory implements WithSecurityContextFactory<WithMockJwtAuthentication> {

    @Override
    public SecurityContext createSecurityContext(WithMockJwtAuthentication annotation) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        JwtAuthenticationToken authentication = new JwtAuthenticationToken(new JwtAuthentication(annotation.id(), annotation.accountId(), annotation.email()),
            null, authorities(Set.of(AccountRole.ADMIN)));
        context.setAuthentication(authentication);
        return context;
    }


    private Collection<? extends GrantedAuthority> authorities(Set<AccountRole> role) {
        return role.stream().map(r -> new SimpleGrantedAuthority("ROLE_" + r.name())).collect(Collectors.toSet());
    }

}
