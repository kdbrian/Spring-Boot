package com.relations._01;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(
                name = "uniq_email",
                columnNames = "email"
        )
)
public class Employee {

    @Column( name = "employee_id")
    @Id
    @SequenceGenerator( name = "empl_seq", sequenceName = "empl_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empl_seq")
    private Long id;

    @Column( name = "first_name")
    private String fname;

    @Column( name = "last_name")
    private String lname;

    private Date dateJoined;

    private String email;

    private Boolean isActive;
}
