package adapters;

import models.TestSuite;

import java.util.ArrayList;
import java.util.LinkedHashMap;

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
        String body = converter.toJson(get(String.format("%s/%s/%s", URI, projectCode, id))
                .body().path("result"), LinkedHashMap.class);
        return converter.fromJson(body, TestSuite.class);
    }

    public ArrayList<TestSuite> getAllTestSuites(String projectCode) {
        return get(String.format("%s/%s", URI, projectCode))
                .body().path("result.entities");
    }
}
