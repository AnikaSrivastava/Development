package models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Session extends BaseModel {
    private String userId;
    private String token;
    private Date expAt;
    private String id;
    private String deviceInfo;
}
