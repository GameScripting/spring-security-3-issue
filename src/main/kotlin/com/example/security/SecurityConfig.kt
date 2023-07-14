package com.example.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter


@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Autowired
    lateinit var everybodyAuthenticationFilter: EverybodyAuthenticationFilter

    @Bean
    @Throws(Exception::class)
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {

        http
            .securityMatcher("/**")
            .authorizeHttpRequests {
                it.requestMatchers("/unsecure").permitAll()
                it.anyRequest().authenticated()
            }
            .addFilterBefore(everybodyAuthenticationFilter, BasicAuthenticationFilter::class.java)

        return http.build()
    }
}