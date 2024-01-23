package com.shine.bank.monobank.services

import com.shine.bank.monobank.domain.Customer
import com.shine.bank.monobank.repositories.CustomersRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.any
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations.openMocks
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import java.time.LocalDate
import java.time.Month

//@SpringBootTest
@ExtendWith(MockitoExtension::class)
class CustomersServicesTest {

    @Mock
    private lateinit var repository: CustomersRepository

    private lateinit var service: CustomersService

    @BeforeEach
    fun setupTest() {
        openMocks(CustomersRepository::class.java)
        service = CustomersService(repository)
    }

    @Test
    fun given_whenGetCustomerList_thenFirstPageOfListReturned() {
        val page = buildPageOneCustomer()

        `when`(repository.findAll(any(Pageable::class.java)))
            .thenReturn(page)

        val result = service.getCustomerList(0, 5)

        assertNotNull(result)
        assertEquals(5, result.size)
        assertEquals(72, result.first().id)
    }

    private fun buildPageOneCustomer(): PageImpl<Customer> {
        val c1 = Customer(
            id = 72,
            name = "Branko",
            surname = "Minic",
            dob = LocalDate.of(1979, Month.OCTOBER, 12),
            addressLine1 = "42 Wentworth Court",
            city = "Taylors Lakes",
            state = "Victoria",
            postcode = "3038",
            email = "branko.minic@shinesolutions.com",
            phone = "0417 570 507"
        )
        val c2 = Customer(
            id = 102,
            name = "Jim",
            surname = "Hargreaves",
            dob = LocalDate.of(1943, Month.SEPTEMBER, 17),
            addressLine1 = "62 Umbrella Circuit",
            city = "Aptitude Valley",
            state = "Australian Capital Territory",
            postcode = "2977",
            phone = "0444 816 877"
        )
        val c3 = Customer(
            id = 17,
            name = "Simona",
            surname = "Smart",
            dob = LocalDate.of(1982, Month.JULY, 12),
            addressLine1 = "174 Blackhorse St",
            city = "Wandavale",
            state = "Queensland",
            postcode = "4818"
        )
        val c4 = Customer(
            id = 390,
            name = "Jane",
            surname = "Lawless",
            dob = LocalDate.of(1968, Month.FEBRUARY, 9),
            addressLine1 = "2A Chesterfield Rd",
            city = "Kensington",
            state = "New South Wales",
            postcode = "2164",
            email = "jane.lawless@shinesolutions.com"
        )
        val c5 = Customer(
            id = 98,
            name = "Cornelia",
            surname = "Whetherby",
            dob = LocalDate.of(1955, Month.NOVEMBER, 30),
            addressLine1 = "16/256 Cinquieme Lane",
            city = "New New York",
            state = "Western Australia",
            postcode = "8181"
        )

        return PageImpl(listOf(c1, c2, c3, c4, c5), Pageable.ofSize(5).withPage(0), 7)
    }
}