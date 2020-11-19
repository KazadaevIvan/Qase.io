package models;

import com.google.gson.annotations.Expose;
import lombok.Data;

import java.util.ArrayList;

@Data
public class TestSuitesList {
    @Expose
    ArrayList<TestSuite> entities;
}
