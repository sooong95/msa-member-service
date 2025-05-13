package member.member.dto.join;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import member.member.Entity.Address;
import member.member.enums.Role;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberJoinDto implements MemberJoinBaseDto{

    @NotEmpty(message = "이름은 필수입니다.")
    private String username;

    @NotEmpty(message = "이메일은 필수입니다.")
    @Column(unique = true)
    private String email;

    @NotEmpty(message = "비밀번호를 입력해 주세요.")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role; // member, admin

    @Embedded
    @Valid
    private Address address;
}