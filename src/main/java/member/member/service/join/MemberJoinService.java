package member.member.service.join;

import member.member.dto.join.MemberJoinDto;
import member.member.dto.join.ShopMemberJoinDto;

import java.util.concurrent.ExecutionException;

public interface MemberJoinService {

    void memberSave(MemberJoinDto dto) throws ExecutionException, InterruptedException;

    void shopMemberSave(ShopMemberJoinDto dto) throws ExecutionException, InterruptedException;
}
