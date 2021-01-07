package com.order.jpa.repository;

import com.order.jpa.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@Transactional
public class JpaMemberRepositoryTest {
    @Autowired MemberRepository memberRepository;
    
    @Test
    @Rollback(false)
    void testMember() {
        //given
        Member member = new Member();
        member.setUsername("memberA");

        //when
        Long savedId = memberRepository.save(member);
        Member findMember = memberRepository.find(savedId);

        //then
        assertThat(findMember.getId()).isEqualTo(member.getId());
        
        //member == findMember: 같은 영속성 컨텍스에서 식별자가 같으면 같은 엔티티로 취급
    }
}
