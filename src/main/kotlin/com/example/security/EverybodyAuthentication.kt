package com.example.security

import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils

class EverybodyAuthentication : Authentication {
    private var isAuth = false
    override fun getName() = ""
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return AuthorityUtils.NO_AUTHORITIES
    }
    override fun getCredentials() = ""
    override fun getDetails() = ""
    override fun getPrincipal() = ""
    override fun isAuthenticated() = isAuth
    override fun setAuthenticated(isAuthenticated: Boolean) {
        isAuth = isAuthenticated
    }
}