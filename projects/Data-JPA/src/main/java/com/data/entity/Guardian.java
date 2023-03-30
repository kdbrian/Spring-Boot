package com.data.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable//indicates that this class can be embedded into an entity class
//this allows no creation of a new table(entity)

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides(
        //allows mapping the attributes to a column in the entity that embeds this class
        {
                @AttributeOverride( name = "name", column = @Column(name = "guardian_name")),
                @AttributeOverride( name = "email", column = @Column(name = "guardian_email")),
                @AttributeOverride( name = "phone", column = @Column(name = "guardian_phone"))
        }
)
public class Guardian {

    private String name;
    private String email;
    private String phone;

}
