package com.shine.bank.monobank.services

import com.shine.bank.monobank.domain.CustomerSummary
import com.shine.bank.monobank.repositories.CustomersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class CustomersService(
    @Autowired private val repository: CustomersRepository,
) {

    fun getCustomerList(page: Int, size: Int): Page<CustomerSummary> {
        val sortOrder = Sort.Order.asc("surname")
        var pageable = PageRequest.of(page, size, Sort.by(sortOrder))

        val pagedCustomerList = repository.findAll(pageable)

        val customerSummary = pagedCustomerList.map {
            CustomerSummary(
                id = it.id,
                name = it.name,
                surname = it.surname,
                dob = it.dob,
                city = it.city,
                state = it.state
            )
        }

        return customerSummary
    }
}