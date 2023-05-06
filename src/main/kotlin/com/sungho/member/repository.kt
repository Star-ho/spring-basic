package com.sungho.member

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberJPARepository : JpaRepository<Member, String>