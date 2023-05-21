package com.sgyj.commonservice.security;

import java.util.Collection;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

@ToString
@EqualsAndHashCode( callSuper = true )
public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private final transient Object principal;

    private transient CredentialInfo credential;

    /**
     * Creates a token with the supplied array of authorities.
     * @param authorities the collection of <tt>GrantedAuthority</tt>s for the principal
     * represented by this authentication object.
     * @param principal
     * @param credential
     */
    public JwtAuthenticationToken (
        Object principal, CredentialInfo credential, Collection<? extends GrantedAuthority> authorities
    ) {
        super( authorities );
        super.setAuthenticated( true );
        this.principal = principal;
        this.credential = credential;
    }

    public JwtAuthenticationToken ( String principal, CredentialInfo credential ) {
        super( null );
        super.setAuthenticated( false );
        this.principal = principal;
        this.credential = credential;
    }

    @Override
    public CredentialInfo getCredentials () {
        return credential;
    }

    @Override
    public Object getPrincipal () {
        return principal;
    }

    @Override
    public void setAuthenticated ( boolean isAuthenticated ) throws IllegalArgumentException {
        if ( isAuthenticated ) {
            throw new IllegalArgumentException( "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead" );
        }
        super.setAuthenticated( false );
    }

    @Override
    public void eraseCredentials () {
        super.eraseCredentials();
        credential = null;
    }
}
