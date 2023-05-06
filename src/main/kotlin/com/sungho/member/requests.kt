package com.sungho.member

class CreateMemberDto(
    val memberId: String,
    val password: String,
    val email: String,
    val role:ROLE,
)

class MemberDTO(
    val id: Long = 0,
    val memberId: String,
    val password: String,
    val email: String
)

class LoginDto(
    val memberId: String,
    val password: String,
)
