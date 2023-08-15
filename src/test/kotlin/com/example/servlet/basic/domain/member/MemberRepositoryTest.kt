package com.example.servlet.basic.domain.member

import com.example.servlet.domain.member.Member
import com.example.servlet.domain.member.MemberRepository
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.shouldBe

class MemberRepositoryTest : ShouldSpec({
    val memberRepository = MemberRepository

    should("save") {
        val member = Member("hello", 20)
        val savedMember = memberRepository.save(member)

        val findMember = memberRepository.findById(savedMember.id)
        findMember shouldBeEqual savedMember
    }

    should("find All") {
        val member1 = Member("member1", 20)
        val member2 = Member("member2", 30)

        memberRepository.save(member1)
        memberRepository.save(member2)

        val findAll = memberRepository.findAll()

        findAll.size shouldBe 2
        findAll shouldContainAll listOf(member1, member2)
    }

    afterEach {
        memberRepository.clearStore()
    }
})
