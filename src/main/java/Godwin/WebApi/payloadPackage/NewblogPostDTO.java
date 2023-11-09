package Godwin.WebApi.payloadPackage;

public record NewblogPostDTO(String categories, String title, String cover,
                             String content, int readingTime, int author_id) {
}
