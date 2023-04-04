package com.relations._02;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private Long uid;

    private String full_name;

    private String email;

    private Date dateJoined;

    private Boolean isActive;

}
