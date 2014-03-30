package magic.model;

import magic.model.choice.MagicTargetChoice;
import magic.model.target.MagicTargetFilter;
import magic.model.target.MagicTargetFilterFactory;
import magic.model.event.MagicActivationHints;
import magic.model.event.MagicLevelUpActivation;
import magic.model.event.MagicPlayCardEvent;
import magic.model.event.MagicPlayMulticounterEvent;
import magic.model.event.MagicRegenerationActivation;
import magic.model.event.MagicSacrificeManaActivation;
import magic.model.event.MagicSacrificeTapManaActivation;
import magic.model.event.MagicTapManaActivation;
import magic.model.event.MagicPainTapManaActivation;
import magic.model.event.MagicPayLifeTapManaActivation;
import magic.model.event.MagicTiming;
import magic.model.event.MagicVividManaActivation;
import magic.model.event.MagicPermanentActivation;
import magic.model.event.MagicCardActivation;
import magic.model.event.MagicCyclingActivation;
import magic.model.event.MagicReinforceActivation;
import magic.model.event.MagicNinjutsuActivation;
import magic.model.event.MagicEvokeActivation;
import magic.model.event.MagicKickerCost;
import magic.model.event.MagicMultikickerCost;
import magic.model.event.MagicMonstrosityActivation;
import magic.model.event.MagicBestowActivation;
import magic.model.event.MagicRuleEventAction;
import magic.model.event.MagicMatchedCostEvent;
import magic.model.event.MagicAdditionalCost;
import magic.model.mstatic.MagicCDA;
import magic.model.mstatic.MagicStatic;
import magic.model.trigger.MagicTrigger;
import magic.model.trigger.MagicAllyGrowTrigger;
import magic.model.trigger.MagicAnnihilatorTrigger;
import magic.model.trigger.MagicBattleCryTrigger;
import magic.model.trigger.MagicBecomesBlockedPumpTrigger;
import magic.model.trigger.MagicBloodthirstTrigger;
import magic.model.trigger.MagicComesIntoPlayWithCounterTrigger;
import magic.model.trigger.MagicCumulativeUpkeepTrigger;
import magic.model.trigger.MagicDamageGrowTrigger;
import magic.model.trigger.MagicDevourTrigger;
import magic.model.trigger.MagicEchoTrigger;
import magic.model.trigger.MagicEntersDamageTargetTrigger;
import magic.model.trigger.MagicChampionTrigger;
import magic.model.trigger.MagicExaltedTrigger;
import magic.model.trigger.MagicFadeVanishCounterTrigger;
import magic.model.trigger.MagicFlankingTrigger;
import magic.model.trigger.MagicFromGraveyardToLibraryTrigger;
import magic.model.trigger.MagicWhenPutIntoGraveyardTrigger;
import magic.model.trigger.MagicLeavesDamageTargetTrigger;
import magic.model.trigger.MagicLeavesGainLifeTrigger;
import magic.model.trigger.MagicLeavesReturnExileTrigger;
import magic.model.trigger.MagicLivingWeaponTrigger;
import magic.model.trigger.MagicMiracleTrigger;
import magic.model.trigger.MagicModularTrigger;
import magic.model.trigger.MagicRampageTrigger;
import magic.model.trigger.MagicRavnicaLandTrigger;
import magic.model.trigger.MagicReplicateTrigger;
import magic.model.trigger.MagicSoulshiftTrigger;
import magic.model.trigger.MagicSpecterTrigger;
import magic.model.trigger.MagicStormTrigger;
import magic.model.trigger.MagicTappedIntoPlayTrigger;
import magic.model.trigger.MagicTappedIntoPlayUnlessTrigger;
import magic.model.trigger.MagicTappedIntoPlayUnlessTwoTrigger;
import magic.model.trigger.MagicThiefTrigger;
import magic.model.trigger.MagicThiefTrigger.Type;
import magic.model.trigger.MagicThiefTrigger.Choice;
import magic.model.trigger.MagicThiefTrigger.Player;
import magic.model.trigger.MagicWhenBlocksPumpTrigger;
import magic.model.trigger.MagicWhenComesIntoPlayTrigger;
import magic.model.trigger.MagicWhenLeavesPlayTrigger;
import magic.model.trigger.MagicWhenSelfLeavesPlayTrigger;
import magic.model.trigger.MagicWhenDiesTrigger;
import magic.model.trigger.MagicAtEndOfTurnTrigger;
import magic.model.trigger.MagicAtUpkeepTrigger;
import magic.model.trigger.MagicWhenOtherComesIntoPlayTrigger;
import magic.model.trigger.MagicExtortTrigger;
import magic.model.trigger.MagicUnleashTrigger;
import magic.model.trigger.MagicUndyingTrigger;
import magic.model.trigger.MagicPersistTrigger;
import magic.model.trigger.MagicLandfallTrigger;
import magic.model.trigger.MagicCascadeTrigger;
import magic.model.trigger.MagicWhenTargetedTrigger;
import magic.model.trigger.MagicWhenDamageIsDealtTrigger;
import magic.model.trigger.MagicHeroicTrigger;
import magic.model.trigger.MagicBattalionTrigger;
import magic.model.trigger.MagicWhenSelfAttacksTrigger;
import magic.model.trigger.MagicWhenSelfBecomesUntappedTrigger;
import magic.model.trigger.MagicWhenYouCastSpiritOrArcaneTrigger;
import magic.model.trigger.MagicTributeTrigger;

