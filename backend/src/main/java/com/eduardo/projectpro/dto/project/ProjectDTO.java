package com.eduardo.projectpro.dto.project;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@NotNull
@NotBlank
public record ProjectDTO(
        String projectName,
        String projectDescription,
        String projectStatus,
        String projectStartDate,
        String projectEndDate,
        String projectManager
) {
}
