package com.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
		name = "tbl_student",
		uniqueConstraints = @UniqueConstraint(//creating a constraint
				name = "unique_email",
				columnNames = { "email" }	
		)
)
public class Student {
	
	@Id
	@SequenceGenerator(//defining a sequence
			name = "student_sequence",
			sequenceName = "student_sequence",
			allocationSize = 1
	)
	@GeneratedValue(//sequence in action
			strategy = GenerationType.SEQUENCE,
			generator = "student_sequence"
	)
	private Long studentId;
	private String firstName;
	private String lastName;
	
	@Column(nullable = false)
	private String email;


	@Embedded
	private Guardian guardian;
	
}
