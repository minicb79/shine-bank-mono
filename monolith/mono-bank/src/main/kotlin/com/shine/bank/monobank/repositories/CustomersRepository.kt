package com.shine.bank.monobank.repositories

import com.shine.bank.monobank.domain.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.ListPagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomersRepository : JpaRepository<Customer, Int>, ListPagingAndSortingRepository<Customer, Int>