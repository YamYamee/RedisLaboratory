package com.practice.redis.domain;

import com.practice.redis.common.redis.RedisSingleDataService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;
    private final CacheManager cacheManager;

    private final RedisTemplate<String, Object> redisTemplate;

    @Cacheable(value = "memberCache", key = "#p0", cacheManager = "MemberCacheManager")
    public Optional<Member> getMember(long memberId) {

        log.info("getMember: memberId={}", memberRepository.findById(memberId));

        return memberRepository.findById(memberId);
    }

    @CachePut(value = "memberCache", key = "#p0", cacheManager = "MemberCacheManager")
    public long addMember(long memberId) {
        log.info("addMember: memberId={}", memberId);

        return memberId;
    }

    public void getAllMembers() {
        System.out.println(redisTemplate.keys("memberCache" + "*"));
    }
}
