package com.sungho.member

import javax.persistence.*

@Entity
@Table(name = "MEMBER")
class Member(
    @Id
    @Column(name = "id")
    val memberId: Long,
    @Column(name = "PASSWORD")
    val password: String,
    @Column(name = "EMAIL")
    val email: String = "",
    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE")
    val role: ROLE,
)

enum class ROLE(val label: String) {
    USER("일반유저"), ADMIN("관리자")
}