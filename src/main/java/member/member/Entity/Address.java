package member.member.Entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Embeddable
@Getter
public class Address {

    @NotEmpty(message = "city를 입력해 주세요.")
    private String city;
    @NotEmpty(message = "street를 입력해 주세요.")
    private String street;
    @NotEmpty(message = "zipcode를 입력해 주세요.")
    private String zipcode;

    protected Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
