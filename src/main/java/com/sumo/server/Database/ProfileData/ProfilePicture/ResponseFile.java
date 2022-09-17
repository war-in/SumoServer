package com.sumo.server.Database.ProfileData.ProfilePicture;

import lombok.Data;

@Data
public class ResponseFile {
    private final String name;
    private final String url;
    private final String type;
    private final long size;

}
