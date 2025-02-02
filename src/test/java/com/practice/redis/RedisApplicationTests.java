package com.practice.redis;

import com.practice.redis.common.redis.RedisSingleDataService;
import com.practice.redis.domain.Member;
import com.practice.redis.domain.MemberRepository;
import com.practice.redis.domain.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class RedisApplicationTests {

    @Autowired
    private RedisSingleDataService redisSingleDataService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;


    @BeforeEach
    void setUp() {

        List<Member> members = new ArrayList<>();

        for(int i = 0; i < 10000; i++){
            //*memberRepository.save(new Member((long) i, "name"+i));*//*

            members.add(new Member((long) i, "name" + i));
        }

        memberRepository.saveAll(members);
    }

    @Test
    void testRedis() {
/*        // 첫 번째 호출 시간 측정
        long startTime1 = System.nanoTime();
        System.out.println(memberService.getMember(100L));
        long endTime1 = System.nanoTime();
        long duration1 = endTime1 - startTime1; // 첫 번째 호출에 걸린 시간 (나노초 단위)
        System.out.println("첫 번째 호출에 걸린 시간: " + duration1 + " 나노초");


        // 두 번째 호출 시간 측정
        long startTime2 = System.nanoTime();
        System.out.println(memberService.getMember(100L));
        long endTime2 = System.nanoTime();
        long duration2 = endTime2 - startTime2; // 두 번째 호출에 걸린 시간 (나노초 단위)
        System.out.println("두 번째 호출에 걸린 시간: " + duration2 + " 나노초");

        System.out.println(memberRepository.findById(100L).get().getId());*/

        memberService.addMember(1L);
        memberService.addMember(2L);
        memberService.addMember(3L);
        memberService.addMember(4L);
        memberService.getAllMembers();

    }
}
