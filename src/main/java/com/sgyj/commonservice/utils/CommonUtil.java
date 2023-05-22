package com.sgyj.commonservice.utils;

import com.sgyj.commonservice.enums.AccountRole;
import com.sgyj.commonservice.security.Jwt;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class CommonUtil {

    private CommonUtil() {
        throw new AssertionError();
    }

    public static Collection<? extends GrantedAuthority> authorities(Set<AccountRole> role) {
        return role.stream().map(r -> new SimpleGrantedAuthority("ROLE_" + r.name())).collect(Collectors.toSet());
    }

    public static Collection<? extends GrantedAuthority> authorities(Jwt.Claims claims) {
        String[] roles = claims.getRoles();
        return Arrays.stream(roles).map(r -> new SimpleGrantedAuthority("ROLE_" + r)).collect(Collectors.toSet());
    }

}
