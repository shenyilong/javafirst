package com.example.jpademo.model

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.Type
import org.hibernate.annotations.UpdateTimestamp
import org.joda.money.Money
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import java.io.Serializable
import java.util.Date

@Entity
@Table(name = "T_MENU")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
class Coffee : Serializable {
    @Id
    @GeneratedValue
    private val id: Long? = null
    private val name: String? = null

    @Column
    @Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyAmount", parameters = [org.hibernate.annotations.Parameter(name = "currencyCode", value = "CNY")])
    private val price: Money? = null

    @Column(updatable = false)
    @CreationTimestamp
    private val createTime: Date? = null

    @UpdateTimestamp
    private val updateTime: Date? = null
}