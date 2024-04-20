package com.samsung.hakafon.service.lmpl;

import com.samsung.hakafon.dao.ProjectRepository;
import com.samsung.hakafon.domain.Project;
import com.samsung.hakafon.domain.User;
import com.samsung.hakafon.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public Project create(Project pj, User user) {
        if (!(user.getTeamrole().equals("Teamlead"))) throw new RuntimeException("You cant create project without teamlead role");

        pj.setTlId(user.getId());

        return projectRepository.save(pj);
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project findById(Long id) {
        Optional<Project> projectOptional = projectRepository.findById(id);
        if (projectOptional.isEmpty()) throw new RuntimeException("Project with ID" + id + "does not exist");

        return projectOptional.get();
    }

    @Override
    public Project update(Long id, Project pj) {
        Optional<Project> projectOptional = projectRepository.findById(id);
        if (projectOptional.isEmpty()) throw new RuntimeException("Project with ID" + id + "does not exist");

        Project updateProject = projectOptional.get();
        updateProject.setDev1Id(pj.getDev1Id());
        updateProject.setDev2Id(pj.getDev2Id());
        updateProject.setDev3Id(pj.getDev3Id());
        updateProject.setDicsript(pj.getDicsript());

        return projectRepository.save(updateProject);
    }

    @Override
    public void deleteById(Long id) {
        projectRepository.deleteById(id);
    }


}
