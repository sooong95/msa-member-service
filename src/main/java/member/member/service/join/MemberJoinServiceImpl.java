package member.member.service.join;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import member.member.Entity.Member;
import member.member.dto.join.MemberJoinBaseDto;
import member.member.dto.join.MemberJoinDto;
import member.member.dto.join.ShopMemberJoinDto;
import member.member.enums.Role;
import member.member.repository.MemberRepository;
import member.member.service.toEntity.ToMember;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MemberJoinServiceImpl implements MemberJoinService {

    private final MemberRepository memberRepository;
    private final ToMember toMember;
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Override
    public void memberSave(MemberJoinDto dto) throws ExecutionException, InterruptedException {

        emailVerification(dto);
        memberRepository.save(toMember(dto));
    }

    @Override
    public void shopMemberSave(ShopMemberJoinDto dto) throws ExecutionException, InterruptedException {

        emailVerification(dto);
        memberRepository.save(toMember(dto));
    }

    private void emailVerification(MemberJoinBaseDto memberJoinBaseDto) throws InterruptedException, ExecutionException {

        log.info("이메일 확인 = {}",memberJoinBaseDto.getEmail());
        Future<Boolean> future = executorService.submit(() -> memberRepository.existsByEmail((memberJoinBaseDto).getEmail()));
        Boolean isDuplicate = future.get();

        if (isDuplicate) {
            throw new IllegalArgumentException("중복된 이메일 입니다.");
        }
    }

    private Member toMember(MemberJoinBaseDto dto) {
        if (dto instanceof MemberJoinDto) {
            return toMember.toMemberEntity(dto);
        } else if (dto instanceof ShopMemberJoinDto) {
            return toMember.toShopMemberEntity(dto);
        } else {
            throw new IllegalArgumentException("지원하지 않는 DTO 타입입니다.");
        }
    }
}
