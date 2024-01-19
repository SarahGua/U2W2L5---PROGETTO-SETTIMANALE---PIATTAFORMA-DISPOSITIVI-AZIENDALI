package sarahguarneri.BEU2W2L5.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
public class Device {
    @Id
    @GeneratedValue
    private UUID id;
    private String type;
    private String available;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
