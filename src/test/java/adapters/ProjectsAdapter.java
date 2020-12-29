package adapters;

import models.Project;

import java.util.LinkedHashMap;
import java.util.List;

public class ProjectsAdapter extends BaseAdapter {
    public static final String URI = "v1/project";

    public String create(Project project) {
        return post(URI, converter.toJson(project))
                .body().path("result.code");
    }

    public Project getSpecificProject(String projectCode) {
        String body = converter.toJson(get(String.format("%s/%s", URI, projectCode))
                .body().path("result"), LinkedHashMap.class);
        return converter.fromJson(body, Project.class);
    }

    public List<Project> getAllProjects() {
        return get(URI).body().path("result.entities");
    }
}
