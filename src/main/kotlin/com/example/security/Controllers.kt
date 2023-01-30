package com.example.security

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("unsecure")
class UnsecuredController {

    @GetMapping
    fun get(): ResponseEntity<*> {
        return ResponseEntity("unsecure",HttpStatus.OK)
    }
}
@RestController
@RequestMapping("secure")
class SecuredController {

    @GetMapping
    fun get(): ResponseEntity<*> {
        return ResponseEntity("secure",HttpStatus.OK)
    }
}
