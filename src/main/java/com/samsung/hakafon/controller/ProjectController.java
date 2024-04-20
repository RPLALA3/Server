package com.samsung.hakafon.controller;

import com.samsung.hakafon.domain.Project;
import com.samsung.hakafon.domain.User;
import com.samsung.hakafon.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/project")
    public Project create(@RequestBody Project pj, @RequestBody User user) {
        return projectService.create(pj, user);
    }

    @GetMapping("/project")
    public List<Project> getAll() {
        return projectService.getAll();
    }

    @GetMapping("/project/{id}")
    public Project getDyId(@PathVariable Long id) {
        return projectService.findById(id);
    }

    @GetMapping("/project/{id}")
    public Project update(@PathVariable Long id, @RequestBody Project pj) {
        return projectService.update(id, pj);
    }

    @GetMapping("/project/{id}")
    public void deleteById(@PathVariable Long id) {
        projectService.deleteById(id);
    }
}
