package com.shine.bank.monobank.repositories

import com.shine.bank.monobank.domain.Customer
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.time.LocalDate

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CustomersRepositoryTest(@Autowired private val repository: CustomersRepository) {

    @Test
    fun testInsert() {
        val customer = Customer(
            name = "Branko",
            surname = "Minic",
            dob = LocalDate.of(1979, 9, 19),
            addressLine1 = "600 Bourke St",
            city = "Melbourne",
            state = "VIC",
            postcode = "3000"
        )

        repository.save(customer)
    }
}