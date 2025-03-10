package com.example.security


import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class EverybodyAuthenticationFilter(
    val everybodyAuthenticationProvider: EverybodyAuthenticationProvider
) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val context = SecurityContextHolder.createEmptyContext()
        context.authentication = EverybodyAuthentication()
        SecurityContextHolder.setContext(context)

        context.authentication = everybodyAuthenticationProvider.authenticate(context.authentication)

        filterChain.doFilter(request, response)
    }


}
