package member.entity;

import jakarta.persistence.*;
import lombok.*;
import member.TimeStamp;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member extends TimeStamp {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String username;

    private String businessRegistrationNumber;

    @Column(unique = true)
    private String email;

    private String password;

}
