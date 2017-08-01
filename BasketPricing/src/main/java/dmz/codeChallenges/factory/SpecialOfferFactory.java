package dmz.codeChallenges.factory;

import dmz.codeChallenges.model.SpecialOffer;
import dmz.codeChallenges.util.JsonHelper;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class SpecialOfferFactory {

    private final List<SpecialOffer> deals;

    public SpecialOfferFactory() throws IOException, URISyntaxException {

        this.deals = JsonHelper.LoadSpecialOffer(getClass().getResource("/data/deals.json").toURI());
    }

    public List<SpecialOffer> getSpecialOffers() {
        return this.deals;
    }
}
