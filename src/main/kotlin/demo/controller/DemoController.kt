package demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("demo")
class DemoController {

    @GetMapping
    fun getString(@RequestParam name: String): String {
        return "Hello, $name"
    }
}