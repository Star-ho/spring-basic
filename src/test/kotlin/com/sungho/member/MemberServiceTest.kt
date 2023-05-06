package com.sungho.member

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeGreaterThan
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MemberServiceTest @Autowired constructor(
    private val memberService: MemberService
) : FunSpec(){
    init {
        test("registerMember") {
            val request = CreateMemberDto(
                memberId = 0,
                password = "p@sswOrd",
                email = "atsdf@email.com",
                role = ROLE.USER
            )
            shouldNotThrow<Exception> {
                memberService.registerMember(request)
            }
        }

        test("getMemberList") {
            memberService.getMemberList().size shouldBeGreaterThan 1
        }

        test("getMember") {
            shouldNotThrow<Exception> {
                memberService.getMember(1)
            }
        }
    }
}
