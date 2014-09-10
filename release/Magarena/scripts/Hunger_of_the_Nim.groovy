[
    new MagicSpellCardEvent() {
        @Override
        public MagicEvent getEvent(final MagicCardOnStack cardOnStack,final MagicPayedCost payedCost) {
            return new MagicEvent(
                cardOnStack,
                MagicTargetChoice.POS_TARGET_CREATURE,
                MagicPumpTargetPicker.create(),         
            this,
                "Target creature\$ gets +1/+0 until end of turn for each artifact you control."
            );
        }
        @Override
        public void executeEvent(final MagicGame game, final MagicEvent event) {
            event.processTargetPermanent(game, {
                final int amount = event.getPlayer().getNrOfPermanents(MagicType.Artifact);
                game.doAction(new MagicChangeTurnPTAction(it, amount, 0));
            });
        }
    }
]
