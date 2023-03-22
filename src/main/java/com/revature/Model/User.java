package com.revature.Model;

import jakarta.persistence.*;
import lombok.*;

//@MappedSuperclass
@Data
@Entity
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public abstract class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String username;
	@Column
	private String passwd;
}
