package by.it.academy.shopS.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UsersResponse {
    private List<UserResponse> users;
    private String userMetaInfo;
}
