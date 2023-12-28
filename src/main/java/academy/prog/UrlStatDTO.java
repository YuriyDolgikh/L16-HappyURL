package academy.prog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class UrlStatDTO extends UrlResultDTO {
    private long redirects;
    private Date lastAccess; // TODO: set normal format

    public long getRedirects() {
        return redirects;
    }

    public void setRedirects(long redirects) {
        this.redirects = redirects;
    }

    public String getLastAccess() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss", Locale.ENGLISH);
        dateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Kiev"));
        return dateFormat.format(lastAccess);
    }

    public void setLastAccess(Date lastAccess) {
        this.lastAccess = lastAccess;
    }
}
