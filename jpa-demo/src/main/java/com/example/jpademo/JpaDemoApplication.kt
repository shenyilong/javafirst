package com.example.jpademo

import geektime.spring.springbucks.jpademo.model.Coffee
import geektime.spring.springbucks.jpademo.model.CoffeeOrder
import geektime.spring.springbucks.jpademo.repository.CoffeeOrderRepository
import geektime.spring.springbucks.jpademo.repository.CoffeeRepository
import lombok.extern.slf4j.Slf4j
import org.joda.money.CurrencyUnit
import org.joda.money.Money
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import java.util.Arrays
import java.util.Collections
import kotlin.jvm.Throws

@SpringBootApplication
@EnableJpaRepositories
@Slf4j
class JpaDemoApplication : ApplicationRunner {
    @Autowired
    private val coffeeRepository: CoffeeRepository? = null

    @Autowired
    private val orderRepository: CoffeeOrderRepository? = null

    @Override
    @Throws(Exception::class)
    fun run(args: ApplicationArguments?) {
        initOrders()
    }

    private fun initOrders() {
        val espresso: Coffee = Coffee.builder().name("espresso")
                .price(Money.of(CurrencyUnit.of("CNY"), 20.0))
                .build()
        coffeeRepository.save(espresso)
        JpaDemoApplication.log.info("Coffee: {}", espresso)
        val latte: Coffee = Coffee.builder().name("latte")
                .price(Money.of(CurrencyUnit.of("CNY"), 30.0))
                .build()
        coffeeRepository.save(latte)
        JpaDemoApplication.log.info("Coffee: {}", latte)
        var order: CoffeeOrder = CoffeeOrder.builder()
                .customer("Li Lei")
                .items(Collections.singletonList(espresso))
                .state(0)
                .build()
        orderRepository.save(order)
        JpaDemoApplication.log.info("Order: {}", order)
        order = CoffeeOrder.builder()
                .customer("Li Lei")
                .items(Arrays.asList(espresso, latte))
                .state(0)
                .build()
        orderRepository.save(order)
        JpaDemoApplication.log.info("Order: {}", order)
    }

    companion object {
        fun main(args: Array<String?>?) {
            SpringApplication.run(JpaDemoApplication::class.java, args)
        }
    }
}