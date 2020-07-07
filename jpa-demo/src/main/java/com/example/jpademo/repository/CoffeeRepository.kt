package com.example.jpademo.repository

import geektime.spring.springbucks.jpademo.model.Coffee
import org.springframework.data.repository.CrudRepository
import kotlin.jvm.Throws

interface CoffeeRepository : CrudRepository<Coffee?, Long?> 