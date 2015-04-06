package magic.model;

import java.util.Properties;
import magic.data.CardDefinitions;
import magic.model.player.PlayerProfile;

public class MagicPlayerDefinition {

    private static final String COLORS="colors";

    private MagicDeckProfile deckProfile;
    private final MagicDeck deck = new MagicDeck();
    private final PlayerProfile playerProfile;

    // CTR
    public MagicPlayerDefinition(final PlayerProfile aPlayerProfile, final MagicDeckProfile aDeckProfile) {
        playerProfile = aPlayerProfile;
        deckProfile = aDeckProfile;
    }

    public String getName() {
        return playerProfile.getPlayerName();
    }

    public void setDeckProfile(final MagicDeckProfile profile) {
        this.deckProfile=profile;
    }
    public MagicDeckProfile getDeckProfile() {
        return deckProfile;
    }

    public MagicDeck getDeck() {
        return deck;
    }

    public void setDeck(final MagicDeck aDeck) {
        deck.setContent(aDeck);
    }

    private static String getDeckPrefix(final String prefix,final int index) {
        return prefix+"deck"+index;
    }

    void load(final Properties properties,final String prefix) {

        final String colors=properties.getProperty(prefix+COLORS,"");
        deckProfile=new MagicDeckProfile(colors);
        deck.clear();
        for (int index=1;index<=properties.size();index++) {
            final String deckPrefix = getDeckPrefix(prefix,index);
            if (properties.containsKey(deckPrefix)) {
                final String tName = properties.getProperty(deckPrefix);
                final MagicCardDefinition cdef = CardDefinitions.getCard(tName);
                if (cdef.isValid()){
                    deck.add(cdef);
                }
            }
        }
    }

    void save(final Properties properties,final String prefix) {
        int index=1;
        for (final MagicCardDefinition cardDefinition : deck) {
            properties.setProperty(getDeckPrefix(prefix,index++),cardDefinition.getFullName());
        }
    }

    public PlayerProfile getProfile() {
        return playerProfile;
    }

}