import java.util.EnumSet;
import java.util.Set;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum MagicAbility {

    AttacksEachTurnIfAble("attacks each turn if able",-10),
    CannotBlock("can't block",-50),
    CannotAttack("can't attack",-50),
    CannotAttackOrBlock("can't attack or block",-200),
    CannotBlockWithoutFlying("can't block creatures without flying",-40),
    CannotBeBlockedByFlying("can't be blocked by creatures with flying",20),
    CannotBeBlockedExceptWithFlying("can't be blocked except by creatures with flying",30),
    CannotBeBlockedExceptWithFlyingOrReach("can't be blocked except by creatures with flying or reach",25),
    CannotBeBlockedExceptBySliver("can't be blocked except by slivers",90),
    CannotBeBlockedExceptByWalls("can't be blocked except by walls",80),
    CannotBeBlockedByWalls("can't be blocked by walls",10),
    CannotBeBlockedByHumans("can't be blocked by humans",10),
    CannotBeBlockedByBlack("can't be blocked by black creatures",10),
    CannotBeBlockedByBlue("can't be blocked by blue creatures",10),
    CannotBeBlockedByGreen("can't be blocked by green creatures",10),
    CannotBeBlockedByRed("can't be blocked by red creatures",10),
    CannotBeBlockedByWhite("can't be blocked by white creatures",10),
    CannotBeBlockedByTokens("can't be blocked by creature tokens",10),
    CanBlockShadow("can block creatures with shadow",10),
    CannotBeCountered("can't be countered",0),
    Hexproof("hexproof",80),
    CannotBeTheTarget0("can't be the target of spells or abilities your opponents control",80),
    CannotBeTheTarget1("can't be the target of spells or abilities your opponents control",80),
    CannotBeTheTargetOfNonGreen("can't be the target of nongreen spells or abilities from nongreen sources",10),
    CannotBeTheTargetOfBlackOrRedOpponentSpell("can't be the target of black or red spells your opponents control",10),
    Deathtouch("deathtouch",60),
    Defender("defender",-100),
    DoesNotUntap("SN doesn't untap during your untap step.",-30),
    DoubleStrike("double strike",100),
    Fear("fear",50),
    Flash("flash",0),
    Flying("flying",50),
    FirstStrike("first strike",50),
    Plainswalk("plainswalk",10),
    Islandwalk("islandwalk",10),
    Swampwalk("swampwalk",10),
    Mountainwalk("mountainwalk",10),
    Forestwalk("forestwalk",10),
    Indestructible("indestructible",150),
    Haste("haste",0),
    Lifelink("lifelink",40),
    ProtectionFromBlack("protection from black",20),
    ProtectionFromBlue("protection from blue",20),
    ProtectionFromGreen("protection from green",20),
    ProtectionFromRed("protection from red",20),
    ProtectionFromWhite("protection from white",20),
    ProtectionFromMonoColored("protection from monocolored",50),
    ProtectionFromAllColors("protection from all colors",150),
    ProtectionFromCreatures("protection from creatures",100),
    ProtectionFromArtifacts("protection from artifacts",50),
    ProtectionFromDemons("protection from Demons",10),
    ProtectionFromDragons("protection from Dragons",10),
    ProtectionFromVampires("protection from Vampires",10),
    ProtectionFromWerewolves("protection from Werewolves",10),
    ProtectionFromColoredSpells("protection from colored spells",100),
    ProtectionFromEverything("protection from everything",200),
    ProtectionFromZombies("protection from Zombies",10),
    ProtectionFromLands("protection from lands",10),
    ProtectionFromSpirits("protection from Spirits",10),
    ProtectionFromArcane("protection from Arcane",10),
    ProtectionFromElves("protection from Elves",10),
    ProtectionFromGoblins("protection from Kavu",10),
    ProtectionFromKavu("protection from Goblins",10),
    ProtectionFromSnow("protection from snow",10),
    ProtectionFromLegendaryCreatures("protection from legendary creatures",10),
    Reach("reach",20),
    Shadow("shadow",30),
    Shroud("shroud",60),
    Trample("trample",30),
    Unblockable("unblockable",100),
    Vigilance("vigilance",20),
    Wither("wither",30),
    TotemArmor("totem armor",0),
    Intimidate("intimidate",45),
    Infect("infect",35),
    Horsemanship("horsemanship",60),
    Soulbond("soulbond",30),
    CantActivateAbilities("can't activate abilities",-20),

    Undying("undying",60) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            assert arg.isEmpty() : this + " does not accept arg = " + arg;
            card.add(MagicUndyingTrigger.create());
        }
    },
    Persist("persist",60) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            assert arg.isEmpty() : this + " does not accept arg = " + arg;
            card.add(MagicPersistTrigger.create());
        }
    },
    Modular("modular", 10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final int n = Integer.parseInt(arg);
            card.add(new MagicComesIntoPlayWithCounterTrigger(MagicCounterType.PlusOne,n));
            card.add(MagicModularTrigger.create());
        }
    },
    Flanking("flanking",10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            assert arg.isEmpty() : this + " does not accept arg = " + arg;
            card.add(MagicFlankingTrigger.create());
        }
    },
    Changeling("changeling",10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            assert arg.isEmpty() : this + " does not accept arg = " + arg;
            card.add(MagicCDA.Changeling);
        }
    },
    Exalted("exalted",10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            assert arg.isEmpty() : this + " does not accept arg = " + arg;
            card.add(MagicExaltedTrigger.create());
        }
    },
    BattleCry("battle cry",10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            assert arg.isEmpty() : this + " does not accept arg = " + arg;
            card.add(MagicBattleCryTrigger.create());
        }
    },
    LivingWeapon("living weapon", 10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            assert arg.isEmpty() : this + " does not accept arg = " + arg;
            card.add(MagicLivingWeaponTrigger.create());
        }
    },
    Regenerate("regenerate",30) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final MagicManaCost manaCost = MagicManaCost.create(arg);
            card.add(new MagicRegenerationActivation(manaCost));
        }
    },
    Bushido("bushido",20) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final int n = Integer.parseInt(arg);
            card.add(new MagicBecomesBlockedPumpTrigger(n,n,false));
            card.add(new MagicWhenBlocksPumpTrigger(n,n));
        }
    },
    Soulshift("soulshift",20) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final int n = Integer.parseInt(arg);
            card.add(new MagicSoulshiftTrigger(n));
        }
    },
    Fading("fading",-20) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final int n = Integer.parseInt(arg);
            card.add(new MagicComesIntoPlayWithCounterTrigger(MagicCounterType.Fade,n));
            card.add(new MagicFadeVanishCounterTrigger(MagicCounterType.Fade));
        }
    },
    Vanishing("vanishing",-20) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final int n = Integer.parseInt(arg);
            if (n > 0) {
                card.add(new MagicComesIntoPlayWithCounterTrigger(MagicCounterType.Time,n));
            }
            card.add(new MagicFadeVanishCounterTrigger(MagicCounterType.Time));
        }
    },
    CumulativeUpkeep("cumulative upkeep",-30) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final MagicManaCost manaCost = MagicManaCost.create(arg);
            card.add(new MagicCumulativeUpkeepTrigger(manaCost));
        }
    },
    LevelUp("level up", 10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final String[] token = arg.split(" ");
            final MagicManaCost cost = MagicManaCost.create(token[0]);
            final int maxLevel = Integer.parseInt(token[1]);
            card.add(new MagicLevelUpActivation(cost, maxLevel));
        }
    },
    BlockedPump("blocked pump", 10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final String[] pt = arg.replace("+","").split("/");
            final int power = Integer.parseInt(pt[0]);
            final int toughness = Integer.parseInt(pt[1]);
            card.add(new MagicBecomesBlockedPumpTrigger(power,toughness,false));
        }
    },
    BlockedByPump("blocked by pump", 20) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final String[] pt = arg.replace("+","").split("/");
            final int power = Integer.parseInt(pt[0]);
            final int toughness = Integer.parseInt(pt[1]);
            card.add(new MagicBecomesBlockedPumpTrigger(power,toughness,true));
        }
    },
    BlocksOrBlockedPump("Whenever SN blocks or becomes blocked, it gets ", 20) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final String[] pt = arg.replace(" until end of turn.","").replace("+","").split("/");
            final int power = Integer.parseInt(pt[0]);
            final int toughness = Integer.parseInt(pt[1]);
            card.add(new MagicWhenBlocksPumpTrigger(power,toughness));
            card.add(new MagicBecomesBlockedPumpTrigger(power,toughness,false));
        }
    },
    BlocksPump("Whenever SN blocks, it gets ", 10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final String[] pt = arg.replace(" until end of turn.","").replace("+","").split("/");
            final int power = Integer.parseInt(pt[0]);
            final int toughness = Integer.parseInt(pt[1]);
            card.add(new MagicWhenBlocksPumpTrigger(power,toughness));
        }
    },
    ShockLand("As SN enters the battlefield, you may pay 2 life. If you don't, SN enters the battlefield tapped.", -10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            assert arg.isEmpty() : this + " does not accept arg = " + arg;
            card.add(MagicRavnicaLandTrigger.create());
        }
    },
    Devour("devour",10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final int n = Integer.parseInt(arg);
            card.add(new MagicDevourTrigger(n));
        }
    },
    Rampage("rampage",20) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final int n = Integer.parseInt(arg);
            card.add(new MagicRampageTrigger(n));
        }
    },
    AttacksEffect("Whenever SN attacks,", 10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            card.add(MagicWhenSelfAttacksTrigger.create(
                MagicRuleEventAction.create(arg)
            ));
        }
    },
    UntappedEffect("Whenever SN becomes untapped,", 10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            card.add(MagicWhenSelfBecomesUntappedTrigger.create(
                MagicRuleEventAction.create(arg)
            ));
        }
    },
    AllyGrow("ally grow",20) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            assert arg.isEmpty() : this + " does not accept arg = " + arg;
            card.add(MagicAllyGrowTrigger.create());
        }
    },
    LandfallEffect("Whenever a land enters the battlefield under your control,",0) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            card.add(MagicLandfallTrigger.create(
                MagicRuleEventAction.create(arg)
            ));
        }
    },
    TapAddMana("tap add mana",10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final List<MagicManaType> manatype = MagicManaType.getList(arg);
            card.add(new MagicTapManaActivation(manatype));
        }
    },
    TapDrainAddMana("tap drain add mana",10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final List<MagicManaType> manatype = MagicManaType.getList(arg);
            card.add(new MagicVividManaActivation(manatype));
        }
    },
    TapPainAddMana("tap pain add mana", 10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final List<MagicManaType> manatype = MagicManaType.getList(arg);
            card.add(new MagicPainTapManaActivation(manatype));
        }
    },
    TapPayLifeAddMana("tap pay 1 life add mana", 10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final List<MagicManaType> manatype = MagicManaType.getList(arg);
            card.add(new MagicPayLifeTapManaActivation(manatype));
        }
    },
    SacAddMana("sac add mana",10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final List<MagicManaType> manatype = MagicManaType.getList(arg);
            card.add(new MagicSacrificeManaActivation(manatype));
        }
    },
    SacAtEnd("At the beginning of the end step, sacrifice SN.",-100) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            assert arg.isEmpty() : this + " does not accept arg = " + arg;
            card.add(MagicAtEndOfTurnTrigger.Sacrifice);
        }
    },
    ExileAtEnd("exile at end",-100) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            assert arg.isEmpty() : this + " does not accept arg = " + arg;
            card.add(MagicAtEndOfTurnTrigger.ExileAtEnd);
        }
    },
    SacWhenTargeted("When SN becomes the target of a spell or ability, sacrifice it.",-10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            assert arg.isEmpty() : this + " does not accept arg = " + arg;
            card.add(MagicWhenTargetedTrigger.SacWhenTargeted);
        }
    },
    TapSacAddMana("tap sac add mana",10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final List<MagicManaType> manatype = MagicManaType.getList(arg);
            card.add(new MagicSacrificeTapManaActivation(manatype));
        }
    },
    DamageToOpponent("Whenever SN deals damage to an opponent,", 10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            card.add(MagicWhenDamageIsDealtTrigger.DamageToOpponent(
                MagicRuleEventAction.create(arg)
            ));
        }
    },
    DamageToPlayer("deals damage to a player effect", 10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            card.add(MagicWhenDamageIsDealtTrigger.DamageToPlayer(
                MagicRuleEventAction.create(arg)
            ));
        }
    },
    CombatDamageToPlayer("Whenever SN deals combat damage to a player,", 10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            card.add(MagicWhenDamageIsDealtTrigger.CombatDamageToPlayer(
                MagicRuleEventAction.create(arg)
            ));
        }
    },
    DamageDiscardCard("damage discard",10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final int n = Integer.parseInt(arg);
            card.add(new MagicSpecterTrigger(Type.Any, Player.Any, n));
        }
    },
    CombatDamageDiscardCard("combat damage discard",10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final int n = Integer.parseInt(arg);
            card.add(new MagicSpecterTrigger(Type.Combat, Player.Any, n));
        }
    },
    CombatDamageDiscardRandomCard("combat damage discard random",10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final int n = Integer.parseInt(arg);
            card.add(MagicSpecterTrigger.Random(Type.Combat, Player.Any, n));
        }
    },
    DamageOpponentDiscardRandomCard("damage opponent discard random",10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final int n = Integer.parseInt(arg);
            card.add(MagicSpecterTrigger.Random(Type.Any, Player.Opponent, n));
        }
    },
    DamageCreatureGrow("Whenever SN deals damage to a creature, put a +1/+1 counter on SN.",10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            assert arg.isEmpty() : this + " does not accept arg = " + arg;
            card.add(new MagicDamageGrowTrigger(false, false));
        }
    },
    CombatDamageCreatureGrow("Whenever SN deals combat damage to a creature, put a +1/+1 counter on SN.",10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            assert arg.isEmpty() : this + " does not accept arg = " + arg;
            card.add(new MagicDamageGrowTrigger(true, false));
        }
    },
    OpponentDiscardOntoBattlefield("If a spell or ability an opponent controls causes you to discard SN, put it onto the battlefield instead of putting it into your graveyard.",10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            assert arg.isEmpty() : this + " does not accept arg = " + arg;
            card.add(MagicWhenPutIntoGraveyardTrigger.OpponentDiscardOntoBattlefield);
        }
    },
    RecoverGraveyard("When SN is put into a graveyard from anywhere, its owner shuffles his or her graveyard into his or her library.",10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            assert arg.isEmpty() : this + " does not accept arg = " + arg;
            card.add(MagicWhenPutIntoGraveyardTrigger.RecoverGraveyard);
        }
    },
    GraveyardToLibrary("When SN is put into a graveyard from anywhere, shuffle it into its owner's library.",10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            assert arg.isEmpty() : this + " does not accept arg = " + arg;
            card.add(MagicFromGraveyardToLibraryTrigger.create());
        }
    },
    LibraryInteadOfGraveyard("If SN would be put into a graveyard from anywhere, reveal SN and shuffle it into its owner's library instead.",10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            assert arg.isEmpty() : this + " does not accept arg = " + arg;
            card.add(MagicWhenPutIntoGraveyardTrigger.LibraryInsteadOfGraveyard);
        }
    },
    Champion("champion",-10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            card.add(new MagicChampionTrigger(arg));
            card.add(MagicLeavesReturnExileTrigger.create());
        }
    },
    LeavesReturnExile("leaves return exile", 0) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            assert arg.isEmpty() : this + " does not accept arg = " + arg;
            card.add(MagicLeavesReturnExileTrigger.create());
        }
    },
    EntersChooseOpponent("As SN enters the battlefield, choose an opponent.", 0) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            assert arg.isEmpty() : this + " does not accept arg = " + arg;
            card.add(MagicWhenComesIntoPlayTrigger.ChooseOpponent);
        }
    },
    EntersTapped("SN enters the battlefield tapped.", -10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            assert arg.isEmpty() : this + " does not accept arg = " + arg;
            card.add(MagicTappedIntoPlayTrigger.create());
        }
    },
    EntersWithCounter("enters with counter", 0) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final String[] token = arg.split(" ");
            final String name = token[0];
            final MagicCounterType counterType = MagicCounterType.getCounterRaw(name);
            if (token[1].equalsIgnoreCase("X")) {
                card.add(MagicWhenComesIntoPlayTrigger.XCounters(counterType));
            } else {
                final int n = Integer.parseInt(token[1]);
                card.add(new MagicComesIntoPlayWithCounterTrigger(counterType,n));
            }
        }
    },
    EntersTappedUnlessTwo("SN enters the battlefield tapped unless you control two or fewer other lands.", -10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            assert arg.isEmpty() : this + " does not accept arg = " + arg;
            card.add(MagicTappedIntoPlayUnlessTwoTrigger.create());
        }
    },
    EntersTappedUnless("SN enters the battlefield tapped unless you control a", -10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final String[] token = arg.split(" ");
            final MagicSubType t1 = MagicSubType.getSubType(token[0]);
            final MagicSubType t2 = MagicSubType.getSubType(token[1]);
            card.add(new MagicTappedIntoPlayUnlessTrigger(t1,t2));
        }
    },
    Echo("echo",-20) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            assert arg.isEmpty() == false: this + " does not accept empty arg";
            card.add(new MagicEchoTrigger(MagicManaCost.create(arg)));
        }
    },
    Bloodthirst("bloodthirst",10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final int n = Integer.parseInt(arg);
            card.add(new MagicBloodthirstTrigger(n));
        }
    },
    Storm("storm", 20) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            assert arg.isEmpty() : this + " does not accept arg = " + arg;
            card.add(MagicStormTrigger.create());
        }
    },
    Annihilator("annihilator", 80) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final int n = Integer.parseInt(arg);
            card.add(new MagicAnnihilatorTrigger(n));
        }
    },
    Multicounter("enters with counter +1/+1 for each kick", 0) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final MagicManaCost manaCost = MagicManaCost.create(arg);
            card.add(new MagicPlayMulticounterEvent(manaCost));
        }
    },
    Miracle("miracle", 0) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final MagicManaCost manaCost = MagicManaCost.create(arg);
            card.add(new MagicMiracleTrigger(manaCost));
        }
    },
    Kicker("kicker", 0) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final MagicManaCost cost = MagicManaCost.create(arg);
            card.add(new MagicKickerCost(cost));
        }
    },
    Buyback("buyback", 0) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final MagicManaCost cost = MagicManaCost.create(arg);
            card.add(MagicKickerCost.Buyback(cost));
        }
    },
    Multikicker("multikicker", 0) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final MagicManaCost cost = MagicManaCost.create(arg);
            card.add(new MagicMultikickerCost(cost));
        }
    },
    Replicate("replicate", 20) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final MagicManaCost cost = MagicManaCost.create(arg);
            card.add(MagicMultikickerCost.Replicate(cost));
            card.add(MagicReplicateTrigger.create());
        }
    },
    EntersEffect("When SN enters the battlefield,", 10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            card.add(MagicWhenComesIntoPlayTrigger.create(
                MagicRuleEventAction.create(arg)
            ));
        }
    },
    EndStepEffect("At the beginning of the end step,", 0) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            card.add(MagicAtEndOfTurnTrigger.create(
                MagicRuleEventAction.create(arg)
            ));
        }
    },
    YourEndStepEffect("At the beginning of your end step,", 0) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            card.add(MagicAtEndOfTurnTrigger.createYour(
                MagicRuleEventAction.create(arg)
            ));
        }
    },
    EntersKickedEffect("When SN enters the battlefield, if it was kicked,", 10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            card.add(MagicWhenComesIntoPlayTrigger.createKicked(
                MagicRuleEventAction.create(arg)
            ));
        }
    },
    DiesEffect("When SN dies,", 10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            card.add(MagicWhenDiesTrigger.create(
                MagicRuleEventAction.create(arg)
            ));
        }
    },
    LeavesEffect("When SN leaves the battlefield,", 10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            card.add(MagicWhenSelfLeavesPlayTrigger.create(
                MagicRuleEventAction.create(arg)
            ));
        }
    },
    ControlEnchanted("control enchanted", 10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            assert arg.isEmpty() : this + " does not accept arg = " + arg;
            card.add(MagicStatic.ControlEnchanted);
        }
    },
    SwitchPT("switch pt", 10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final MagicManaCost manaCost = MagicManaCost.create(arg);
            card.add(MagicPermanentActivation.SwitchPT(manaCost));
        }
    },
    Evoke("evoke", 20) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final MagicManaCost manaCost = MagicManaCost.create(arg);
            card.add(new MagicEvokeActivation(manaCost));
            card.add(MagicWhenComesIntoPlayTrigger.Evoke);
        }
    },
    Evolve("evolve", 20) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            assert arg.isEmpty() : this + " does not accept arg = " + arg;
            card.add(MagicWhenOtherComesIntoPlayTrigger.Evolve);
        }
    },
    Extort("extort", 20) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            assert arg.isEmpty() : this + " does not accept arg = " + arg;
            card.add(MagicExtortTrigger.create());
        }
    },
    Cycling("cycling", 20) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final MagicManaCost manaCost = MagicManaCost.create(arg);
            card.add(new MagicCyclingActivation(manaCost));
        }
    },
    Reinforce("reinforce", 20) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final String[] token = arg.split(" ");
            final int n = Integer.parseInt(token[0]);
            final MagicManaCost manaCost = MagicManaCost.create(token[1]);
            card.add(new MagicReinforceActivation(n, manaCost));
        }
    },
    Unleash("unleash", 20) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            assert arg.isEmpty() : this + " does not accept arg = " + arg;
            card.add(MagicUnleashTrigger.create());
            card.add(MagicStatic.Unleash);
        }
    },
    Ninjutsu("ninjutsu", 20) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final MagicManaCost manaCost = MagicManaCost.create(arg);
            card.add(new MagicNinjutsuActivation(manaCost));
        }
    },
    Cascade("cascade", 50) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            assert arg.isEmpty() : this + " does not accept arg = " + arg;
            card.add(MagicCascadeTrigger.create());
        }
    },
    Lord("lord", 0) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final String prefix = "other ";
            final boolean other = arg.startsWith(prefix);
            final String rest = arg.replaceFirst(prefix, "");
            final String[] tokens = rest.split(" get | have | has ");
            final MagicTargetFilter<MagicPermanent> filter = MagicTargetFilterFactory.multiple(tokens[0]);
            if (rest.contains(" get ")) {
                final String[] pt = tokens[1].replace('+','0').split("/");
                final int power = Integer.parseInt(pt[0]);
                final int toughness = Integer.parseInt(pt[1]);
                if (other) {
                    card.add(MagicStatic.genPTStaticOther(filter, power, toughness));
                } else {
                    card.add(MagicStatic.genPTStatic(filter, power, toughness));
                }
            } else {
                final MagicAbilityList abilityList = MagicAbility.getAbilityList(tokens[1]);
                if (other) {
                    card.add(MagicStatic.genABStaticOther(filter, abilityList));
                } else {
                    card.add(MagicStatic.genABStatic(filter, abilityList));
                }
            }
        }
    },
    Poisonous("poisonous", 10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final int n = Integer.parseInt(arg);
            card.add(MagicWhenDamageIsDealtTrigger.Poisonous(n));
        }
    },
    Monstrosity("monstrosity", 10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final String[] token = arg.split(" ");
            final int n = Integer.parseInt(token[0]);
            final MagicManaCost manaCost = MagicManaCost.create(token[1]);
            card.add(new MagicMonstrosityActivation(manaCost, n));
        }
    },
    Tribute("tribute", 10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final String[] token = arg.split(" ", 2);
            final int n = Integer.parseInt(token[0]);
            final String effect  = token[1].replaceFirst("^effect ", "");
            card.add(MagicTributeTrigger.create(n,  MagicRuleEventAction.create(effect)));
        }
    },
    Bestow("bestow", 10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final MagicManaCost manaCost = MagicManaCost.create(arg);
            card.add(new MagicBestowActivation(manaCost));
        }
    },
    ActivatedAbility("cost", 10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            card.add(MagicPermanentActivation.create(arg));
        }
    },
    AlternateCost("alt cost", 10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final MagicCardDefinition cardDef = (MagicCardDefinition)card;
            final String[] tokens = arg.split(" named ");
            card.add(MagicCardActivation.create(cardDef, tokens[0], tokens[1]));
        }
    },
    AdditionalCost("As an additional cost to cast SN,", 10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            card.add(MagicAdditionalCost.create(new MagicMatchedCostEvent(arg)));
        }
    },
    HeroicEffect("Whenever you cast a spell that targets SN,", 10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            card.add(MagicHeroicTrigger.create(
                MagicRuleEventAction.create(arg)
            ));
        }
    },
    EachUpkeepEffect("At the beginning of each upkeep,", 10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            card.add(MagicAtUpkeepTrigger.create(
                MagicRuleEventAction.create(arg)
            ));
        }
    },
    YourUpkeepEffect("At the beginning of your upkeep,", 10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            card.add(MagicAtUpkeepTrigger.createYour(
                MagicRuleEventAction.create(arg)
            ));
        }
    },
    BattalionEffect("Whenever SN and at least two other creatures attack,", 10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            card.add(MagicBattalionTrigger.create(
                MagicRuleEventAction.create(arg)
            ));
        }
    },
    SpiritOrArcaneEffect("Whenever you cast a Spirit or Arcane spell,", 10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            card.add(MagicWhenYouCastSpiritOrArcaneTrigger.create(
                MagicRuleEventAction.create(arg)
            ));
        }
    },
    Graft("graft",10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final int n = Integer.parseInt(arg);
            card.add(new MagicComesIntoPlayWithCounterTrigger(MagicCounterType.PlusOne,n));
            card.add(MagicWhenOtherComesIntoPlayTrigger.Graft);
        }
    },
    Loyalty("loyalty",10) {
        protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
            final int n = Integer.parseInt(arg);
            card.add(new MagicComesIntoPlayWithCounterTrigger(MagicCounterType.Loyalty,n));
        }
    },
    None("",0);

    public static final Set<MagicAbility> PROTECTION_FLAGS = EnumSet.range(ProtectionFromBlack, ProtectionFromZombies);
    
    public static final Set<MagicAbility> LANDWALK_FLAGS = EnumSet.range(Plainswalk, Forestwalk);
                
    private final String name;
    private final int score;

    private MagicAbility(final String aName,final int aScore) {
        name  = aName;
        score = aScore;
    }

    public String getName() {
        return name;
    }

    protected void addAbilityImpl(final MagicAbilityStore card, final String arg) {
        assert arg.isEmpty() : this + " does not accept arg = " + arg;
    }

    public void addAbility(final MagicAbilityStore card, final String ability) {
        final String arg = ability.substring(getName().length()).trim();
        card.addAbility(this);
        addAbilityImpl(card, arg);
    }

    @Override
    public String toString() {
        return name;
    }

    private int getScore() {
        return score;
    }

    public static int getScore(final Set<MagicAbility> flags) {
        int score=0;
        for (final MagicAbility ability : flags) {
            score+=ability.getScore();
        }
        return score;
    }

    public static MagicAbility getAbility(final String name) {
        MagicAbility match = None;
        for (final MagicAbility ability : values()) {
            if (name.startsWith(ability.getName()) && ability.getName().length() > match.getName().length()) {
                match = ability;
            }
        }
        if (match == None) {
            throw new RuntimeException("Unable to convert \"" + name + "\" to an ability");
        } else {
            return match;
        }
    }
    
    public static MagicAbilityList getAbilityList(final String[] names) {
        final MagicAbilityList abilityList = new MagicAbilityList();
        for (final String name : names) {
            getAbility(name).addAbility(abilityList, name);
        }
        return abilityList;
    }
    
    public static MagicAbilityList getAbilityList(final Set<MagicAbility> abilities) {
        final MagicAbilityList abilityList = new MagicAbilityList();
        for (final MagicAbility ability : abilities) {
            ability.addAbility(abilityList, ability.getName());
        }
        return abilityList;
    }

    private static final Pattern SUB_ABILITY_LIST = Pattern.compile("\"([^\"]*)\"|([A-Za-z][^,]*)");
    
    public static MagicAbilityList getAbilityList(final String names) {
        final MagicAbilityList abilityList = new MagicAbilityList();
        final Matcher m = SUB_ABILITY_LIST.matcher(names);
        while (m.find()) {
            final String name = m.group(1) != null ? m.group(1) : m.group(2);
            getAbility(name).addAbility(abilityList, name);
        }
        return abilityList;
    }
    
    public static Set<MagicAbility> of(final MagicAbility first, MagicAbility... rest) {
        return EnumSet.of(first, rest);
    }

    public static Set<MagicAbility> noneOf() {
        return EnumSet.noneOf(MagicAbility.class);
    }
    
    public static MagicAbility CannotBeTheTarget(final MagicPlayer player) {
        return player.getIndex() == 0 ?
            CannotBeTheTarget0 :
            CannotBeTheTarget1;
    }
}
