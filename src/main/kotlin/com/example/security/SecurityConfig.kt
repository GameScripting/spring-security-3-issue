package com.example.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter


@Configuration
@EnableWebSecurity
class SecurityConfig {


    @Bean
    @Throws(Exception::class)
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {

        http
            .securityMatcher("/**")
                // using this works 200
            .authorizeRequests {
                it.requestMatchers("/unsecure").permitAll()
                it.anyRequest().authenticated()
            }
                // this block causes 403
//            .authorizeHttpRequests {
//                it.requestMatchers("/unsecure").permitAll()
//                it.anyRequest().authenticated()
//            }
            .addFilterBefore(EverybodyAuthenticationFilter(), BasicAuthenticationFilter::class.java)
            .authenticationProvider(EverybodyAuthenticationProvider())

        return http.build()
    }
}