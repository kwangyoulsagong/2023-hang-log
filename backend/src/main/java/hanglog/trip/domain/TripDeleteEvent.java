package hanglog.trip.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TripDeleteEvent {

    private final Long tripId;
}
