package com.sgyj.commonservice.security;

import static com.sgyj.commonservice.utils.CommonUtil.authorities;

import com.sgyj.commonservice.advice.exceptions.NotFoundException;
import com.sgyj.commonservice.dto.AccountDto;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface JwtAuthenticationProvider extends AuthenticationProvider {

    @Override
    default Authentication authenticate(Authentication authentication) throws AuthenticationException {
        JwtAuthenticationToken authenticationToken = (JwtAuthenticationToken) authentication;
        return processUserAuthentication(String.valueOf(authenticationToken.getPrincipal()), authenticationToken.getCredentials());
    }

    private Authentication processUserAuthentication(String principal, CredentialInfo credential) {
        try {
            AccountDto accountDto = getAccountDto(principal, credential);
            CredentialInfo credentialInfo = new CredentialInfo(accountDto.getPassword(), accountDto.getLoginType());
            JwtAuthenticationToken authenticationToken = new JwtAuthenticationToken(
                new JwtAuthentication(accountDto.getId(), accountDto.getAccountId(), accountDto.getEmail()), credentialInfo,
                authorities(accountDto.getRoles()));
            authenticationToken.setDetails(accountDto);
            return authenticationToken;
        } catch (NotFoundException e) {
            throw new UsernameNotFoundException(e.getMessage());
        } catch (IllegalArgumentException e) {
            throw new BadCredentialsException(e.getMessage());
        } catch (DataAccessException e) {
            throw new AuthenticationServiceException(e.getMessage(), e);
        }
    }

    @Override
    default boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(JwtAuthenticationToken.class);
    }

    AccountDto getAccountDto(String principal, CredentialInfo credential);

}
