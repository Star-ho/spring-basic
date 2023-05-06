package com.sungho.member

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(
    private val memberService: MemberService,
) {

    @PostMapping("/signup")
    fun registerMember(@RequestBody createMemberDto: CreateMemberDto): ResponseEntity<Unit> {
        memberService.registerMember(createMemberDto)
        return ResponseEntity.ok().build()
    }

    @GetMapping()
    fun getMembers(): List<Member> {
        return memberService.getMemberList()
    }
}