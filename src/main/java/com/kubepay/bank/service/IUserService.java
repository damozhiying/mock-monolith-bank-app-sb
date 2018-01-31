package com.kubepay.bank.service;

import com.kubepay.bank.entity.security.User;
import com.kubepay.bank.web.dto.UserDto;
import com.kubepay.bank.web.error.UserAlreadyExistException;

public interface IUserService {

    Iterable<User> findAll();

    User registerNewUserAccount(UserDto accountDto) throws UserAlreadyExistException;

    void saveRegisteredUser(User user);

    void deleteUser(User user);

    User findUserByEmail(String email);

    User getUserByID(long id);

    void changeUserPassword(User user, String password);

    boolean checkIfValidOldPassword(User user, String password);

    // String generateQRUrl(User user) throws UnsupportedEncodingException;

    // User updateUser2FA(boolean use2FA);

    // List<String> getUsersFromSessionRegistry();

    // User getUser(String verificationToken);

    // void createVerificationTokenForUser(User user, String token);

    // VerificationToken getVerificationToken(String VerificationToken);

    // VerificationToken generateNewVerificationToken(String token);

    // void createPasswordResetTokenForUser(User user, String token);

    // PasswordResetToken getPasswordResetToken(String token);

    // User getUserByPasswordResetToken(String token);

    // String validateVerificationToken(String token);

}
