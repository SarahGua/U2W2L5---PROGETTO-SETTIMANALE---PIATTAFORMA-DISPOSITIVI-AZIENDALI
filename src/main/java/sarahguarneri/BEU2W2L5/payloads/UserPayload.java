package sarahguarneri.BEU2W2L5.payloads;

import lombok.Getter;

import java.util.UUID;

@Getter
public class UserPayload {
    private String username;
    private String name;
    private String surname;
    private String email;
    private UUID deviceId;
}
