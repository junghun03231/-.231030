package member.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Member {
    long id;
    String userId;
    String password;

    public Member(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}
