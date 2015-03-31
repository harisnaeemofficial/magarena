[
   new MagicSpellCardEvent() {
        @Override
        public MagicEvent getEvent(final MagicCardOnStack cardOnStack,final MagicPayedCost payedCost) {
            return new MagicEvent(
                cardOnStack,
                MagicTargetChoice.NEG_TARGET_CREATURE_OR_PLAYER,
                this,
                "SN deals X damage to target creature or player\$,"+
                "where X is 2 plus the number of cards named Kindle in all graveyards."
            );
        }
        @Override
        public void executeEvent(final MagicGame game, final MagicEvent event) {
            final int amount = game.filterCards(
                MagicTargetFilterFactory.cardName("Kindle")
                .from(MagicTargetType.Graveyard)
                .from(MagicTargetType.OpponentsGraveyard)
            ).size()+2;
            event.processTarget(game, {
                game.logAppendMessage(event.getPlayer()," (X="+amount+")");
                game.doAction(new MagicDealDamageAction(event.getSource(),it,amount));
            });
        }
    }
]
