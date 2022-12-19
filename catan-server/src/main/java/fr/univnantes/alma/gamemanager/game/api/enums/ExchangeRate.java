package fr.univnantes.alma.gamemanager.game.api.enums;

public enum ExchangeRate {
    quatre(4),
    trois(3),
    deux(2);

    public final int value;

    public ExchangeRate(int value) {
        this.value = value;
    }
}
