package com.kubepay.bank.web.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@PasswordMatches
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder(toBuilder=true)
public class UserDto {
    @NotNull
    @Size(min = 1, message = "{Size.userDto.firstName}")
    private String firstName;

    @NotNull
    @Size(min = 1, message = "{Size.userDto.lastName}")
    private String lastName;

    //@ValidPassword
    private String password;

    @NotNull
    @Size(min = 1)
    private String matchingPassword;

    //@ValidEmail
    @NotNull
    @Size(min = 1, message = "{Size.userDto.email}")
    private String email;

    private boolean isUsing2FA;

    private Integer role;

}
