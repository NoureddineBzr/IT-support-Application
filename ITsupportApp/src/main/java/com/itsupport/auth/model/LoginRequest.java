package com.itsupport.auth.model;

import lombok.*;

/**
 * Represents a login request containing user credentials.
 *
 * This class is used to encapsulate the login credentials required for user
 * authentication. It includes the username and password that are submitted
 * during the login process.
 *
 * Created by Yassine Oularbi
 *
 * Contact:
 * Email: yassineoularbi4@gmail.com
 * GitHub: @YassineOularbi
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {


    private String username;


    private String password;
}
