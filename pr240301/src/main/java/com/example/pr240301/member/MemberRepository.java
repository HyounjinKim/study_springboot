package com.example.pr240301.member;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final SqlSessionTemplate sql;
    Map<String,Member> map = new HashMap<>();

    public void insert(Member member) {
        map.put(member.getId(), member);
    }

    public Collection<Member> select() {

        return map.values();
    }

    public void save(Member member) {
        sql.insert("Board.save",member);
    }
}
