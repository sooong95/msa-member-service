package member.member.repository;

import member.member.Entity.Member;
import member.member.repository.query.MemberQueryRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberQueryRepository {

    Boolean existsByEmail(String email);

    Member findByEmail(String email);
}
