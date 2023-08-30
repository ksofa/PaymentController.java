package forhack.hack.service;

import forhack.hack.dto.NotificationRequest;
import forhack.hack.dto.PayRequest;
import forhack.hack.entity.Notification;
import forhack.hack.entity.PersonalAccount;
import forhack.hack.entity.Provider;
import forhack.hack.entity.User;
import forhack.hack.repository.NotificationRepo;
import forhack.hack.repository.ProviderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProviderService {

    private final ProviderRepo providerRepo;
    private final UserService userService;
    private final PersonalAccountService personalAccountService;
    private final NotificationRepo notificationRepo;

    public Double payProvider(PayRequest payRequest) {
        Provider provider = providerRepo.findByName(payRequest.getNameProvider()).get();
        PersonalAccount personalAccount = personalAccountService.findByAccount(payRequest.getAccount()).get();

        if (provider.getPersonalAccount().equals(personalAccount)) {

            User userfromdb = userService.findByPersonalAccount(personalAccount).get();
            Double providerCount = provider.getCount();

            Double payment = userfromdb.getMoney() - provider.getCount();
            userfromdb.setMoney(payment);
            provider.setCount(0.0);

            providerRepo.save(provider);
            userService.saveUser(userfromdb);

            return providerCount;
        }else return 0.0;
    }


    public Notification sendNotification(NotificationRequest notificationRequest) {
        PersonalAccount personalAccount = personalAccountService.findByAccount(notificationRequest.getAccount()).get();
        User userFromDb = userService.findByPersonalAccount(personalAccount).get();
        Provider provider = providerRepo.findByName(notificationRequest.getProviderName()).get();

        Notification notification = new Notification(provider, userFromDb, notificationRequest.getDescription());

        notificationRepo.save(notification);

        userFromDb.setNotification(notification);
        userService.saveUser(userFromDb);

        return notification;
    }
}
