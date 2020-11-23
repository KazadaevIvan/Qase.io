package models;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

@Data
@Builder
public class Project {
    @Expose
    String title;
    @Expose
    String code;
    String description;
    String access;
    String group;

    public static String generateCode(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }
}
