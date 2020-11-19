package tests;

import adapters.ProjectsAdapter;
import adapters.SuiteAdapter;
import models.Project;
import models.TestSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class QaseTest {

    @Test
    public void allProjectsShouldBeReturned() {

        new ProjectsAdapter().getAllProjects();
    }

    @Test
    public void specificProjectShouldBeReturned() {
        Project project = Project.builder()
                .title("Ivan Kazadaev")
                .access("all")
                .code("IK")
                .group(null)
                .description("Ivan's project")
                .build();
//        new ProjectsAdapter().create(project);
        Project actualProject = new ProjectsAdapter().getSpecificProject("IK");
        assertEquals(actualProject, project);
    }

    @Test
    public void newProjectShouldBeCreated() {
        Project project = Project.builder()
                .title("Ivan Kazadaev")
                .access("all")
                .code("IK")
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
                .code("IK")
                .group(null)
                .description("Ivan's project")
                .build();
        //String code = new ProjectsAdapter().create(project);
        TestSuite suite = TestSuite.builder()
                .title("Ivan Kazadaev Suite")
                .description("Just a test suite")
                .preconditions("Pre conditions")
                .build();
        new SuiteAdapter().create( "IK" /*code*/, suite);
    }

    @Test
    public void allSuitesShouldBeReturned() {
        Project project = Project.builder()
                .title("Ivan Kazadaev")
                .access("all")
                .code("IK")
                .group(null)
                .description("Ivan's project")
                .build();
        //String code = new ProjectsAdapter().create(project);
        new SuiteAdapter().getAllTestSuites("IK");
    }

    @Test
    public void specificSuiteShouldBeReturned() {
        Project project = Project.builder()
                .title("Ivan Kazadaev")
                .access("all")
                .code("IK")
                .group(null)
                .description("Ivan's project")
                .build();
        //String code = new ProjectsAdapter().create(project);
        TestSuite suite = TestSuite.builder()
                .title("Ivan Kazadaev Suite")
                .description("Just a test suite")
                .preconditions("Pre conditions")
                .build();
        int id = new SuiteAdapter().create("IK" /*code*/, suite);
        TestSuite actualSuite = new SuiteAdapter().getSpecificTestSuite( "IK" /*code*/,3 /*id*/);
        assertEquals(actualSuite, suite);
    }

    @Test
    public void suiteShouldBeDeleted() {
        Project project = Project.builder()
                .title("Ivan Kazadaev")
                .access("all")
                .code("IK")
                .group(null)
                .description("Ivan's project")
                .build();
        //String code = new ProjectsAdapter().create(project);
        TestSuite suite = TestSuite.builder()
                .title("Ivan Kazadaev Suite")
                .description("Just a test suite")
                .preconditions("Pre conditions")
                .build();
        int id = new SuiteAdapter().create("IK" /*code*/, suite);
        new SuiteAdapter().delete( "IK" /*code*/, 3 /*id*/);
    }

    @Test
    public void newSuiteShouldBeUpdated() {
        Project project = Project.builder()
                .title("Ivan Kazadaev Second Project")
                .access("all")
                .code("IK")
                .group(null)
                .description("Ivan's project")
                .build();
        String code = new ProjectsAdapter().create(project);
        TestSuite suite = TestSuite.builder()
                .title("Ivan Kazadaev Suite for update")
                .description("Just a test suite")
                .preconditions("Pre conditions")
                .build();
        int id = new SuiteAdapter().create("IK" /*code*/, suite);
        TestSuite updatedSuite = TestSuite.builder()
                .title("Updated Ivan Kazadaev Suite")
                .description("Just an updated test suite")
                .preconditions("Pre conditions")
                .build();
        new SuiteAdapter().update( "IK" /*code*/, 3 /*id*/, updatedSuite);
    }
}
