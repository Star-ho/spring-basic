package com.sungho.member

import org.springframework.dao.DuplicateKeyException
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class MemberService(
    private val memberRepository: MemberJPARepository,
) {

    @Transactional
    fun registerMember(createMemberDto: CreateMemberDto) {
        val exist = memberRepository.existsById(createMemberDto.memberId)
        if (exist) throw DuplicateKeyException("해당되는 아이디가 있습니다.")
        val member = Member(memberId = createMemberDto.memberId, password = createMemberDto.password, role = createMemberDto.role)
        memberRepository.save(member)
    }

    fun getMemberList(): List<Member> {
        return memberRepository.findAll()
    }

    fun getMember(memberId: String): Member {
        return memberRepository.findById(memberId).orElseThrow { throw IllegalArgumentException("해당 멤버가 없습니다") }
    }
}