package com.shine.bank.monobank

import com.shine.bank.monobank.domain.CustomerSummary
import com.shine.bank.monobank.repositories.CustomersRepository
import com.shine.bank.monobank.services.CustomersService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.Page

@SpringBootTest
class CustomersServicesIntegrationTest {

    @Autowired
    private lateinit var repository: CustomersRepository

    private lateinit var service: CustomersService

    @BeforeEach
    fun setupTest() {
        service = CustomersService(repository)
    }

    @Test
    fun getCustomerList_returnFirstPage() {
        val result: Page<CustomerSummary> = service.getCustomerList(0, 5)

        assertNotNull(result)
        assertEquals(5, result.size)
        assertEquals(1, result.first().id)
        assertEquals(10, result.totalElements)
        assertEquals(2, result.totalPages)
    }
}