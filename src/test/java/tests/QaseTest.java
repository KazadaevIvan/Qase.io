package tests;

import adapters.ProjectsAdapter;
import adapters.SuiteAdapter;
import models.Project;
import models.TestSuite;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class QaseTest {

    @Test
    public void allProjectsShouldBeReturned() {
        List<Project> listBefore = new ProjectsAdapter().getAllProjects();
        Project project = Project.builder()
                .title("Ivan Kazadaev TEST")
                .access("all")
                .code(Project.generateCode(4))
                .group(null)
                .description("Ivan's project")
                .build();
        String code = new ProjectsAdapter().create(project);
        List<Project> listAfter = new ProjectsAdapter().getAllProjects();
        assertEquals(listAfter.size(), listBefore.size() + 1);
        Project actualProject = new ProjectsAdapter().getSpecificProject(code);
        assertEquals(actualProject.getTitle(), project.getTitle());
        assertEquals(actualProject.getCode(), project.getCode());
    }

    @Test
    public void specificProjectShouldBeReturned() {
        Project project = Project.builder()
                .title("Ivan Kazadaev")
                .access("all")
                .code(Project.generateCode(4))
                .group(null)
                .description("Ivan's project")
                .build();
        String code = new ProjectsAdapter().create(project);
        Project actualProject = new ProjectsAdapter().getSpecificProject(code);
        assertEquals(actualProject.getTitle(), project.getTitle());
        assertEquals(actualProject.getCode(), project.getCode());
    }

    @Test
    public void newProjectShouldBeCreated() {
        Project project = Project.builder()
                .title("Ivan Kazadaev")
                .access("all")
                .code(Project.generateCode(4))
                .group(null)
                .description("Ivan's project")
                .build();
        new ProjectsAdapter().create(project);
    }

    @Test
    public void newSuiteShouldBeCreated() {
        Project project = Project.builder()
                .title("Ivan Kazadaev")
                .access("all")
                .code(Project.generateCode(4))
                .group(null)
                .description("Ivan's project")
                .build();
        String code = new ProjectsAdapter().create(project);
        TestSuite suite = TestSuite.builder()
                .title("Ivan Kazadaev Suite")
                .description("Just a test suite")
                .preconditions("Pre conditions")
                .build();
        new SuiteAdapter().create(code, suite);
    }

    @Test
    public void allSuitesShouldBeReturned() {
        Project project = Project.builder()
                .title("Ivan Kazadaev")
                .access("all")
                .code(Project.generateCode(4))
                .group(null)
                .description("Ivan's project")
                .build();
        String code = new ProjectsAdapter().create(project);
        List<TestSuite> listBefore = new SuiteAdapter().getAllTestSuites(code);
        TestSuite suite = TestSuite.builder()
                .title("Ivan Kazadaev Test Suite")
                .description("Just a test suite")
                .preconditions("Pre conditions")
                .build();
        int id = new SuiteAdapter().create(code, suite);
        new SuiteAdapter().getAllTestSuites(code);
        List<TestSuite> listAfter = new SuiteAdapter().getAllTestSuites(code);
        assertEquals(listAfter.size(), listBefore.size() + 1);
        TestSuite actualSuite = new SuiteAdapter().getSpecificTestSuite(code, id);
        assertEquals(actualSuite, suite);
    }

    @Test
    public void specificSuiteShouldBeReturned() {
        Project project = Project.builder()
                .title("Ivan Kazadaev")
                .access("all")
                .code(Project.generateCode(4))
                .group(null)
                .description("Ivan's project")
                .build();
        String code = new ProjectsAdapter().create(project);
        TestSuite suite = TestSuite.builder()
                .title("Ivan Kazadaev Suite")
                .description("Just a test suite")
                .preconditions("Pre conditions")
                .build();
        int id = new SuiteAdapter().create(code, suite);
        TestSuite actualSuite = new SuiteAdapter().getSpecificTestSuite(code, id);
        assertEquals(actualSuite, suite);
    }

    @Test
    public void suiteShouldBeDeleted() {
        Project project = Project.builder()
                .title("Ivan Kazadaev")
                .access("all")
                .code(Project.generateCode(4))
                .group(null)
                .description("Ivan's project")
                .build();
        String code = new ProjectsAdapter().create(project);
        TestSuite suite = TestSuite.builder()
                .title("Ivan Kazadaev Suite")
                .description("Just a test suite")
                .preconditions("Pre conditions")
                .build();
        int id = new SuiteAdapter().create(code, suite);
        new SuiteAdapter().delete(code, id);
    }

    @Test
    public void newSuiteShouldBeUpdated() {
        Project project = Project.builder()
                .title("Ivan Kazadaev Second Project")
                .access("all")
                .code(Project.generateCode(4))
                .group(null)
                .description("Ivan's project")
                .build();
        String code = new ProjectsAdapter().create(project);
        TestSuite suite = TestSuite.builder()
                .title("Ivan Kazadaev Suite for update")
                .description("Just a test suite")
                .preconditions("Pre conditions")
                .build();
        int id = new SuiteAdapter().create(code, suite);
        TestSuite updatedSuite = TestSuite.builder()
                .title("Updated Ivan Kazadaev Suite")
                .description("Just an updated test suite")
                .preconditions("Pre conditions")
                .build();
        new SuiteAdapter().update(code, id, updatedSuite);
    }
}
