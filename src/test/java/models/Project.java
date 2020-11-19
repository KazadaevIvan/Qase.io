package models;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;

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
}
