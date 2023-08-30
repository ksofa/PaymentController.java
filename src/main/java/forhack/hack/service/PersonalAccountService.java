package forhack.hack.service;

import forhack.hack.entity.PersonalAccount;
import forhack.hack.repository.PersonalAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonalAccountService {

    private final PersonalAccountRepository personalAccountRepository;

    public Optional<PersonalAccount> findByAccount(String account) {
        return personalAccountRepository.findByAccount(account);
    }
}
