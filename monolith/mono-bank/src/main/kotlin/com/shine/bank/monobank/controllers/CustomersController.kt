package com.shine.bank.monobank.controllers

import com.shine.bank.monobank.domain.CustomerSummary
import com.shine.bank.monobank.exceptions.CustomersNotFoundException
import com.shine.bank.monobank.services.CustomersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customers")
class CustomersController(@Autowired private val customersService: CustomersService) {

    @GetMapping(params = ["page", "size"])
    @ResponseBody
    fun getCustomerSummaryList(@RequestParam("page") page: Int = 0, @RequestParam("size") size: Int = 5): List<CustomerSummary> {

        val resultPage: Page<CustomerSummary> = customersService.getCustomerList(page, size)

        if (page >= resultPage.totalPages) {
            throw CustomersNotFoundException("No customers found")
        }

        return resultPage.content
    }
}