package member.member.Entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import member.member.enums.Role;
import org.springframework.util.StringUtils;

import java.util.Objects;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String username;

    private String businessRegistrationNumber;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role; // member, admin

    @Embedded
    @Valid
    private Address address;

    public void transPassword(String hashPassword) {
        this.password = hashPassword;
    }

    public void changeUsername(String username) {
        if (StringUtils.hasText(username)) this.username = username;
    }

    public void changePassword(String password) {
        if (StringUtils.hasText(password)) this.password = password;
    }

    public void changeEmail(String email) {
        this.email = email;
    }

    public void changeBusinessRegistrationNumber(String businessRegistrationNumber) {
        if (StringUtils.hasText(businessRegistrationNumber))
            this.businessRegistrationNumber = businessRegistrationNumber;
    }

    public void changeRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(id, member.id) && Objects.equals(username, member.username) && Objects.equals(email, member.email) && Objects.equals(password, member.password) && role == member.role && Objects.equals(address, member.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, password, role, address);
    }
}
