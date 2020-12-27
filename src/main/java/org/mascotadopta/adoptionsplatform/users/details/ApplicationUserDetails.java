package org.mascotadopta.adoptionsplatform.users.details;

import org.mascotadopta.adoptionsplatform.users.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class ApplicationUserDetails implements UserDetails
{
    private final String email;
    
    private final String password;
    
    private final boolean isEmailConfirmed;
    
    public ApplicationUserDetails(User user)
    {
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.isEmailConfirmed = user.isEmailConfirmed();
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return null;
    }
    
    @Override
    public String getPassword()
    {
        return password;
    }
    
    @Override
    public String getUsername()
    {
        return email;
    }
    
    @Override
    public boolean isAccountNonExpired()
    {
        return false;
    }
    
    @Override
    public boolean isAccountNonLocked()
    {
        return false;
    }
    
    @Override
    public boolean isCredentialsNonExpired()
    {
        return false;
    }
    
    @Override
    public boolean isEnabled()
    {
        return isEmailConfirmed;
    }
}
