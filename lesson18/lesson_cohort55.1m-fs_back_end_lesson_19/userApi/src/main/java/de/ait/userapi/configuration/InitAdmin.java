package de.ait.userapi.configuration;


import de.ait.userapi.dto.UserRequestDto;
import de.ait.userapi.dto.UserResponseDto;
import de.ait.userapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitAdmin implements CommandLineRunner {
    @Value("${app.admin.username:admin}")
    private String adminUserName ;

    @Value("${app.admin.password:qwerty}")
    private String adminUserPass;
    private final UserService service;

    @Override
    public void run(String... args) throws Exception {
        if (service.getUsersByRole("ADMIN").size() == 0) {
            service.addUser(UserRequestDto(adminUserName,adminUserName, adminUserPass, null ))
                    if(UserResponseDto==null){throw new RuntimeException("Create ADMIN error");}
                    service.assignRole(userResponsDto.getId(), "ADMIN");
        }
    }
}
