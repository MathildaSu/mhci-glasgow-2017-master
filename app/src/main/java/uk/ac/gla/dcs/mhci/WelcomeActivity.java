package uk.ac.gla.dcs.mhci;

import com.stephentuso.welcome.BasicPage;
import com.stephentuso.welcome.TitlePage;
import com.stephentuso.welcome.WelcomeConfiguration;

public class WelcomeActivity extends com.stephentuso.welcome.WelcomeActivity {
    @Override
    protected WelcomeConfiguration configuration() {
        return new WelcomeConfiguration.Builder(this)
                .defaultBackgroundColor(R.color.colorPrimary)
                .page(new TitlePage(R.drawable.logo,
                        "WelcomeActivity to Glasgow Student center (Alpha)")
                )
                .page(new BasicPage(R.drawable.information,
                        "Your Information",
                        "The app uses the information about you to provide information that you want" +
                                " to see. When you want to see it!")
                        .background(R.color.purpleColor)
                )
                .page(new BasicPage(R.drawable.privacy,
                        "Privacy Guaranteed",
                        "This application will never use Your information without a consent!")
                        .background(R.color.redColor)
                )
                .defaultBackgroundColor(R.color.tealColor)
                .page(new TitlePage(R.drawable.help,
                        "Before we begin, let's have a short overview of the features...")
                )
                .page(new BasicPage(R.drawable.grades,
                        "Your grades",
                        "Your grades are always easily accessible! You will find a persistent tab" +
                                "on the bottom of the screen.")
                        .background(R.color.greenColor)
                )
                .page(new BasicPage(R.drawable.deadline,
                        "Your deadlines",
                        "Never miss your deadline again! All your deadlines are on the same " +
                                "tab as your grades.")
                        .background(R.color.orangeColor)
                )
                .page(new BasicPage(R.drawable.location,
                        "Location based information",
                        "The middle tab of the bottom toolbar will show information about the location" +
                                "you're in. Sadly, this version only has a limited information for " +
                                "the library.")
                        .background(R.color.tealColor)
                )
                .defaultBackgroundColor(R.color.pinkColor)
                .page(new TitlePage(R.drawable.check,
                        "That's it for now! We really hope you will love this application.")
                )
                .swipeToDismiss(true)
                .build();
    }
}
