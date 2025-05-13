package member.member.service.toEntity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import member.member.Entity.Member;
import member.member.dto.join.MemberJoinBaseDto;
import member.member.dto.join.MemberJoinDto;
import member.member.dto.join.ShopMemberJoinDto;
import member.member.enums.Role;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Getter
@RequiredArgsConstructor
@Component
public class ToMember {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Member toShopMemberEntity(MemberJoinBaseDto memberJoinBaseDto) {

        ShopMemberJoinDto dto = (ShopMemberJoinDto) memberJoinBaseDto;

        Member member = Member.builder()
                .username(dto.getUsername())
                .businessRegistrationNumber(dto.getBusinessRegistrationNumber())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .address(dto.getAddress())
                .role(dto.getRole())
                .build();

        member.changeRole(Role.ROLE_SHOP);
        member.changePassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        return member;
    }

    public Member toMemberEntity(MemberJoinBaseDto memberJoinBaseDto) {

        MemberJoinDto dto = (MemberJoinDto) memberJoinBaseDto;

        Member member = Member.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .address(dto.getAddress())
                .role(dto.getRole())
                .build();

        member.changeRole(Role.ROLE_MEMBER);
        member.changePassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        return member;
    }
}
