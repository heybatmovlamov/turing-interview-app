package az.edu.turing.interviu.dao.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "point")
public class PointEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Byte point;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    private UserEntity user;
}
