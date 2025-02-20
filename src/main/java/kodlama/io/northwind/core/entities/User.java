package kodlama.io.northwind.core.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "email")
    @Email
    @NotBlank(message = "Email cannot contain spaces")
    @NotNull(message = "Email cannot be null")
    private String email;


    @Column(name = "password")
    @NotBlank(message = "Password cannot contain spaces")
    @NotNull(message = "Password cannot be null")
    private String password;
}
