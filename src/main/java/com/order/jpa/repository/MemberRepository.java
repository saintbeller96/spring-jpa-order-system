package com.order.jpa.repository;

import com.order.jpa.domain.Member;

public interface MemberRepository {

    public Long save(Member member);

    public Member find(Long id);

}
