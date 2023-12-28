package academy.prog;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class CheckAliveScheduler {
    private final UrlService urlService;
    private final UrlRepository urlRepository;
    private final static Long timeAlive = 300000L;

    public CheckAliveScheduler(UrlService urlService, UrlRepository urlRepository) {
        this.urlService = urlService;
        this.urlRepository = urlRepository;
    }

    @Scheduled(fixedDelay = 60000)
    public void checkAlive(){
        var records = urlRepository.findAll();
        Date checkDate = new Date();
        checkDate.setTime(checkDate.getTime() - timeAlive);
        for (UrlRecord record : records){
            if (record.getLastAccess().before(checkDate)){
                urlRepository.deleteById(record.getId());
            }
        }
    }
}
