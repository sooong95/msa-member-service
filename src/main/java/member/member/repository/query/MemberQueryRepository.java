package member.member.repository.query;

import member.member.Entity.Member;

import java.util.List;

public interface MemberQueryRepository {

    List<Member> findMembers();

    List<Member> findShopMembers();
}
