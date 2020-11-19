package adapters;

import models.TestSuite;
import models.TestSuitesList;

public class SuiteAdapter extends BaseAdapter {
    public static final String URI = "v1/suite";

    public int create(String projectCode, TestSuite testSuite) {
        return post(String.format("%s/%s", URI, projectCode), converter.toJson(testSuite))
                .body().path("result.id");
    }

    public void delete(String projectCode, int id) {
        delete(String.format("%s/%s/%s", URI, projectCode, id));
    }

    public int update(String projectCode, int id, TestSuite testSuite) {
        return patch(String.format("%s/%s/%s", URI, projectCode, id), converter.toJson(testSuite))
                .body().path("result.id");
    }

    public TestSuite getSpecificTestSuite(String projectCode, int id) {
        return converter.fromJson(get(String.format("%s/%s/%s", URI, projectCode, id)), TestSuite.class);
    }

    public TestSuitesList getAllTestSuites(String projectCode) {
        return converter.fromJson(get(String.format("%s/%s", URI, projectCode)), TestSuitesList.class);
    }
}
