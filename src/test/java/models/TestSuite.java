package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestSuite {
    @Expose
    String title;
    @Expose
    @SerializedName("parent_id")
    int parentId;
    @Expose
    String description;
    @Expose
    String preconditions;
}
