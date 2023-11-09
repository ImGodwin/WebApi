package Godwin.WebApi.payloadPackage;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record NewblogPostDTO(@NotEmpty(message = "Please add a category") @Size(min = 6, max =15) String categories,
                             @NotEmpty(message = "Please add a title") @Size(min = 2, max =30)String title,
                             @NotEmpty(message = "Please add a cover") String cover,
                             @NotEmpty(message = "Please add a content") String content,
                             @NotEmpty(message = "Please add an author reading time") int readingTime,
                             @NotEmpty(message = "Please add an author ID")int author_id) {
}
