package com.kubepay.bank.service;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.kubepay.bank.dao.security.RoleRepository;
import com.kubepay.bank.dao.security.UserRepository;
import com.kubepay.bank.entity.security.User;
import com.kubepay.bank.web.dto.UserDto;
import com.kubepay.bank.web.error.UserAlreadyExistException;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository repository;

    //private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;

    public Iterable<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User registerNewUserAccount(final UserDto accountDto) {
        if (emailExist(accountDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email adress: " + accountDto.getEmail());
        }
        final User user = new User();

        //user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        user.setPassword(accountDto.getPassword());
        user.setUserName(accountDto.getEmail());
        user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
        return repository.save(user);
    }

    @Override
    public void saveRegisteredUser(final User user) {
        repository.save(user);
    }

    @Override
    public User findUserByEmail(final String email) {
        return repository.findByUserName(email);
    }

    @Override
    public User getUserByID(final long id) {
        return repository.findOne(id);
    }

    @Override
    public void changeUserPassword(final User user, final String password) {
        //user.setPassword(passwordEncoder.encode(password));
        user.setPassword(password);
        repository.save(user);
    }

    @Override
    public boolean checkIfValidOldPassword(final User user, final String oldPassword) {
        return oldPassword.equals(user.getPassword());
        //return passwordEncoder.matches(oldPassword, user.getPassword());
    }

    private boolean emailExist(final String email) {
        return repository.findByUserName(email) != null;
    }

    @Override
    public void deleteUser(final User user) {
        // final VerificationToken verificationToken = tokenRepository.findByUser(user);

        // if (verificationToken != null) {
        // tokenRepository.delete(verificationToken);
        // }

        // final PasswordResetToken passwordToken =
        // passwordTokenRepository.findByUser(user);

        // if (passwordToken != null) {
        // passwordTokenRepository.delete(passwordToken);
        // }

        repository.delete(user);
    }

    // private final VerificationTokenRepository tokenRepository;

    // private final PasswordResetTokenRepository passwordTokenRepository;

    // private final SessionRegistry sessionRegistry;

    // public static final String TOKEN_INVALID = "invalidToken";
    // public static final String TOKEN_EXPIRED = "expired";
    // public static final String TOKEN_VALID = "valid";

    // public static String QR_PREFIX =
    // "https://chart.googleapis.com/chart?chs=200x200&chld=M%%7C0&cht=qr&chl=";
    // public static String APP_NAME = "SpringRegistration";

    // @Override
    // public String generateQRUrl(User user) throws UnsupportedEncodingException {
    // return QR_PREFIX +
    // URLEncoder.encode(String.format("otpauth://totp/%s:%s?secret=%s&issuer=%s",
    // APP_NAME,
    // user.getEmail(), user.getSecret(), APP_NAME), "UTF-8");
    // }

    // @Override
    // public User updateUser2FA(boolean use2FA) {
    // final Authentication curAuth =
    // SecurityContextHolder.getContext().getAuthentication();
    // User currentUser = (User) curAuth.getPrincipal();
    // currentUser.setUsing2FA(use2FA);
    // currentUser = repository.save(currentUser);
    // final Authentication auth = new
    // UsernamePasswordAuthenticationToken(currentUser, currentUser.getPassword(),
    // curAuth.getAuthorities());
    // SecurityContextHolder.getContext().setAuthentication(auth);
    // return currentUser;
    // }

    // @Override
    // public List<String> getUsersFromSessionRegistry() {
    // return sessionRegistry.getAllPrincipals().stream()
    // .filter((u) -> !sessionRegistry.getAllSessions(u,
    // false).isEmpty()).map(Object::toString)
    // .collect(Collectors.toList());
    // }

    // @Override
    // public User getUser(final String verificationToken) {
    // final VerificationToken token =
    // tokenRepository.findByToken(verificationToken);
    // if (token != null) {
    // return token.getUser();
    // }
    // return null;
    // }

    // @Override
    // public VerificationToken getVerificationToken(final String VerificationToken)
    // {
    // return tokenRepository.findByToken(VerificationToken);
    // }

    // @Override
    // public void createVerificationTokenForUser(final User user, final String
    // token) {
    // final VerificationToken myToken = new VerificationToken(token, user);
    // tokenRepository.save(myToken);
    // }

    // @Override
    // public VerificationToken generateNewVerificationToken(final String
    // existingVerificationToken) {
    // VerificationToken vToken =
    // tokenRepository.findByToken(existingVerificationToken);
    // vToken.updateToken(UUID.randomUUID().toString());
    // vToken = tokenRepository.save(vToken);
    // return vToken;
    // }

    // @Override
    // public void createPasswordResetTokenForUser(final User user, final String
    // token) {
    // final PasswordResetToken myToken = new PasswordResetToken(token, user);
    // passwordTokenRepository.save(myToken);
    // }

    // @Override
    // public PasswordResetToken getPasswordResetToken(final String token) {
    // return passwordTokenRepository.findByToken(token);
    // }

    // @Override
    // public User getUserByPasswordResetToken(final String token) {
    // return passwordTokenRepository.findByToken(token).getUser();
    // }

    // @Override
    // public String validateVerificationToken(String token) {
    // final VerificationToken verificationToken =
    // tokenRepository.findByToken(token);
    // if (verificationToken == null) {
    // return TOKEN_INVALID;
    // }
    //
    // final User user = verificationToken.getUser();
    // final Calendar cal = Calendar.getInstance();
    // if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime())
    // <= 0) {
    // tokenRepository.delete(verificationToken);
    // return TOKEN_EXPIRED;
    // }
    //
    // user.setEnabled(true);
    // // tokenRepository.delete(verificationToken);
    // repository.save(user);
    // return TOKEN_VALID;
    // }

}
