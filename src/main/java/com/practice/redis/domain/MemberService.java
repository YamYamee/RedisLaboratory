package com.practice.redis.domain;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    @Cacheable(value = "memberCache", key = "#p0", cacheManager = "MemberCacheManager")
    public Optional<Member> getMember(long memberId) {

        log.info("getMember: memberId={}", memberRepository.findById(memberId));

        return memberRepository.findById(memberId);
    }
}
