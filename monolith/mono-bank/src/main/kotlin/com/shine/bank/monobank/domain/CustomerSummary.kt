package com.shine.bank.monobank.domain

import java.time.LocalDate

data class CustomerSummary(
    val id: Int?,
    val name: String,
    val surname: String,
    val dob: LocalDate,
    val city: String,
    val state: String
)