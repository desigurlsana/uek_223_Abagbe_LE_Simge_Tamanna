package ch.noseryoung.uk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests()

                //Users
                .antMatchers(HttpMethod.POST, "/users/**").hasAuthority("CREATE_USER")
                .antMatchers(HttpMethod.GET, "/users/**").hasAuthority("RETRIEVE_USER")
                .antMatchers(HttpMethod.PUT, "/users/**").hasAuthority("UPDATE_USER")
                .antMatchers(HttpMethod.DELETE, "/users/**").hasAuthority("DELETE_USER")

                //Roles
                .antMatchers(HttpMethod.POST, "/roles/**").hasAuthority("CREATE_ROLE")
                .antMatchers(HttpMethod.GET, "/roles/**").hasAuthority("RETRIEVE_ROLE")
                .antMatchers(HttpMethod.PUT, "/roles/**").hasAuthority("UPDATE_ROLE")
                .antMatchers(HttpMethod.DELETE, "/roles/**").hasAuthority("DELETE_ROLE")

                //Auctions
                .antMatchers(HttpMethod.POST, "/auctions/**").hasAuthority("CREATE_AUCTION")
                .antMatchers(HttpMethod.GET, "/auctions/**").hasAuthority("RETRIEVE_AUCTION")
                .antMatchers(HttpMethod.PUT, "/auctions/**").hasAuthority("UPDATE_AUCTION")
                .antMatchers(HttpMethod.DELETE, "/auctions/**").hasAuthority("DELETE_AUCTION")

                //Authorities
                .antMatchers(HttpMethod.POST, "/authorities/**").hasAuthority("CREATE_AUTHORITY")
                .antMatchers(HttpMethod.GET, "/authorities/**").hasAuthority("RETRIEVE_AUTHORITY")
                .antMatchers(HttpMethod.PUT, "/authorities/**").hasAuthority("UPDATE_AUTHORITY")
                .antMatchers(HttpMethod.DELETE, "/authorities/**").hasAuthority("DELETE_AUTHORITY")



                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {

        //User Role
        UserDetails theUser = User.withUsername("jens")
                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
                .password("jens").roles("USER").authorities("RETRIEVE_USER").build();

        //Manager Role
        UserDetails theManager = User.withUsername("yves")
                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
                .password("yves").roles("MANAGER")
                .authorities("CREATE_USER", "UPDATE_USER", "RETRIEVE_USER", "DELETE_USER").build();


        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

        userDetailsManager.createUser(theUser);
        userDetailsManager.createUser(theManager);

        return userDetailsManager;
    }
}