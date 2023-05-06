package com.sungho.member

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "MEMBER")
class Member(
    @Id
    val memberId: String,
    @Column(name = "PASSWORD")
    val password: String,
    @Column(name = "EMAIL")
    val email: String = "",
    @Column(name = "ROLE")
    val role: ROLE,
)

enum class ROLE(val label: String) {
    USER("일반유저"), ADMIN("관리자")
}