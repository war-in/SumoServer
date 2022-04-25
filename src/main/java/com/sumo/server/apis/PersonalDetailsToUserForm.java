package com.sumo.server.apis;

import lombok.Data;

@Data
class PersonalDetailsToUserForm {
    private String username;
    private Long personalDetailsId;
}
