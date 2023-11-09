package Godwin.WebApi.payloadPackage;

import java.util.Date;

public record ErrorsDTO(String message, Date errorTimeStamp) {
}
