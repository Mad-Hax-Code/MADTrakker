package com.madhax.trakker.controller

import com.madhax.trakker.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller

@Controller
class UserController {

    private val userService: UserService

    @Autowired
    constructor(userService: UserService) {
        this.userService = userService
    }


}
