SET referential_integrity FALSE;
TRUNCATE TABLE trip RESTART IDENTITY;
TRUNCATE TABLE day_log RESTART IDENTITY;
TRUNCATE TABLE trip_city RESTART IDENTITY;
TRUNCATE TABLE place RESTART IDENTITY;
TRUNCATE TABLE item RESTART IDENTITY;
TRUNCATE TABLE expense RESTART IDENTITY;
TRUNCATE TABLE image RESTART IDENTITY;
TRUNCATE TABLE currency RESTART IDENTITY;
TRUNCATE TABLE city RESTART IDENTITY;
TRUNCATE TABLE category RESTART IDENTITY;
TRUNCATE TABLE member RESTART IDENTITY;
SET referential_integrity TRUE;
