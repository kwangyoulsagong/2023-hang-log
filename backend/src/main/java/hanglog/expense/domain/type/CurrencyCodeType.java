package hanglog.expense.domain.type;

import static hanglog.global.exception.ExceptionCode.INVALID_CURRENCY;

import hanglog.expense.domain.Currency;
import hanglog.global.exception.InvalidDomainException;
import java.util.Arrays;
import java.util.function.Function;
import lombok.Getter;

@Getter
public enum CurrencyCodeType {

    USD("usd", Currency::getUsd),
    EUR("eur", Currency::getEur),
    GBP("gbp", Currency::getGbp),
    JPY("jpy", Currency::getUnitRateOfJpy),
    CNY("cny", Currency::getCny),
    CHF("chf", Currency::getChf),
    SGD("sgd", Currency::getSgd),
    THB("thb", Currency::getThb),
    HKD("hkd", Currency::getHkd),
    KRW("krw", Currency::getKrw);

    private final String code;
    private final Function<Currency, Double> getRate;

    CurrencyCodeType(final String code, final Function<Currency, Double> getRate) {
        this.code = code;
        this.getRate = getRate;
    }

    public static double mappingCurrency(final String currency, final Currency currencies) {
        return Arrays.stream(values())
                .filter(value -> value.code.equals(currency.toLowerCase()))
                .findAny().orElseThrow(() -> new InvalidDomainException(INVALID_CURRENCY))
                .getRate.apply(currencies);
    }
}
