package com.example.jpademo.model

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.Table
import java.io.Serializable
import java.util.Date
import java.util.List
import kotlin.jvm.Throws

@Entity
@Table(name = "T_ORDER")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class CoffeeOrder : Serializable {
    @Id
    @GeneratedValue
    private val id: Long? = null
    private val customer: String? = null

    @ManyToMany
    @JoinTable(name = "T_ORDER_COFFEE")
    private val items: List<Coffee>? = null

    @Column(nullable = false)
    private val state: Integer? = null

    @Column(updatable = false)
    @CreationTimestamp
    private val createTime: Date? = null

    @UpdateTimestamp
    private val updateTime: Date? = null
}