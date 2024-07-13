package com.eduardo.projectpro.domain.user;

import com.eduardo.projectpro.domain.project.Project;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Represents a user entity within the system, including personal and authentication details.
 * This class is annotated for persistence in a relational database, specifically mapping to the "tb_user" table.
 * It includes relationships to other entities, such as projects, to represent the many-to-many association between users and projects.
 * <p>
 * Annotations:
 * - @Entity: Specifies that this class is an entity. This annotation is applied to the entity class.
 * - @Table(name = "tb_user"): Specifies the table in the database with which this entity is mapped.
 * - @Data: Lombok annotation to automatically generate getters, setters, toString, equals, and hashCode methods based on the fields.
 * - @AllArgsConstructor: Generates a constructor with one parameter for each field.
 * - @NoArgsConstructor: Generates a no-argument constructor, required for JPA entities.
 * - @Serial: Indicates that a field is part of the serialization mechanism defined by the Serializable interface.
 * <p>
 * Fields:
 * - id: Unique identifier for the user, generated using UUID.
 * - fullName: The user's full name.
 * - email: The user's email address, used for identification and communication.
 * - password: The user's password, stored in an encrypted format for security.
 * - projects: A list of projects associated with the user, demonstrating a many-to-many relationship.
 */
@Entity
@Table(name = "tb_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String fullName;
    private String email;
    private String password;

    @ManyToMany(mappedBy = "users")
    private List<Project> projects = new ArrayList<>();
}