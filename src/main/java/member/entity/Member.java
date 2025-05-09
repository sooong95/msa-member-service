package member.entity;

import jakarta.persistence.*;
import lombok.*;
import member.TimeStamp;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member extends TimeStamp {

    // item entity 직접 참조 x. item entity 의 식별만 저장.

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String username;

    private String businessRegistrationNumber;

    @Column(unique = true)
    private String email;

    private String password;

    private Long itemId;
}
