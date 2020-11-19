package adapters;

import models.Project;
import models.ProjectsList;

public class ProjectsAdapter extends BaseAdapter {
    public static final String URI = "v1/project";

    public String create(Project project) {
        return post(URI, converter.toJson(project))
                .body().path("result.code");
    }

    public Project getSpecificProject(String projectCode) {
        return converter.fromJson(get(String.format("%s/%s", URI, projectCode)), Project.class);
    }

    public ProjectsList getAllProjects() {
        return converter.fromJson(get(URI), ProjectsList.class);
    }
}
