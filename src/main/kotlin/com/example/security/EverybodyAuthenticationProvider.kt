package com.example.security


import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

@Component
class EverybodyAuthenticationProvider : AuthenticationProvider {

    override fun supports(authentication: Class<*>?): Boolean {
        return true
    }

    override fun authenticate(authentication: Authentication): Authentication? {
        return EverybodyAuthentication().apply { isAuthenticated = true }
    }
}
