package hanglog.expense.dto.response;

import hanglog.expense.domain.DayLogExpense;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DayLogExpenseResponse {

    private final Long id;
    private final Integer ordinal;
    private final LocalDate date;
    private final int totalAmount;
    private final List<ItemDetailResponse> items;

    public static DayLogExpenseResponse of(final DayLogExpense dayLogExpense) {
        final List<ItemDetailResponse> itemResponses = dayLogExpense.getDayLog().getItems().stream()
                .map(ItemDetailResponse::of)
                .toList();

        return new DayLogExpenseResponse(
                dayLogExpense.getDayLog().getId(),
                dayLogExpense.getDayLog().getOrdinal(),
                dayLogExpense.getDayLog().calculateDate(),
                dayLogExpense.getAmount(),
                itemResponses
        );
    }
}
