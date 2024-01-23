package com.shine.bank.monobank.configuration

import jakarta.persistence.EntityManagerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.TransactionManager
import javax.sql.DataSource


@Configuration
//@EnableJpaRepositories(basePackages = ["com.shine.bank.monobank.repositories"])
class ShineBankConfiguration {
//
//    @Bean
//    fun dataSource(): DataSource {
//        val dataSource = DriverManagerDataSource()
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver")
//        dataSource.url = "jdbc:mysql://localhost:3306/db_example"
//
//        return dataSource
//    }
//
//    @Bean
//    fun entityManagerFactory(): EntityManagerFactory {
//        val vendorAdapter = HibernateJpaVendorAdapter()
//        vendorAdapter.setGenerateDdl(true)
//
//        val factory = LocalContainerEntityManagerFactoryBean()
//        factory.jpaVendorAdapter = vendorAdapter
//        factory.setPackagesToScan("com.shine.bank.monobank.domain")
//        factory.dataSource = dataSource()
//        return factory.nativeEntityManagerFactory
//    }
//
//    @Bean
//    @Profile("test")
//    fun testDataSource(): DataSource {
//        val dataSource = DriverManagerDataSource()
//        dataSource.setDriverClassName("org.h2.Driver")
//        dataSource.url = "jdbc:h2:mem:db;DB_CLOSE_DELAY=-1"
//        dataSource.username = "sa"
//        dataSource.password = "sa"
//
//        return dataSource
//    }
//
//    @Bean
//    @Profile("test")
//    fun testEntityManagerFactory(): EntityManagerFactory {
//        val vendorAdapter = HibernateJpaVendorAdapter()
//        vendorAdapter.setGenerateDdl(true)
//
//        val factory = LocalContainerEntityManagerFactoryBean()
//        factory.jpaVendorAdapter = vendorAdapter
//        factory.setPackagesToScan("com.shine.bank.monobank.domain")
//        factory.dataSource = testDataSource()
//        return factory.nativeEntityManagerFactory
//    }
//
//    @Bean
//    fun transactionManager(entityManagerFactory: EntityManagerFactory): TransactionManager {
//        val txManager = JpaTransactionManager()
//        txManager.entityManagerFactory = entityManagerFactory
//        return txManager
//    }
//
//    @Bean
//    @Profile("test")
//    fun testTransactionManager(entityManagerFactory: EntityManagerFactory): TransactionManager {
//        val txManager = JpaTransactionManager()
//        txManager.entityManagerFactory = entityManagerFactory
//        return txManager
//    }
}