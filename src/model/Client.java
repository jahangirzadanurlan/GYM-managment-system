package model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Client {
    String name;
    String surname;
    String fin;
    String serialNumber;
    int departure;
    LocalDate registerDate;
    LocalDate updateDate;
    LocalDate memberExpiration;
    int amount;
}
