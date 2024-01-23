package com.shine.bank.monobank.domain

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "customer")
open class Customer(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    open val id: Int? = null,
    @Column(name = "name", nullable = false, length = 40)
    open val name: String,
    @Column(name = "surname", nullable = false, length = 80)
    open val surname: String,
    @Temporal(TemporalType.DATE)
    @Column(name = "dob", nullable = false)
    open val dob: LocalDate,
    @Column(name = "addressLine1", nullable = false, length = 120)
    open val addressLine1: String,
    @Column(name = "addressLine2", nullable = true, length = 120)
    open val addressLine2: String? = null,
    @Column(name = "city", nullable = false, length = 50)
    open val city: String,
    @Column(name = "state", nullable = false, length = 3)
    open val state: String,
    @Column(name = "postcode", nullable = false, length = 4)
    open val postcode: String,
    @Column(name = "phone", length = 20, nullable = true)
    open val phone: String? = null,
    @Column(name = "email", length = 255, nullable = true)
    open val email: String? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Customer

        if (id != other.id) return false
        if (name != other.name) return false
        if (surname != other.surname) return false
        if (dob != other.dob) return false
        if (addressLine1 != other.addressLine1) return false
        if (addressLine2 != other.addressLine2) return false
        if (city != other.city) return false
        if (state != other.state) return false
        if (postcode != other.postcode) return false
        if (phone != other.phone) return false
        if (email != other.email) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + name.hashCode()
        result = 31 * result + surname.hashCode()
        result = 31 * result + dob.hashCode()
        result = 31 * result + addressLine1.hashCode()
        result = 31 * result + (addressLine2?.hashCode() ?: 0)
        result = 31 * result + city.hashCode()
        result = 31 * result + state.hashCode()
        result = 31 * result + postcode.hashCode()
        result = 31 * result + (phone?.hashCode() ?: 0)
        result = 31 * result + (email?.hashCode() ?: 0)
        return result
    }


}
