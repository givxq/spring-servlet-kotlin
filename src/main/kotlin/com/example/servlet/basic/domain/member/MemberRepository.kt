package com.example.servlet.basic.domain.member

object MemberRepository {
    val store = mutableMapOf<Long, Member>()
    var sequence: Long = 0L

    fun save(member: Member): Member {
        member.id = ++sequence
        store[member.id] = member
        return member
    }

    fun findById(id: Long): Member = store[id]!!

    fun findAll(): List<Member> = ArrayList(store.values)

    fun clearStore() = store.clear()
}