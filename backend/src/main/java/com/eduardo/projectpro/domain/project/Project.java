package com.eduardo.projectpro.domain.project;

import com.eduardo.projectpro.domain.project.types.ProjectPriority;
import com.eduardo.projectpro.domain.user.User;
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
 * Represents a project entity with comprehensive details such as its name, description, status, start and end dates,
 * manager, and priority. Additionally, it maintains a many-to-many relationship with the User entity, indicating the
 * users involved in the project.
 * <p>
 * Annotations used in this class:
 * - @Entity marks this class as a JPA entity.
 * - @Table specifies the table in the database with which this entity is mapped. Here, it's mapped to "tb_project".
 * - @Data is a Lombok annotation to generate getters, setters, toString, equals, and hashCode methods.
 * - @AllArgsConstructor generates a constructor with one parameter for each field in the class.
 * - @NoArgsConstructor generates a no-argument constructor.
 * <p>
 * Fields:
 * - id: Unique identifier for the project, generated as a UUID.
 * - projectName: Name of the project.
 * - projectDescription: Description of the project.
 * - projectStatus: Current status of the project.
 * - projectStartDate: Start date of the project.
 * - projectEndDate: End date of the project.
 * - projectManager: Manager of the project.
 * - projectPriority: Priority of the project, represented by an enum.
 * - users: List of users involved in the project, establishing a many-to-many relationship.
 */
@Entity
@Table(name = "tb_project")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String projectName;
    private String projectDescription;
    private String projectStatus;
    private String projectStartDate;
    private String projectEndDate;
    private String projectManager;
    private ProjectPriority projectPriority;

    @ManyToMany
    private List<User> users = new ArrayList<>();
}